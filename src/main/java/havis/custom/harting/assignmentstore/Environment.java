package havis.custom.harting.assignmentstore;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Environment {
	private final static Logger LOGGER = Logger.getLogger(Environment.class.getName());
	private final static Properties properties = new Properties();

	static {
		try (InputStream stream = Environment.class.getClassLoader().getResourceAsStream("Environment.properties")) {
			properties.load(stream);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to load environment properties", e);
		}
	}

	public static final String CONFIG_FILE = properties.getProperty("havis.custom.harting.assignmentstore.config.configFile",
			"/tmp/havis/custom/harting/assignmentstore/config.json");

	public static final String JDBC_DRIVER = properties.getProperty("havis.custom.harting.assignmentstore.config.jdbcDriver", "org.h2.Driver");
	public static final String JDBC_URL = properties.getProperty("havis.custom.harting.assignmentstore.config.dbConnection",
			"jdbc:h2:./assignment-store;INIT=RUNSCRIPT FROM 'conf/havis/custom/harting/assignmentstore/assignmentstore.sql'");
	public static final String JDBC_USERNAME = properties.getProperty("havis.custom.harting.assignmentstore.config.jdbcUsername", "sa");
	public static final String JDBC_PASSWORD = properties.getProperty("havis.custom.harting.assignmentstore.config.jdbcPassword", "");

	/**
	 * Length in bit
	 */
	public static final Short TID_LENGTH = Short.parseShort(properties.getProperty("havis.custom.harting.assignmentstore.config.tidLength", "96"));
}
