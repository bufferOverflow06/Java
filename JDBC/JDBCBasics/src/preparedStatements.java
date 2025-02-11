import java.sql.*;

public class preparedStatements {
    public static void main(String []args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String passwd = "0000";

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, passwd);
        System.out.println("Connection Established");

//        Statement st = con.createStatement();
        int id = 102;
        String name = "Koby";
        int marks = 55;
        // if the values are comming from users
        // we can't directly do this
        // String sql = "insert into student values(sid, name, marks)";
        // because of double quotes
        // we have to keep the variables outsite the double quotes
//        String sql = "insert into student values(" + id + ", '" + name + "'," + marks + ")";
        // there is a chance of sql injections
        // improve performance by caching the queries
        // if we want to execute a query multiple times
        // we can cache the query in the database
        // all this can be done with the help of prepared statements
//        st.execute(sql);

        // Using prepared statement
        String sql = "insert into student values(?, ?, ?)";

        // There is statement, PreparedStatement and Callable statements
        // Whenever we want to execute stored procedures we use callable statements
        // If we want to do anything that deals with updating the table, itself, dropping or altering and select
        // the statement is fine
        // for select when we have where clause we use PreparedStatement

        PreparedStatement st = con.prepareStatement(sql);// PreparedStatement extends Statements
        // this gives the pre-compiled query which we can use it for the caching purpose

        // replacing the question marks
        st.setInt(1, id); // takes two parameter columnnumber and the actual data
        st.setString(2, name);
        st.setInt(3, marks);

        st.execute();

        con.close(); // closes the connection
        System.out.println("Connection Closed");
    }
}
