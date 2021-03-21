package com.DAI.ProChild.Kid;

import com.DAI.ProChild.User.User;

import javax.persistence.*;
import java.util.Date;
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
    private Date dateOfBirth;
    @ManyToMany(mappedBy = "kids")
    private Set<User> users;
}
