package spring.lab6.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.lab6.demo.controller.*;
import spring.lab6.demo.entity.*;
import spring.lab6.demo.entity.Collection;
import spring.lab6.demo.model.NotificationStatusEnum;
import spring.lab6.demo.model.RequestStatusEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

@Component
public class LibraryManagementSystem {
    @Autowired
    private MemberController memberController;
    @Autowired
    private AdminController adminController;
    @Autowired
    private BookController bookController;
    @Autowired
    private RequestController requestController;
    @Autowired
    private NotificationController notificationController;
    @Autowired
    private CollectionController collectionController;

    @Autowired
    @Qualifier("getScannerBean")
    private Scanner sc;
    @Autowired
    @Qualifier("getBufferedReader")
    private BufferedReader reader;

    private boolean isAuth;
    private boolean isAdmin;
    private String currentUser;

    public LibraryManagementSystem() {}

    private void login() {
        String op, login, password;
        boolean status;

        while (true) {
            System.out.println("\n1 - Member");
            System.out.println("2 - Admin");
            System.out.print("input: ");
            op = sc.next();

            if (op.equals("1")) {
                System.out.print("\nLogin: ");
                login = sc.next();

                System.out.print("Password: ");
                password = sc.next();

                status = memberController.check(login, password);

                if (status) {
                    currentUser = login;
                    isAdmin = false;
                    isAuth = true;
                    break;
                } else {
                    System.out.println("Login or password is not correct!");
                }
            } else if (op.equals("2")) {
                System.out.print("\nUsername: ");
                login = sc.next();

                System.out.print("Password: ");
                password = sc.next();

                status = adminController.check(login, password);

                if (status) {
                    currentUser = login;
                    isAdmin = true;
                    isAuth = true;
                    break;
                } else {
                    System.out.println("Login or password is not correct!");
                }
            } else {
                System.out.println("Invalid argument, try again!");
            }
        }
    }

    private void logout() {
        isAuth = false;
        isAdmin = false;
        currentUser = null;
        System.out.println("\n--- Logout ---\n");
    }

    private void makeNewIssueRequest() {
        List<Book> books = bookController.getBooksIsAvailability();

        System.out.println("--- Books ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ") " + books.get(i).getShortInfoStr());
        }
        System.out.print("input: ");
        int bookIndex = sc.nextInt();

        Book book = books.get(bookIndex - 1);
        Member member = memberController.getMember(currentUser);

        Request request = new Request();
        request.setStatus(RequestStatusEnum.IN_PROCESSION_ISSUE);
        request.setBook(book);
        request.setMember(member);

