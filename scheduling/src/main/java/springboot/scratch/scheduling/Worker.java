package springboot.scratch.scheduling;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Worker implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(Worker.class);

	@Override
	public void run() {
		logger.debug("worker thread started. current thread name {}", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("worker thread finished. current thread name {}", Thread.currentThread().getName());
	}
}
