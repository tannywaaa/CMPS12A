/************************************************************ 
 * GCD.c
 * Tangni Wang
 * twang63
 * Lab Assignment 8
 * This program calculates the GCD of two numbers.  
 *************************************************************/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(){
	int x, y, bigN, smallN, r, tempn;
	char temps[100001];
	char temps2[100001];
	printf("Enter a positive integer: ");
	int nread = scanf("%d",&x);
	while(nread == 0 || x<=0){
		printf("Please enter a positive integer: ");
		scanf("%s", temps);
		tempn = nread;
		if (tempn == 1) printf("Please enter a positive integer: ");
		nread = scanf("%d", &x);
		tempn = 0;
	}
	printf("Enter another positive integer: ");
	int nread2 = scanf("%d",&y);
        while(nread2 == 0 || y<=0){
                printf("Please enter a positive integer: ");
                scanf("%s", temps2);
		tempn = nread2;
		if (tempn == 1) printf("Please enter a positive integer: ");
		nread2 = scanf("%d", &y);
		tempn = 0;
        }
	if(x>y){
		bigN = x;smallN = y;
	}else{
		bigN = y; smallN = x;
	}r =1;
	while(r!=0){
		r = bigN%smallN;
		bigN = smallN;
		smallN = r;
	}printf("The GCD of %d and %d is %d\n", x, y, bigN);
	return 0;
}
