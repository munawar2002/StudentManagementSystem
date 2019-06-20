package com.myKidGoal.repository;

import com.myKidGoal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/*
    The student repository, contains all curd methods. *These methods are also exposed*. You can see all exposed api's to Hal browser
    For example:  /students will return all clients. And /students/{id} will return one client permission.
 */
@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Delete exposing false, No user can delete student from Hal Browser
     * 
     * @param clientPermissions
     */
    @Override
    @RestResource(exported = false)
    void delete(Student clientPermissions);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    long countByLeftSchoolIsFalse();

    long countByDolIsNull();

    @Query(name = Student.DISCOUNT_COUNT_QUERY, nativeQuery = true)
    long countStudentDiscount();

    @Query(name = Student.LEFT_STUDENT_COUNT_QUERY, nativeQuery = true)
    long countStudentLeftSchool();

    @Query(name = Student.STUDENT_GRADUATED_COUNT_QUERY, nativeQuery = true)
    long countStudentGraduated();

    @Query(name = Student.CURRENT_TEACHER_COUNT_QUERY, nativeQuery = true)
    long countCurrentTeacher();

    @Query(value = "SELECT s.name as name FROM ds_category s ", nativeQuery = true)
    List<Student> findStudentPerBranch();

    List<Student> findByLeftSchoolIsFalse();
}
