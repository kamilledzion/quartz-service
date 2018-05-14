package com.quartz;

import java.util.Calendar;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class Job2 {

  private static final Logger LOG = LoggerFactory.getLogger(Job2.class);

  private static final String TRIGGER_1 = "trigger1";

  private static final String cronExp = "0/30 * * ? * *";

  @Autowired
  private Scheduler scheduler;

  public Job2() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  public void setupCronExpressionForTrigger1() throws Exception {
    LOG.info("=========================================================");
    LOG.info("TEST JOB_2 at: {}", Calendar.getInstance().getTime());
    LOG.info("=========================================================");

    CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(new TriggerKey(TRIGGER_1));
    if (!trigger.getCronExpression().equals(cronExp)) {
      trigger.setCronExpression(cronExp);
      scheduler.rescheduleJob(trigger.getKey(), trigger);

      LOG.info(
          "Setup cronExp: {} for trigger: {} at : {}",
          cronExp, trigger.getKey(), Calendar.getInstance().getTime());
    }
  }
}