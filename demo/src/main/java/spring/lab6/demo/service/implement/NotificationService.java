package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Notification;
import spring.lab6.demo.model.NotificationStatusEnum;
import spring.lab6.demo.repository.NotificationRepository;
import spring.lab6.demo.service.INotificationService;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public int getUnreadNotificationSizeByMemberLogin(String login) {
        return notificationRepository.countNotificationsByMember_LoginAndStatus(login, NotificationStatusEnum.UNREAD);
    }

    @Override
    public List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status) {
        return notificationRepository.getNotificationsByMember_LoginAndStatus(login, status);
    }

    @Override
    public void saveAll(List<Notification> notifications) {
        notificationRepository.saveAll(notifications);
    }
}
