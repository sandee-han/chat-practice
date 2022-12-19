package com.chat.practice.chatapppractice.controller;

import com.chat.practice.chatapppractice.dto.ChatMessage;
import com.chat.practice.chatapppractice.dto.RsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<ChatMessage> writeMessage() {
        ChatMessage message = new ChatMessage("김혁규", "안녕하시오");
        return new RsData(
                "S-1",
                "메세지가 작성되었습니다.",
                message);
    }
}
