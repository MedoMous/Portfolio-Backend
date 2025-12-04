package com.med.springboot.SE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService service;

    @Autowired
    public SoftwareEngineerController(SoftwareEngineerService service) {
        this.service = service;
    }

    // GET all engineers
    // URL: http://localhost:8080/api/v1/software-engineers
    @GetMapping
    public List<SoftwareEngineer> getAllEngineers() {
        return service.findAll();
    }

    // POST - Create engineer
    // URL: http://localhost:8080/api/v1/software-engineers
    @PostMapping
    public SoftwareEngineer createEngineer(@RequestBody SoftwareEngineer engineer) {
        return service.save(engineer);
    }
    @GetMapping("/{id}")
    public SoftwareEngineer findEngineerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SoftwareEngineer updateEngineer(
            @PathVariable Long id,
            @RequestBody SoftwareEngineer engineer) {
        return service.update(id, engineer);
    }

    @DeleteMapping("/{id}")
    public void deleteEngineerById(@PathVariable Long id){
        service.delete(id);
    }
}

    // GET by ID (add this later)
    // URL: http://localhost:8080/api/v1/software-engineers/1


//    // PUT - Update engineer (add this later)
//    // URL: http://localhost:8080/api/v1/software-engineers/1
//    @PutMapping("/{id}")
//    public SoftwareEngineer updateEngineer(@PathVariable Long id, @RequestBody SoftwareEngineer engineer) {
//        return service.update(id, engineer);
//    }
//
//    // DELETE - Delete engineer (add this later)
//    // URL: http://localhost:8080/api/v1/software-engineers/1
//    @DeleteMapping("/{id}")
//    public void deleteEngineer(@PathVariable Long id) {
//        service.delete(id);
//    }
//}