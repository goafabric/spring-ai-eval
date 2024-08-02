package dev.danvega.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public void chat() {
        var  scanner = new Scanner(System.in);
        while (true) {
            System.out.print("[User]: ");
            var userMessage = scanner.nextLine();
            System.out.print("[Agent]: ");
            System.out.println(chatClient.prompt().user(userMessage).call().content());
        }
    }

}
