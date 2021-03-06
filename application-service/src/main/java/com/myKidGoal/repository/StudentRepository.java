package com.myKidGoal.repository;

import com.myKidGoal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

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

    Long countByLeftSchoolIsFalse();

    Long countByDolIsNull();

    @Query(name = Student.DISCOUNT_COUNT_QUERY, nativeQuery = true)
    Long countStudentDiscount();

    @Query(name = Student.LEFT_STUDENT_COUNT_QUERY, nativeQuery = true)
    Long countStudentLeftSchool();

    @Query(name = Student.STUDENT_GRADUATED_COUNT_QUERY, nativeQuery = true)
    Long countStudentGraduated();

    @Query(name = Student.CURRENT_TEACHER_COUNT_QUERY, nativeQuery = true)
    Long countCurrentTeacher();

    @Query(name = Student.TOTAL_DEBIT_QUERY, nativeQuery = true)
    Long totalDebit();

    @Query(name = Student.TOTAL_CREDIT_QUERY, nativeQuery = true)
    Long totalCredit();

    List<Student> findByLeftSchoolIsFalse();

    @RestResource(path = "all")
    List<Student> findByDeletedIsFalse();

    Optional<Student> findByEmail(@Param("email") String email);

    Optional<Student> findByEmailAndId(@Param("email") String email, @Param("id") int id);
}
