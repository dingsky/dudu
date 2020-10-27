package com.dudu.config;

public class SysEnv {
    public static final String nacosServKey = "NACOSADDR";
    public static  String nacosServ = System.getenv(nacosServKey);
}
