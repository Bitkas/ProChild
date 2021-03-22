package com.DAI.ProChild.Complaint_form;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name= "complaint_form")
public class Complaint_form {
    @Id
    private int idcomplaint_form;
    private String name;
    private Date birth_date;
    private String gender;
    private String adress;
    private int cellphone;
    private String description;
    private int id_complanitt;

    public Complaint_form(int idcomplaint_form, String name, Date birth_date, String gender, String adress, int cellphone, String description, int id_complanitt){
        this.idcomplaint_form = idcomplaint_form;   //É preciso?
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.adress = adress;
        this.cellphone = cellphone;
        this.description = description;
        this.id_complanitt = id_complanitt;
    }

    public int getIdcomplaint_form() {
        return idcomplaint_form;
    }

    public void setIdcomplaint_form(int idcomplaint_form) {
        this.idcomplaint_form = idcomplaint_form;
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
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public int getId_complanitt() {
        return id_complanitt;
    }

    public void setId_complanitt(int id_complanitt) {
        this.id_complanitt = id_complanitt;
    }
}
