import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestConnection {

    private String dbms = "mariadb";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1/db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public void getConnection() throws SQLException {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mariadb://localhost:3306";
        String driver = "org.mariadb.jdbc.Driver";

        Connection con = null;
        Statement st = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();
            System.out.println("Connection is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
