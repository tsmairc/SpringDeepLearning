package my_quartz_start_up;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 测试类
 * 
 * @author mrc
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		//Grab the Scheduler instance from the Factory
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		//and start it off
		scheduler.start();
		JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();

		// Trigger the job to run now, and then repeat every 40 seconds
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
	}

}
