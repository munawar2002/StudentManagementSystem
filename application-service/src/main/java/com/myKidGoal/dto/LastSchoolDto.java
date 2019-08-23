package com.myKidGoal.dto;

public class LastSchoolDto {
    private int id;
    private String schoolName;
    private long count;

    public LastSchoolDto(int id, String schoolName, long count) {
        this.id = id;
        this.schoolName = schoolName;
        this.count = count;
    }

    public LastSchoolDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
