package com.example.demo;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional({Condition1.class,Condition2.class,Condition3.class})
public class MainConfig6 {
}
