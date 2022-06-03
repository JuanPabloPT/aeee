package pe.edu.upc.suscriptionservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.suscriptionservice.entity.*;
import pe.edu.upc.suscriptionservice.service.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private Postulant_SubscriptionService postulantSubscriptionService;
    @Autowired
    Employer_SubscriptionService employer_subscriptionService;
    @Autowired
    private PostulantService postulantService;
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscription() {
        List<Subscription> subscriptionList = subscriptionService.getAllSubscription();
        if(subscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subscriptionList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable("id")Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subscription);
    }
    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        if(subscription == null) return ResponseEntity.noContent().build();
        subscriptionService.createSubscription(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable("id")Long id, @RequestBody Subscription subscription){
        if(id == null || subscription == null) return ResponseEntity.noContent().build();
        subscription.setId(id);
        subscriptionService.updateSubscription(subscription);
        return ResponseEntity.ok(subscription);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return;
        subscriptionService.deleteSubscription(subscription);
    }

    @GetMapping(value = "/postulant")
    public ResponseEntity<List<Postulant_Subscription>> getAllSubscriptionPostulant() {
        List<Postulant_Subscription> postulantSubscriptionList = postulantSubscriptionService.getAllPostulant_Subscription();
        if(postulantSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscriptionList);
    }

    @GetMapping(value = "/{id}/postulant")
    public ResponseEntity<List<Postulant_Subscription>> getAllSubscriptionByIdPostulant(@PathVariable("id") Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return ResponseEntity.noContent().build();

        List<Postulant_Subscription> postulantSubscriptionList = postulantSubscriptionService.findBySubscription(subscription);
        if(postulantSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscriptionList);
    }

    @GetMapping(value = "/postulant/{id}")
    public ResponseEntity<List<Postulant_Subscription>> getSubscriptionByIDPostulant(@PathVariable("id") Long id) {
        Postulant postulant = postulantService.getPostulant(id);
        if(postulant == null) return ResponseEntity.noContent().build();

        List<Postulant_Subscription> postulantSubscriptionList = postulantSubscriptionService.getPostulant_Subscription(postulant);
        if(postulantSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscriptionList);
    }
    @GetMapping(value = "/postulant/{id}/last")
    public ResponseEntity<Postulant_Subscription> getLastSubscriptionByIdPostulant(@PathVariable("id") Long id) {
        Postulant postulant = postulantService.getPostulant(id);
        if(postulant == null) return ResponseEntity.noContent().build();

        Postulant_Subscription postulantSubscription = postulantSubscriptionService.findPostulant_LastSubscription(postulant);
        if(postulantSubscription == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscription);
    }

    @GetMapping(value = "/employer")
    public ResponseEntity<List<Employer_Subscription>> getAllSubscriptionEmployer() {
        List<Employer_Subscription> employerSubscriptionList = employer_subscriptionService.getAllEmployer_Subscription();
        if(employerSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employerSubscriptionList);
    }

    @GetMapping(value = "/{id}/employer")
    public ResponseEntity<List<Employer_Subscription>> getAllSubscriptionByIdEmployer(@PathVariable("id") Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return ResponseEntity.noContent().build();

        List<Employer_Subscription> employerSubscriptionList = employer_subscriptionService.findBySubscription(subscription);
        if(employerSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employerSubscriptionList);
    }

    @GetMapping(value = "/employer/{id}")
    public ResponseEntity<List<Employer_Subscription>> getSubscriptionByIdEmployer(@PathVariable("id") Long id) {
        Employer employer = employerService.getEmployer(id);
        if(employer == null) return ResponseEntity.noContent().build();

        List<Employer_Subscription> employerSubscriptionList = employer_subscriptionService.getEmployer_Subscription(employer);
        if(employerSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employerSubscriptionList);
    }
    @GetMapping(value = "/employer/{id}/last")
    public ResponseEntity<Employer_Subscription> getLastSubscriptionByIdEmployer(@PathVariable("id") Long id) {
        Employer employer = employerService.getEmployer(id);
        if(employer == null) return ResponseEntity.noContent().build();

        Employer_Subscription employerSubscription = employer_subscriptionService.findEmployer_LastSubscription(employer);
        if(employerSubscription == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employerSubscription);
    }


    @PostMapping(value = "/employer")
    public ResponseEntity<Employer_Subscription> createSubscriptionEmployer(@RequestBody Employer_Subscription employer_subscription) {
        if(employer_subscription == null) return ResponseEntity.noContent().build();
        Subscription subscription = subscriptionService.getSubscription(employer_subscription.getSubscription().getId());
        if(subscription == null) return ResponseEntity.noContent().build();

        Employer employer = employerService.getEmployer(employer_subscription.getEmployer().getId());
        if(employer == null) return ResponseEntity.noContent().build();

        Employer_Subscription employerSubscription = employer_subscriptionService.createEmployer_Subscription(employer_subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(employerSubscription);
    }
    @PostMapping(value = "/postulant")
    public ResponseEntity<Postulant_Subscription> createSubscription(@RequestBody Postulant_Subscription postulant_subscription) {
        if(postulant_subscription == null) return ResponseEntity.noContent().build();
        Subscription subscription = subscriptionService.getSubscription(postulant_subscription.getSubscription().getId());
        if(subscription == null) return ResponseEntity.noContent().build();

        Employer employer = employerService.getEmployer(postulant_subscription.getPostulant().getId());
        if(employer == null) return ResponseEntity.noContent().build();

        Postulant_Subscription employerSubscription = postulantSubscriptionService.createPostulant_Subscription(postulant_subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(employerSubscription);
    }
    @DeleteMapping(value = "/employer/{id}")
    public void deleteSubscriptionEmployer(@PathVariable Long id) {
        employer_subscriptionService.deleteEmployer_Subscription(id);
    }
    @DeleteMapping(value = "/postulant/{id}")
    public void deleteSubscriptionPostulant(@PathVariable Long id) {
        postulantSubscriptionService.deletePostulant_Subscription(id);
    }

}
