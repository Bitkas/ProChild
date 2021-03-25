package com.DAI.ProChild.Complaint;

import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.Complaint_form;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.User.User;

import javax.persistence.*;
import java.util.Optional;

public class Complaint {
    @Id
    @GeneratedValue
    private int idComplaint;
    @OneToOne
    @JoinColumn(name = "idAudio", referencedColumnName = "idAudio")
    private Complaint_Audio audio;
    @OneToOne
    @JoinColumn(name = "idForm", referencedColumnName = "idForm")
    private Complaint_form form;
    @ManyToOne
    private User user;
    @ManyToOne
    private Kid kid;

    public Complaint(User user) {
        this.user = user;
    }

    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Complaint_Audio getAudio() {
        return audio;
    }

    public Complaint_form getForm() {
        return form;
    }

    public User getUser() {
        return user;
    }

    public Kid getKid() {
        return kid;
    }

    public void setAudio(Complaint_Audio audio) {
        this.audio = audio;
    }

    public void setForm(Complaint_form form) {
        this.form = form;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }
}
