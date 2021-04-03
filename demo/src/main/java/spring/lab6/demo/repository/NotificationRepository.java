package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
