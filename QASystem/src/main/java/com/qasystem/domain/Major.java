package com.qasystem.domain;

public class Major {
    private Long Mid;
    private Long Did;
    private String Dname;
    private String Mname;
    private String Minfo;

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public Long getMid() {
        return Mid;
    }

    public void setMid(Long mid) {
        Mid = mid;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMinfo() {
        return Minfo;
    }

    public void setMinfo(String minfo) {
        Minfo = minfo;
    }
}
