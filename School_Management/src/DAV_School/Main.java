package DAV_School;
import java.util.Scanner;

public class Main {
	

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("👤 Username: ");
	        String username = sc.nextLine();
	        System.out.print("🔒 Password: ");
	        String password = sc.nextLine();

	        if (!LoginService.login(username, password)) {
	            System.out.println("Login failed (Only School staff are allowed to access..................................admin)");
	            return;
	        }

	        while (true) {
	            System.out.println("*********************** DAV PUBLIC SCHOOL******************************");
	            System.out.println("1. Register Student");
	            System.out.println("2. View Student by Name & Grade");
	            System.out.println("3. View Teachers");
	            System.out.println("4. Exit");
	            System.out.print("Choose option: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 -> StudentService.registerStudent(sc);
	                case 2 -> StudentService.viewStudentByNameAndGrade(sc);
	                case 3 -> TeacherService.viewTeachers();
	                case 4 -> {
	                    System.out.println("Goodbye");
	                    return;
	                }
	                default -> System.out.println("Invalid option");
	            }
	        }
	    }
	}



