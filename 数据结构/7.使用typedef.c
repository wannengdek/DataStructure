#include <stdio.h>

typedef struct student 
{
	int id; 
	int age ;
}ST ;
int main()
{
	struct student st ; //�ȼ��� ST st
	struct student * ps= &st ; // �ȼ���ST *ps ;
	st.age=20 ;
	ps->id=20 ; //ָ���� ->    
	ST st1 ;
	st1.id =10 ;
	
	printf("%d	%d\n",st.age,st.id);
	
	
	return 0;
} 
