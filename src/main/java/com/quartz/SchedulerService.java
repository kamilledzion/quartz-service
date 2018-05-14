package com.quartz;

import java.util.Calendar;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SchedulerService implements Processor {

  private static final Logger LOG = LoggerFactory.getLogger(SchedulerService.class);

  private static final String JOB_DETAIL_2 = "jobDetail2";

  private Scheduler scheduler;

  private ApplicationContext context;

  @Autowired
  public SchedulerService(Scheduler scheduler, ApplicationContext context) {
    this.scheduler = scheduler;
    this.context = context;
  }

  private void runJobScheduler2() throws Exception {
    LOG.info("=========================================================");
    LOG.info("SERVICE_SCHEDULE INSTANCE_ID: " + scheduler.getSchedulerInstanceId());
    LOG.info("Test SERVICE_SCHEDULE at: {}", Calendar.getInstance().getTime());
    LOG.info("=========================================================");

    scheduler.triggerJob(new JobKey(JOB_DETAIL_2));
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    runJobScheduler2();
    exchange.getOut()
        .setBody("<html><body>Done at: " + Calendar.getInstance().getTime() + "</body></html>");
  }
}