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
	//top ָ��ջ��Ԫ�� 
	PNODE bottom ;  
	// bottom ָ��ջԪ�� ����һ��û��ʵ�������Ԫ�� 
}STACK, *PSTACK;


// PSTACK �ȼ���struct Stack *   
//�βν��� ����  * ����  ����ʵ�δ�ֵʱ��Ҫ  ���&  
void init(PSTACK  ps)
{
	ps->top = (PNODE)malloc(sizeof(NODE));
	if(ps->top==NULL)
	{
		printf("fail");
		exit(-1);
	}
	else
	{
		ps->bottom = ps->top; 
		ps->top->next =NULL;
	}	
}
void push(PSTACK ps,int val)
{
	PNODE pnew =(PNODE)malloc(sizeof(NODE));
	pnew->data=val;
	pnew->next = ps->top ; 
	//�� ָ��ջ����ָ�� ��ֵ�� ���µ�Ԫ�� ��ָ���� 
	ps->top = pnew ;
	// ���½����� Ԫ�� ��ֵ��  ջ��  ��Ϊ�µ� ջ�� 
}
void traverse(PSTACK ps)
{
	PNODE p = ps->top ;
	while(p!=ps->bottom)
	{
		//��ջ��ָ�뻹û��ָ��ջβָ��ʱ   �������±������ 
		printf("%3d",p->data);
		p=p->next;
	}
}
int empty(PSTACK ps)
{
	if(ps->top==ps->bottom)
	{
		return 0;
		// ջΪ�� ����0 
	}
	else
	{
		return 1;
		// ջ��Ϊ��  ���� 1 
	}
} 
// ��ջ����    �ѳ�ջ��Ԫ�ر��浽val �β���ָ��ı���  
void pop(PSTACK ps,int *val )  
{	
	int i = empty(ps);
	// ps ��������βεĵ�ַ 
	//  ������������������ֵʱʹ�� ps  ������ &ps 
	//printf("%d\n",i);
	if(i==0)  //ps ��ŵľ���   S �ĵ�ַ  ��� 
	{ 
		printf("\nջΪ��  ��ջʧ��\n");
	} 
	else 
	{
		PNODE r =  ps->top;
		//����ָ��  ָ��ջ�� 
		*val = r->data ; 
		// ���� ��ջԪ�ص�ֵ 
		ps->top = r->next;
		// ������ջԪ�ص�ָ����   ��ֵ��   top  �����µ�ջ�� 
		free(r); 
		r=NULL ;
		//�ͷſռ� 
		
		traverse(ps);
		printf("��ջ�ɹ�����ջԪ���ǣ�%d\n",*val);
	}	
}
void clear(PSTACK ps)
{
	//������ֱ�Ӹı�ָ���ָ�� ��Ӧ��һ��һ���ͷſռ䵽���һ��ָ��	
	
	int i=empty(ps);
	if(i==1)
	{
		PNODE p,q;
		p=ps->top;
		q=NULL;
		while(p!=ps->bottom)
		{
			q=p->next; //��p ��ָ����ֵ�� q 
			free(p); 
			//p=q->next; 
			p=q;  // ��q ��ֵ�� �µ� p �ٽ�����һ�����ж� 
		}	
		ps->top=ps->bottom ; 
		printf("\������\n");
	}
	else
	{
		printf("\nջΪ�գ��������\n");
	}
}
int main()
{
	STACK S ; //stack �ȼ��� struct stack 
	
	int val ; //�����ջԪ�� 
	
	init(&S); //���һ����ջ 
	push(&S,1);  // ѹջ 
	push(&S,2);
	push(&S,3);
	push(&S,4);
	traverse(&S); //��� 
	
	printf("��ջ\n");
	pop(&S,&val);//��ջ 
	clear(&S);  //��� 
	pop(&S,&val);//��ջ 
	return 0;
} 
