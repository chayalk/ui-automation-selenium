package com.saucedemo.utils;

public class StringUtil {
    public static String generateAddToCardId(String prefix, String name) {
        name = name.replace(" ", "-");
        prefix = prefix.replace(" ", "-");
        return prefix.toLowerCase() + "-" + name.toLowerCase();
    }
}
