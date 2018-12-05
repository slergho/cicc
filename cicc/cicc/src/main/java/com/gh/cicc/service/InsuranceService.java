package com.gh.cicc.service;

import com.gh.cicc.model.Insurance;

import java.util.List;

public interface InsuranceService {


    Insurance addInsurance(Insurance insurance);


    void deleteInsurance(int id);


    Insurance updateInsurance(Insurance insurance);


    List<Insurance> allList();
}
