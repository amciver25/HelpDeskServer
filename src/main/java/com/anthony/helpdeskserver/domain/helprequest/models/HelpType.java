package com.anthony.helpdeskserver.domain.helprequest.models;

public enum HelpType {
    PASSWORD("password"), NETWORK("network"), BABY_MAMMA("baby mama"), BABY_DADDY("baby daddy");
    private String name;
    HelpType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
