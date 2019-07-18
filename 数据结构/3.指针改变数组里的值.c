#include <stdio.h>
void f(int * p)
{
	p[2] =1; // p[0]==*p  p[2] ==*(p+2) ==*(a+2) ==a[2] 
} 
int main()
{
	int a[5] ={1,2,3,4,5};
	f(a);   //a µÈ¼ÛÓÚ &a[0]; 
	printf("%d\n",a[2]);
	
	return 0;
} 
