package com.example.thirtysixth;

public class TestValute {

    private final String valuteNumCode;
    private final String valuteCharCode;
    private final String valuteName;
    private final float valuteValue;

    public TestValute(String valuteNumCode, String valuteCharCode, String valuteName, float valuteValue) {

        this.valuteNumCode = valuteNumCode;
        this.valuteCharCode = valuteCharCode;
        this.valuteName = valuteName;
        this.valuteValue = valuteValue;
    }

    public String getValuteNumCode() {

        return valuteNumCode;
    }

    public String getValuteCharCode() {

        return valuteCharCode;
    }

    public String getValuteName() {

        return valuteName;
    }

    public float getValuteValue() {

        return valuteValue;
    }
}