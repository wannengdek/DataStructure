#include <stdio.h>

void f(int * p) //����һ���βΣ��β����ֽ���p ������int *
//��ŵ������α�����ַ 
// ���Ƕ���һ�� ������   *p���β�    
//*p ����i 
 
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
