import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteAndProcess {
    public static void main(String []args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String passwd = "0000";

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, passwd);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
        String sql = "select name from student where id = 1";
        // select query will simply fetch data so we use executeQuery(),
        // if we want to make changes we use execute()
        ResultSet rs = st.executeQuery(sql);

        // System.out.println(rs.next());
        // This returns a boolean value if there is a next row it returns true and if we don't
        // have a row it returns false;

        //rs.getString() gives the string data for a particular column
        rs.next(); // by default the pointer will be before the first row
        // so the next will be first record
        String name = rs.getString("name");
        System.out.println("Name of the student: " + name);

        con.close(); // closes the connection
        System.out.println("Connection Closed");
    }
}
