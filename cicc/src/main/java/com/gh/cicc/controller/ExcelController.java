package com.gh.cicc.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;


@RestController
public class ExcelController {

    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    File excelFile = new File("C:/Users/Administrator/Documents");
}
