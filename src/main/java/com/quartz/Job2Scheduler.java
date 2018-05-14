package com.quartz;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Job2Scheduler extends QuartzJobBean {

  private static final Logger LOG = LoggerFactory.getLogger(Job2Scheduler.class);

  private Job2 job2;

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) {
    try {
      LOG.info("=========================================================");
      LOG.info("JOB_2_SCHEDULER_CRON_EXP INSTANCE_ID: " + jobExecutionContext.getScheduler()
          .getSchedulerInstanceId());
      LOG.info("=========================================================");

      job2.setupCronExpressionForTrigger1();
    } catch (Exception e) {
      LOG.error("ERROR !!!", e);
    }
  }

  public void setJob2(Job2 job2) {
    this.job2 = job2;
  }
}