package DAV_School;


import java.sql.*;

public class LoginService {
    public static boolean login(String username, String password) {
        boolean isValid = false;
        try (Connection con = DBConnection.getConnection()) 
        {
            String sql = "SELECT * FROM staff WHERE username = ? AND password = ?";
            try (PreparedStatement ps = con.prepareStatement(sql))
            {
                ps.setString(1, username);
                
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful. Role " + rs.getString("role"));
                    isValid = true;
                } 
                else
                {
                    System.out.println("Invalid username or password.");
                }
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return isValid;
    }
}

