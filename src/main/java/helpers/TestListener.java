package helpers;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestListener extends ExitCodeListener implements ITestListener {

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot();
        } catch (IOException exception) {
            throw new IOException(exception);
        }
        super.onTestFailure(result);
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] takeScreenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return FileUtils.readFileToByteArray(screenshot);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println("Test failed but within success percentage" + WebDriverRunner.hasWebDriverStarted());
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        System.out.println("Test success. WebDriver has started:" + WebDriverRunner.hasWebDriverStarted());
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }

    @Override
    public void onConfigurationFailure(ITestResult result) {
        super.onConfigurationFailure(result);
        System.out.println("Configuration failure" + WebDriverRunner.hasWebDriverStarted());
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }
}