        requestController.makeNewRequest(request);
    }

    private void makeNewReturnRequest() {
        List<Request> requests = requestController.getRequestByMemberLoginAndStatus(currentUser, RequestStatusEnum.ISSUE);

        System.out.println("\n--- Request ISSUE ---");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ") " + requests.get(i));
        }
        System.out.print("input: ");
        int requestIndex = sc.nextInt();

        Request request = requests.get(requestIndex - 1);

        requestController.changeStatusToReturn(request);
        bookController.incBookQuantitySave(request.getBook());

        Notification notification = new Notification();
        notification.setDate(request.getIssuedDate());
        notification.setMessage("Your request (RETURN) has been accepted.\nBook: " + request.getBook().getShortInfoStr());
        notification.setMember(request.getMember());
        notification.setStatus(NotificationStatusEnum.UNREAD);
        notificationController.saveNotification(notification);
    }

    private void searchBooks(int type) throws IOException {
        System.out.println("\n--- Search Books ---");
        List<Book> books;

        if (type == 1) {
            System.out.print("input book name: ");
            books = bookController.getBooksByName(reader.readLine().trim());
        } else if (type == 2) {
            System.out.print("input book author: ");
            books = bookController.getBooksByAuthor(reader.readLine().trim());
        } else {
            System.out.print("input book description: ");
            books = bookController.getBooksByDescription(reader.readLine().trim());
        }

        System.out.println("\n--- Books ---");
        System.out.println("Books size: " + books.size());
        int i = 0;
        for (Book book : books) {
            System.out.println((i++ + 1) + ") " + book.getShortInfoStr());
        }
    }

    private void showRequestedBooks() {
        List<Request> requests = requestController.getRequestByMemberLoginAndStatus(currentUser, RequestStatusEnum.IN_PROCESSION_ISSUE);

        System.out.println("\n--- Requested Books ---");
        int i = 0;
        for (Request request : requests) {
            System.out.println((i++ + 1) + ") " + request.getBook().getShortInfoStr());
        }
    }

    private void showMyIssuedBooks() {
        List<Request> requests = requestController.getRequestByMemberLoginAndStatus(currentUser, RequestStatusEnum.ISSUE);

        System.out.println("\n--- Request ISSUE ---");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ") " + requests.get(i));
        }
    }

    private void showBooksAvailability() {
        List<Book> books = bookController.getBooksIsAvailability();

        int i = 0;
        System.out.println("\n--- Books Availability ---");
        for (Book book : books) {
            System.out.println((i++ + 1) + ") " + book.getShortInfoStr());
        }
    }

    private void showMyBooksOverDueDate() {
        Date date = new Date();
        List<Request> requests = requestController.getByMemberLoginAndStatusIsAndLastDateLessThan(
                currentUser,
                RequestStatusEnum.ISSUE,
                date
        );

        int i = 0;
        System.out.println("\n-- My Books Over DueDate ---");
        for (Request request : requests) {
            System.out.println((i++ + 1) + ") " + request);
        }
    }

    private void showMyUnreadNotifications() {
        List<Notification> notifications = notificationController.getByMemberLoginAndStatus(currentUser, NotificationStatusEnum.UNREAD);

        System.out.println("\n--- My Unread Notifications ---");
        int i = 0;
        for (Notification notification : notifications) {
            System.out.println((i++ + 1) + ") " + notification);
        }

        notificationController.changeNotificationsStatusToRead(notifications);
    }

    private void showAllIssuedBooks() {
        List<Request> requests = requestController.getRequestByStatus(RequestStatusEnum.ISSUE);

        int i = 0;
        System.out.println("--- All Issued Books ---");
        for (Request request : requests) {
            System.out.println(request.getBook().getShortInfoStr());
        }
    }

    private void showAllRequestedBooks() {
        List<Request> requests = requestController.getRequestByStatus(RequestStatusEnum.IN_PROCESSION_ISSUE);

        int i = 0;
        System.out.println("--- All Requested Books ---");
        for (Request request : requests) {
            System.out.println(request.getBook().getShortInfoStr());
        }
    }

    private void showAllBooksOverDueDate() {
        List<Request> requests = requestController.getStatusAndLastDateLessThan(RequestStatusEnum.ISSUE, new Date());

        int i = 0;
        System.out.println("--- All Books Over Due Date ---");
        for (Request request : requests) {
            System.out.println(request.getBook().getShortInfoStr());
        }
    }

    public int getUnreadNotificationSize() {
        return notificationController.getCountUnreadByMember_Login(currentUser);
    }

    private void changeIN_PROCESSION_ISSUEtoISSUE() {
        List<Request> requests = requestController.getRequestByStatus(RequestStatusEnum.IN_PROCESSION_ISSUE);

        int i = 0;
        System.out.println("\n--- Request IN_PROCESSION_ISSUE ---");
        for (Request request : requests) {
            System.out.println((i++ + 1) + ") " + request);
        }
        System.out.println("input: ");
        i = sc.nextInt();

        Request request = requests.get(i - 1);

        bookController.decBookQuantitySave(request.getBook());
        requestController.changeStatusToIssue(request);

        Notification notification = new Notification();
        notification.setDate(request.getIssuedDate());
        notification.setMessage("Your request (ISSUE) has been accepted.\nBook: " + request.getBook().getShortInfoStr());
        notification.setMember(request.getMember());
        notification.setStatus(NotificationStatusEnum.UNREAD);
        notificationController.saveNotification(notification);
    }

    private  void addNewCollection() throws IOException {
        System.out.println("\n--- Add New Collection ---");
        Set<Book> bookSet = new HashSet<>();
        Collection collection = new Collection();
        List<Book> books = bookController.getAllBook();

        System.out.print("Collection Name: ");
        collection.setName(reader.readLine().trim());

        while(true) {
            int i = 0;
            System.out.println("--- All Books ---");
            for (Book book : books) {
                System.out.println((i++ + 1) + ") " + book.getShortInfoStr());
            }
            System.out.print("input: ");
            int indexBook = sc.nextInt();

            bookSet.add(books.get(indexBook - 1));

            System.out.println("Want to add another book to new collection?");
            System.out.print("y (yes) / n (no): ");
            if (sc.next().equalsIgnoreCase("n")) {
                List<Book> collectionBooks = new ArrayList<>();
                collectionBooks.addAll(bookSet);
                collection.setBooks(collectionBooks);
                break;
            }
        }

        collectionController.saveNewCollection(collection);
    }

    public void run() throws IOException {
        String op;
        boolean statusRun = true;

        while (statusRun) {
            if (!isAuth) {
                System.out.println("1 - Login");
                System.out.println("0 - EXIT");
                System.out.print("input: ");
                op = sc.next();

                switch (op) {
                    case "1":
                        login();
                        break;
                    case "0":
                        statusRun = false;
                        System.out.println("\n--- APP EXIT ---");
                        break;
                    default:
                        System.out.println("\nInvalid argument, try again!");
                }
            } else {
                if (!isAdmin) {
                    System.out.println("\nMember Login: " + currentUser);
                    System.out.println("1 - new issue request");
                    System.out.println("2 - new return request");
                    System.out.println("\n3 - search books by name");
                    System.out.println("4 - search books by description");
                    System.out.println("5 - search books by author");
                    System.out.println("\n6 - show my issued books");
                    System.out.println("7 - show my requested books");
                    System.out.println("8 - show my books over due date");
                    System.out.println("9 - Show books availability");
                    if (getUnreadNotificationSize() != 0) {
                        System.out.println("10 - show my unread notifications");
                    }
                    System.out.println("\n0 - Logout");
                    System.out.print("input: ");
                    op = sc.next();

                    switch (op) {
                        case "1":
                            makeNewIssueRequest();
                            break;
                        case "2":
                            makeNewReturnRequest();
                            break;
                        case "3":
                            searchBooks(1);
                            break;
                        case "4":
                            searchBooks(2);
                            break;
                        case "5":
                            searchBooks(3);
                            break;
                        case "6":
                            showMyIssuedBooks();
                            break;
                        case "7":
                            showRequestedBooks();
                            break;
                        case "8":
                            showMyBooksOverDueDate();
                            break;
                        case "9":
                            showBooksAvailability();
                            break;
                        case "10":
                            showMyUnreadNotifications();
                            break;
                        case "0":
                            logout();
                            break;
                        default:
                            System.out.println("\nInvalid argument, try again!");
                    }
                } else {
                    System.out.println("\nAdmin: " + currentUser);
                    System.out.println("1 - change IN_IN_PROCESSION_ISSUE to ISSUE");
                    System.out.println("2 - add new collection");
                    System.out.println("\n3 - search books by name");
                    System.out.println("4 - search books by description");
                    System.out.println("5 - search books by author");
                    System.out.println("\n6 - show all issued books");
                    System.out.println("7 - show all requested books");
                    System.out.println("8 - show all books over due date");
                    System.out.println("9 - Show books availability");
                    System.out.println("\n0 - Logout");
                    System.out.print("input: ");
                    op = sc.next();

                    switch (op) {
                        case "1":
                            changeIN_PROCESSION_ISSUEtoISSUE();
                            break;
                        case "2":
                            addNewCollection();
                            break;
                        case "3":
                            searchBooks(1);
                            break;
                        case "4":
                            searchBooks(2);
                            break;
                        case "5":
                            searchBooks(3);
                            break;
                        case "6":
                            showAllIssuedBooks();
                            break;
                        case "7":
                            showAllRequestedBooks();
                            break;
                        case "8":
                            showAllBooksOverDueDate();
                            break;
                        case "9":
                            showBooksAvailability();
                            break;
                        case "0":
                            logout();
                            break;
                        default:
                            System.out.println("\nInvalid argument, try again!");
                    }
                }
            }
        }
    }
}
