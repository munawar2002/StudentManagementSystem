package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.model.Category;
import com.myKidGoal.model.Class;
import com.myKidGoal.model.examination.*;
import com.myKidGoal.repository.CategoryRepository;
import com.myKidGoal.repository.ClassRepository;
import com.myKidGoal.repository.examination.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SessionServiceTest {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @Autowired
    private ExamTitleRepository examTitleRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectTitleRepository subjectTitleRepository;

    @Autowired
    private ExamTestRepository examTestRepository;

    @Autowired
    DataSource dataSource;

    @Test
    public void testSessionSaveData() {

        Session session = new Session();
        session.setName("Session-2019-20");
        session.setExecuted(true);
        session.setStartDate(LocalDateTime.now());
        session.setEndDate(LocalDateTime.now());
        session.setStatus("ACTIVE");
        session.setUserId(-1);

        Category category = new Category();
        category.setName("Gulshan Branch");
        category.setBankAccount("HBL");
        category.setCode(1001);
        category.setOrderNo(119);
        category = categoryRepository.save(category);

        Category category2 = new Category();
        category2.setName("Gulshan Branch");
        category2.setBankAccount("HBL");
        category2.setCode(1001);
        category2.setOrderNo(119);
        category2 = categoryRepository.save(category2);

        List<Category> categories = new ArrayList<>(Arrays.asList(category, category2));

        session.setCategory(categories);

        session = sessionRepository.save(session);

        ExamType examType = new ExamType();
        examType.setName("Assessment");
        examType.setLevel(1);
        examType.setActive(true);
        examType.setUserId(-1);
        examType = examTypeRepository.save(examType);

        ExamTitle examTitle = new ExamTitle();
        examTitle.setName("1st Assesment");
        examTitle.setExamType(examType);
        examTitle.setActive(true);
        examTitle = examTitleRepository.save(examTitle);

        ExamTitle examTitle2 = new ExamTitle();
        examTitle2.setName("2nd Assesment");
        examTitle2.setExamType(examType);
        examTitle2.setActive(true);
        examTitle2 = examTitleRepository.save(examTitle2);

        Exam exam = new Exam();
        exam.setExamTitle(examTitle);
        exam.setSession(session);
        exam.setRemarks("1st one");
        exam.setSideNote("if any");
        exam = examRepository.save(exam);

        Exam exam2 = new Exam();
        exam2.setExamTitle(examTitle2);
        exam2.setSession(session);
        exam2.setRemarks("2nd one");
        exam2.setSideNote("if any");
        exam2 = examRepository.save(exam2);

        Class class1 = new Class();
        class1.setName("Class-1");
        class1.setCategory(category);
        class1.setLevel(1);
        class1 = classRepository.save(class1);

        SubjectTitle subjectTitle = new SubjectTitle();
        subjectTitle.setTitle("Mathametics");
        subjectTitle.setColor(1);
        subjectTitle.setExtraActivity(false);
        subjectTitle.setShortTitle("Maths");
        subjectTitle = subjectTitleRepository.save(subjectTitle);

        SubjectTitle subjectTitle2 = new SubjectTitle();
        subjectTitle2.setTitle("English");
        subjectTitle2.setColor(1);
        subjectTitle2.setExtraActivity(false);
        subjectTitle2.setShortTitle("English");
        subjectTitle2 = subjectTitleRepository.save(subjectTitle2);

        Subject subject = new Subject();
        subject.setSession(session);
        subject.setClasses(class1);
        subject.setSubjectTitle(subjectTitle);
        subject.setActive(true);
        subject = subjectRepository.save(subject);

        Subject subject2 = new Subject();
        subject2.setSession(session);
        subject2.setClasses(class1);
        subject2.setSubjectTitle(subjectTitle2);
        subject2.setActive(true);
        subject2 = subjectRepository.save(subject2);

        ExamTest test1 = new ExamTest();
        test1.setSession(session);
        test1.setSubject(subject);
        test1.setExam(exam);
        test1.setExamDate(LocalDateTime.now());
        test1.setMaxMarks(25d);
        test1.setPassingMarks(12d);
        test1 = examTestRepository.save(test1);

        ExamTest test2 = new ExamTest();
        test2.setSession(session);
        test2.setSubject(subject);
        test2.setExam(exam2);
        test2.setExamDate(LocalDateTime.now());
        test2.setMaxMarks(25d);
        test2.setPassingMarks(12d);
        test2 = examTestRepository.save(test2);

        ExamTest test3 = new ExamTest();
        test3.setSession(session);
        test3.setSubject(subject2);
        test3.setExam(exam);
        test3.setExamDate(LocalDateTime.now());
        test3.setMaxMarks(25d);
        test3.setPassingMarks(12d);
        test3 = examTestRepository.save(test3);

        ExamTest test4 = new ExamTest();
        test4.setSession(session);
        test4.setSubject(subject2);
        test4.setExam(exam2);
        test4.setExamDate(LocalDateTime.now());
        test4.setMaxMarks(25d);
        test4.setPassingMarks(12d);
        test4 = examTestRepository.save(test4);

        Assert.assertTrue(session.getId() > 0);

    }

    @Test
    @Transactional
    public void testSession() {
        Session session = sessionRepository.findById(1).get();
        Assert.assertEquals(2, session.getCategory().size());
    }
}
