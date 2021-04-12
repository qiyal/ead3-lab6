package spring.lab7.demo.service;

import spring.lab7.demo.entity.Request;
import spring.lab7.demo.model.RequestStatusEnum;

import java.util.Date;
import java.util.List;

public interface IRequestService {
    void makeNewRequest(Request request);
    List<Request> getByMemberLoginAndStatus(String login, RequestStatusEnum status);
    List<Request> getByMemberLoginAndStatusIsAndLastDateLessThan(String login, RequestStatusEnum status, Date date);
    List<Request> getStatusAndLastDateLessThan(RequestStatusEnum status, Date date);
    List<Request> getByStatus(RequestStatusEnum status);
    void updateRequest(Request request);
}
