package com.DAI.ProChild.Complaint;

import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Complaint")
public class Complaint {
    @Id
    @SequenceGenerator(
            name = "complaint_sequence",
            sequenceName = "complaint_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "complaint_sequence"
    )
    @Column
    private int idComplaint;
    @OneToMany
    @JoinColumn(name = "idAudio")
    private Set<Complaint_Audio> audio;
    @OneToMany
    @JoinColumn(name = "idForm")
    private Set<Complaint_Form> form;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idKid")
    private Kid kid;


    public Complaint(User user) {
        this.user = user;
    }
    public Complaint() {
    }


    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Set<Complaint_Audio> getAudio() {
        return audio;
    }

    public void setAudio(Set<Complaint_Audio> audio) {
        this.audio = audio;
    }

    public Set<Complaint_Form> getForm() {
        return form;
    }

    public void setForm(Set<Complaint_Form> form) {
        this.form = form;
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
