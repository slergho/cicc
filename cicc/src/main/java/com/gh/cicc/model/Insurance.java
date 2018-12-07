package com.gh.cicc.model;


import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Insurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Excel(name = "被保险人姓名",orderNum = "")
    private String insuredName;
    @Excel(name = "被保险人证件号",orderNum = "")
    private String insuredIDNumber;
    @Excel(name = "车牌号",orderNum = "")
    private String plateNumber;
    @Excel(name = "车架号",orderNum = "")
    private String vin;
    @Excel(name = "电动机号",orderNum = "")
    private String frameNumber;
    @Excel(name = "详细地址",orderNum = "")
    private String address;
    @Excel(name = "被保险人手机号",orderNum = "")
    private String insuredPhone;
    @Excel(name = "车辆品牌",orderNum = "")
    private String vehicleBrand;
    @Excel(name = "颜色",orderNum = "")
    private String colors;
    @Excel(name = "车辆购买日期",exportFormat = "yyyy-MM-dd",orderNum = "")
    private Date buyCarDate;
    @Excel(name = "三者险方案名称",orderNum = "")
    private String allRiskScenarioName;
    @Excel(name = "盗抢险方案名称",orderNum = "")
    private String theftScenarioName;
    @Excel(name = "三者险保费",orderNum = "")
    private String allRiskPremium;
    @Excel(name = "三者险保期",orderNum = "")
    private String allRiskDuration;
    @Excel(name = "三者险投保日期",exportFormat = "yyyy-MM-dd",orderNum = "")
    private Date allRiskInsuredDate;
    @Excel(name = "盗抢险保费",orderNum = "")
    private String theftPremium;
    @Excel(name = "盗抢险保期",orderNum = "")
    private String theftDuration;
    @Excel(name = "盗抢险投保日期",exportFormat = "yyyy-MM-dd",orderNum = "")
    private Date theftInsuredDate;

    @Column(name = "status")
    private String status;
 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "insured_name")
    private String insuredName;
    @NotNull
    @Column(name = "insured_ID_number")
    private String insuredIDNumber;
    @NotNull
    @Column(name = "plate_number")
    private String plateNumber;
    @NotNull
    @Column(name = "vin")
    private String vin;
    @NotNull
    @Column(name = "frame_number")
    private String frameNumber;
    @NotNull
    @Column(name = "address")
    private String address;
    @NotNull
    @Column(name = "insured_phone")
    private String insuredPhone;
    @NotNull
    @Column(name = "vehicle_brand")
    private String vehicleBrand;
    @NotNull
    @Column(name = "colors")
    private String colors;
    @NotNull
    @Column(name = "buy_car_date")
    private Date buyCarDate;
    @Column(name = "all_risk_scenario_name")
    private String allRiskScenarioName;
    @Column(name = "theft_scenario_name")
    private String theftScenarioName;
    @Column(name = "all_risk_premium")
    private String allRiskPremium;
    @Column(name = "all_risk_duration")
    private String allRiskDuration;
    @Column(name = "all_risk_insured_date")
    private Date allRiskInsuredDate;
    @Column(name = "theft_premium")
    private String theftPremium;
    @Column(name = "theft_duration")
    private String theftDuration;
    @Column(name = "theft_insured_date")
    private Date theftInsuredDate;
    @Column(name = "status")
    private String status;*/

    public Insurance(){}

    public Insurance(Integer id, String insuredName, String insuredIDNumber, String plateNumber, String vin, String frameNumber, String address, String insuredPhone, String vehicleBrand, String colors, Date buyCarDate, String allRiskScenarioName, String theftScenarioName, String allRiskPremium, String allRiskDuration, Date allRiskInsuredDate, String theftPremium, String theftDuration, Date theftInsuredDate, String status) {
        this.id = id;
        this.insuredName = insuredName;
        this.insuredIDNumber = insuredIDNumber;
        this.plateNumber = plateNumber;
        this.vin = vin;
        this.frameNumber = frameNumber;
        this.address = address;
        this.insuredPhone = insuredPhone;
        this.vehicleBrand = vehicleBrand;
        this.colors = colors;
        this.buyCarDate = buyCarDate;
        this.allRiskScenarioName = allRiskScenarioName;
        this.theftScenarioName = theftScenarioName;
        this.allRiskPremium = allRiskPremium;
        this.allRiskDuration = allRiskDuration;
        this.allRiskInsuredDate = allRiskInsuredDate;
        this.theftPremium = theftPremium;
        this.theftDuration = theftDuration;
        this.theftInsuredDate = theftInsuredDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                ", insuredName='" + insuredName + '\'' +
                ", insuredIDNumber='" + insuredIDNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", frameNumber='" + frameNumber + '\'' +
                ", address='" + address + '\'' +
                ", insuredPhone='" + insuredPhone + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", colors='" + colors + '\'' +
                ", buyCarDate=" + buyCarDate +
                ", allRiskScenarioName='" + allRiskScenarioName + '\'' +
                ", theftScenarioName='" + theftScenarioName + '\'' +
                ", allRiskPremium='" + allRiskPremium + '\'' +
                ", allRiskDuration='" + allRiskDuration + '\'' +
                ", allRiskInsuredDate=" + allRiskInsuredDate +
                ", theftPremium='" + theftPremium + '\'' +
                ", theftDuration='" + theftDuration + '\'' +
                ", theftInsuredDate=" + theftInsuredDate +
                '}';
    }
}
