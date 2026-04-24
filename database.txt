import java.sql.*;
// Data Access Object (DAO) for Student table
public class StudentDAO {
 private Connection conn;
 // Constructor receives DB connection
 public StudentDAO(Connection conn) {
 this.conn = conn;
 }
 // Insert a student
 public void insertStudent(String name, int age) throws SQLException {
 String sql = "INSERT INTO student (name, age) VALUES (?, ?)";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, name);
 ps.setInt(2, age);
 int rows = ps.executeUpdate();
 System.out.println(rows + " student inserted.");
 }
 }
 // Search student by ID
 public void searchStudent(int id) throws SQLException {
 String sql = "SELECT * FROM student WHERE id=?";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, id);
 try (ResultSet rs = ps.executeQuery()) {
 if (rs.next()) {
 System.out.println("ID: " + rs.getInt("id"));
 System.out.println("Name: " + rs.getString("name"));
 System.out.println("Age: " + rs.getInt("age"));
 } else {
 System.out.println("Student not found.");
 }
 }
 }
 }
 // Fetch all students
 public void fetchAllStudents() throws SQLException {
 String sql = "SELECT * FROM student";
 try (Statement stmt = conn.createStatement();
 ResultSet rs = stmt.executeQuery(sql)) {
 System.out.println("\n--- All Students ---");
 while (rs.next()) {
 System.out.println("ID: " + rs.getInt("id") +
 ", Name: " + rs.getString("name") +
 ", Age: " + rs.getInt("age"));
 }
 }
 }
 // Update student details by ID
 public void updateStudent(int id, String name, int age) throws SQLException {
 String sql = "UPDATE student SET name=?, age=? WHERE id=?";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, name);
 ps.setInt(2, age);
 ps.setInt(3, id);
 int rows = ps.executeUpdate();
 System.out.println(rows + " student updated.");
 }
 }
 // Delete student by ID
 public void deleteStudent(int id) throws SQLException {
 String sql = "DELETE FROM student WHERE id=?";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, id);
 int rows = ps.executeUpdate();
 System.out.println(rows + " student deleted.");
 }
 }
}
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class Main {
 public static void main(String[] args) {
 Properties props = new Properties();
 // Load DB properties
 try (FileInputStream fis = new FileInputStream("db.properties")) {
 props.load(fis);
 } catch (IOException e) {
 e.printStackTrace();
 return;
 }
 String url = props.getProperty("db.url");
 String user = props.getProperty("db.user");
 String pass = props.getProperty("db.pass");
 // DB connection
 try (Connection conn = DriverManager.getConnection(url, user, pass);
 Scanner sc = new Scanner(System.in)) {
 System.out.println("Connected to database successfully.");
 StudentDAO dao = new StudentDAO(conn); // Create DAO object
 while (true) {
 System.out.println("\n1. Insert Student\n2. Search Student\n3. Fetch All Students\n4.
Update Student\n5. Delete Student\n6. Exit");
 System.out.print("Choose option: ");
 int choice = sc.nextInt();
 sc.nextLine(); // Consume newline
 switch (choice) {
 case 1:
 System.out.print("Enter name: ");
 String name = sc.nextLine();
 System.out.print("Enter age: ");
 int age = sc.nextInt();
 dao.insertStudent(name, age);
 break;
 case 2:
 System.out.print("Enter ID to search: ");
 int id = sc.nextInt();
 dao.searchStudent(id);
 break;
 case 3:
 dao.fetchAllStudents();
 break;
 case 4:
 System.out.print("Enter ID to update: ");
 int updateId = sc.nextInt();
 sc.nextLine();
 System.out.print("Enter new name: ");
 String newName = sc.nextLine();
 System.out.print("Enter new age: ");
 int newAge = sc.nextInt();
 dao.updateStudent(updateId, newName, newAge);
 break;
 case 5:
 System.out.print("Enter ID to delete: ");
 int deleteId = sc.nextInt();
 dao.deleteStudent(deleteId);
 break;
 case 6:
 System.out.println("Exiting...");
 return;
 default:
 System.out.println("Invalid option!");
 }
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}