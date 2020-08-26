package com.example.demo;

import org.apache.commons.text.CaseUtils;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityCreation {
    public static void main(String args[]) throws FileNotFoundException {
        List<String> inputStringList = Arrays.asList("NUMBER(5)","NUMBER(1)","NUMBER(2)","NUMBER(3)","NUMBER(4)","NUMBER(5)");
        File file = ResourceUtils.getFile("classpath:lines.txt");
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getPath()))) {
            list = br.lines().collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String x : list) {
            final String[] split = x.split("\\s+");
            StringBuilder stringBuilder = new StringBuilder();
            if (split[1].contains("VARCHAR")) {
                stringBuilder.append("private LocalDate ");
            }else if (split[1].contains("DATE")){
                stringBuilder.append("private String ");
            }else if (split[1].contains("TIMESTAMP")){
                stringBuilder.append("private LocalDateTime ");
            }
            else if (split[1].contains("NUMBER") && inputStringList.contains(split[1])){
                stringBuilder.append("private Integer ");
            }
            else if (split[1].contains("NUMBER") && split[1].contains(",") ){
                stringBuilder.append("private Double ");
            }
            else if (split[1].contains("NUMBER")){
                stringBuilder.append("private Long ");
            }

            else if (split[1].contains("CHAR")){
                stringBuilder.append("private String ");
            }else{

                stringBuilder.append("private String ");
            }
            if (split[0].contains("_")) {
                String camelCase = CaseUtils.toCamelCase(split[0], false, new char[]{'_', ' '});
                stringBuilder.append(camelCase);
                stringBuilder.append(";");
            }


            System.out.println(stringBuilder.toString());
        }


    }


}