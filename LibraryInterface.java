import java.util.Scanner;

public class LibraryInterface {
    private Library library;
    private Scanner scanner;

    public LibraryInterface(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Print All Books");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    printAllBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void addBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void removeBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        boolean removed = library.removeBook(title);
        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found or already removed.");
        }
    }

    private void borrowBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter user name:");
        String userName = scanner.nextLine();
        User user = new User(userName);
        boolean borrowed = library.borrowBook(title, user);
        if (borrowed) {
            System.out.println(userName + " borrowed " + title);
        } else {
            System.out.println("Book not available for borrowing or not found.");
        }
    }

    private void returnBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter user name:");
        String userName = scanner.nextLine();
        User user = new User(userName);
        boolean returned = library.returnBook(title, user);
        if (returned) {
            System.out.println(userName + " returned " + title);
        } else {
            System.out.println("Book not found or not borrowed by " + userName);
        }
    }

    private void printAllBooks() {
        library.printAllBooks();
    }
}
