#include <stdio.h>

void f(int * p) //定义一个形参，形参名字叫作p 类型是int *
//存放的是整形变量地址 
// 不是定义一个 名字是   *p的形参    
//*p 代表i 
 
{
	*p =100 ;
}
 
int main()
{
	printf("123\n");  
	
	int i = 9 ;
	f(&i) ;
	printf("%d",i);
	return 0;
} 
