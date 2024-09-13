package ageria.U5S6L5.controllers;


import ageria.U5S6L5.dto.EmployeeDTO;
import ageria.U5S6L5.dto.TravelDTO;
import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.entities.Travel;
import ageria.U5S6L5.exception.BadRequestException;
import ageria.U5S6L5.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    TravelService travelService;

    // 1 GET PAGE
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Travel> findAll(@RequestParam(defaultValue = "0") int pages,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy){
        return this.travelService.getAllEmployee(pages, size, sortBy);
    }

    // 1.1 GET BY ID
    @GetMapping("/{travelId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Travel findById(@PathVariable Long travelId){
        return this.travelService.findById(travelId);
    }


    //2. POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Travel createEmployee(@RequestBody @Validated TravelDTO body, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = (String) bindingResult.getAllErrors().stream().map(error ->error.getDefaultMessage()).collect(Collectors.joining());
            throw new BadRequestException(msg);
        }
        return this.travelService.saveEmployee(body);
    }

    @PutMapping("/{travelId}")
    @ResponseStatus(HttpStatus.OK)
    public Travel updateEmployee(@PathVariable Long travelId, @RequestBody TravelDTO body){
        return this.travelService.findByIdAndUpdate(travelId, body);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmploye(@PathVariable Long travelId){
        this.travelService.findByIdAndDelete(travelId);
        return "Travel Correctly DELETED";
    }
}
