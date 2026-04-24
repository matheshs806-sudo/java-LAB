import java.util.Scanner; 
public class Main { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter first number: "); 
int num1 = sc.nextInt(); 
System.out.print("Enter second number: "); 
int num2 = sc.nextInt(); 
// Call static methods directly using class name 
ArithOp.add(num1, num2); 
ArithOp.sub(num1, num2); 
ArithOp.mul(num1, num2); 
ArithOp.div(num1, num2); 
sc.close(); 
} 
}


