package com.DAI.ProChild.User;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.Message.Message;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utilizador")
public class User {
    @Column
    private String nome;
    @Id
    private String email;
    @Column(name="Kinship")
    private String grauParentesco;
    @Column
    private String password;
    @Column
    private int contacto;

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

    public User(String nome, String email, String grauParentesco, String password, int contacto) {
        this.nome = nome;
        this.email = email;
        this.grauParentesco = grauParentesco;
        this.password = password;
        this.contacto = contacto;
        this.kid = new HashSet<Kid>();
    }

    public User(User user) {
        this.nome = user.nome;
        this.email = user.email;
        this.grauParentesco = user.grauParentesco;
        this.password = user.password;
        this.contacto = user.contacto;
        this.kid = user.kid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public Set<Kid> getKid() {
        return this.kid;
    }

    public boolean login(User user) {
        return this.getEmail().equals(user.getEmail()) && this.getPassword().equals(user.getPassword());
    }

}
