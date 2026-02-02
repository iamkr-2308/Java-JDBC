import java.sql.*;

public class BasicJDBC {

    // private - Access modifier no direct access not accessible by anyone,
    // static - Use these 3 data members without making amy object outside main.
    // final - once url, user, pass, uploaded not be changed multiple times.
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "user";
    private static final String password  = "pass";

    public static void main(String []args) throws Exception {

        // Step 1: Register the Driver.
        try {
            Class.forName("com.mysql.cj.jdbc.driver");
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
              System.out.println(e.getMessage());
        }

        try {

            // Step 2 : Create a Connection Object.
            // Makes the connection between the IDE and the Database.
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Create Statement Object.
            // Object used for executing a static SQL statement and returning the results it produces.
            Statement stmt = con.createStatement();

            // Step 4 : Execute the query.
            String query = "SELECT * FROM students";
            ResultSet st = stmt.executeQuery(query);

            while (st.next())
            {
                int id = st.getInt("id");
                String name = st.getString("name");
                int age = st.getInt("age");
                double marks = st.getDouble("marks");
                System.out.println("ID:" + id);
                System.out.println("NAME: " + name);
                System.out.println("AGE: " + age);
                System.out.println("MARKS: " + marks);
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}