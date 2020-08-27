package com.example.demo.list;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    String name;
    Integer id;
}
