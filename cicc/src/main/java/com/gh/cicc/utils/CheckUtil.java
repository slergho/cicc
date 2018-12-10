package com.gh.cicc.utils;

import com.gh.cicc.model.Insurance;

public class CheckUtil {

    public void checkInsurance(Insurance insurance){
        if (insurance.getInsuredName() == null && insurance.getInsuredIDNumber() == null && insurance.getPlateNumber() == null
        && insurance.getVin() == null && insurance.getFrameNumber() == null && insurance.getAddress() == null
        && insurance.getInsuredPhone() == null && insurance.getVehicleBrand() == null && insurance.getColors() == null
        && insurance.getBuyCarDate() == null){
            System.out.println("请完善任务信息和车辆信息！");
            insurance.setStatus("2");
        }
        if (!insurance.getTheftScenarioName().isEmpty()| !insurance.getAllRiskScenarioName().isEmpty()){
            System.out.println("盗抢险方案名称和三者险方案名称不能同时为空！");
            insurance.setStatus("2");
        }
        if (!insurance.getTheftScenarioName().isEmpty()){
            if (insurance.getInsuredName() == null && insurance.getInsuredIDNumber() == null && insurance.getPlateNumber() == null
                    && insurance.getVin() == null && insurance.getFrameNumber() == null && insurance.getAddress() == null
                    && insurance.getInsuredPhone() == null && insurance.getVehicleBrand() == null && insurance.getColors() == null
                    && insurance.getBuyCarDate() == null && insurance.getTheftInsuredDate() == null && insurance.getTheftDuration() == null
                    && insurance.getTheftPremium() == null){
                System.out.println("如果盗抢险方案名称不为空，则人的信息，车辆信息，详细地址，盗抢险方案信息均不能为空！");
                insurance.setStatus("2");
            }
        }
        if (insurance.getTheftScenarioName().isEmpty() | !insurance.getAllRiskScenarioName().isEmpty()){
            if (insurance.getTheftInsuredDate() == null && insurance.getTheftDuration() == null
                    && insurance.getTheftPremium() == null){
                System.out.println("若盗抢险方案名称为空且三者险方案名称不为空，盗抢险信息不能为空！");
                insurance.setStatus("2");
            }
        }
    }


}
