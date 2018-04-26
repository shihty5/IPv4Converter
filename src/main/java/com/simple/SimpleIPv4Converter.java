package com.simple;

public class SimpleIPv4Converter {

    //成功返回结果, 失败返回-1
    public long calculate(String str) {
        String[] arrs = str.split("\\.");

        if (arrs.length != 4) {
            return -1;
        }

        int i = 0;
        long result = 0;
        for (String s : arrs) {

            //中间有空格则为异常
            if (s.trim().indexOf(' ') != -1) {
                return -1;
            }

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
