//-----------------------------------------------------------------------------
//   IntegerTest.java
//   Tests the Integer wrapper class
//-----------------------------------------------------------------------------

class IntegerTest{

   public static void main(String[] args){
      Integer a = new Integer("365");  // constructor from String
      Integer b = new Integer(365);    // constructor from int
      Integer c = 365;                 // shortcut constructor from int

      System.out.println(a);
      System.out.println(b);
      System.out.println(c);

      // arithmetic operators work on Integer as on int
      a += 10;  
      System.out.println(a+b+c);

      System.out.println(a.equals(b));
      System.out.println(b.equals(c));
      System.out.println(c.equals(a));

      System.out.println(a.compareTo(b));
      System.out.println(b.compareTo(c));
      System.out.println(c.compareTo(a));

      System.out.println(c.doubleValue());

      System.out.println(Integer.valueOf("512"));        // same as new Integer("512")
      System.out.println(Integer.valueOf(512));          // same as new integer(512);
      System.out.println(Integer.parseInt("7334712"));   // parseInt() returns int not Integer
      
      try{ 
         System.out.println(Integer.parseInt("27xyz53")); 
      }catch(NumberFormatException e){ 
         System.out.println(e.getMessage()+": cannot parse as int");
      }
      
      System.out.println(Integer.MAX_VALUE);
      System.out.println(Integer.MIN_VALUE);
      
      System.out.println(Integer.SIZE);
      
      System.out.println(Integer.MAX_VALUE+1);
      System.out.println(Integer.MIN_VALUE-1);

      System.out.println( 2*(Integer.MAX_VALUE + 1) );

   }
}
