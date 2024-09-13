package ageria.U5S6L5.services;


import ageria.U5S6L5.dto.EmployeeDTO;
import ageria.U5S6L5.dto.TravelDTO;
import ageria.U5S6L5.dto.UpdateTravelStatusDTO;
import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.entities.Travel;
import ageria.U5S6L5.exception.BadRequestException;
import ageria.U5S6L5.exception.NotFoundException;
import ageria.U5S6L5.repositories.TraveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    TraveRepository travelRepository;

    // 1. GET
    public Page<Travel> getAllEmployee(int pages, int size, String sortBy){
        Pageable pageable = PageRequest.of(pages, size , Sort.by(sortBy));
        return this.travelRepository.findAll(pageable);
    }

    // 1.1 GET by id
    public Travel findById(Long id){
        return this.travelRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    // 2. POST
    public Travel saveEmployee(TravelDTO body){
        if(travelRepository.existsByDestination(body.destination())){
            throw new BadRequestException("Employee with this email already exists");
        }

        Travel newTravel = new Travel(body.destination(),body.travelDate(), body.travelStatus());
        return this.travelRepository.save(newTravel);

    }



    public Travel findByIdAndUpdateStatus(Long id, UpdateTravelStatusDTO body){
        Travel travelFromDb = this.findById(id);
        travelFromDb.setTravelStatus(body.travelStatus());
        return travelFromDb;
    }

    public void findByIdAndDelete(Long id){
        Travel travelToDelete = this.findById(id);
        this.travelRepository.delete(travelToDelete);
    }
}
