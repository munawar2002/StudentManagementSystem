package com.myKidGoal.dto;

import java.util.List;

public class IncomeExpenseDto {
    private String label;
    private List<Double> data;

    public IncomeExpenseDto(String label, List<Double> data) {
        this.label = label;
        this.data = data;
    }

    public IncomeExpenseDto() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
