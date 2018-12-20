package com.qasystem.domain;

public class Course {
    private Long Cid;
    private String Cname;
    private String Cinfo;
    private Long Did;
    private String Dname;

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public Long getCid() {
        return Cid;
    }

    public void setCid(Long cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCinfo() {
        return Cinfo;
    }

    public void setCinfo(String cinfo) {
        Cinfo = cinfo;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }
}
