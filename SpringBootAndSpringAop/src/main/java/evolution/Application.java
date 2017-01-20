package evolution;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.service.AnyService;

@SpringBootApplication
// With the help of CommandLineRunner, you don't need Spring MVC to fire up a method.
public class Application implements CommandLineRunner {
	@Autowired
	private AnyService anyService;

	@Override
	public void run(String... args) {
		System.out.println(anyService.anyMethod());
		System.out.println(anyService.anotherMethod("Ling"));
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
