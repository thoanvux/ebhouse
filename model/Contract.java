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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author anhlh
 */
@Entity(name = "Contract")
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", referencedColumnName = "id", nullable = false)
    private Landlord landLord;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    private Room room;

    @Column(name = "room_price", nullable = false)
    private int roomPrice;

    @Column(name = "contract_img", nullable = true)
    private String contractImg;

    @Column(name = "deposit", nullable = true)
    private int deposit;

    @Column(name = "[start_date]", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "[end_date]", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(name = "[status]", nullable = false)
    private int status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract")
    private List<ContractTenant> lstContract = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract")
    private List<ContractLog> lstContractLog = new ArrayList<>();

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Landlord getLandLord() {
        return landLord;
    }

    public void setLandLord(Landlord landLord) {
        this.landLord = landLord;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public List<ContractTenant> getLstContract() {
        return lstContract;
    }

    public void setLstContract(List<ContractTenant> lstContract) {
        this.lstContract = lstContract;
    }

    public List<ContractLog> getLstContractLog() {
        return lstContractLog;
    }

    public void setLstContractLog(List<ContractLog> lstContractLog) {
        this.lstContractLog = lstContractLog;
    }

    @Override
    public String toString() {
        return "\"id\":" + id + ","
                + "\"room\":" + room.toString() + ", "
                + "\"roomPrice\":\"" + roomPrice + "\", "
                + "\"contractImg\":\"" + contractImg + "\", "
                + "\"deposit\":\"" + deposit + "\", "
                + "\"startDate\":\"" + startDate + "\", "
                + "\"endDate\":\"" + endDate + "\"}";
    }

}
