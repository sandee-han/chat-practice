package com.chat.practice.chatapppractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    // 결과 코드 S: 성공, F: 실패
    private String resultCode;
    private String msg;
    private T data;
}
