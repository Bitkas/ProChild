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

    public Complaint_Form(){

    }
    public Complaint_Form(String name, Date birthDate, String gender, String address, int cellphone, String description, Complaint complaint){
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.cellphone = cellphone;
        this.description = description;
        this.complaint = complaint;
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
