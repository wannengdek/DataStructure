#include <stdio.h>
#include <malloc.h>
#include <stdlib.h> 

typedef struct Node 
{
	int data ;
	struct Node * p;	
}NODE,*PNODE;
PNODE creat()
{
	int len ;
	int i;
	int val;
	PNODE head =(PNODE)malloc(sizeof(NODE)) ;
	if(NULL == head) 
	{
		printf("����ʧ�ܣ�������ֹ") ; 
		exit(-1); 
	}
	PNODE last = head ;
	last->p =NULL ;
	printf("��������ڵ�ĸ�����len=");
	scanf("%d",&len) ;
	for(i=0;i<len;i++)
	{
		printf("�������%d���ڵ��ֵ��",i+1) ;
		scanf("%d",&val) ;
		PNODE pNew =(PNODE)malloc(sizeof(NODE)) ; //����һ���µ�ָ��ڵ�  ���������ʱ���� 
		if(NULL == pNew) 
		{
		printf("����ʧ�ܣ�������ֹ");
		exit(-1); 
		}
		pNew->data =val ;
		last->p = pNew ;  //��pnew  �ҵ������ 
		pNew->p =NULL ; 
		last = pNew;
	}
	return head ;
}
void traverse(PNODE head) //�� struct node * ����  ��ͷ�ڵ�ĵ�ַ������ 
{
	PNODE p1 = head->p ;
	while(NULL!=p1)
	{
		printf("%3d",p1->data);
		p1=p1->p ;
		printf("123\n");
	} 
}
int lenth(PNODE head)
{
	PNODE p = head->p ;
	int len =0;
	while(NULL!=p)
	{
		
		p=p->p ;
		++len ;
	} 
	return len;
}

int main()
{
	printf("123\n");
	
	PNODE head = NULL ;
	
	head = creat();
	traverse(head) ; 
	int len=lenth(head) ; 
	 printf("�������	%d\n",len);
	return 0;
} 
