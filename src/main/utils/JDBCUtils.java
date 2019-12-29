package main.utils;



import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {

    static DataSource comboPooledDataSource = new ComboPooledDataSource("c3p0-config");

    public static Connection getConnection() throws SQLException {
        return comboPooledDataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return comboPooledDataSource;
    }
}
