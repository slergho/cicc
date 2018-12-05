package com.gh.cicc.utils;



public enum  AllRiskEnum {
    A("河南天地人三责A款"),
    B("河南天地人三责B款"),
    C("河南天地人三责C款"),
    C1("天地人A款郑州60"),
    C2("天地人B款郑州60");

    private String risk;

    AllRiskEnum(String risk) {
        this.risk = risk;
    }
    public String getAllRirskEnum(){
        return risk;
    }

    public static void main(String[] args) {
        System.out.println(AllRiskEnum.A.getAllRirskEnum());
        System.out.println(AllRiskEnum.B.getAllRirskEnum());
        System.out.println(AllRiskEnum.C.getAllRirskEnum());
        System.out.println(AllRiskEnum.C1.getAllRirskEnum());
        System.out.println(AllRiskEnum.C2.getAllRirskEnum());
    }
}
