package com.example.firstproject.dto;

import com.example.firstproject.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class NoticeDTO {

    private String noticeName;
    private String noticeContent;

    public Notice toEntity() {
        return new Notice(null, noticeName, noticeContent);
    }
}
