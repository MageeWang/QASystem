package com.qasystem.domain;

public class Question {
    private Long Qid;
    private Long Sid;
    private String Sname;
    private Long Cid;
    private String Cname;
    private Long Did;
    private String Dname;
    private String Qtitle;
    private String Qtext;
    private String Qtime;
    private boolean Qfile;
    private String Qhref;

    public String getQhref() {
        return Qhref;
    }

    public void setQhref(String qhref) {
        Qhref = qhref;
    }

    private Integer Qunread;

    public Integer getQunread() {
        return Qunread;
    }

    public void setQunread(Integer qunread) {
        Qunread = qunread;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public Long getQid() {
        return Qid;
    }

    public void setQid(Long qid) {
        Qid = qid;
    }

    public Long getSid() {
        return Sid;
    }

    public void setSid(Long sid) {
        Sid = sid;
    }

    public Long getCid() {
        return Cid;
    }

    public void setCid(Long cid) {
        Cid = cid;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public String getQtitle() {
        return Qtitle;
    }

    public void setQtitle(String qtitle) {
        Qtitle = qtitle;
    }

    public String getQtext() {
        return Qtext;
    }

    public void setQtext(String qtext) {
        Qtext = qtext;
    }

    public String getQtime() {
        return Qtime;
    }

    public void setQtime(String qtime) {
        Qtime = qtime;
    }

    public boolean isQfile() {
        return Qfile;
    }

    public void setQfile(boolean qfile) {
        Qfile = qfile;
    }
}
