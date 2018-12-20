package com.qasystem.domain;

public class Teacher {
    private Long Tid;
    private String Tname;
    private String Tpsw;
    private Long Did;
    private String Dname;
    private String Tinfo;
    private String Tlevel;

    public Long getTid() {
        return Tid;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public void setTid(Long tid) {
        Tid = tid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTpsw() {
        return Tpsw;
    }

    public void setTpsw(String tpsw) {
        Tpsw = tpsw;
    }

    public String getTinfo() {
        return Tinfo;
    }

    public void setTinfo(String tinfo) {
        Tinfo = tinfo;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public String getTlevel() {
        return Tlevel;
    }

    public void setTlevel(String tlevel) {
        Tlevel = tlevel;
    }
}
