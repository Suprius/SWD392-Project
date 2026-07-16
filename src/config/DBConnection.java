package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String SERVER_URL =
            "jdbc:sqlserver://localhost:1433;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private DBConnection() {
    }

    public static Connection getMasterConnection() throws SQLException {
        return connect("master");
    }

    public static Connection getFUDBConnection() throws SQLException {
        return connect("FU_DB");
    }

    private static Connection connect(String databaseName)
            throws SQLException {

        String url = SERVER_URL
                + "databaseName=" + databaseName + ";";

        return DriverManager.getConnection(
                url,
                USERNAME,
                PASSWORD
        );
    }
}