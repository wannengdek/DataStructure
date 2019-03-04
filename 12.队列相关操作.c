#include <stdio.h>
#include <malloc.h>


typedef struct Queue
{
	int * pBase ;
	int front;
	int rear; 
}QUEUE;
 
void init(QUEUE *pQ)
{
	pQ->pBase=(int *)malloc(sizeof(int)*6);
	pQ->front=0;
	pQ->rear=0;
}
int full(QUEUE *pQ)
{
	if((pQ->rear+1)%6==pQ->front)
	{
		return 1;
	}
	else
	{
		return 0;
		printf("队列为空\n");
	} 
}
void insert(QUEUE *pQ,int val)
{
	if(full(pQ)==1)
	{
		printf("队列已满\n");
	}
	else
	{
		pQ->pBase[pQ->rear] =val;
		pQ->rear=(pQ->rear+1)%6;
	}
}
void traverse(QUEUE *pQ)
{
	int i = pQ->front ;
	while(i!=pQ->rear)
	{
		printf("%d\n",pQ->pBase[i]);
		i=(i+1)%6 ; 
	} 
}
int empty(QUEUE *pQ)
{
	if(pQ->front==pQ->rear)
	{
		return 1;
	} 
	else
	{
		return 0;
	}
}
int out(QUEUE *pQ,int *pval)
{
	if(empty(pQ)==0)
	{
		*pval = pQ->pBase[pQ->front] ;
		pQ->front =(pQ->front+1)%6 ;
		printf("出队成功\n");
		traverse(pQ);
		return 1;
	}
	else
	{
		return 0;
		printf("出队失败\n");
	}
	
	
		
}

int main()
{	
	QUEUE Q;
	
	init(&Q);
	
	insert(&Q,1); 
	insert(&Q,2);
	insert(&Q,3);
	insert(&Q,4);
	insert(&Q,5);
	
	full(&Q);
	traverse(&Q);
	
	int val= 4; 
	int i = out(&Q,&val);
	//printf("%d\n",val);
	
	return 0;
} 
