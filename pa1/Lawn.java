
/************************************************************ 
 * * Lawn.java
 * * Tangni Wang
 * * twang63
 * * Programming Assignment 1
 * * This java program asks the user for length, width and moving rate and it gives the area and moving time. 
 * ************************************************************/
import java.util.Scanner;

class Lawn{

   public static void main( String[] args ){

      double lengthL, widthL,lengthH, widthH, area, rate;
      int r, h, m, s;
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter the length and width of the lot, in feet: ");
      lengthL = sc.nextDouble();
      widthL = sc.nextDouble();
      System.out.print("Enter the length and width of the house, in feet: ");
      lengthH = sc.nextDouble();
      widthH = sc.nextDouble();
      area = (lengthL*widthL)-(lengthH*widthH);
      System.out.println("The lawn area is: "+ area + "square feet.");
      
      System.out.print("Enter the moving rate, in square feet per second: ");
      rate = sc.nextDouble();
      s = (int)Math.round(area/rate);
      m = s/60;
      s = s%60;
      h = m/60;
      m = m%60;
      String sec, min, hour;
      sec = ( s==1 ? " second" : " seconds");
      min = ( m==1 ? " minute" : " mintures");
      hour = ( h==1 ? " hour" : " hours");
      System.out.println("The moving time is "+ h+ hour +" "+ m+ min +" "+ s+ sec+ ".");

      
     }
   }
