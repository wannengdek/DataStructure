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
	//top 指向栈顶元素 
	PNODE bottom ;  
	// bottom 指向栈元素 的下一个没有实际意义的元素 
}STACK, *PSTACK;


// PSTACK 等价于struct Stack *   
//形参接收 的是  * 类型  所以实参传值时需要  添加&  
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
	//将 指向栈顶的指针 赋值给 最新的元素 的指针域 
	ps->top = pnew ;
	// 将新建立的 元素 赋值给  栈顶  做为新的 栈顶 
}
void traverse(PSTACK ps)
{
	PNODE p = ps->top ;
	while(p!=ps->bottom)
	{
		//当栈顶指针还没有指向栈尾指针时   继续往下遍历输出 
		printf("%3d",p->data);
		p=p->next;
	}
}
int empty(PSTACK ps)
{
	if(ps->top==ps->bottom)
	{
		return 0;
		// 栈为空 返回0 
	}
	else
	{
		return 1;
		// 栈不为空  返回 1 
	}
} 
// 出栈操作    把出栈的元素保存到val 形参所指向的变量  
void pop(PSTACK ps,int *val )  
{	
	int i = empty(ps);
	// ps 保存的是形参的地址 
	//  所以再往其他函数传值时使用 ps  而不是 &ps 
	//printf("%d\n",i);
	if(i==0)  //ps 存放的就是   S 的地址  如果 
	{ 
		printf("\n栈为空  出栈失败\n");
	} 
	else 
	{
		PNODE r =  ps->top;
		//建立指针  指向栈顶 
		*val = r->data ; 
		// 保存 出栈元素的值 
		ps->top = r->next;
		// 将所出栈元素的指针域   赋值给   top  当作新的栈顶 
		free(r); 
		r=NULL ;
		//释放空间 
		
		traverse(ps);
		printf("出栈成功，出栈元素是：%d\n",*val);
	}	
}
void clear(PSTACK ps)
{
	//不可以直接改变指针的指向 而应该一个一个释放空间到最后一个指针	
	
	int i=empty(ps);
	if(i==1)
	{
		PNODE p,q;
		p=ps->top;
		q=NULL;
		while(p!=ps->bottom)
		{
			q=p->next; //将p 的指针域赋值给 q 
			free(p); 
			//p=q->next; 
			p=q;  // 将q 赋值给 新的 p 再进行下一步的判断 
		}	
		ps->top=ps->bottom ; 
		printf("\清空完毕\n");
	}
	else
	{
		printf("\n栈为空，无需清空\n");
	}
}
int main()
{
	STACK S ; //stack 等价于 struct stack 
	
	int val ; //保存出栈元素 
	
	init(&S); //造出一个空栈 
	push(&S,1);  // 压栈 
	push(&S,2);
	push(&S,3);
	push(&S,4);
	traverse(&S); //输出 
	
	printf("出栈\n");
	pop(&S,&val);//出栈 
	clear(&S);  //清空 
	pop(&S,&val);//出栈 
	return 0;
} 
