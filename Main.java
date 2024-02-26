import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String username = "postgres";
        String password = "1598753";

        Library library = new Library();
        LibraryInterface libraryInterface = new LibraryInterface(library);
        libraryInterface.start();

        try {
            DatabaseManager databaseManager = new DatabaseManager(url, username, password);
            Book book1 = new Book("Java Programming", "John Doe");
            Book book2 = new Book("Python Basics", "Jane Smith");
            databaseManager.addBook(book1);
            databaseManager.addBook(book2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}