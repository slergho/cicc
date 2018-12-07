package com.gh.cicc.repository;

import com.gh.cicc.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepositiry extends JpaRepository<Insurance, Integer> {


    List<Insurance> findByInsuredName(String insuredname);
}
