package org.goafabric.springai.person;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class PersonController {
    private final ChatClient chatClient;

    public PersonController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a helpful AI Assistant that can find persons by it's lastName")
                .defaultFunctions("findByFirstName", "findByLastName")
                .build();
    }

    public void chat() {
        try {
            /*
            var scanner = new Scanner(System.in);
            while (true) {
                System.out.print("[User]: ");
                var userMessage = scanner.nextLine();
                System.out.print("[Agent]: ");
                System.out.println(chatClient.prompt().user(userMessage).call().content());
            }

             */

            System.out.println(chatClient.prompt().user("I am Searching for bart").call().content());
            System.out.println(chatClient.prompt().user("I am Searching for someone with named burns").call().content());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
