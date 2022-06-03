package pe.edu.upc.suscriptionservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.suscriptionservice.entity.Employer;
import pe.edu.upc.suscriptionservice.service.EmployerService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployer() {
        List<Employer> employerList = employerService.getAllEmployer();
        if(employerList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employerList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable("id")Long id) {
        Employer employer = employerService.getEmployer(id);
        if(employer == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employer);
    }
    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        if(employer == null) return ResponseEntity.noContent().build();
        employerService.createEmployer(employer);
        return ResponseEntity.status(HttpStatus.CREATED).body(employer);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable("id")Long id, @RequestBody Employer employer){
        if(id == null || employer == null) return ResponseEntity.noContent().build();
        employer.setId(id);
        employerService.updateEmployer(employer);
        return ResponseEntity.ok(employer);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteEmployer(@PathVariable Long id) {
        Employer employer = employerService.getEmployer(id);
        if(employer == null) return;
        employerService.deleteEmployer(employer);
    }
}
