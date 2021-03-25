package com.DAI.ProChild.Directory;
import com.DAI.ProChild.Topic.Topic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Directory")
public class Directory {
    @Id
    @SequenceGenerator(
            name = "directory_sequence",
            sequenceName = "directory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "directory_sequence"
    )
    private int idDirectory;
    @Column
    private String title;
    @OneToMany(mappedBy = "directory")
    private Set<Topic> topics;

    public Directory() {
        this.topics = new HashSet<>();
    }
    public Directory(String title) {
        this.title = title;
        this.topics = new HashSet<>();
    }
    public int getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(int idDirectory) {
        this.idDirectory = idDirectory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }}
