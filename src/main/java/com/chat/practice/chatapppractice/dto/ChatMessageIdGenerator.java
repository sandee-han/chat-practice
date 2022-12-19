package com.chat.practice.chatapppractice.dto;

public class ChatMessageIdGenerator {
    private static long id;

    public static long genNextId() {
        return ++id;
    }
}
