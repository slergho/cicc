package com.gh.cicc.service.Impl;

import com.gh.cicc.model.Insurance;
import com.gh.cicc.repository.InsuranceRepositiry;
import com.gh.cicc.service.InsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;


@Service
public class InsureanceServiceImpl implements InsuranceService {

    Logger log = LoggerFactory.getLogger(InsureanceServiceImpl.class);

    @Autowired
    InsuranceRepositiry insuranceRepositiry;




    @Override
    @PostMapping(value = "/add")
    public Insurance addInsurance(Insurance insurance) {
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
    @DeleteMapping(value = "/del")
    public void deleteInsurance(int id) { insuranceRepositiry.deleteById(id);
    }

    @Override
    @PutMapping(value = "/upd")
    public Insurance updateInsurance(Insurance insurance) {
        insurance.setId(insurance.getId());
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
    @PostMapping(value = "/all")
    public List<Insurance> allList() {
        return insuranceRepositiry.findAll();
    }
    public List<Insurance> findByInsuredName(@PathParam("insuredname") String insuredname){
        return insuranceRepositiry.findByInsuredName(insuredname);
    }
}
