package com.DAI.ProChild.Complaint;

import com.DAI.ProChild.Message.Message;
import com.DAI.ProChild.User.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComplaintController {
    private final ComplaintService complaintService;
    private final Gson gson = new Gson();

    @Autowired
    public ComplaintController(ComplaintService complaintService){
        this.complaintService = complaintService;
    }

    @GetMapping(path = "/Complaint/")
    public ResponseEntity<String> getAllComplaint() {
        List<Complaint> complaints = this.complaintService.GetAllComplaint();
        return ResponseEntity.ok()
                .body(gson.toJson(complaints));
    }

    @RequestMapping(value = "/deleteComplaint", method = RequestMethod.POST)
    public ResponseEntity<String> deleteComplaint(@RequestBody Integer idComplaint){
        Optional<Complaint> complaints = this.complaintService.getComplaint(idComplaint);
        this.complaintService.deleteComplaint(complaints.get());
        return ResponseEntity.ok()
                .body(gson.toJson(complaints));
    }
}
