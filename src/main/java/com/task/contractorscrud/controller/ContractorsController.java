package com.task.contractorscrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.contractorscrud.model.Contractor;
import com.task.contractorscrud.service.ContractorsService;

@RestController
public class ContractorsController {
    @Autowired
    ContractorsService contractorsService;

    @GetMapping("/contractor")  
    private List<Contractor> getContractors()   
    {  
        return contractorsService.getContractors();  
    }  

    @PostMapping("/contractor")  
    private Contractor addContractor(@RequestBody Contractor contractor)   
    {  
        contractorsService.addContractor(contractor);   

        return contractor;
    } 

    @PutMapping("/contractor/{id}")  
    private Contractor updateContractor(@PathVariable int id, @RequestBody Contractor contractor)   
    {  
        contractorsService.updateContractor(id, contractor);  

        return contractor;  
    } 
 
    @DeleteMapping("/contractor/{id}")  
    private boolean deleteContractor(@PathVariable("id") int id)   
    {  
        return contractorsService.deleteContractor(id);  
    }  
}
