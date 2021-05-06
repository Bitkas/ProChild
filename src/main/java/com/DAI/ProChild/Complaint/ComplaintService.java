package com.DAI.ProChild.Complaint;
import com.DAI.ProChild.Message.Message;
import com.DAI.ProChild.RegisterComplaint.RegisterComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {
    private final RegisterComplaintRepository registerComplaintRepository;

    @Autowired
    public ComplaintService(RegisterComplaintRepository registerComplaintRepository){
        this.registerComplaintRepository = registerComplaintRepository;
    }

    public List<Complaint> GetAllComplaint() {
        return this.registerComplaintRepository.findAll();
    }

    public Optional<Complaint> getComplaint(Integer idComplaint) {
        Optional<Complaint> complaint = this.registerComplaintRepository.findById(idComplaint);
        return complaint;
    }

    public void deleteComplaint(Complaint complaint){
        this.registerComplaintRepository.delete(complaint);
    }
}
