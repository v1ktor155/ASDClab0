package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SingletonWorkerClass {
    private static SingletonWorkerClass singletonWorkerClass = null;
    private static final  File file = new File("С:\\Users\\vikto\\IdeaProjects\\qwer\\ASDC_1\\src\\data.txt");

    static SingletonWorkerClass getInstance() {
        return Objects.requireNonNullElseGet(singletonWorkerClass, () -> (singletonWorkerClass =
                new SingletonWorkerClass()));
    }

    public ArrayList<Student> readFromCSVFile() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        String readingStr;
        int lineCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((readingStr = bufferedReader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1)
                    continue;
                String[] splitedCSVString = readingStr.split(",");
                studentArrayList.add(
                        new Student(
                                Integer.parseInt(splitedCSVString[0]),
                                splitedCSVString[1],
                                splitedCSVString[2],
                                Integer.parseInt(splitedCSVString[3]),
                                Integer.parseInt(splitedCSVString[4]),
                                Integer.parseInt(splitedCSVString[5])
                        )
                );
            }
        } catch (IOException exception) {
            System.out.println("Exception!");
            exception.printStackTrace();
        }

        return studentArrayList;
    }

    public void showStudentArrayList(@NotNull ArrayList<Student> studArrayList) {
        for (Student student : studArrayList) {
            for (Faculties faculty : Faculties.values()) {
                if (student.getFaculty() == faculty.ordinal() + 1)
                    if (faculty.ordinal() + 1 == student.getFaculty()) {
                        System.out.println(student.getId() + " "
                                + student.getName() + " "
                                + student.getSurname() + " "
                                + student.getYearOfBirth() + " "
                                + student.getYearOfIntroduction() + " "
                                + " " + faculty + "\t" + student.getFaculty());
                        break;
                    }
            }
        }
    }


}
