package osama.learning.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationDeploymentListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("The Application is being deployed");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("The application is being destroyed");
    }
}
