package com.example.demo.list;

import java.util.function.Function;

public interface Utility {
  Function<Emp,Student> MAPTOSTUDENT = con-> Student.builder().id(con.getId()).name(con.getName()).build();
}
