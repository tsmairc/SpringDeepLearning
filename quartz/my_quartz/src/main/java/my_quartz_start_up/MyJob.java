package my_quartz_start_up;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job {

      public MyJob() {
      }

      public void execute(JobExecutionContext context) throws JobExecutionException {
          System.err.println("Hello World!  MyJob is executing.");
      }
  }