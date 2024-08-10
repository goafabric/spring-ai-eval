package org.goafabric.springai;

import org.goafabric.springai.chat.ChatController;
import org.goafabric.springai.person.PersonController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner init(ApplicationContext context, ChatController chatController, PersonController personController) {
		//chatController.chat();
		personController.chat();

		return args -> {
			if ((args.length > 0) && ("-check-integrity".equals(args[0]))) {
				SpringApplication.exit(context, () -> 0);
			}
		};
	}

}
