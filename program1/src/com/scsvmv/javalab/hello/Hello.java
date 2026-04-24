Hello.java(com.scsvmv.javalab.hello)
package com.scsvmv.javalab.hello;

 r
import java.util.Date;

/*
 *Hello class
 *Demonstrates method overloading and command-line arguments
 *\
public class Hello {
  
  //Default constructor
  public Hello(){
  }

  //Generic wish
  public void wish(){
    System.out.println("Hello world");
  }

  //Overloaded wish method with name parameter
  public void wish(string name){
    System.out.println("Hello"+name);
  }
  
  //wish with name and today's date
  public void wishWithDate(string name){
    Date today=new Date();
    System.out.println("Hello"+name+"|Date:"+today);
   }
  } 