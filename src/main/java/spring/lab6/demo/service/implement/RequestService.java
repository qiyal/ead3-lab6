package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.controller.NotificationController;
import spring.lab6.demo.entity.Book;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.entity.Notification;
import spring.lab6.demo.entity.Request;
import spring.lab6.demo.model.NotificationStatusEnum;
import spring.lab6.demo.model.RequestStatusEnum;
import spring.lab6.demo.repository.RequestRepository;
import spring.lab6.demo.service.IRequestService;

import java.util.Date;
import java.util.List;

@Service
public class RequestService implements IRequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private NotificationService notificationService;

    @Override
    public Request makeNewRequest(String login, Long bookId) {
        Request request = new Request();
        Book book = bookService.getBookById(bookId);
        Member member = memberService.getByLogin(login);
        request.setBook(book);
        request.setMember(member);
        request.setStatus(RequestStatusEnum.IN_PROCESSION_ISSUE);
        return requestRepository.saveAndFlush(request);
    }

    @Override
    public List<Request> getByMemberLoginAndStatus(String login, RequestStatusEnum status) {
        return requestRepository.getRequestByMember_LoginAndStatusIs(login, status);
    }

    @Override
    public List<Request> getLastDateLessThanByMemberLogin(String login) {
        return requestRepository.getRequestsByMember_LoginAndStatusAndLastDateLessThan(login, RequestStatusEnum.ISSUE, new Date());
    }

    @Override
    public List<Request> getLastDateLessThan() {
        return requestRepository.getRequestsByStatusAndLastDateLessThan(RequestStatusEnum.ISSUE, new Date());
    }

    @Override
    public List<Request> getByStatus(RequestStatusEnum status) {
        return requestRepository.getRequestByStatus(status);
    }

    public Request changeStatusToIssue(Long id) {
        Request request = requestRepository.getRequestById(id);
        request.setStatus(RequestStatusEnum.ISSUE);

        Date date = new Date();
        request.setIssuedDate(date);

        Date lasDay = new Date(request.getIssuedDate().getTime() + (60 * 60 * 24 * 14 * 1000));
        request.setLastDate(lasDay);

        Book book = request.getBook();
        bookService.decBookQuantitySave(book);

        Notification notification = new Notification();
        notification.setMember(request.getMember());
        notification.setStatus(NotificationStatusEnum.UNREAD);
        notification.setDate(date);
        String message = "Your issue request(id=" + request.getId() + ") was accepted!";
        notification.setMessage(message);
        notificationService.saveNotification(notification);

        return requestRepository.saveAndFlush(request);
    }

    public Request changeStatusToReturn(Long id) {
        Request request = requestRepository.getRequestById(id);
        request.setStatus(RequestStatusEnum.RETURN);

        Date date = new Date();
        request.setReturnDate(date);

        Book book = request.getBook();
        bookService.incBookQuantitySave(book);

        Notification notification = new Notification();
        notification.setMember(request.getMember());
        notification.setStatus(NotificationStatusEnum.UNREAD);
        notification.setDate(date);
        String message = "Your return request(id=" + request.getId() + ") was accepted!";
        notification.setMessage(message);
        notificationService.saveNotification(notification);

        return requestRepository.saveAndFlush(request);
    }
}
