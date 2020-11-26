package com.cpp288.demo.programLogic.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * data io demo
 *
 * @author chenjian
 * @date 2020/11/26 下午6:57
 */
public class DataStreamDemo {

    private static class Student {

        private String name;

        private int age;

        private double score;

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }
    }

    private static void writeStudents() {

        List<Student> students = Arrays.asList(
                new Student("张三", 18, 80.5d),
                new Student("李四", 20, 87.5d)
        );

        try (final DataOutputStream output = new DataOutputStream(new FileOutputStream("students.dat"))) {
            output.writeInt(students.size());
            for (Student student : students) {
                output.writeUTF(student.getName());
                output.writeInt(student.getAge());
                output.writeDouble(student.getScore());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readStudents() {

        try (final DataInputStream input = new DataInputStream(new FileInputStream("students.dat"))) {
            int size = input.readInt();

            for (int i = 0; i < size; i++) {
                final Student student = new Student(
                        input.readUTF(),
                        input.readInt(),
                        input.readDouble()
                );
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        writeStudents();
        readStudents();
    }
}
