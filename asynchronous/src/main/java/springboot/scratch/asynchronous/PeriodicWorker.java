package springboot.scratch.asynchronous;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PeriodicWorker {
	private static final Logger logger = LoggerFactory.getLogger(PeriodicWorker.class);

	@Autowired
	private AsynchronousWorker asynchronousWorker;

	@Scheduled(fixedRateString = "${worker.period}")
	public void job_1() throws InterruptedException {
		asynchronousWorker.asynchJob();
	}

	@Scheduled(fixedRateString = "${worker.period}")
	public void job_2() throws InterruptedException {
		logger.info("job_2: started: " + new Date());
		TimeUnit.SECONDS.sleep(6);
		logger.info("job_2: finished: " + new Date());
	}

}
