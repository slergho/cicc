package com.gh.cicc.service;

import com.gh.cicc.model.Insurance;

import java.util.List;

public interface InsuranceService {


    public Boolean importExcel(String fileName);


    void deleteInsurance(int id);


    Insurance updateInsurance(Insurance insurance);


    List<Insurance> allList();
}
