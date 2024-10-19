package tech.icei.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.icei.util.HibernateUtil;

public class HibernateListener implements ServletContextListener {
    Logger log = LoggerFactory.getLogger(HibernateListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        log.info("=====================================  Inicializando Hibernate  =======================================");
        HibernateUtil.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        log.info("=====================================  Cerrando Hibernate  =======================================");
        HibernateUtil.closeSessionFactory();
    }
}
