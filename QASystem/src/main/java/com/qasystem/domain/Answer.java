package com.qasystem.domain;

public class Answer {
    private Long Qid;
    private Long Tid;
    private String Tname;
    private String Atext;
    private String Atime;
    private boolean Afile;

    public Long getQid() {
        return Qid;
    }

    public void setQid(Long qid) {
        Qid = qid;
    }

    public Long getTid() {
        return Tid;
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

    public String getAtext() {
        return Atext;
    }

    public void setAtext(String atext) {
        Atext = atext;
    }

    public String getAtime() {
        return Atime;
    }

    public void setAtime(String atime) {
        Atime = atime;
    }

    public boolean isAfile() {
        return Afile;
    }

    public void setAfile(boolean afile) {
        Afile = afile;
    }
}
