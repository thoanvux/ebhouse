/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Le Hoang Anh
 */
@Entity(name = "Users")
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "phone", unique = true, nullable = false, length = 10)
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "address")
    private String address="";
    @Column(name = "sex")
    private Integer sex = 0;
    @Column(name = "flag_login")
    @ColumnDefault("0")
    private Boolean flagLogin;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    @Column(name = "create_date")
    private Date cDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    @Column(name = "modify_date")
    private Date mDate;
    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    @Column(name = "delete_date")
    private Date dDate;
    @Column(name = "access_token")
    private String token;
    @Column(name = "status")
    @ColumnDefault("1")
    private int status;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Landlord landlord;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Tenant tenant;
    
    public User() {
    }

    public User(String phone, String password, String name, Date dateOfBirth, String address, Integer sex, Boolean flagLogin) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.sex = sex;
        this.flagLogin = flagLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getFlagLogin() {
        return flagLogin;
    }

    public void setFlagLogin(Boolean flag_login) {
        this.flagLogin = flag_login;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"phone\":\"" + phone + "\", \"name\":\"" + name + "\", \"dateOfBirth\":\"" + dateOfBirth + "\", \"address\":\"" + address + "\", \"sex\":\"" + sex + "\", \"flagLogin\":\"" + flagLogin + "\", \"cDate\":\"" + cDate + "\", \"mDate\":\"" + mDate + "\", \"dDate\":\"" + dDate + "\", \"status\":\"" + status + "\", \"token\":\"" + token + "\"}";
    }

}
