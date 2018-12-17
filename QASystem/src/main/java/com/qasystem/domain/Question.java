package com.qasystem.domain;

public class Question {
    private Long Qid;
    private Long Sid;
    private Long Tid;
    private Long Cid;
    private Long Mid;
    private Long Did;
    private String Qtitle;
    private String Qtext;
    private String Qans;
    private String Qtime;
    private boolean Qfile;

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

    public Long getTid() {
        return Tid;
    }

    public void setTid(Long tid) {
        Tid = tid;
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

    public String getQans() {
        return Qans;
    }

    public void setQans(String qans) {
        Qans = qans;
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
