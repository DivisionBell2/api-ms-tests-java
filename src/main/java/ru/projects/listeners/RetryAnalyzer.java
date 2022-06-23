package ru.projects.listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
  private static final Logger LOGGER = LogManager.getLogger(RetryAnalyzer.class);
  private int nowCount = 0;
  private final int maxCount = 1;

  @Override
  public boolean retry(ITestResult iTestResult) {
    if (!iTestResult.isSuccess()) {
      if (nowCount < maxCount) {
        nowCount++;
        iTestResult.setStatus(ITestResult.SUCCESS);
        return true;
      }
    } else {
      iTestResult.setStatus(ITestResult.FAILURE);
    }
    LOGGER.debug("Тест провален дважды!");
    nowCount = 0;
    return false;
  }
}