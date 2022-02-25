package com.crazy_ataman;

import com.crazy_ataman.University.Dean.Dean;
import com.crazy_ataman.University.Students.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.crazy_ataman.Sax_parser.Sax;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting program");
            ArrayList<Student> students_POIT_4 = new ArrayList<>();
            var student_POIT_4_1 = new Student_IT("Vasya", "Zopin", "full-time", Student.Course.fourth, 9, 0, 98);
            var student_POIT_4_2 = new Student_IT("Petya", "Lopata", "full-time", Student.Course.fourth, 6, 0, 55);
            students_POIT_4.add(student_POIT_4_1);
            students_POIT_4.add(student_POIT_4_2);
            LOG.info("Students created");

            for (Student student : students_POIT_4) {
                System.out.println(student);
            }
            System.out.println("----------------------------------------------------------");

            students_POIT_4.sort(Student.SurnameComparator);
            for (Student student : students_POIT_4) {
                System.out.println(student);
            }
            LOG.info("Students sorted");

            System.out.println("----------------------------------------------------------");
            var dean = new Dean("Alexander", "Mozolevsky");
            LOG.info("Dean created");

            dean.countStudentsByCourses(students_POIT_4);
            LOG.info("Dean counted students by courses");

            System.out.println("----------------------------------------------------------");
            ArrayList<Student> res_list = dean.selectionStudentsAcademicPerf(students_POIT_4);
            for (Student student : res_list) {
                System.out.println(student);
            }
            LOG.info("Dean counted students by academic perfection");

            System.out.println("--------------------XML Serialize-------------------------");
            FileOutputStream xmlOut = new FileOutputStream("files/info.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(xmlOut);
            xmlEncoder.writeObject(student_POIT_4_1);
            xmlEncoder.close();
            LOG.info("XML serialized");

            System.out.println("--------------------XML Deserialize-----------------------");
            FileInputStream xmlIn = new FileInputStream("files/info.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(xmlIn);
            Student_IT student_POIT_4_1_XML = (Student_IT)xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(student_POIT_4_1_XML);
            LOG.info("XML deserialized");

            System.out.println("--------------------JSON Serialize-----------------------");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(dean);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("files/info.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);
            LOG.info("JSON serialized");

            System.out.println("--------------------JSON Deserialize---------------------");
            Scanner scanner = new Scanner(new File("files/info.json"));
            StringBuilder result = new StringBuilder();
            while(scanner.hasNext())
                result.append(scanner.nextLine());
            scanner.close();
            Dean deanJson = gson.fromJson(result.toString(), Dean.class);
            System.out.println(deanJson);
            LOG.info("JSON deserialized");

            System.out.println("--------------------Stream API---------------------------");
            Stream<Student> resStream = students_POIT_4.stream().filter(s -> s.getAcademic_perf() < 7);
            for(var student : resStream.toList()) {
                System.out.println(student);
            }
            LOG.info("Stream API");

            System.out.println("-----------------------SAX-------------------------------");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Sax sax = new Sax();
            parser.parse(new File("files/Dean.xml"), sax);
            Dean deanSax = sax.getResult();
            System.out.println(deanSax);
            LOG.info("SAX");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            LOG.warn(ex.getMessage());
        }
    }
}
