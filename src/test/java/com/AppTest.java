package com;

import com.simple.RegexIPv4Converter;
import com.simple.SimpleIPv4Converter;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    RegexIPv4Converter regexIPv4Converter = new RegexIPv4Converter();
    SimpleIPv4Converter simpleIPv4Converter = new SimpleIPv4Converter();

    @Test
    public void testSuccess1() {
        String str = "172.168.5.1";
        Assert.assertEquals(2896692481L, regexIPv4Converter.calculate(str));
        Assert.assertEquals(2896692481L, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testSuccess2() {
        String str = "172 .168 .5. 1";
        Assert.assertEquals(2896692481L, regexIPv4Converter.calculate(str));
        Assert.assertEquals(2896692481L, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testSuccess3() {
        String str = "0.0.0.0";
        Assert.assertEquals(0, regexIPv4Converter.calculate(str));
        Assert.assertEquals(0, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testSuccess4() {
        String str = "255.255.255.255";
        Assert.assertEquals(4294967295L, regexIPv4Converter.calculate(str));
        Assert.assertEquals(4294967295L, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testSuccess5() {
        String str = "  255.   255.   255.255";
        Assert.assertEquals(4294967295L, regexIPv4Converter.calculate(str));
        Assert.assertEquals(4294967295L, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure1() {
        String str = "256.255.255.255";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure2() {
        String str = "256.255.255.255.255";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure3() {
        String str = "17 2.168.5.1";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure4() {
        String str = "1716851";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure5() {
        String str = "17.1685.1";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure6() {
        String str = "-17.16.85.1";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }

    @Test
    public void testFailure7() {
        String str = "1 7.1 6.8 5. 1 ";
        Assert.assertEquals(-1, regexIPv4Converter.calculate(str));
        Assert.assertEquals(-1, simpleIPv4Converter.calculate(str));
    }
}
