#include <stdio.h>

struct Student
{
	int id;
	char name[200];
 } ;

void f(struct Student *pst)
{
	pst->id =99;
 } 
void g(struct Student st)
{
	printf("%d  %s",st.id,st.name);
	//���ڴ�   ��ʱ��    
	
}

void g1(struct Student * st)
{
	printf("%d  %s",st->id,st->name); 
	//ͨ��ָ��ָ��  ֱ�ӶԳ�Ա���в���   ���⸴���ڴ�  ��Լ�ռ� 	 
}
//ʹ�� �ṹ��ָ��Խṹ����ĳ�Ա���и�ֵ 
int main()
{
	printf("123\n");
	
	struct Student st={1000,"123"};
	
	struct Student * pst ;
	pst = &st ;
	pst->id = 919;
	
	f(&st);
	g(st);
	g1(&st);
	// pst->id �ȼ���  *(pst) .id   ==  st.id   
	//pst ָ��  �ṹ���е� id ��Ա
	
	 

	return 0;
} 
