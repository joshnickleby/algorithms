package nickleby.algorithms;

import nickleby.algorithms.domain.Executor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmsApplication {

	public static void main(String[] args) {
		Executor.run();
//		SpringApplication.run(AlgorithmsApplication.class, args);
	}
}
