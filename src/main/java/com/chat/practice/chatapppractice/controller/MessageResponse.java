package com.chat.practice.chatapppractice.controller;

import com.chat.practice.chatapppractice.dto.ChatMessage;

import java.util.List;

public record MessageResponse(List<ChatMessage> messages, long count) {
}