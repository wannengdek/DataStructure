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
	int i=1;
	while(NULL!=p1)
	{
		printf("第%d个结点：%d\n",i,p1->data);
		i++;
		p1=p1->p ;
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
void Insert(PNODE head,int insert,int insert_val)
{
//	PNODE In =(PNODE)malloc(sizeof(NODE)) ; 
//	PNODE m =(PNODE)malloc(sizeof(NODE)) ; 
//	In->data = inset_val ;
//	int len = lenth(head) ; 
//	int i ;
//	int j=1 ;
//	whlie(head->p)
//	
//	for(i=1;i<insert;i++)
//	{
//		m = head->p;
//	}
//	
//	for(i=1;i<len;i++)
//	{
//		if(i==insert)
//		{
//			In->p = head->p; 
//			head->p = In ;
//			printf("插入成功\n");
//			traverse(head);
//		}
//		else
//		{
//			printf("插入失败\n");
//			traverse(head) ;	
//		}
//		
//	}
//
//	PNODE q,s ;
//	q=Get(head,insert-1); 
//	if(q==NULL)
//	{
//		printf("插入位置不合理") ; 
//	}
//	s=(PNODE)malloc(sizeof(NODE)) ;
//	s->data = inset_val ;
//	s->p =q->p ;
//	q->p = s; 
//	traverse(head);

	//在head所指向链表的第 insert个结点的前面插入一个新的结点，该结点的值 是insert_val
	int i= 0 ;
	PNODE p = head ; 
	while(NULL!=p&&i<insert-1)
	{
		p = p->p ;
		++i ;
	}
	if(i>insert-1||NULL==p)
		printf("插入失败") ;
	PNODE pnew = (PNODE)malloc(sizeof(NODE)) ;
	if(NULL == pnew)
	{
		printf("动态内存分配失败"); 
	}
	pnew->data = insert_val ;
	PNODE q = p->p ;
	p->p = pnew ;
	pnew->p = q ;
	printf("插入成功\n");
	traverse(head);
}
int Get(PNODE head,int i) //按序号查找当前加点 
{
	int j = 0 ;
	int x ;
	PNODE p = head ;
	while(p!=NULL&&j<i)
	{
		j++ ;
		p=p->p ;
	} 
	if(p==NULL)
	{
		return 0; 
	}
	else
	{
		x= p->data ;
	}
}

int main()
{
	printf("123\n");
	
	PNODE head = NULL ;
	
	head = creat();
	traverse(head) ; 
	int len=lenth(head) ; 
	int insert,insert_val ; 
	printf("这个链表的长度是%d\n",len);
	printf("请输入要插入节点的位置(不可以大于%d)",len);
	scanf("%d",&insert);
	
	printf("请输入要插入节点的值");
	scanf("%d",&insert_val);
	Insert(head,insert,insert_val);
	
	return 0;
} 
