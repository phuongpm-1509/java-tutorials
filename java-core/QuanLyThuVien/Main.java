import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

abstract class Book {
    public Number id;
    public String title;
    public String author;
    public boolean isAvailable;

    Book(Number id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return "[" + id + "] - " + title + " - " + author + " - " + (isAvailable ? "Available" : "Not available");
    }
}

class TextBook extends Book {
    public String subject;

    TextBook(Number id, String title, String author, boolean isAvailable, String subject) {
        super(id, title, author, isAvailable);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + subject;
    }
}

class Novel extends Book {
    public String genre;

    Novel(Number id, String title, String author, boolean isAvailable, String genre) {
        super(id, title, author, isAvailable);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + genre;
    }
}

class User {
    public Number id;
    public String name;

    User(Number id, String name) {
        this.id = id;
        this.name = name;
    }
}

class BorrowedBook {
    public Number bookId;
    public Number userId;
    public LocalDate borrowDate;
    public LocalDate returnDate;

    BorrowedBook(Number bookId, Number userId, LocalDate borrowDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}

class Library {
    public List<Book> books;
    public List<User> users;
    public List<BorrowedBook> borrowedBooks;
}

public class Main {

    public static int getValidIntegerInput(Scanner sc, String prompt) {
        int result;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            try {
                result = Integer.parseInt(sc.nextLine());
                isValid = true;
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return -1;
    }

    public static Book findBook(List<Book> books, Number bookId) {
        Book foundBook = books.stream()
                .filter(b -> b.id.equals(bookId))
                .findFirst()
                .orElse(null);
        return foundBook;
    }

    public static User findUser(List<User> users, Number userId) {
        User foundUser = users.stream()
                .filter(u -> u.id.equals(userId))
                .findFirst()
                .orElse(null);
        return foundUser;
    }

    public static BorrowedBook findBorrowedBook(List<BorrowedBook> borrowedBooks, Number bookId, Number userId) {
        BorrowedBook foundBorrowedBook = borrowedBooks.stream()
                .filter(b -> b.bookId.equals(bookId) && b.userId.equals(userId) && b.returnDate == null)
                .findFirst()
                .orElse(null);
        return foundBorrowedBook;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.books = new ArrayList<Book>();
        library.users = new ArrayList<User>();
        library.borrowedBooks = new ArrayList<BorrowedBook>();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xem danh sách sách");
            System.out.println("3. Tìm sách theo tên");
            System.out.println("4. Mượn sách");
            System.out.println("5. Trả sách");
            System.out.println("0. Thoát");

            int choose = getValidIntegerInput(sc, "Chọn: ");

            switch (choose) {
                case 1:
                    System.out.println("-----Nhập thông tin sách-----");
                    Number newBookId = -1;
                    boolean isExist = false;

                    do {
                        newBookId = getValidIntegerInput(sc, "Nhập ID[sách][số nguyên]: ");
                        Book book = findBook(library.books, newBookId);
                        if (book != null) {
                            System.out.println("ID sách đã tồn tại. Vui lòng nhập ID khác.");
                            isExist = true;
                            continue;
                        }
                        break;

                    } while (isExist);

                    System.out.print("Nhập Tên[sách]: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập Tác Giả[sách]: ");
                    String author = sc.nextLine();

                    System.out.println("Chọn loại sách: ");
                    System.out.println("1. Sách giáo khoa");
                    System.out.println("2. Tiểu thuyết");

                    int bookType = getValidIntegerInput(sc, "Chọn loại: ");
                    Book newBook = null;
                    switch (bookType) {
                        case 1:
                            System.out.print("Nhập Môn học: ");
                            String subject = sc.nextLine();
                            newBook = new TextBook(newBookId, name, author, true, subject);
                            break;
                        case 2:
                            System.out.print("Nhập Thể loại: ");
                            String genre = sc.nextLine();
                            newBook = new Novel(newBookId, name, author, true, genre);
                            break;
                        default:
                            System.out.println("Loại sách không hợp lệ. Thêm sách thất bại.");
                            break;
                    }
                    if (newBook != null) {
                        library.books.add(newBook);
                        System.out.println("Thêm sách thành công!");
                    }
                    break;

                case 2:
                    System.out.println("List sách:");
                    for (Book book : library.books) {
                        System.out.println(book.toString());
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên[sách] tìm kiếm: ");
                    String searchTitle = sc.nextLine();

                    for (Book book : library.books) {
                        if (book.title.toLowerCase().contains(searchTitle.toLowerCase())) {
                            System.out.println(book.toString());
                        }
                    }
                    break;

                case 4:
                    // Input book Id
                    Number bookId = getValidIntegerInput(sc, "Nhập ID[sách] mượn: ");
                    Book borrowBook = findBook(library.books, bookId);
                    if (borrowBook == null) {
                        System.out.println("Không tìm thấy sách với ID đã nhập.");
                        break;
                    }
                    if (!borrowBook.isAvailable) {
                        System.out.println("Sách hiện không khả dụng để mượn.");
                        break;
                    }
                    // Input user info
                    Number newUserId = getValidIntegerInput(sc, "Nhập ID[User] mượn: ");
                    User user = findUser(library.users, newUserId);
                    if (user == null) {
                        System.out.print("Nhập tên[User]: ");
                        String newUserName = sc.nextLine();
                        user = new User(newUserId, newUserName);
                        library.users.add(user);
                    }

                    // Register borrow book
                    System.out.println("-----Thông tin mượn sách-----");
                    System.out.println("Người mượn: [" + user.id + "] - " + user.name);
                    System.out.println("Sách: [" + borrowBook.id + "] - " + borrowBook.title);
                    System.out.println("Ngày mượn: " + LocalDate.now());

                    borrowBook.isAvailable = false;
                    library.borrowedBooks.add(new BorrowedBook(bookId, user.id, LocalDate.now(), null));

                    System.out.println("Đăng ký mượn sách thành công");
                    break;

                case 5:
                    // Input book Id
                    Number returnBookId = getValidIntegerInput(sc, "Nhập ID[Sách] trả: ");
                    Book returnBook = findBook(library.books, returnBookId);
                    if (returnBook == null) {
                        System.out.println("Không tìm thấy sách với ID đã nhập.");
                        break;
                    }

                    // Input user Id
                    Number returnUserId = getValidIntegerInput(sc, "Nhập ID[User] trả: ");
                    User returnUser = findUser(library.users, returnUserId);
                    if (returnUser == null) {
                        System.out.println("Không tìm thấy User với ID đã nhập.");
                        break;
                    }

                    BorrowedBook borrowedBook = findBorrowedBook(library.borrowedBooks, returnBookId, returnUserId);
                    if (borrowedBook == null) {
                        System.out.println(
                                "Không tìm thấy thông tin mượn sách với ID đã nhập hoặc sách đã được trả.");
                        break;
                    }

                    borrowedBook.returnDate = LocalDate.now();
                    returnBook.isAvailable = true;
                    System.out.println("Trả sách thành công!");
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }

        }
    }
}
