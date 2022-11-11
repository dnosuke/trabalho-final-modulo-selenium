package br.com.ifood.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ListenersTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult re) {


    }
    @Override
    public void onTestSuccess(ITestResult re) {


    }
    @Override
    public void onTestFailure(ITestResult re) {
        TakesScreenshot  t = (TakesScreenshot) Browser.driver;

        File srcFile = t.getScreenshotAs(OutputType.FILE);

        try {
            File destFile = new File ("./ScreenShot/"+1234+".jpg");
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


