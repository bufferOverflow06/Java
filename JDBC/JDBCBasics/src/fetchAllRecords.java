import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class fetchAllRecords {
    public static void main(String []args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String passwd = "0000";

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, passwd);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
        String sql = "select * from student";

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){ // basically it will put the pointer to the next row and check
            // if it is available
            System.out.print(rs.getInt(1) + " - "); // in res.getInt() we can
            // either pass columnname or columnindex
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3) + " ");
        }

        con.close(); // closes the connection
        System.out.println("Connection Closed");
    }
}