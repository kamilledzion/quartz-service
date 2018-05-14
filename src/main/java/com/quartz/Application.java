package com.quartz;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) throws IOException {
    new ClassPathXmlApplicationContext("**/quartz-context.xml");
  }
}