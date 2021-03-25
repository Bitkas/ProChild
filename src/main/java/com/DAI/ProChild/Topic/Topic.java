package com.DAI.ProChild.Topic;

import com.DAI.ProChild.Directory.Directory;
import com.DAI.ProChild.Message.Message;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Topic")
public class Topic {
    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    private int idTopic;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "idDirectory")
    private Directory directory;
    @OneToMany (mappedBy = "Message")
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


    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }


    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

}
