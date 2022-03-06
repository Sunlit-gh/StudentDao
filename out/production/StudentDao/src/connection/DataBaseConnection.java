package connection;

import java.sql.*;

public class DataBaseConnection {
    private final String DBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DBURL = "jdbc:sqlserver://127.0.0.1:1433;";
    private final String DBUSER = "sa";
    private final String DBPASSWORD = "123456";
    private Connection conn = null;

    //������
    public DataBaseConnection() {
        try {
            Class.forName(DBDriver);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
        }
    }

    //�������
    public Connection getConnection() {
        return this.conn;
    }

    //�ر�����
    public void close() throws SQLException {
        this.conn.close();
    }
} 
