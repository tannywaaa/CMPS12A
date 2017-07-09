
/************************************************************ 
 * * Guess.java
 * * Tangni Wang
 * * twang63
 * * Programming Assignment 3
 * * This program allowds the user to guess the number the computer is thinking about; then the user will have three chances to guess the number, if the user gets it right, the computer will return "You Win", otherwise " You Loose"  
 * ************************************************************/


import java.util.Scanner;

class Guess{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int n = (int)(10.0*Math.random())+1;

                System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
                System.out.print("Enter your first guess: ");
                int nGuess1 = sc.nextInt();
                if (nGuess1 == n){
			System.out.println("You win!");
			System.exit(0);
		}else if (nGuess1 > n){
                        System.out.println("Your Guess is too high. ");
		}else{
			System.out.println("Your Guess is too low. ");}
		System.out.print("Enter your second guess: ");
                int nGuess2 = sc.nextInt();
                if(nGuess2 == n){
			System.out.println("You win!");
			System.exit(0);
                }else if (nGuess2 > n){
                        System.out.println("Your Guess is too high. ");
                }else{
                        System.out.println("Your Guess is too low. ");}
		System.out.print("Enter your third guess: ");
                int nGuess3 = sc.nextInt();
                if(nGuess3 == n){
                        System.out.println("You win!");
                }else{
                        System.out.println("Your loose. The number was " +n+ ".");}
	
	}
}
