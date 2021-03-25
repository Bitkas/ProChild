package com.DAI.ProChild.Message;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.User.User;
import javax.persistence.*;
@Entity
@Table(name = "Message")
public class Message {
    @Id
    @SequenceGenerator(
            name = "message_sequence",
            sequenceName = "message_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "message_sequence"
    )
    private int idMessage;
    @Column
    private boolean isURL;
    @Column
    private String message;
    @ManyToOne
    @JoinColumn(name = "idTopic")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idKid")
    private Kid kid;

    public Message(){
    }
    public Message(boolean isURL, String message){
        this.isURL = isURL;
        this.message = message;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public boolean isURL() {
        return isURL;
    }

    public void setURL(boolean URL) {
        isURL = URL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }
}
