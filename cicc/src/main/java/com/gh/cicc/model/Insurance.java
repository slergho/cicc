package com.gh.cicc.model;


import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class Insurance implements Serializable {

    @Excel(name = "被保险人姓名",orderNum = "")
    private String insuredName;
    @Excel(name = "被保险人证件号",orderNum = "")
    private String insuredIDNumbe;
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

    public Insurance(){}

    public Insurance(String insuredName, String insuredIDNumbe, String plateNumber, String vin, String frameNumber, String address, String insuredPhone, String vehicleBrand, String colors, Date buyCarDate, String allRiskScenarioName, String theftScenarioName, String allRiskPremium, String allRiskDuration, Date allRiskInsuredDate, String theftPremium, String theftDuration, Date theftInsuredDate, String status) {
        this.insuredName = insuredName;
        this.insuredIDNumbe = insuredIDNumbe;
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
}
