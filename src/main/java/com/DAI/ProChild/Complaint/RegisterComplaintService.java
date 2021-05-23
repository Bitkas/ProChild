package com.DAI.ProChild.Complaint;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Complaint_Audio.ComplaintAudioRepository;
import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.ComplaintFormRepository;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.Kid.KidRepository;
import com.DAI.ProChild.RegisterComplaint.RegisterComplaintRepository;
import com.DAI.ProChild.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterComplaintService {

    private final RegisterComplaintRepository registerComplaintRepository;
    private final ComplaintAudioRepository complaintAudioRepository;
    private final ComplaintFormRepository complaintFormRepository;
    private final KidRepository kidRepository;

    @Autowired
    public RegisterComplaintService(KidRepository kidRepository ,RegisterComplaintRepository registerComplaintRepository, ComplaintAudioRepository complaintAudioRepository, ComplaintFormRepository complaintFormRepository) {
        this.registerComplaintRepository = registerComplaintRepository;
        this.complaintAudioRepository = complaintAudioRepository;
        this.complaintFormRepository = complaintFormRepository;
        this.kidRepository = kidRepository;
    }
    public Complaint registerComplaintForAudio(User user) {

        Complaint complaint = new Complaint(user);
        Kid kid = new Kid();
        kid.setName("Maria");
        this.kidRepository.save(kid);
        complaint.setKid(kid);
        this.registerComplaintRepository.save(complaint);
        return complaint;
    }

    public Complaint_Audio registerAudio(Complaint_Audio complaint_audio) {
        return this.complaintAudioRepository.save(complaint_audio);
    }

    public Complaint_Form registerForm(Complaint_Form complaint_form) {
        return this.complaintFormRepository.save(complaint_form);
    }
}
