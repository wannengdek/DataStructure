#include <stdio.h>
#include<time.h>
int main()
{
	clock_t start, stop;
	start = clock();
	
	// 所要测试的代码 
	
	int a=123;
	
	int b=123/100;
	int c=123%100%10;
	printf("%d	%d ",b,c);
	 
	
	 
	stop = clock();
	double duration = ((double)(stop - start)) / CLK_TCK;
	printf("%lf", duration);
	return 0;
} 
