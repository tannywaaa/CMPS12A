/************************************************************ 
 * * * GCD.java
 * * * Tangni Wang
 * * * twang63
 * * * Programming Assignment 4
 * * * This program calculates the GCD of two numbers.  
 * * ************************************************************/

import java.util.Scanner;

class GCD{
	public static void main( String[] args){
		Scanner sc = new Scanner(System.in);
		int x,y,bigN,smallN, r;
		System.out.print("Enter a positive integer: ");
		while(true){
			while(!sc.hasNextInt()){
				sc.next();
				System.out.print("Please enter a positive integer: ");
			}
			x = sc.nextInt();
			if( x>0 ) break;
			System.out.print("Please enter a positive integer: ");
		}System.out.print("Enter another positive integer: ");
		while(true){
                        while(!sc.hasNextInt()){
				sc.next();
				System.out.print("Please enter a positive integer: ");
			}
                        y = sc.nextInt();
                        if( y>0 ) break;
                        System.out.print("Please enter a positive integer: ");
                }

		if(x>y){
			bigN = x;smallN = y;
		}else{
			bigN = y;smallN = x;
		}
		r = 1;
		while(r!=0){
			r = bigN%smallN;
                	bigN = smallN;
                	smallN = r;
		}
		System.out.println("The GCD of "+ x + " and " + y + " is " + bigN);
	}
}
