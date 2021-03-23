package com.DAI.ProChild.Kid;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Message.Message;
import com.DAI.ProChild.User.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Kid {
    @Id
    @GeneratedValue
    private int idKid;
    @Column
    private String name;
    @Column
    private Date birthDate;
    @ManyToMany(mappedBy = "kids")
    private Set<User> users;
    @OneToMany
    private Set<Complaint> complaints;
    @OneToMany
    private Set<Message> messages;

    public Kid() {
        this.name = "";
        this.birthDate = new Date();
        this.users = new HashSet<>();
        this.complaints = new HashSet<>();
        this.messages = new HashSet<>();
    }

    public Kid(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.complaints = new HashSet<>();
        this.users = new HashSet<>();
        this.messages = new HashSet<>();
    }

    public int getIdKid() {
        return idKid;
    }

    public void setIdKid(int idKid) {
        this.idKid = idKid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
