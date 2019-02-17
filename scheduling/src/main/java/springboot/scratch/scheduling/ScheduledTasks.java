package springboot.scratch.scheduling;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 1000)
	public void scheduledTaskWithFixedRate() {
		logger.debug("scheduledTaskWithFixedRate: current time: " + new Date());
	}

	@Scheduled(fixedRate = 1000)
	public void scheduledTaskWithFixedRateAndProcessingTime() throws InterruptedException {
		logger.debug("scheduledTaskWithFixedRateAndProcessingTime: started: " + new Date());
		TimeUnit.SECONDS.sleep(3);
		logger.debug("scheduledTaskWithFixedRateAndProcessingTime: finished: " + new Date());
	}

	@Scheduled(fixedDelay = 3000)
	public void scheduledTaskWithFixedDelay() {
		logger.debug("scheduledTaskWithFixedDelay: current time: " + new Date());
	}

	@Scheduled(fixedDelay = 3000)
	public void scheduledTaskWithFixedDelayAndProcessingTime() throws InterruptedException {
		logger.debug("scheduledTaskWithFixedDelayAndProcessingTime: started: " + new Date());
		TimeUnit.SECONDS.sleep(2);
		logger.debug("scheduledTaskWithFixedDelayAndProcessingTime: finished: " + new Date());
	}

	@Scheduled(initialDelay = 5000, fixedRate = 1000)
	public void scheduledTaskWithInitialDelay() {
		logger.debug("scheduledTaskWithInitialDelay: current time: " + new Date());
	}

	@Scheduled(cron = "0 * * * * ?")
	public void scheduledTaskWithCronExpression() {
		logger.debug("scheduledTaskWithCronExpression: current time: " + new Date());
	}

}
