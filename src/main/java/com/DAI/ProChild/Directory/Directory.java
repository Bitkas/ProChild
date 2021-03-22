package com.DAI.ProChild.Directory;

import com.DAI.ProChild.Topic.Topic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class Directory {
    @Id
    @GeneratedValue
    private int idDirectory;
    @Column
    private String title;
    @Column
    private String theme;
    @OneToMany
    private Set<Topic> topics;

    public Directory() {
        this.topics = new HashSet<>();
    }

    public Directory(String title, String theme) {
        this.title = title;
        this.theme = theme;
        this.topics = new HashSet<>();
    }
}
