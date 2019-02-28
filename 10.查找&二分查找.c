#include <stdio.h>
#include <malloc.h>
#include <stdlib.h> 
#include<time.h>

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
	}// 通过循环来判断当前有多少个节点 并且将所要 操作的结点赋值 给 p 
	if(i>insert-1||NULL==p)  //判断链表是否为空 
		printf("插入失败\n") ;
	PNODE pnew = (PNODE)malloc(sizeof(NODE)) ;
	if(NULL == pnew)
	{
		printf("动态内存分配失败"); 
	}
	pnew->data = insert_val ;
	PNODE q = p->p ;   //创建新的结点  将需要插入 位置的结点 信息 赋值给 q 
	p->p = pnew ;  //   将旧结点指向  为新的结点 
	pnew->p = q ;  //新结点的 指向  原来插入 位置的结点 
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
void delete_val(PNODE head,int delete_position)
{
	int i= 0 ;
	PNODE p = head ; 
	while(NULL!=p&&i<delete_position-1)
	{
		p = p->p ;
		++i ;
	}// 通过循环来判断当前有多少个节点  并且将所要 操作的结点赋值 给 p 
	if(i>delete_position-1||NULL==p)  //判断链表是否为空 
	{
		printf("删除失败") ;
		exit(-1) ;
	}	 
	PNODE n = (PNODE)malloc(sizeof(NODE));
	if(NULL == n)
	{
		printf("动态内存分配失败"); 
	}
	n = p->p ; 	 //将  需要删除的结点的指向  赋值给  n 
	p->p = n->p ; // 将 n的下一个指向那赋值给   所删除结点前的结点   
	printf("删除成功\n");
	traverse(head);
//	free(head);  //因为free当前链表 所以 此步之后的 链表为空  一直死循环 
}
void select1(PNODE head,int val)//按位置查 是否有这个结点 
{
	PNODE s = head ;
	int j= 0;

	while(s->p&&j<val)
	{ 
	    s = s->p;
        j++;
	}
	if(j==val)
	{
		printf(	"\t第%d个\n",val);
	}    
	else
	{
		printf("查找失败\n");
	} 	
}
void select2(PNODE head,int val)//按值查 这个值在第几个结点 
{
        int j=1;
        PNODE p = head->p ; 
        while(p&&p->data!=val)
		{
            p=p->p;
            ++j;
        }
        if(p){
        	printf("所要查找的结点为第%d个",j);
        }else{
		printf("ssss"); //失败，返回0
        }
	printf("\n") ;
	traverse(head); 
} 

int main()
{
	PNODE head = NULL ;
	head = creat();
	traverse(head) ; 
	
//	int len=lenth(head) ; 	
	int insert,insert_val ; 
//	printf("这个链表的长度是%d\n",len);
//	printf("请输入要插入节点的位置(不可以大于%d)",len);
//	scanf("%d",&insert);
//	
//	printf("请输入要插入节点的值");
//	scanf("%d",&insert_val);
	
	Insert(head,1,99);
	int delete_position = 2 ;
	delete_val(head,delete_position);
	
	int val = 1 ;
//	select1(head,2);
	select2(head,val);

//	printf("\t第%d个\n",position); 

	clock_t start, stop;
	start = clock();
	
	stop = clock();
	double duration = ((double)(stop - start)) / CLK_TCK;
	printf("\t运行时间是：%lf", duration);  //测试运行时间 
	
	return 0;
} 
