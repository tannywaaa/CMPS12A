/************************************************************ 
 * * * * Queens.java
 * * * * Tangni Wang
 * * * * twang63
 * * * * Programming Assignment 5
 * * * * This program returns the possibile solutions for Queens Game. 
 * * * ************************************************************/

public class Queens {
    

    public static void main(String[] args) {
	//count is the number of solutions
        int count=0;
	//when the command line argument is only the number, prints out the # of solutions
        if(args.length == 1){
            int b = 0;
            try{//check if the input is an integer
                b =Integer.parseInt(args[0]);

            int f = factorial(b);
            int [] A = new int[b];
	    //give the array a size based on the command arguments
            for (int i = 0; i < b; i++) {
                A[i] = (i+1);   
            }//run and find all possible solutions
            for (int i = 0; i < f; i++) {
                nextPermutation(A);
                if (isSolution(A)){
                    count++;
                }  
            }
            System.out.println(args[0]+"-"+"Queens has "+count+" solutions");
            }catch(NumberFormatException e1){//catch the else cases
		System.out.println("Usage: Queens [-v] number");
		System.out.println("Option: -v  verbose output, print all solutions");}
        }
	//when the command line has two arugments, prints out all solutions and the solution numbers
	else if(args.length == 2 && args[0].equals("-v")){
            int b = 0;
             try{
                b = Integer.parseInt(args[1]);
            }catch(NumberFormatException e1){
                System.out.println("Usage: Queens [-v] number");
                System.out.println("Option: -v  verbose output, print all solutions");
            }
            int f = factorial(b);
            int [] A = new int[b];
            for (int i = 0; i < b; i++) {
                A[i] = (i+1);   
            }
            for (int i = 0; i < f; i++) {
		 nextPermutation(A);
		if (isSolution(A)){    
		printArray(A);
                    count++;
                }  
            }System.out.println(args[1]+"-"+"Queens has "+count+" solutions");
        }
	//all other possible cases that prints the usage line
	else{
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v  verbose output, print all solutions");
        }
    }

    //calculates all permutation based on the command line arugment
    static void nextPermutation(int[] A){

        int pivot=A.length-1, successor=0;
        boolean pivotFound = false;
        //check from the right to the left
        //if the current element is less than its right-hand neighbour 
        for (int i = A.length-1; i >= 0; i--) {
            if(i != A.length-1){
                if(A[i]<A[i+1]){
                    //call the current element pivot
                    pivot = i;
                    pivotFound = true;
                    break;
                }
            }
            
        }//if the left end was reached without finding a pivot
        if(pivotFound == false){
            reverse(A,0);
            return;
        }//scan the array from right-to-left again
        for (int i = A.length-1; i >= 0; i--) {
            //if the current element is larger than the pivot
            if(A[i] > A[pivot]){
                //call the current element the successor
                successor = i;
                break;
            }
        }
        swap(A,pivot,successor);//swap the pivot and the successor
        //reverse the portion of the array to the right of where the pivot was found
        reverse(A, pivot+1);
           
    } 
    //print the array
    static void printArray(int[] P){
	System.out.print("(");
        for (int i = 0; i < P.length-1; i++) {
            System.out.print(P[i]+", ");
        }System.out.print(P[P.length-1]);
	System.out.print(")");
	System.out.println();
    }
    //check if the permutation is a solution
    static boolean isSolution(int[] A){
        boolean solution = true; 
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if(Math.abs(A[i]-A[j])== Math.abs(i-j)){
                    solution = false;
                }
            }
        }return solution;
    }
    //swap two elements
    static void swap(int[] Q, int i, int j){
        int temp = Q[i];
        Q[i] = Q[j];
        Q[j] = temp;
    }
    //reverse the left end and right end until it towards the middle
    static void reverse(int[] P, int n){
        int i=n, j=P.length-1;
        while(i<j){
            swap(P, i, j);
            i++;
            j--;
        }
    }
    //find the factorial run times for the permutation
    static int factorial(int n){
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }   
}
    
