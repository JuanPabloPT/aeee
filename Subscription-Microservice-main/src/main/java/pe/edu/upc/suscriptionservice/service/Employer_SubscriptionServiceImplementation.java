package pe.edu.upc.suscriptionservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.suscriptionservice.entity.*;
import pe.edu.upc.suscriptionservice.repository.Employer_SubscriptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class Employer_SubscriptionServiceImplementation implements Employer_SubscriptionService  {
    @Autowired
    private Employer_SubscriptionRepository employer_subscriptionRepository;
    @Override
    public List<Employer_Subscription> getAllEmployer_Subscription() {
        List<Employer_Subscription> employer_subscriptions = employer_subscriptionRepository.findAll();
        if(employer_subscriptions == null) {return null;}
        return employer_subscriptions;
    }

    @Override
    public List<Employer_Subscription> getEmployer_Subscription(Employer employer) {
        return employer_subscriptionRepository.findByAllEmployer(employer);
    }

    @Override
    public Employer_Subscription createEmployer_Subscription(Employer_Subscription employer_subscription) {
        if(employer_subscription == null) return null;
        return employer_subscriptionRepository.save(employer_subscription);
    }

    @Override
    public Employer_Subscription updateEmployer_Subscription(Employer_Subscription employer_subscription) {
        if(employer_subscription == null) return null;
        Employer_Subscription employerDB = employer_subscriptionRepository.getById(employer_subscription.getId());
        if(employerDB == null) return null;
        employerDB.setEmployer(employer_subscription.getEmployer());
        employerDB.setSubscription(employer_subscription.getSubscription());
        employerDB.setDate(employer_subscription.getDate());
        return employer_subscriptionRepository.save(employerDB);
    }

    @Override
    public List<Employer_Subscription> findBySubscription(Subscription subscription) {
        return employer_subscriptionRepository.findBySubscription(subscription);
    }


    @Override
    public void deleteEmployer_Subscription(Long id) {
        Employer_Subscription employer_subscription = this.findSubscription(id);
        if(employer_subscription == null) return;
        employer_subscriptionRepository.delete(employer_subscription);
    }

    @Override
    public Employer_Subscription findEmployer_LastSubscription(Employer employer) {
        Employer_Subscription employer_subscription = employer_subscriptionRepository.findLastSubscriptionEmployer(employer);
        if(employer_subscription == null) return null;
        return  employer_subscription;
    }
    @Override
    public  Employer_Subscription findSubscription(Long id) {
        Employer_Subscription employerSubscription = employer_subscriptionRepository.findById(id).orElse(null);
        if(employerSubscription == null) return null;
        return employerSubscription;
    }
}
