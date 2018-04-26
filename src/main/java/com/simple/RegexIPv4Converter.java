package com.simple;

import java.util.regex.Pattern;

public class RegexIPv4Converter {
    private String regex = "^((\\s*\\d{1,3}\\s*(?!\\d))(.|$)){4}";

    //成功返回结果, 失败返回-1
    public long calculate(String str) {
        if (!Pattern.matches(regex, str.trim())) {
            return -1;
        }

        String[] arrs = str.split("\\.");

        int i = 0;
        long result = 0;
        for (String s : arrs) {
            long value = Long.parseLong(s.trim());
            if (checkRange(value)) {
                result += value * (1 << (24 - i++ * 8));
            } else {
                return -1;
            }
        }
        return result;
    }

    private boolean checkRange(long num) {
        return num <= 255 && num >= 0;
    }
}
