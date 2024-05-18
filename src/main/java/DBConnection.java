import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/Radha";
    private static final String user = "root";
    private static final String pass = "Shiv@123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter your first name: ");
                String firstName = scanner.nextLine();
                System.out.println("Enter your last name: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter your City");
                String city = scanner.nextLine();
                System.out.println("Enter your Address");
                String address = scanner.nextLine();
                System.out.println("Choose your option: (Y/N)");
                String option = scanner.nextLine();
                if(option.toUpperCase().equals("N")){
                    break;
                }
            }
            String insertQuery = "INSERT INTO Persons(FirstName,LastName,Address,City) VALUES(?,?,?,?)";
//            Statement stmt = conn.createStatement();
//            String updateQuery ="UPDATE Persons SET FirstName=?, LastName=? WHERE PersonID = ?";
//            PreparedStatement prep = conn.prepareStatement(updateQuery);
//            prep.setString(1,"Shyam");
//            prep.setString(2,"Radhe");
//            prep.setInt(3,1);
//            int affectedRows = prep.executeUpdate();
//            if(affectedRows>0){
//                System.out.println("Successfully updated");
//            }else{
//                System.out.println("Failed to update");
//            }
//
//            String deleteQuery = "DELETE FROM Persons WHERE PersonId=4";


            String query = "SELECT * FROM Persons";
            ResultSet rs = prep.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getString("firstName") + " " + rs.getString("lastName"));
            }
            prep.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
