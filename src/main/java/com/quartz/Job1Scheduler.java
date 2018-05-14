package com.quartz;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Job1Scheduler extends QuartzJobBean {

  private static final Logger LOG = LoggerFactory.getLogger(Job1Scheduler.class);

  private Job1 job1;

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) {
    try {
      LOG.info("=========================================================");
      LOG.info("JOB_1_SCHEDULER INSTANCE_ID: " + jobExecutionContext.getScheduler()
          .getSchedulerInstanceId());
      LOG.info("=========================================================");

      job1.testMSG();
    } catch (Exception e) {
      LOG.error("ERROR !!!", e);
    }
  }

  public void setJob1(Job1 job1) {
    this.job1 = job1;
  }
}