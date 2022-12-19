package com.chat.practice.chatapppractice.controller;

import com.chat.practice.chatapppractice.dto.ChatMessage;
import com.chat.practice.chatapppractice.dto.ChatMessageIdGenerator;
import com.chat.practice.chatapppractice.dto.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/chat")
@Slf4j
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
    public RsData<MessageResponse> getMessage(MessageRequest req) {
        List<ChatMessage> messages = chatMessages;

        if (req.fromId() != null) {
            int index = IntStream.range(0, messages.size())
                    .filter(i -> chatMessages.get(i).getId() == req.fromId())
                    .findFirst()
                    .orElse(0);

            if (index != -1) {
                // 만약 index가 있으면, 0번부터 index 번 까지 제거한 리스트를 생성
                messages = messages.subList(index + 1, messages.size());
            }
        }

        return new RsData<>(
                "S-1",
                "성공",
                new MessageResponse(chatMessages, chatMessages.size())
        );
    }
}
