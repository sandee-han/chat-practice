package com.chat.practice.chatapppractice.controller;

import com.chat.practice.chatapppractice.dto.ChatMessage;
import com.chat.practice.chatapppractice.dto.ChatMessageIdGenerator;
import com.chat.practice.chatapppractice.dto.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    // record: constructor, getter 가 들어있는 java에서 기본으로 제공하는 type. java 17부터 사용 가능
    // lombok이 있어서 잘 안쓰게됨.
    public record WriteMessageResponse(Long id){
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage() {
        ChatMessage message = new ChatMessage("김혁규", "안녕하시오");

        chatMessages.add(message);

        return new RsData<>(
                "S-1",
                "메세지가 작성되었습니다.",
                new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> getMessage() {
        return new RsData<>(
                "S-1",
                "성공",
                chatMessages);
    }
}
