package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailureScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        capture(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        capture(result);
    }

    private void capture(ITestResult result) {
        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest baseTest)) {
            return;
        }

        String testName = result.getTestClass().getName() + "." + result.getMethod().getMethodName();
        FailureScreenshotUtil.capture(baseTest.getDriver(), testName);
    }
}
