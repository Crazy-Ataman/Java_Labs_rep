package Tests;

import com.crazy_ataman.University.Students.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class Tests extends Assert {

    Student student_POIT_4_1 = new Student_IT("Vasya", "Zopin", "full-time", Student.Course.fourth, 9, 0, 98);
    Student student_POIT_4_2 = new Student_IT("Petya", "Lopata", "full-time", Student.Course.fourth, 6, 0, 55);

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod - I will run before every test method.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod – I will run after each test method.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups – I will run before the first method from any specified groups run.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("@AfterGroups – I will run after the last method from any specified groups.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass – I will be run before calling any method in the current class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass  – I will be run after all called methods in the current class.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - I will be run before all runs of any test method belonging to classes inside the <test> tag.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest – I will be run after all runs of the test method belonging to the classes inside the <test> tag. ");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite – I will run before all tests exactly once.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite – I will run after all tests exactly once.");
    }

    @Test(groups = {"GR1"})
    public void testAddStudents() {
        ArrayList<Student> students_POIT_4 = new ArrayList<>();

        students_POIT_4.add(student_POIT_4_1);
        students_POIT_4.add(student_POIT_4_2);

        students_POIT_4.forEach(System.out::println);

        Assert.assertNotNull(students_POIT_4);
    }

    @Test(timeOut = 1500)
    public void testSizeStudents() {
        ArrayList<Student> students_POIT_4 = new ArrayList<>();

        students_POIT_4.add(student_POIT_4_1);
        students_POIT_4.add(student_POIT_4_2);

        Assert.assertEquals(2, students_POIT_4.size());
    }

    @Test(groups = {"GR1"})
    public void testRemoveStudent() throws NullPointerException {
        ArrayList<Student> students_POIT_4 = new ArrayList<>();

        students_POIT_4.add(student_POIT_4_1);

        students_POIT_4.remove(student_POIT_4_1);

        students_POIT_4.add(student_POIT_4_2);

        Assert.assertNotNull(students_POIT_4);
    }

    @Test(enabled = false)
    public void testAddStudentsIgnore() {
        ArrayList<Student> students_POIT_4 = new ArrayList<>();

        students_POIT_4.add(student_POIT_4_1);
        students_POIT_4.add(student_POIT_4_2);

        students_POIT_4.forEach(System.out::println);

        Assert.assertNotNull(students_POIT_4);
    }

}
