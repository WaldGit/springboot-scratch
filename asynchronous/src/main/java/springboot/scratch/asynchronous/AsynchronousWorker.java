package springboot.scratch.asynchronous;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AsynchronousWorker {

	private static final Logger logger = LoggerFactory.getLogger(AsynchronousWorker.class);
	
	@Async("asynchThreadPoolTaskExecutor")
	public void asynchJob() throws InterruptedException {
		logger.info("async job started: " + new Date() + " threadId:" + Thread.currentThread().getId());
		TimeUnit.SECONDS.sleep(3);
		logger.info("async job finished: " + new Date() + " threadId:" + Thread.currentThread().getId());
	}
}
