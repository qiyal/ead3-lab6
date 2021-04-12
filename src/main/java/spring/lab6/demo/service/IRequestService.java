package spring.lab6.demo.service;

import spring.lab6.demo.entity.Request;
import spring.lab6.demo.model.RequestStatusEnum;

import java.util.Date;
import java.util.List;

public interface IRequestService {
    Request makeNewRequest(String login, Long bookId);
    List<Request> getByMemberLoginAndStatus(String login, RequestStatusEnum status);
    List<Request> getLastDateLessThanByMemberLogin(String login);
    List<Request> getLastDateLessThan();
    List<Request> getByStatus(RequestStatusEnum status);
}
