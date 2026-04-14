package ollamaExample.OllamaCodellama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class ControllerClass {

    private ChatClient chatClient;

    public ControllerClass(ChatModel chatModel){

        this. chatClient= ChatClient.builder(chatModel).build();
        System.out.println(chatModel.getClass().getName());
    }

    @GetMapping(value="/chat")
    public ResponseEntity<?> getResponse(@RequestParam String query){

       String responseContent= this.chatClient.prompt(query).call().content();

        return ResponseEntity.ok(responseContent);
    }
}
