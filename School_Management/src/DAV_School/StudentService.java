package DAV_School;

	import java.sql.*;
	import java.util.Scanner;

	public class StudentService {
	    public static void registerStudent(Scanner sc) {
	        try (Connection con = DBConnection.getConnection()) {
	            System.out.print("Name ");
	            String name = sc.nextLine();

	            System.out.print("Age: ");
	            int age = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Grade: ");
	            String grade = sc.nextLine();

	            System.out.print("Phone: ");
	            String phone = sc.nextLine();

	            System.out.print("Address: ");
	            String address = sc.nextLine();
	            
	            
	            String checkSql = "SELECT COUNT(*) FROM student WHERE grade=?";
	            try (PreparedStatement psCheck = con.prepareStatement(checkSql)) {
	                psCheck.setString(1, grade);
	                ResultSet rs = psCheck.executeQuery();
	                rs.next();
	                int count = rs.getInt(1);

	                if (count > 5) {
	                    System.out.println("Strength of the grade is already full");
	                    return;
	                }
	            }
	            
	            

	            String sql = "INSERT INTO student (name, age, grade, phone, address) VALUES (?, ?, ?, ?, ?)";
	            try (PreparedStatement ps = con.prepareStatement(sql)) {
	                ps.setString(1, name);
	                ps.setInt(2, age);
	                ps.setString(3, grade);
	                ps.setString(4, phone);
	                ps.setString(5, address);
	                ps.executeUpdate();
	            }

	            System.out.println("✅ Student registered successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void viewStudentByNameAndGrade(Scanner sc) {
	        try (Connection con = DBConnection.getConnection()) {
	            System.out.print("Enter Student Name: ");
	            String name = sc.nextLine();
	            System.out.print("Enter Grade: ");
	            String grade = sc.nextLine();

	            String sql = "SELECT * FROM student WHERE name = ? AND grade = ?";
	            try (PreparedStatement ps = con.prepareStatement(sql)) {
	                ps.setString(1, name);
	                ps.setString(2, grade);
	                ResultSet rs = ps.executeQuery();

	                if (!rs.next()) {
	                    System.out.println(" No student found.");
	                } else {
	                    do {
	                        System.out.printf("ID: %d | Name: %s | Age: %d | Grade: %s | Phone: %s | Address: %s\n",
	                        		rs.getInt("student_id"), rs.getString("name"), rs.getInt("age"),
	                                rs.getString("grade"), rs.getString("phone"), rs.getString("address"));
	                    } while (rs.next());
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



