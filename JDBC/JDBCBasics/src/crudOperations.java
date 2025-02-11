import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class crudOperations {
    public static void main(String []args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String passwd = "0000";

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, passwd);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
        // Insert query
        // String sql = "insert into student values(5, 'Freddy', 77)";

        // boolean status = st.execute(sql);
        // so execute can return different type of data
        // returns true if the first result is a ResultSet object,
        // false if it is an update count or there are no results
        // System.out.println(status);

        // Update query
//        String sql = "update student set name='Max' where id=5";
//        st.execute(sql);

        // Delete query
        String sql = "delete from student where id=5";
        st.execute(sql);

        con.close(); // closes the connection
        System.out.println("Connection Closed");
    }
}
