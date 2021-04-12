package spring.lab7.demo.service;

import spring.lab7.demo.entity.Notification;
import spring.lab7.demo.model.NotificationStatusEnum;

import java.util.List;

public interface INotificationService {
    void saveNotification(Notification notification);
    int getUnreadNotificationSizeByMemberLogin(String login);
    List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status);
    void saveAll(List<Notification> notifications);
}
