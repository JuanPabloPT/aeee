package pe.edu.upc.suscriptionservice.service;

import pe.edu.upc.suscriptionservice.entity.*;

import java.util.List;

public interface Employer_SubscriptionService {
    public List<Employer_Subscription> getAllEmployer_Subscription();
    public List<Employer_Subscription> getEmployer_Subscription(Employer employer);
    public Employer_Subscription createEmployer_Subscription(Employer_Subscription employer_subscription);
    public Employer_Subscription updateEmployer_Subscription(Employer_Subscription employer_subscription);
    public List<Employer_Subscription> findBySubscription(Subscription subscription);
    public Employer_Subscription findEmployer_LastSubscription(Employer employer);
    public void deleteEmployer_Subscription(Long id);
    public  Employer_Subscription findSubscription(Long id);
}
