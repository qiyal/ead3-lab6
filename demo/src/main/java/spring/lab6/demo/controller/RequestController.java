package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.lab6.demo.entity.Request;
import spring.lab6.demo.model.RequestStatusEnum;
import spring.lab6.demo.service.implement.RequestService;

import java.util.Date;
import java.util.List;

@Controller
public class RequestController {
    @Autowired
    private RequestService requestService;

    public void makeNewRequest(Request request) {
        requestService.makeNewRequest(request);
    }

    public List<Request> getRequestByMemberLoginAndStatus(String login, RequestStatusEnum status) {
        return requestService.getByMemberLoginAndStatus(login, status);
    }

    public List<Request> getByMemberLoginAndStatusIsAndLastDateLessThan(String login, RequestStatusEnum status, Date date) {
        return requestService.getByMemberLoginAndStatusIsAndLastDateLessThan(login, status, date);
    }

    public List<Request> getStatusAndLastDateLessThan(RequestStatusEnum status, Date date) {
        return requestService.getStatusAndLastDateLessThan(status, date);
    }

    public List<Request> getRequestByStatus(RequestStatusEnum status) {
        return requestService.getByStatus(status);
    }

    public void changeStatusToIssue(Request request) {
        request.setStatus(RequestStatusEnum.ISSUE);

        Date date = new Date();
        request.setIssuedDate(date);

        Date lasDay = new Date(request.getIssuedDate().getTime() + (60 * 60 * 24 * 14 * 1000));
        request.setLastDate(lasDay);

        requestService.updateRequest(request);
    }

    public void changeStatusToReturn(Request request) {
        request.setStatus(RequestStatusEnum.RETURN);

        Date date = new Date();
        request.setReturnDate(date);

        requestService.updateRequest(request);
    }

}
