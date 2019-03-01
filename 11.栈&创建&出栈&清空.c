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
	PNODE pnew = (PNODE)malloc(sizeof(NODE)); // 创建新的结点 
	pnew->data = val ; //将数据赋值给新的结点 
	pnew->next = ps->top ; // 将原来top的指向赋值给 pnew  
	ps->top = pnew ;  //将当前的top 指向  pnew 
	return ;
}
void traverse(PSTACK ps)//输出时  不可以改变 原本栈的结构
{
	PNODE pnew = (PNODE)malloc(sizeof(NODE));
	pnew = ps->top ;
	int i= 1; 
	while(pnew!=ps->bottom)
	{
		printf("第%d个结点为%d\n",i,pnew->data);
		i++;
		pnew=pnew->next ; 
	} 
	return ;
} 
int empty(PSTACK ps)
{
	if(ps->top==ps->bottom)
	{
		return 0 ; //为空 
	}
	else
	{
		return 1;
	}
}
//把ps 所指向的栈出栈一次  
//并把出栈的元素  存入 val形参 所指向的变量中  
void pop(PSTACK ps,int *val )  
{	
	int i = empty(ps);
//	printf("%d\n",i);
	if(i==0)  //ps 存放的就是   S 的地址  如果 
	{
		printf("栈为空  出栈失败\n");
	} 
	else
	{
		PNODE r =  ps->top;
		*val = r->data ; 
		ps->top = r->next;
		free(r);
		r=NULL ;
		traverse(ps);
		printf("出栈成功，出栈元素是：%d\n",*val);
	}
	
}
void clear(PSTACK ps)
{
	int i = empty(ps);
	printf("%d\n",i);
	if(i==0)
	{
		printf("栈为空\n");
	}
	else
	{
		PNODE p=ps->top;
		PNODE q=NULL;
		while(p!=ps->bottom )
		{
			q=p->next; //p指向赋值给q 
			free(p); //释放p 
			p=q ;  //将q 赋值给 p   相当于向下移动一位  
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
	 
	printf("出栈\n");
	pop(&S,&val);//出栈 
	clear(&S);  
	pop(&S,&val);//出栈 
	
	return 0;
} 
