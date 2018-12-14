package com.qa.qasystem.domain;

public class User {
    private String usrName;
    private String usrPsw;

    public User(String usrName,String usrPsw){
        this.usrName = usrName;
        this.usrPsw = usrPsw;
    }

    public String getUsrPsw() {
        return usrPsw;
    }

    public void setUsrPsw(String usrPsw) {
        this.usrPsw = usrPsw;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
}
