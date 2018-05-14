package com.quartz;

import java.util.Calendar;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchExecutor implements Processor {

  private static final Logger LOG = LoggerFactory.getLogger(BatchExecutor.class);

  @Override
  public void process(Exchange exchange) {
    LOG.info("=========================================================");
    LOG.info("TEST BATCH_EXECUTOR at: {}", Calendar.getInstance().getTime());
    LOG.info("=========================================================");
  }
}