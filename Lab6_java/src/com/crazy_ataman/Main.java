package com.crazy_ataman;

import com.crazy_ataman.dao.MyDAO;
import com.crazy_ataman.request.Requests;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.DOMConfiguration;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Program is starting.");
        MyDAO dao = new MyDAO();
        try {
            var connection = dao.getConnection();
            var requests = new Requests(connection);

            requests.getAllCitizensSelectedLanguage();
            LOG.info("The method getAllCitizensSelectedLanguage is done.");
            System.out.println("_______________________________________");

            requests.getAllSelectedCitizensInCities();
            LOG.info("The method getAllSelectedCitizensInCities is done.");
            System.out.println("_______________________________________");

            requests.getAllCitiesWithSelectedPopulation();
            LOG.info("The method getAllCitiesWithSelectedPopulation is done.");
            System.out.println("_______________________________________");

            requests.getPopulationInTheOldestCity();
            LOG.info("The method getPopulationInTheOldestCity is done.");
            System.out.println("_______________________________________");

            LOG.info("Program is done.");
        } catch (Exception ex) {
            LOG.warn(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
