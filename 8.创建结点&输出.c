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
		printf("分配失败，程序终止") ; 
		exit(-1); 
	}
	PNODE last = head ;
	last->p =NULL ;
	printf("输入链表节点的个数：len=");
	scanf("%d",&len) ;
	for(i=0;i<len;i++)
	{
		printf("请输入第%d个节点的值：",i+1) ;
		scanf("%d",&val) ;
		PNODE pNew =(PNODE)malloc(sizeof(NODE)) ; //创建一个新的指针节点  用来存放临时数据 
		if(NULL == pNew) 
		{
		printf("分配失败，程序终止");
		exit(-1); 
		}
		pNew->data =val ;
		last->p = pNew ;  //将pnew  挂到最后面 
		pNew->p =NULL ; 
		last = pNew;
	}
	return head ;
}
void traverse(PNODE head) //即 struct node * 类型  将头节点的地址传过来 
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
	 printf("这个链表	%d\n",len);
	return 0;
} 
