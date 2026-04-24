package com.scsvmv.javalab;
import com.scsvmv.javalab.hello;
/*
 *testHello class
 *Demonstrates passing command-line arguments
 */
public class TestHello {

  public class void main(strig[]args){
    
    //using Hello class from parent packeg
    Hello simpleHello=new Hello();
    simpleHello.wish();
    
    //using hello class from child package
    com.scsvmv.javalab.Hello h=
       new com.scsvmv.java.hello.Hello();
  
    //check for command-line argument
    if(arge.lengh>0){
      h.wish(arge[0]);
      h.wishWithDate(arge[0]);
    } else {
      system.out.println("Usage:");
      system.out.println("java com.scsvmv.javalab.testHello<name>");
      system.out.print("example:");
      system.out.print("java com.ssvmv.javalab.testHello student");
     }
    }
   }
 
   
