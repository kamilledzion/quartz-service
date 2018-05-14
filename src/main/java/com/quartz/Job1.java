package com.quartz;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Job1 {

  private static final Logger LOG = LoggerFactory.getLogger(Job1.class);

  public void testMSG() {
    LOG.info("=========================================================");
    LOG.info("TEST JOB_1 at: {}", Calendar.getInstance().getTime());
    LOG.info("=========================================================");
  }
}