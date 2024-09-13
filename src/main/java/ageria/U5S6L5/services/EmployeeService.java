package ageria.U5S6L5.services;


import ageria.U5S6L5.dto.EmployeeDTO;
import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.exception.BadRequestException;
import ageria.U5S6L5.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // 1. GET
    public Page<Employee> getAllEmployee(int pages, int size, String sortBy){
        Pageable pageable = PageRequest.of(pages, size , Sort.by(sortBy));
        return this.employeeRepository.findAll(pageable);
    }



    // 2. POST
    public Employee saveEmployee(EmployeeDTO body){
        if(employeeRepository.existsByEmail(body.email())){
            throw new BadRequestException("Employee with this email already exists");
        }
        else{
            return new Employee(body.name(),
                    body.surname(),
                    body.username(),
                    body.email(),
                    "https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
        }
    }


}
