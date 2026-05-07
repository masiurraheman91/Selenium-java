package DAV_School;



import java.sql.*;

public class TeacherService {
    public static void viewTeachers() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {

            System.out.printf("\n%-5s %-20s %-20s %-15s\n", "ID", "Name", "Subject", "Phone");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-20s %-15s\n",
                        rs.getInt("teacher_id"), rs.getString("name"),
                        rs.getString("subject"), rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

