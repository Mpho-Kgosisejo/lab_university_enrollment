package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPing {
    static Student s1 = null;
    static Student s2 = null;
    static Student s3 = null;
    static Student s4 = null;
    static Student s5 = null;
    static Course courseIT = null;
    static Course courseACC = null;
    static Course courseBUS = null;

    @BeforeAll
    public static void populateStudents(){
        s1 = new Student("Mpho", 999, "2000/05/12");
        s2 = new Student("Bod", 123, "2003/20/06");
        s3 = new Student("Jill", 486, "1984/14/08");
        s4 = new Student("John", 001, "1994/03/12");
        s5 = new Student("Kim", 4321, "1996/05/20");
    }

    @Test
    public void testStudent() {
        //Test for stu. 1
        assertEquals("Mpho", s1.getName());
        assertEquals(999, s1.getStudentNumber());
        assertEquals("2000/05/12", s1.getDob());

        //Test for stu. 2
        assertEquals("Bod", s2.getName());
        assertEquals(123, s2.getStudentNumber());
        assertEquals("2003/20/06", s2.getDob());

        //Test for stu. 3
        assertEquals("Jill", s3.getName());
        assertEquals(486, s3.getStudentNumber());
        assertEquals("1984/14/08", s3.getDob());

        //Test for stu. 4
        assertEquals("John", s4.getName());
        assertEquals(001, s4.getStudentNumber());
        assertEquals("1994/03/12", s4.getDob());

        //Test for stu. 5
        assertEquals("Kim", s5.getName());
        assertEquals(4321, s5.getStudentNumber());
        assertEquals("1996/05/20", s5.getDob());
    }

    @BeforeAll
    public static void populateCourses(){
        courseIT = new Course("IT", 3);
        courseACC = new Course("ACC", 220);
        courseBUS = new Course("BUS", 350);
    }

    @Test
    public void enrollmentStudents(){
        //enroll IT students...
        assertEquals(true, courseIT.enrollStudent(s1));
        assertEquals(false, courseIT.enrollStudent(s1));
        assertEquals(true, courseIT.enrollStudent(s2));
        assertEquals(true, courseIT.enrollStudent(s3));
        assertEquals(false, courseIT.enrollStudent(s4));

        //enroll ACC students...
        assertEquals(true, courseACC.enrollStudent(s1));
        assertEquals(true, courseACC.enrollStudent(s2));
        assertEquals(true, courseACC.enrollStudent(s3));
        assertEquals(true, courseACC.enrollStudent(s4));
        assertEquals(true, courseACC.enrollStudent(s5));

        //enroll BUS students...
        assertEquals(true, courseBUS.enrollStudent(s1));
        assertEquals(true, courseBUS.enrollStudent(s2));
        assertEquals(true, courseBUS.enrollStudent(s4));
        assertEquals(true, courseBUS.enrollStudent(s5));
    }

    @Test
    public void unenrollmentStudents() {
        //unenroll ACC students...
        assertEquals(true, courseACC.unenrollStudent(s1));
        assertEquals(false, courseACC.unenrollStudent(s1));
        assertEquals(true, courseACC.unenrollStudent(s2));

        //unenroll BUS students...
        assertEquals(true, courseBUS.unenrollStudent(s4));
        assertEquals(false, courseBUS.unenrollStudent(s3));
    }

    @Test
    public void testCourses(){
        //Check number of courses...
        assertEquals(3, courseIT.getNumberOfCourses());

        //Courses names...
        assertEquals("IT", courseIT.getName());
        assertEquals("ACC", courseACC.getName());
        assertEquals("BUS", courseBUS.getName());

        assertEquals("BUS", courseBUS.getName());
        assertEquals("BUS", courseBUS.getName());
        assertEquals("BUS", courseBUS.getName());
    }

    @Test
    public void checkCourseCapacities(){
        assertEquals(3, courseIT.getCapacity());
        assertEquals(220, courseACC.getCapacity());
        assertEquals(350, courseBUS.getCapacity());
    }
}