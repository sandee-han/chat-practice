package com.chat.practice.chatapppractice.controller;

import com.chat.practice.chatapppractice.dto.ChatMessage;
import com.chat.practice.chatapppractice.dto.ChatMessageIdGenerator;
import com.chat.practice.chatapppractice.dto.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();



    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest req) {
        ChatMessage message = new ChatMessage(req.authorName(), req.content());

        chatMessages.add(message);

        return new RsData<>(
                "S-1",
                "메세지가 작성되었습니다.",
                new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageResponse> getMessage() {
        return new RsData<>(
                "S-1",
                "성공",
                new MessageResponse(chatMessages, chatMessages.size())
        );
    }
}
