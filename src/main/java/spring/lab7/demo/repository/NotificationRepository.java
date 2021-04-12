package spring.lab7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab7.demo.entity.Notification;
import spring.lab7.demo.model.NotificationStatusEnum;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Integer countNotificationsByMember_LoginAndStatus(String login, NotificationStatusEnum status);
    List<Notification> getNotificationsByMember_LoginAndStatus(String login, NotificationStatusEnum status);
}
