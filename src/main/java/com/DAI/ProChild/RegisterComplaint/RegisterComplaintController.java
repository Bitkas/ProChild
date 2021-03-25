package com.DAI.ProChild.RegisterComplaint;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Complaint_Audio.Complaint_Audio;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class RegisterComplaintController {
    private final RegisterComplaintService registerComplaintService;
    private final UserService userService;

    @Autowired
    public RegisterComplaintController(RegisterComplaintService registerComplaintService, UserService userService) {
        this.registerComplaintService = registerComplaintService;
        this.userService = userService;
    }

    @RequestMapping(value = "/Audio", method = RequestMethod.POST)
    public HttpStatus registerAudioComplaint(@RequestBody String email, @RequestBody String URLAudio) {
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            Complaint complaint = new Complaint(user.get());
            this.registerComplaintService.registerComplaintForAudio(user.get());
            Complaint_Audio complaint_audio = new Complaint_Audio(complaint, URLAudio);
            this.registerComplaintService.registerAudio(complaint_audio);
            return HttpStatus.OK;
        } else {
            return HttpStatus.CONFLICT;
        }
    }

    @RequestMapping(value = "/Form", method = RequestMethod.POST)
    public HttpStatus registerFormComplaint(@RequestBody String email, @RequestBody String name, @RequestBody Date bithDate, @RequestBody String gender, @RequestBody String address, @RequestBody int cellphone, @RequestBody String description) {
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            Complaint complaint = this.registerComplaintService.registerComplaintForAudio(user.get());
            Complaint_Form complaint_form = new Complaint_Form(name, bithDate, gender, address, cellphone, description, complaint);
            return this.registerComplaintService.registerForm(complaint_form);
        } else {
            return HttpStatus.CONFLICT;
        }
    }

}
