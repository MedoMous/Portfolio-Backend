package com.med.springboot.SE;

import com.med.springboot.repository.SoftwareEngineerRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Getter
@Setter
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerService {
    @Autowired
    private SoftwareEngineerRepository repository;

    public List<SoftwareEngineer> findAll() {
        return repository.findAll();
    }

    public SoftwareEngineer save(
            @RequestBody SoftwareEngineer engineer){
        return repository.save(engineer);
    }

    public SoftwareEngineer findById(
            @PathVariable long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id+ " ID Not Found"));
    }

    public SoftwareEngineer update(
            Long id ,@RequestBody SoftwareEngineer engineerDetails) {
        SoftwareEngineer engineer = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No Engineer with this id: " + id));
        engineer.setName(engineerDetails.getName());
        engineer.setEmail(engineerDetails.getEmail());
        engineer.setTechStack(engineerDetails.getTechStack());

        return repository.save(engineer);
    }
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
