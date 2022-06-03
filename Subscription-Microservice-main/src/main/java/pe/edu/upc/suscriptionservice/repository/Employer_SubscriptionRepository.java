package pe.edu.upc.suscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.suscriptionservice.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface Employer_SubscriptionRepository  extends JpaRepository<Employer_Subscription, Long>{
    public default Employer_Subscription findByEmployer(Employer employer) {
        List<Employer_Subscription> employer_subscriptionList = this.findAll();
        for(Employer_Subscription employerListing : employer_subscriptionList) {
            if(employerListing.getEmployer().equals(employer)) {
                return employerListing;
            }
        }
        return null;
    }
    public default  List<Employer_Subscription> findBySubscription(Subscription subscription) {
        List<Employer_Subscription> employer_subscriptionList = this.findAll();
        List<Employer_Subscription> oneSpecificSubscription = new ArrayList<>();
        for(Employer_Subscription es : employer_subscriptionList) {
            if(es.getSubscription().equals(subscription)) {
                oneSpecificSubscription.add(es);
            }
        }
        return oneSpecificSubscription;
    }
    public default List<Employer_Subscription> findByAllEmployer(Employer employer) {
        List<Employer_Subscription> employer_subscriptionList = this.findAll();
        List<Employer_Subscription> oneSpecificEmployer = new ArrayList<>();
        for(Employer_Subscription employerListing : employer_subscriptionList) {
            if(employerListing.getEmployer().equals(employer)) {
                oneSpecificEmployer.add(employerListing);
            }
        }
        return oneSpecificEmployer;
    }
    public default Employer_Subscription findLastSubscriptionEmployer(Employer employer) {
        List<Employer_Subscription> oneSpecificEmployer = this.findByAllEmployer(employer);

        return oneSpecificEmployer.get(oneSpecificEmployer.size()-1);
    }
}
