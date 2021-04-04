package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Request;
import spring.lab6.demo.model.RequestStatusEnum;
import spring.lab6.demo.repository.RequestRepository;
import spring.lab6.demo.service.IRequestService;

import java.util.Date;
import java.util.List;

@Service
public class RequestService implements IRequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void makeNewRequest(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<Request> getByMemberLoginAndStatus(String login, RequestStatusEnum status) {
        return requestRepository.getRequestByMember_LoginAndStatusIs(login, status);
    }

    @Override
    public List<Request> getByMemberLoginAndStatusIsAndLastDateLessThan(String login, RequestStatusEnum status, Date date) {
        return requestRepository.getRequestsByMember_LoginAndStatusIsAndLastDateLessThan(login, status, date);
    }

    @Override
    public List<Request> getStatusAndLastDateLessThan(RequestStatusEnum status, Date date) {
        return requestRepository.getRequestsByStatusAndLastDateLessThan(status, date);
    }

    @Override
    public List<Request> getByStatus(RequestStatusEnum status) {
        return requestRepository.getRequestByStatus(status);
    }

    @Override
    public void updateRequest(Request request) {
        requestRepository.save(request);
    }
}
