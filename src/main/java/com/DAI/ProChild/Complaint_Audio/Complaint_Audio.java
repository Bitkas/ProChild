package com.DAI.ProChild.Complaint_Audio;
import com.DAI.ProChild.Complaint.Complaint;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Complaint_Audio")
public class Complaint_Audio {
    @Id
    @SequenceGenerator(
            name = "audio_sequence",
            sequenceName = "audio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "audio_sequence"
    )
    private int idComplaintAudio;
    @Column
    private String URLAudio;
    @ManyToOne
    @JoinColumn(name = "idComplaint")
    private Complaint complaint;

    public Complaint_Audio(Complaint complaint, String URLAudio) {
        this.complaint = complaint;
        this.URLAudio = URLAudio;
    }
    public Complaint_Audio(){
    }
    public Complaint_Audio( String URLAudio){
        this.URLAudio= URLAudio;
    }

    public int getIdComplaintAudio() {
        return idComplaintAudio;
    }

    public void setIdComplaintAudio(int idComplaintAudio) {
        this.idComplaintAudio = idComplaintAudio;
    }

    public String getURLAudio() {
        return URLAudio;
    }

    public void setURLAudio(String URLAudio) {
        this.URLAudio = URLAudio;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
