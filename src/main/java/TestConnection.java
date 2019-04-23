import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

    private String dbms = "mariadb";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public void getConnection() throws SQLException {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            st = con.createStatement();
            System.out.println("Connection is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
