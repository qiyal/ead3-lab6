package spring.lab6.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import spring.lab6.demo.model.RequestStatusEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date issuedDate;
    private Date lastDate;
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    private RequestStatusEnum status;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "member_id")
    private Member member;

    // empty constructor
//    public Request() {}

    // getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Date getIssuedDate() {
//        return issuedDate;
//    }
//
//    public void setIssuedDate(Date issuedDate) {
//        this.issuedDate = issuedDate;
//    }
//
//    public Date getLastDate() {
//        return lastDate;
//    }
//
//    public void setLastDate(Date lastDate) {
//        this.lastDate = lastDate;
//    }
//
//    public Date getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(Date returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public RequestStatusEnum getStatus() {
//        return status;
//    }
//
//    public void setStatus(RequestStatusEnum status) {
//        this.status = status;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
}
