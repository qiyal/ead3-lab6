package spring.lab6.demo.service;

import spring.lab6.demo.entity.Notification;
import spring.lab6.demo.model.NotificationStatusEnum;

import java.util.List;

public interface INotificationService {
    void saveNotification(Notification notification);
    int getUnreadNotificationSizeByMemberLogin(String login);
    List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status);
    void saveAll(List<Notification> notifications);
}
