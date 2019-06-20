package com.myKidGoal.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/*
    The Student table entity.
 */
@Entity
@Table(name = "DS_STUDENT")
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = Student.DISCOUNT_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE discountpercentage > 0  "),
        @NamedNativeQuery(name = Student.LEFT_STUDENT_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE dol IS NOT NULL "),
        @NamedNativeQuery(name = Student.STUDENT_GRADUATED_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE TRIM(CauseOfRemoval) ='Pass Out' "),
        @NamedNativeQuery(name = Student.CURRENT_TEACHER_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_employee WHERE dol IS NULL"), })
public class Student implements Serializable {

    public static final String DISCOUNT_COUNT_QUERY = "student.discount.count.query";
    public static final String LEFT_STUDENT_COUNT_QUERY = "left.school.count.query";
    public static final String STUDENT_GRADUATED_COUNT_QUERY = "student.graduated.count.query";
    public static final String CURRENT_TEACHER_COUNT_QUERY = "teacher.current.count.query";
    public static final String BRANCH_STUDENT_COUNT_QUERY = "branch.student.count.query";

    private Integer id;
    private Integer sectionId;
    private Integer guardianId;
    private Integer parentId;
    private Integer placeOfBirthId;
    private Integer lastSchoolId;
    private Integer nationalityId;
    private Integer religionId;
    private Integer houseId;
    private Integer regNo;
    private LocalDate regDate;
    private Boolean isAdmissioned;
    private String name;
    private Integer grNo;
    private Boolean male;
    private LocalDate dob;
    private LocalDate doa;
    private LocalDate dol;
    private Boolean leftSchool;
    private String causeOfRemoval;
    private Double discountPercentage;
    private String discountReason;
    private Integer freeze;
    private Integer boarding;
    private Integer userId;
    private LocalDateTime userTime;
    private Integer fakeGrNo;
    private Boolean fixedLateFine;

    @Id
    @Column(name = "ID_Student")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_Sec")
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "Id_Guardian")
    public Integer getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Integer guardianId) {
        this.guardianId = guardianId;
    }

    @Basic
    @Column(name = "Id_Parent")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "Id_PlaceOfBirth")
    public Integer getPlaceOfBirthId() {
        return placeOfBirthId;
    }

    public void setPlaceOfBirthId(Integer placeOfBirthId) {
        this.placeOfBirthId = placeOfBirthId;
    }

    @Basic
    @Column(name = "Id_LastSchool")
    public Integer getLastSchoolId() {
        return lastSchoolId;
    }

    public void setLastSchoolId(Integer lastSchoolId) {
        this.lastSchoolId = lastSchoolId;
    }

    @Basic
    @Column(name = "Id_Nationality")
    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Basic
    @Column(name = "Id_Religion")
    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    @Basic
    @Column(name = "Id_House")
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "RegNo")
    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    @Basic
    @Column(name = "RegDate")
    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "IsAdmissioned")
    public Boolean isAdmissioned() {
        return isAdmissioned;
    }

    @Basic
    @Column(name = "IsAdmissioned")
    public void setAdmissioned(Boolean admissioned) {
        this.isAdmissioned = admissioned;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GRNO")
    public Integer getGrNo() {
        return grNo;
    }

    public void setGrNo(Integer grNo) {
        this.grNo = grNo;
    }

    @Basic
    @Column(name = "ISMALE")
    public Boolean isMale() {
        return male;
    }

    @Basic
    @Column(name = "ISMALE")
    public void setMale(Boolean male) {
        this.male = male;
    }

    @Basic
    @Column(name = "DOB")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "DOA")
    public LocalDate getDoa() {
        return doa;
    }

    public void setDoa(LocalDate doa) {
        this.doa = doa;
    }

    @Basic
    @Column(name = "DOL")
    public LocalDate getDol() {
        return dol;
    }

    public void setDol(LocalDate dol) {
        this.dol = dol;
    }

    @Basic
    @Column(name = "IsLeftSchool")
    public Boolean isLeftSchool() {
        return leftSchool;
    }

    @Basic
    @Column(name = "IsSchoolLeft")
    public void setLeftSchool(Boolean leftSchool) {
        this.leftSchool = leftSchool;
    }

    @Basic
    @Column(name = "CauseOfRemoval")
    public String getCauseOfRemoval() {
        return causeOfRemoval;
    }

    public void setCauseOfRemoval(String causeOfRemoval) {
        this.causeOfRemoval = causeOfRemoval;
    }

    @Basic
    @Column(name = "DiscountPercentage")
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Basic
    @Column(name = "DiscountReason")
    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    @Basic
    @Column(name = "Freeze")
    public Integer getFreeze() {
        return freeze;
    }

    public void setFreeze(Integer freeze) {
        this.freeze = freeze;
    }

    @Basic
    @Column(name = "Boarding")
    public Integer getBoarding() {
        return boarding;
    }

    public void setBoarding(Integer boarding) {
        this.boarding = boarding;
    }

    @Basic
    @Column(name = "Id_User")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserTime")
    public LocalDateTime getUserTime() {
        return userTime;
    }

    public void setUserTime(LocalDateTime userTime) {
        this.userTime = userTime;
    }

    @Basic
    @Column(name = "FakeGrNo")
    public Integer getFakeGrNo() {
        return fakeGrNo;
    }

    public void setFakeGrNo(Integer fakeGrNo) {
        this.fakeGrNo = fakeGrNo;
    }

    @Basic
    @Column(name = "IsFixedLateFine")
    public Boolean isFixedLateFine() {
        return fixedLateFine;
    }

    @Basic
    @Column(name = "IsFixedLateFine")
    public void setFixedLateFine(Boolean fixedLateFine) {
        this.fixedLateFine = fixedLateFine;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
