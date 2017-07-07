/* Sphere.c*/
#include<stdio.h>
#include<math.h>

int main(void){
	double r, vol, sa;
	const double pi = 3.141592654;
	printf("Enter the radius of the sphere: ");
	scanf("%lf", &r);
	vol = (4*pi*pow(r,3))/3;
	sa = 4*pi*pow(r,2);
	printf("The volume is %lf and the surface area is %lf.\n",vol,sa);
	return 0;
}
