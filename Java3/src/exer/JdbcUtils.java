package exer;

import java.sql.*;

/**
 * @author 石致彬
 * @create 2020-12-28 22:44
 */
public class JdbcUtils {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java3?characterEncoding=UTF-8","root","6592");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet resultSet) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (resultSet != null)
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
