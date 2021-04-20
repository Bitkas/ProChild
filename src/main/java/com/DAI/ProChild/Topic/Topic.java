package com.DAI.ProChild.Topic;
import com.DAI.ProChild.Directory.Directory;
import com.DAI.ProChild.Message.Message;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Topic")
public class Topic {
    @Id
    private String title;
    @ManyToOne
    @JoinColumn(name = "idDirectory")
    private Directory directory;
    @OneToMany (mappedBy = "topic")
    private Set<Message> messages;
    @Column
    private String theme;
    @Column
    private Date dateCreation;

    public Topic() {
        //this.directory = new Directory();
        this.messages = new HashSet<>();
        this.dateCreation = new Date();
    }
    public Topic(String title, String theme) {
        this.title = title;
        this.directory = new Directory();
        this.messages = new HashSet<>();
        this.theme = theme;
        this.dateCreation = new Date();
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
