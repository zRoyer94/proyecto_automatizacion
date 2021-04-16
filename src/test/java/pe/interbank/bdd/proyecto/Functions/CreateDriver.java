package pe.interbank.bdd.proyecto.Functions;

import com.google.common.collect.ImmutableMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class CreateDriver {
    private static String url;
    private static String browser;
    private static String browserVersion;
    private static String os;
    private static String logLevel;

    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../../../../../test.properties");
    private static CreateDriver instance = null;

    /******** Log Attribute ********/
    private static Logger log = Logger.getLogger(CreateDriver.class);

    /******** Initialize Driver Configuration when the class is instanced ********/
    private CreateDriver() throws IOException {
        CreateDriver.initConfig();
    }

    /**
     * Singleton pattern
     * @return a single instance

    public static CreateDriver getInstance() throws IOException {
    if (instance == null) {
    instance = new CreateDriver();
    }
    return instance;
    }

    /**
     * Get the Browser from the POM
     */
    public static WebDriver initConfig() throws IOException {
        WebDriver driver;

        try {
            log.info("***********************************************************************************************************");
            log.info("[ POM Configuration ] - Read the basic properties configuration from: ../test.properties");
            prop.load(in);
            url = prop.getProperty("MainAppUrlBase");
            browser = prop.getProperty("browser");
            browserVersion  = prop.getProperty("browserVersion");
            os = prop.getProperty("os");
            logLevel = prop.getProperty("logLevel");
            setAllureEnvironment(url, browser, browserVersion, os);

        } catch (IOException e) {
            log.error("initConfig Error", e);
        }

        /******** POM Information ********/
        log.info("[ POM Configuration ] - OS: " + os + " | Browser: " + browser + " |");
        log.info("[ POM Configuration ] - Logger Level: " + logLevel);
        log.info("***********************************************************************************************************");

        /****** Load the driver *******/
        driver = WebDriverFactory.createNewWebDriver(browser, os);

        return driver;
    }

    public static void setAllureEnvironment(String url, String browser, String browserVersion, String os) {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", browser)
                        .put("Browser Version", browserVersion)
                        .put("O.S", os)
                        .put("URL TEST", url)
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

}
