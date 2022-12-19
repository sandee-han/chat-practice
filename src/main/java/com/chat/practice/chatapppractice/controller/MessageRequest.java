package com.chat.practice.chatapppractice.controller;

import org.springframework.web.bind.annotation.RequestParam;

public record MessageRequest(Long fromId) {
}
