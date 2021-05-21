package com.DAI.ProChild.RegisterComplaint;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Complaint_Audio.ComplaintAudioRepository;
import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.ComplaintFormRepository;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterComplaintService {

    private final RegisterComplaintRepository registerComplaintRepository;
    private final ComplaintAudioRepository complaintAudioRepository;
    private final ComplaintFormRepository complaintFormRepository;

    @Autowired
    public RegisterComplaintService(RegisterComplaintRepository registerComplaintRepository, ComplaintAudioRepository complaintAudioRepository, ComplaintFormRepository complaintFormRepository) {
        this.registerComplaintRepository = registerComplaintRepository;
        this.complaintAudioRepository = complaintAudioRepository;
        this.complaintFormRepository = complaintFormRepository;
    }
    public Complaint registerComplaintForAudio(User user) {
        Complaint complaint = new Complaint(user);
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
