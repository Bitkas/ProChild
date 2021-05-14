package com.DAI.ProChild.Chat;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ChatMessage {

    @Id
    @SequenceGenerator(name = "idChatMessage")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idChatMessage;

    @Column(name = "MessageFrom")
    private String from;
    @Column(name = "MessageTo")
    private String to;
    @Column
    private String content;
    @Column
    private LocalDateTime dateTime;

    public ChatMessage() {
        this.dateTime = LocalDateTime.now();
    }

    public ChatMessage(String from, String to, String content) {
        this.dateTime = LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
