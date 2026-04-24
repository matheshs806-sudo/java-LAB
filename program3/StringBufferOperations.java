package textops;

public class StringBufferOperations
{
  private String str;
  
  public StringBufferOperations(String str)
  {
    this.str=str;
   }

  public void exploreStringBufferMethods(String appendstr)
  {
    System.out.println("\n----StringBufferMethods----");

   //Create a StringBuffer object  from str
   StringBuffer sb=new StringBuffer(str);
   System.out.println("Original StringBuffer:"+sb);

  //append() adds text to the end of the buffer(mutable)
  sb.insert(0,"Start-");
  System.out.println("After insert:"+sb);

  //replace() replaces characters between start and end index(mutable)
  sb.replace(0,5,"Begin");
  System.out.println("After replace:"+sb);

  //delete() remove characters between start and end index(mutable)
  sb.delete(0,6);
  System.out.println("After delete:"+sb);

  //reverse() reverse the buffer content(mutable)
  sb.reverse();
  System.out.println("After reverse:"+sb);

  //capacity() shows current buffer size;it automatically increases as needed
  System.out.println("Capacity:"+sb.capacity());

  //length() shows the number of characters cuurently in the buffer 
  System.out.println("Length:"+sb.length());

  //Note:Unlike String,these operations modify the same object
  //String operations(concat,replace,etc.)return new String objects
  }

} 
