package com.DAI.ProChild.Message;

import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.User.User;

import javax.persistence.*;

public class Message {
    @Id
    @GeneratedValue
    private int idMessage;
    @Column
    private boolean isURL;
    @Column
    private String message;
    @ManyToOne
    @JoinColumn(name = "id_Topic")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;
}
