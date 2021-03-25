package com.DAI.ProChild.Topic;

import com.DAI.ProChild.Directory.Directory;
import com.DAI.ProChild.Message.Message;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Topic {
    @Id
    @GeneratedValue
    private int idTopic;
    @Column
    private String title;
    @ManyToOne
    private Directory directory;
    @OneToMany
    private Set<Message> messages;

    public Topic() {
        //this.directory = new Directory();
        this.messages = new HashSet<>();
    }

    public Topic(String title) {
        this.title = title;
        this.directory = new Directory();
        this.messages = new HashSet<>();
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}
