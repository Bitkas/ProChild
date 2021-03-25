package com.DAI.ProChild.Complaint_form;

import com.DAI.ProChild.Complaint.Complaint;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "complaint_form")
public class Complaint_Form {
    @Id
    @SequenceGenerator(
            name = "form_sequence",
            sequenceName = "form_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "form_sequence"
    )
    private int idComplaintForm;
    @Column
    private String name;
    @Column
    private Date birthDate;
    @Column
    private String gender;
    @Column
    private String address;
    @Column
    private int cellphone;
    @Column
    private String description;
    @OneToOne
    @JoinColumn(name = "idComplaint", referencedColumnName = "idComplaint")
    private Complaint complaint;

<<<<<<< HEAD:src/main/java/com/DAI/ProChild/Complaint_form/Complaint_form.java
    public Complaint_form(String name, Date birth_date, String gender, String address, int cellphone, String description, Complaint complaint){
=======
    public Complaint_Form(){

    }
    public Complaint_Form(String name, Date birthDate, String gender, String address, int cellphone, String description){
>>>>>>> e1c8f2321b07ebefc7f3c40fe6d1be77124fefeb:src/main/java/com/DAI/ProChild/Complaint_form/Complaint_Form.java
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.cellphone = cellphone;
        this.description = description;
    }

    public int getIdComplaintForm() {
        return idComplaintForm;
    }

    public void setIdComplaintForm(int idComplaintForm) {
        this.idComplaintForm = idComplaintForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
