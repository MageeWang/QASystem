package com.qasystem.domain;

public class Course {
    private Long Cid;
    private String Cname;
    private String Cinfo;
    private Long Mid;
    private String Mname;
    private Long Did;
    private String Dname;

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

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

    public Long getMid() {
        return Mid;
    }

    public void setMid(Long mid) {
        Mid = mid;
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
