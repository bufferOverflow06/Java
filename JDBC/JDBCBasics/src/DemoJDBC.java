import java.sql.Connection;
import java.sql.DriverManager;

public class DemoJDBC {
    public static void main(String []args) throws Exception{
        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
         */
        // String url = "jdbc:postgres://localhost:5432/demo";
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String passwd = "0000";

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, passwd);

        System.out.println("Connection Established");
    }
}
