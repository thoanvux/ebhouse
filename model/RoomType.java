/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 *
 * @author anhlh
 */
@Entity(name = "RoomType")
@Table(name = "RoomType")
public class RoomType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "area", nullable = false)
    private Float area;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "description")
    private String description="";

    @Column(name = "status", nullable = false)
    private int status;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date cDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modify_date")
    private Date mDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "delete_date")
    private Date dDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RoomType_Equipment",
            joinColumns = {
                @JoinColumn(name = "id_RoomType")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_Equipment")})
    private Set<Equipment> lstEquipment = new HashSet<Equipment>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", referencedColumnName = "id", nullable = false, unique = true)
    private Landlord landLord;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType")
    @Where(clause = "status = 1")
    private Set<Room> lstRoom = new HashSet<>();

    public RoomType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Set<Equipment> getLstEquipment() {
        return lstEquipment;
    }

    public void setLstEquipment(HashSet<Equipment> lstEquipment) {
        this.lstEquipment = lstEquipment;
    }

    public Landlord getLandLord() {
        return landLord;
    }

    public void setLandLord(Landlord landLord) {
        this.landLord = landLord;
    }

     public Set<Room> getLstRoom() {
        return lstRoom;
    }

    public void setLstRoom(Set<Room> lstRoom) {
        this.lstRoom = lstRoom;
    }    
    

    @Override
    public String toString() {
        List<Equipment> lst = new ArrayList<>(lstEquipment);
        return "{\"id\":" + id + ","
                + " \"name\":\"" + name + "\","
                + " \"area\":\"" + area + "\","
                + " \"price\":\"" + price + "\", "
                + "\"capacity\":\"" + capacity + "\", "
                + "\"description\":\"" + description + "\","
                + "\"lstEquipment\":" + returnLstEquipment(lst) +"}";
    }

    public String returnLstEquipment(List<Equipment> lst) {
        String data = "[";
        for (int i = 0; i < lst.size(); i++) {
            data += "{\"id\":\"" + lst.get(i).getId() + "\"}";
            if (i + 1 < lst.size()) {
                data += ",";
            }
        }
        data += "]";
        return data;
    }
}
