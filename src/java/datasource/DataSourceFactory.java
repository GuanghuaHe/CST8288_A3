package datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Shariar
 */
public class DataSourceFactory {

    public DataSourceFactory() {
    }

    /**
     * Only use one connection for this application, prevent memory leaks.
     */
    public static Connection createConnection() {

        try {
            Context initContext = new InitialContext();
            //？
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/MapMaker");
            return ds.getConnection();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSourceFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
