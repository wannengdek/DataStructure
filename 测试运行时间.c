#include <stdio.h>
#include<time.h>
int main()
{
	clock_t start, stop;
	start = clock();
	
	// ��Ҫ���ԵĴ��� 
	 
	stop = clock();
	double duration = ((double)(stop - start)) / CLK_TCK;
	printf("%lf", duration);
	return 0;
} 
