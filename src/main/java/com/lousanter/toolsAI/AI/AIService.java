package com.lousanter.toolsAI.AI;

import com.lousanter.toolsAI.AI.ToolsAI.toolsOne;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.template.TemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private ChatClient chatClient;
    private TemplateRenderer renderer;
    private toolsOne tools;

    ChatMemory memory = MessageWindowChatMemory.builder().build();

    @Autowired
    public AIService(ChatClient.Builder builder, toolsOne tools) {
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
                .build();
        this.tools= tools;
    }

    public ResponseEntity<String> conversar(String sms){
        return ResponseEntity.ok(chatClient
                .prompt(sms)
                .tools(tools)
                .call()
                .content());
    }



}
