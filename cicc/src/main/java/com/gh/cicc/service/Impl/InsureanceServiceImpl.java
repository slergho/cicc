package com.gh.cicc.service.Impl;

import com.gh.cicc.model.Insurance;
import com.gh.cicc.repository.InsuranceRepositiry;
import com.gh.cicc.service.InsuranceService;
import com.gh.cicc.utils.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;


@Service
public class InsureanceServiceImpl implements InsuranceService {

    Logger log = LoggerFactory.getLogger(InsureanceServiceImpl.class);

    @Autowired
    InsuranceRepositiry insuranceRepositiry;




    public Boolean importExcel(String fileName) {
        boolean flag = false;
        log.info("导入数据开始。。。。。。");
        try {
            List<Object[]> list = ExcelUtil.importExcel(fileName);
            for (int i = 0; i < list.size(); i++) {
                Insurance insurance = new Insurance();
                insurance.setInsuredName((String) list.get(i)[0]);
                insurance.setInsuredIDNumber((String) list.get(i)[1]);
                insurance.setPlateNumber((String) list.get(i)[2]);
                insurance.setVin((String) list.get(i)[3]);
                insurance.setFrameNumber((String) list.get(i)[4]);
                insurance.setAddress((String) list.get(i)[5]);
                insurance.setInsuredPhone((String) list.get(i)[6]);
                insurance.setVehicleBrand((String) list.get(i)[7]);
                insurance.setColors((String) list.get(i)[8]);
                insurance.setBuyCarDate((Date) list.get(i)[9]);
                insurance.setAllRiskScenarioName((String) list.get(i)[10]);
                insurance.setTheftScenarioName((String) list.get(i)[11]);
                insurance.setAllRiskPremium((String) list.get(i)[12]);
                insurance.setAllRiskDuration((String) list.get(i)[13]);
                insurance.setAllRiskInsuredDate((Date) list.get(i)[14]);
                insurance.setTheftPremium((String) list.get(i)[15]);
                insurance.setTheftDuration((String) list.get(i)[16]);
                insurance.setTheftInsuredDate((Date) list.get(i)[17]);
                if (insurance.getInsuredName() == "" && insurance.getInsuredIDNumber() == "" && insurance.getPlateNumber() == ""
                        &&insurance.getVin() == "" && insurance.getFrameNumber() == "" && insurance.getAddress() == ""
                        && insurance.getInsuredPhone() == "" && insurance.getVehicleBrand() == "" && insurance.getColors() == ""
                        && insurance.getBuyCarDate() == null){
                    log.info("人的信息、车辆信息均不能为空！");
                    insurance.setStatus("2");//异常状态
                }
                if (insurance.getAllRiskScenarioName() == "" & insurance.getTheftScenarioName() == "" ){
                        log.info("盗抢险方案名称和三者险方案名称不能同时为空");
                    insurance.setStatus("2");//异常状态
                }
                if (insurance.getTheftPremium() == "" && insurance.getTheftDuration() == "" && insurance.getTheftScenarioName() == ""){
                    log.info("三者险方案信息不能为空");
                    insurance.setStatus("2");//异常状态
                }
                insuranceRepositiry.save(insurance);
            }
            log.info("导入数据结束。。。。。。");
           flag = true;
        } catch (Exception e) {
            log.info("导入数据失败。。。。。。");
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }


    @Override
    public void deleteInsurance(int id) { insuranceRepositiry.deleteById(id);
    }

    @Override
    public Insurance updateInsurance(Insurance insurance) {
        insurance.setAddress(insurance.getAddress());
        insurance.setAllRiskDuration(insurance.getAllRiskDuration());
        insurance.setAllRiskInsuredDate(insurance.getAllRiskInsuredDate());
        insurance.setAllRiskPremium(insurance.getAllRiskPremium());
        insurance.setAllRiskScenarioName(insurance.getAllRiskScenarioName());
        insurance.setBuyCarDate(insurance.getBuyCarDate());
        insurance.setColors(insurance.getColors());
        insurance.setFrameNumber(insurance.getFrameNumber());
        insurance.setInsuredIDNumber(insurance.getInsuredIDNumber());
        insurance.setInsuredPhone(insurance.getInsuredPhone());
        insurance.setInsuredName(insurance.getInsuredName());
        insurance.setPlateNumber(insurance.getPlateNumber());
        insurance.setTheftDuration(insurance.getTheftDuration());
        insurance.setTheftPremium(insurance.getTheftPremium());
        insurance.setTheftInsuredDate(insurance.getTheftInsuredDate());
        insurance.setTheftScenarioName(insurance.getTheftScenarioName());
        insurance.setVehicleBrand(insurance.getVehicleBrand());
        insurance.setVin(insurance.getVin());
        return insuranceRepositiry.save(insurance);
    }

    @Override
    public List<Insurance> allList() {
        return insuranceRepositiry.findAll();
    }
    public List<Insurance> findByInsuredName(@PathParam("insuredname") String insuredname){
        return insuranceRepositiry.findByInsuredName(insuredname);
    }



}
