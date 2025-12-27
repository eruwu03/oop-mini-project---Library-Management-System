import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentBook {

    private static final String DB_URL = "jdbc:mysql://100.75.93.2:3306/library_management_system";
    private static final String DB_USER = "najmi";
    private static final String DB_PASS = "Katakunci#25";

    //  SEARCH STATUS BY ID 
    public String checkAvailabilityById(String searchId) {
        String status = "Not Found";
        String query = "SELECT status FROM books WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, searchId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //  SAVE RENTAL 
    public String saveRental(String bookId, String memberId, String duration) {
        int days;
        try {
            days = Integer.parseInt(duration);
            if (days <= 0) return "InputError";
        } catch (NumberFormatException ex) {
            return "InputError";
        }

        LocalDate startDate = LocalDate.now();
        LocalDate dueDate = startDate.plusDays(days);

        String insertRental = "INSERT INTO rentals (book_id, member_id, days, start_date, due_date) VALUES (?, ?, ?, ?, ?)";
        String updateBook = "UPDATE books SET status = 'Rented' WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt1 = conn.prepareStatement(insertRental);
             PreparedStatement pstmt2 = conn.prepareStatement(updateBook)) {

            pstmt1.setString(1, bookId);
            pstmt1.setString(2, memberId);
            pstmt1.setInt(3, days);
            pstmt1.setDate(4, Date.valueOf(startDate));
            pstmt1.setDate(5, Date.valueOf(dueDate));
            pstmt1.executeUpdate();

            pstmt2.setString(1, bookId);
            pstmt2.executeUpdate();

            return "Success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // RETURN BOOK 
    public String returnBook(String bookId, String memberId) {
        String deleteRental = "DELETE FROM rentals WHERE book_id = ? AND member_id = ?";
        String updateBook = "UPDATE books SET status = 'Available' WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt1 = conn.prepareStatement(deleteRental);
             PreparedStatement pstmt2 = conn.prepareStatement(updateBook)) {

            pstmt1.setString(1, bookId);
            pstmt1.setString(2, memberId);
            int rowsDeleted = pstmt1.executeUpdate();

            if (rowsDeleted > 0) {
                pstmt2.setString(1, bookId);
                pstmt2.executeUpdate();
                return "Success";
            } else {
                return "NotFound";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    //  VIEW CURRENT RENTALS 
    public void viewAllRentals() {
        String query = "SELECT * FROM rentals";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("--- Current Rentals ---");
            while (rs.next()) {
                System.out.println("BookID: " + rs.getString("book_id")
                        + " | Member: " + rs.getString("member_id")
                        + " | Days: " + rs.getInt("days")
                        + " | Start: " + rs.getDate("start_date")
                        + " | Due: " + rs.getDate("due_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
