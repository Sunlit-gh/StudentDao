package Client;

import java.sql.*;

public class test2 {

    public static void main(String[] args)

    {

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Students";

        String userName = "sa";

        String userPwd = "123456";

        Connection dbConn = null;

        try

        {

            Class.forName(driverName);

            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("�������ݿ�ɹ�");

        }

        catch (Exception e)

        {

            e.printStackTrace();

            System.out.print("����ʧ��");

        }

    }

}