package com.example.demo.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.list.Utility.MAPTOSTUDENT;

public class OneListToAnotherList {

    public static void main(String[] args) {
        List<Emp> empList = Arrays.asList(
                Emp.builder()
                        .id(123)
                        .name("sonu")
                        .build(),
                Emp.builder()
                        .id(124)
                        .name("kumar")
                        .build(),
                Emp.builder()
                        .id(125)
                        .name("sahu")
                        .build()

        );

        List<Student> studentList = empList.parallelStream().map(x ->
                Student.builder()
                        .id(x.getId())
                        .name(x.getName())
                        .build()
        ).collect(Collectors.toList());
        List<Student> studentList1 = empList.parallelStream()
                .map(MAPTOSTUDENT)
                .collect(Collectors.toList());
        System.out.println(studentList);
        System.out.println(studentList1);
    }
}
