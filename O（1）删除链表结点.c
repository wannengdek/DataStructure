#include <stdio.h>
#include <malloc.h>
#include <stdlib.h> 
#include<time.h>

typedef struct Node 
{
	int data ;  //数据域 
	struct Node * p;	// 指向下一个指针 
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
		printf("插入失败") ;
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
void delete_val(head,delete_position)
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
	free(head);
}

PNODE getToBeDel(PNODE head,int pos)
{
	PNODE tobeDel =(PNODE)malloc(sizeof(NODE)) ;
	int len=lenth(head);
	if(pos>len)
	{
		return ;
	}
	else
	{
		int i=0;
		while(head->p!=NULL&&i<pos)
		{
			head=head->p;
			i++;
		}
		printf("%d\n",head->data);
	}
	tobeDel=head;
	return tobeDel;
}
void delete_O1(PNODE head,PNODE tobeDel)
{
	//  tobeDel 的类型是 struct Node * 类型 即 指向删除节点的指针 
	int i= 0 ;
	PNODE listHead = head ; 
	if(listHead==NULL)  //判断链表是否为空 
	{
		printf("删除失败") ;
		exit(-1) ;
	}	 
	if(tobeDel->p!=NULL)
	{
		//举例  删除下图中的  i 节点 
		PNODE pNext = tobeDel->p; 
		//将要删除的节点的指针 赋值给 新节点 
		// （a） 中  i指向下一个节点的 指针赋值给  新节点 
		// 此时   新节点->j 
		
		tobeDel->data = pNext->data;
		// 将 j 节点的值  赋值给    i 节点   
		
		tobeDel->p = pNext->p ;
		//将 新节点所要指向的下一个节点 赋值给 要删除节点的上一个节点
		// 将 j节点  指向的下一个节点的指针赋值给  h 节点   
		// 此时  h>j>... 
		
		printf("删除节点的值为：%d\n",pNext->data); 
		free(pNext);
	}
	// 链表中只有一个节点，删除头结点。 
	else if(listHead==tobeDel)
	{
		free(listHead);
		free(tobeDel);
		printf("链表中只有一个节点，删除第一个节点，此时链表为空\n"); 
	}
	//链表中有多个节点，删除尾节点 
	else
	{
		PNODE pNext=listHead;
		while(pNext->p!=tobeDel)
		{
			pNext=pNext->p;
		} 
		pNext->p=NULL;
		free(tobeDel);
	} 
}

int main()
{
	
	clock_t start, stop;
	start = clock();
	
	PNODE head = NULL ;
	head = creat();
	traverse(head) ; 
	
	int len=lenth(head) ; 	
	int insert,insert_val ; 
	printf("这个链表的长度是%d\n",len);
	
	PNODE tobeDel = NULL ;
	int b=1;
	tobeDel = getToBeDel(head,b);
	printf("删除第%d个结点\n",b); 
	
	delete_O1(head,tobeDel);
	
	traverse(head) ; 
	
//	Insert(head,1,99);
//	int delete_position = 2 ;
//	delete_val(head,delete_position);
	
	
	stop = clock();
	double duration = ((double)(stop - start)) / CLK_TCK;
	printf("\t运行时间是：%lf", duration);  //测试运行时间 
	
	return 0;
} 
