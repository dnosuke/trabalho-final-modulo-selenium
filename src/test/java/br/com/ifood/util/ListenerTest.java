package br.com.Ifood.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult Result) {


    }
    @Override
    public void onTestSuccess(ITestResult Result) {


    }
    @Override
    public void onTestFailure(ITestResult Result) {
        //in below code, " DemoListener .driver" is used to get same driver from sample test class.
        TakesScreenshot  t = (TakesScreenshot) Browser.driver;

        File srcFile = t.getScreenshotAs(OutputType.FILE);

        try {
            File destFile = new File ("./ScreenShot/"+Result.getName()+".jpg");
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult Result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    @Override
    public void onStart(ITestContext Result) {

    }

    @Override
    public void onFinish(ITestContext Result) {

    }
}