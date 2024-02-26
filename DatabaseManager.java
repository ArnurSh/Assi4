import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, is_borrowed) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setBoolean(3, book.isBorrowed());
            statement.executeUpdate();
        }
    }
}
