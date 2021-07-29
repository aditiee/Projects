package listeners;


import static com.grp10.util.DbUtilities.*;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbConnectionManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DbConnectionManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 

    	try {
    			cleanUp();
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
      ServletContext context = event.getServletContext();
      try {
		createSingletonDBConn(context .getInitParameter("Driver_class"), context.getInitParameter("url"),
				  context.getInitParameter("username"), context.getInitParameter("password"));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	
}
