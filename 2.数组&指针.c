#include <stdio.h>

int main()
{
	printf("123\n");
	
	int a[5] = {1,2,3,4,5};
	//  a[3] = *(a+3)   都代表第四个元素 
	printf("%d\n",*(a+3));
	printf("%p\n",*a+3);// *a+3 = a[0]+3
	 
	return 0;
} 
