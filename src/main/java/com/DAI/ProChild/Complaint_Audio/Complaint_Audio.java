package com.DAI.ProChild.Complaint_Audio;

import com.DAI.ProChild.Complaint.Complaint;

import javax.persistence.*;

public class Complaint_Audio {
    @Id
    @GeneratedValue
    private int idComplaintAudio;
    @Column
    private String URLAudio;
    @OneToOne
    @JoinColumn(name = "idComplaint", referencedColumnName = "idComplaint")
    private Complaint complaint;

    public Complaint_Audio(Complaint complaint, String URLAudio) {
        this.complaint = complaint;
        this.URLAudio = URLAudio;
    }
}
