package com.DAI.ProChild.Complaint;
import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.Complaint.RegisterComplaintService;
import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
@RestController
public class RegisterComplaintController {
    private final RegisterComplaintService registerComplaintService;
    private final UserService userService;
    private final Gson gson = new Gson();

    @Autowired
    public RegisterComplaintController(RegisterComplaintService registerComplaintService, UserService userService) {
        this.registerComplaintService = registerComplaintService;
        this.userService = userService;
    }
    @RequestMapping(path = "/Audio", method = RequestMethod.POST)
    public ResponseEntity<String> registerAudioComplaint(@RequestBody String email, @RequestBody String URLAudio) {
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            Complaint complaint = new Complaint(user.get());
            this.registerComplaintService.registerComplaintForAudio(user.get());
            Complaint_Audio complaintAudio = this.registerComplaintService.registerAudio(new Complaint_Audio(complaint, URLAudio));
            return ResponseEntity.ok()
                    .body(gson.toJson(complaintAudio));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(gson.toJson("User não Encontrado!"));
        }
    }
    @RequestMapping(path = "/Form", method = RequestMethod.POST)
    public ResponseEntity<String> registerFormComplaint(@RequestBody Complaint_Form complaint_form) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = this.userService.getUser(authentication.getPrincipal().toString());
        System.out.println(user.get().getEmail());

            Complaint complaint = this.registerComplaintService.registerComplaintForAudio(user.get());
            complaint_form.setComplaint(complaint);

        this.registerComplaintService.registerForm(complaint_form);
        return ResponseEntity.ok()
                .body(gson.toJson("ola"));

        }
    }

