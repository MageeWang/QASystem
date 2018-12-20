package com.qasystem.domain;

import java.time.Year;

public class Student {
    private Long Sid;
    private String Sname;
    private String Spsw;
    private Long Did;
    private String Dname;
    private String Syear;

    public Long getSid() {
        return Sid;
    }

    public void setSid(Long sid) {
        Sid = sid;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSpsw() {
        return Spsw;
    }

    public void setSpsw(String spsw) {
        Spsw = spsw;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public String getSyear() {
        return Syear;
    }

    public void setSyear(String syear) {
        Syear = syear;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

}
