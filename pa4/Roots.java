/************************************************************ 
 * * * * Roots.java
 * * * * Tangni Wang
 * * * * twang63
 * * * * Programming Assignment 4
 * * * * This program returns the roots of a polonomial function.  
 * * * ************************************************************/
import java.util.Scanner;

class Roots{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		double res, tol, thre;
		int deg;
		double L, R, a, b, fa, fb, root;
		double[] coeArray, diffArray;
		boolean rootB = false;

		//calling inputs.
		System.out.print("Enter the degree: ");
		deg = sc.nextInt();

		System.out.print("Enter "+(deg+1)+ " coefficients: ");

		coeArray = new double[deg +1];
		for (int i = 0; i< coeArray.length; i++){
			coeArray[i] = sc.nextDouble();
		}

		System.out.print("Enter the left and right endpoints: ");
		L = sc.nextDouble();
		R = sc.nextDouble();
		System.out.print("\n");

		//create diffArray
		diffArray = new double[deg];
		diffArray = diff(coeArray);

		//set up the initials
		res = 1e-2;
		tol = 1e-7;
		thre = 1e-3;

		//find roots
		a = L;
		b = a+res;
		while(b <= R){
			fa = poly(coeArray, a);
			fb = poly(coeArray, b);
			//find odd roots 
			if(fa*fb <= 0){
				root = findRoot(coeArray, a, b, tol);
				System.out.print("Root found at ");
				System.out.printf("%.5f%n", root);
				rootB = true;
			//find even roots
			}else{
				double fa2 = poly(diffArray, a);
				double fb2 = poly(diffArray, b);
				if(fa2*fb2 <0){
					root = findRoot(diffArray, a, b, tol);
					if(Math.abs(poly(coeArray, root))<thre){
						System.out.println("Root found at ");
						System.out.printf("%.5f%n", root);
						rootB = true;
					}
				}
			}a = b;
			b = a+res;
			}if (rootB == false){
				System.out.println("No roots were found in the ecified range.");}
		}
		
		//create the polonomial
		static double poly(double[] C, double x){
			double y = 0;
			for(int i = 0; i< C.length; i++){
				y += Math.pow(x,i)*C[i];
			}return y;
		}
		//calculate the differation
		static double[] diff(double[] C){
			double[] D=new double[C.length-1];
			for(int i = 1; i< C.length; i++){
				D[i-1] = C[i]*i;
			}return D;
		}
		//find the roots
		static double findRoot(double[] C, double a, double b, double tolerance){
			double m=0, width;
			double fa, fm;
			width = b-a;

			while(width > tolerance){
				m =(a+b)/2;
				fm = poly(C,m);fa = poly(C,a);
				if (fa*fm <= 0){
					b = m;
				}else{
					a = m;}
				width = b-a;
			}return m;
		}
	}
