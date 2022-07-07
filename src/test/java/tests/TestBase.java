package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import credentials.CredentialsConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void beForAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        String browserResolution = System.getProperty("resolution", "1920×1080");
        Configuration.browserSize = browserResolution;
        String browserVersion = System.getProperty("version", "100");
        Configuration.browserVersion = browserVersion;
        String remoteBrowser = System.getProperty("remote", "demoqa.com");
        CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
        Configuration.remote = "https://" + credentialsConfig.login() + ":" + credentialsConfig.password() + "@" + remoteBrowser;
        String browserOption = System.getProperty("browser", "Opera");
        Configuration.browser = browserOption;
    }

    @AfterEach
    void afterEach() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }
}
