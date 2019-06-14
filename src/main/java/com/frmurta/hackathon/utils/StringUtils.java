package com.frmurta.hackathon.utils;

import java.util.Arrays;

public class StringUtils extends org.springframework.util.StringUtils {

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isNotEmpty(String... strings) {
        return strings != null && Arrays.stream(strings).allMatch(StringUtils::isNotEmpty);
    }
}

