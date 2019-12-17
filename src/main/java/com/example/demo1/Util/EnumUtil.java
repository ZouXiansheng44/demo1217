package com.example.demo1.Util;

import com.example.demo1.Enum.CodeEnum;

public class EnumUtil {
    public static <T extends CodeEnum> T getEnumByCode(String code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
