package com.DAI.ProChild.User;

import com.DAI.ProChild.Kid.Kid;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name = "Utilizador")
public class User {
    private String nome;
    @Id
    private String email;
    private String grauParentesco;
    private String password;
    private int contacto;
    private HashSet<Kid> kid;
    
    public User() {
        this.kid = new HashSet<Kid>();
    }

    public User(int id, String nome, String email, String grauParentesco, String password, int contacto) {
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

    public HashSet<Kid> getKid() {
        return kid;
    }

}
