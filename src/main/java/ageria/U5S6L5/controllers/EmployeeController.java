package ageria.U5S6L5.controllers;

import ageria.U5S6L5.dto.EmployeeDTO;
import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.exception.BadRequestException;
import ageria.U5S6L5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    // 1. GET
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Employee> findAll(@RequestParam(defaultValue = "0") int pages,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy){
        return this.employeeService.getAllEmployee(pages, size, sortBy);
    }

    // 1.1 GET BY ID
    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public Employee findById(@PathVariable Long employeeId){
        return this.employeeService.findById(employeeId);
    }


    //2. POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Validated EmployeeDTO body, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = (String) bindingResult.getAllErrors().stream().map(error ->error.getDefaultMessage()).collect(Collectors.joining());
            throw new BadRequestException(msg);
        }
        return this.employeeService.saveEmployee(body);
    }

    // 2.1 POST UPLOAD AVATAR
    @PostMapping("/avatar/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadEmployeeAvatar(@RequestParam("avatar")MultipartFile avatar, @PathVariable Long employeeId) throws IOException {
        this.employeeService.uploadImage(avatar, employeeId);
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO body){
        return this.employeeService.findByIdAndUpdate(employeeId, body);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmploye(@PathVariable Long employeeId){
        this.employeeService.findByIdAndDelete(employeeId);
        return "Emplyee Correctly DELETED";
    }

}
