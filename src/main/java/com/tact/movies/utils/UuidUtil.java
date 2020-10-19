package com.tact.movies.utils;

import java.util.UUID;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class UuidUtil {
    private UuidUtil(){
    }
    private static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        for (int i = 0; i <(1<<3); i++) {
            System.out.println(UuidUtil.getUuid());
        }
    }
}
