package com.DAI.ProChild.Complaint_form;

import com.DAI.ProChild.Complaint.Complaint;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "complaint_form")
public class Complaint_form {
    @Id
    @GeneratedValue
    private int idComplaintForm;
    @Column
    private String name;
    @Column
    private Date birth_date;
    @Column
    private String gender;
    @Column
    private String address;
    @Column
    private int cellphone;
    @Column
    private String description;
    @OneToOne
    @JoinColumn(name = "id_Complaint", referencedColumnName = "id_Complaint")
    private Complaint complaint;   //CHAVE ESTRANGEIRA!

    public Complaint_form(String name, Date birth_date, String gender, String address, int cellphone, String description, Complaint complaint){
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
        this.cellphone = cellphone;
        this.description = description;
        this.complaint = complaint;
    }

    public int getIdcomplaint_form() {
        return idComplaintForm;
    }

    public void setIdcomplaint_form(int idcomplaint_form) {
        this.idComplaintForm = idcomplaint_form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
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

    public int getId_complaint() {
        return idComplaintForm;
    }

    public void setId_complaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
