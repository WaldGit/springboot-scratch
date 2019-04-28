package springboot.scratch.asynchronous;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class AsynchronousApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronousApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
