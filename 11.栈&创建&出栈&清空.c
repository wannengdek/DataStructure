#include <stdio.h>
#include <malloc.h>
#include <stdlib.h> 
#include<time.h>

typedef struct Node 
{
	int data ;
	struct Node * next;	
}NODE,*PNODE;
typedef struct Stack
{
	PNODE top; 
	PNODE bottom ;  
}STACK, *PSTACK;

void init(PSTACK ps)
{
	ps->top = (PNODE)malloc(sizeof(NODE));
	if(NULL== ps->top)
	{
		printf("fail");
	} 
	else
	{
		ps->bottom = ps->top; 
		ps->bottom->next =NULL;
	}
}
void push(PSTACK ps,int val)
{
	PNODE pnew = (PNODE)malloc(sizeof(NODE)); // �����µĽ�� 
	pnew->data = val ; //�����ݸ�ֵ���µĽ�� 
	pnew->next = ps->top ; // ��ԭ��top��ָ��ֵ�� pnew  
	ps->top = pnew ;  //����ǰ��top ָ��  pnew 
	return ;
}
void traverse(PSTACK ps)//���ʱ  �����Ըı� ԭ��ջ�Ľṹ
{
	PNODE pnew = (PNODE)malloc(sizeof(NODE));
	pnew = ps->top ;
	int i= 1; 
	while(pnew!=ps->bottom)
	{
		printf("��%d�����Ϊ%d\n",i,pnew->data);
		i++;
		pnew=pnew->next ; 
	} 
	return ;
} 
int empty(PSTACK ps)
{
	if(ps->top==ps->bottom)
	{
		return 0 ; //Ϊ�� 
	}
	else
	{
		return 1;
	}
}
//��ps ��ָ���ջ��ջһ��  
//���ѳ�ջ��Ԫ��  ���� val�β� ��ָ��ı�����  
void pop(PSTACK ps,int *val )  
{	
	int i = empty(ps);
//	printf("%d\n",i);
	if(i==0)  //ps ��ŵľ���   S �ĵ�ַ  ��� 
	{
		printf("ջΪ��  ��ջʧ��\n");
	} 
	else
	{
		PNODE r =  ps->top;
		*val = r->data ; 
		ps->top = r->next;
		free(r);
		r=NULL ;
		traverse(ps);
		printf("��ջ�ɹ�����ջԪ���ǣ�%d\n",*val);
	}
	
}
void clear(PSTACK ps)
{
	int i = empty(ps);
	printf("%d\n",i);
	if(i==0)
	{
		printf("ջΪ��\n");
	}
	else
	{
		PNODE p=ps->top;
		PNODE q=NULL;
		while(p!=ps->bottom )
		{
			q=p->next; //pָ��ֵ��q 
			free(p); //�ͷ�p 
			p=q ;  //��q ��ֵ�� p   �൱�������ƶ�һλ  
		} 
		ps->top=ps->bottom ;  
	}
}
int main()
{
	STACK S ; 
	
	int val ; 
	
	init(&S);
	push(&S,1);
	push(&S,2);
	push(&S,3);
	push(&S,4);
	traverse(&S);
	 
	printf("��ջ\n");
	pop(&S,&val);//��ջ 
	clear(&S);  
	pop(&S,&val);//��ջ 
	
	return 0;
} 
