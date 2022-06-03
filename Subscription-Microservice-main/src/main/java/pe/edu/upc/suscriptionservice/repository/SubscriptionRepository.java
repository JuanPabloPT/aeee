package pe.edu.upc.suscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.suscriptionservice.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
