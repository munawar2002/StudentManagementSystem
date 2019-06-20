package com.myKidGoal.dto;

public class CategoryDto {
    private int id;
    private String branchName;
    private long studentCount;

    public CategoryDto(int id, String branchName, long studentCount) {
        this.id = id;
        this.branchName = branchName;
        this.studentCount = studentCount;
    }

    public CategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(long studentCount) {
        this.studentCount = studentCount;
    }
}
