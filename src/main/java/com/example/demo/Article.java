package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;

@JsonIgnoreProperties({"id", "memberId", "boardId", "update"})
public class Article {
    public Long id;
    public Long memberId;
    public Long boardId;
    public String title;
    public String author;
    public String content;
    public OffsetDateTime date;
    public OffsetDateTime update;
}
