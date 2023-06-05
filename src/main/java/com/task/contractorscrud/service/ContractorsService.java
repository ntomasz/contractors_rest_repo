package com.task.contractorscrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.contractorscrud.model.Contractor;  
import com.task.contractorscrud.repository.ContractorsRepository;

@Service
public class ContractorsService {
    @Autowired  
    ContractorsRepository contractorsRepository;  

    public List<Contractor> getContractors() {
        List<Contractor> contractors = new ArrayList<Contractor>();  
        contractorsRepository.findAll().forEach(contractor -> contractors.add(contractor));  

        return contractors;  
    }

    public void addContractor(Contractor contractor) {
        contractorsRepository.save(contractor);
    }

    public void updateContractor(int id, Contractor contractor) {
        Optional<Contractor> contractorOptional = contractorsRepository.findById(id);

        if (contractorOptional.isPresent()) {
            Contractor foundContractor = contractorOptional.get();

            if (contractor.getName() != null && !contractor.getName().isEmpty()) foundContractor.setName(contractor.getName());
            if (contractor.getNip() != null && !contractor.getNip().isEmpty()) foundContractor.setNip(contractor.getNip());
            if (contractor.getPhone() != null && !contractor.getPhone().isEmpty()) foundContractor.setPhone(contractor.getPhone());
            if (contractor.getEmail() != null && !contractor.getEmail().isEmpty()) foundContractor.setEmail(contractor.getEmail());
            if (contractor.getAddress() != null && !contractor.getAddress().isEmpty()) foundContractor.setAddress(contractor.getAddress());
            
            this.addContractor(foundContractor);
        }
    }

    public boolean deleteContractor(int id) {
        if (contractorsRepository.findById(id).isPresent()) {
            contractorsRepository.deleteById(id);

            return true;
        }
        
        return false;
    }
}
