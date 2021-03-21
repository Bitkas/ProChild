package com.DAI.ProChild.Complaint;

import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.Complaint_form;

import javax.persistence.*;

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
}
