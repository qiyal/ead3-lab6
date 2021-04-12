package spring.lab7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab7.demo.entity.Request;
import spring.lab7.demo.model.RequestStatusEnum;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> getRequestByMember_LoginAndStatusIs(String login, RequestStatusEnum status);
    List<Request> getRequestsByMember_LoginAndStatusIsAndLastDateLessThan(String login, RequestStatusEnum status, Date date);
    List<Request> getRequestsByStatusAndLastDateLessThan(RequestStatusEnum status, Date date);
    List<Request> getRequestByStatus(RequestStatusEnum status);
}
