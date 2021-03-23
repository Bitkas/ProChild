package com.DAI.ProChild.User;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.Message.Message;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utilizador")
public class User {
    @Column
    private String name;
    @Id
    private String email;
    @Column
    private String kinship;
    @Column
    private String password;
    @Column
    private int cellphone;

    @ManyToMany()
    @JoinTable(name = "User_Kid",
    joinColumns = {
        @JoinColumn(name = "email_User")},
    inverseJoinColumns = {
            @JoinColumn(name = "kid_id")
    })
    private Set<Kid> kid;

    @OneToMany(mappedBy = "user")
    private Set<Complaint> complaints;
    @OneToMany(mappedBy = "user")
    private Set<Message> messages;
    
    public User() {
        this.kid = new HashSet<Kid>();
    }

    public User(String nome, String email, String kinship, String password, int contacto) {
        this.name = nome;
        this.email = email;
        this.kinship = kinship;
        this.password = password;
        this.cellphone = contacto;
        this.kid = new HashSet<Kid>();
    }

    public User(User user) {
        this.name = user.name;
        this.email = user.email;
        this.kinship = user.kinship;
        this.password = user.password;
        this.cellphone = user.cellphone;
        this.kid = user.kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKinship() {
        return kinship;
    }

    public void setGrauParentesco(String kinship) {
        this.kinship = kinship;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public Set<Kid> getKid() {
        return this.kid;
    }

    public boolean login(User user) {
        return this.getEmail().equals(user.getEmail()) && this.getPassword().equals(user.getPassword());
    }

    public boolean password(String password) {
        return this.getPassword().equals((password));
    }

}
