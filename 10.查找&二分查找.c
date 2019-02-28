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
	int i=1;
	while(NULL!=p1)
	{
		printf("��%d����㣺%d\n",i,p1->data);
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
//			printf("����ɹ�\n");
//			traverse(head);
//		}
//		else
//		{
//			printf("����ʧ��\n");
//			traverse(head) ;	
//		}
//		
//	}
//
//	PNODE q,s ;
//	q=Get(head,insert-1); 
//	if(q==NULL)
//	{
//		printf("����λ�ò�����") ; 
//	}
//	s=(PNODE)malloc(sizeof(NODE)) ;
//	s->data = inset_val ;
//	s->p =q->p ;
//	q->p = s; 
//	traverse(head);

	//��head��ָ������ĵ� insert������ǰ�����һ���µĽ�㣬�ý���ֵ ��insert_val
	int i= 0 ;
	PNODE p = head ; 
	while(NULL!=p&&i<insert-1)
	{
		p = p->p ;
		++i ;
	}// ͨ��ѭ�����жϵ�ǰ�ж��ٸ��ڵ� ���ҽ���Ҫ �����Ľ�㸳ֵ �� p 
	if(i>insert-1||NULL==p)  //�ж������Ƿ�Ϊ�� 
		printf("����ʧ��\n") ;
	PNODE pnew = (PNODE)malloc(sizeof(NODE)) ;
	if(NULL == pnew)
	{
		printf("��̬�ڴ����ʧ��"); 
	}
	pnew->data = insert_val ;
	PNODE q = p->p ;   //�����µĽ��  ����Ҫ���� λ�õĽ�� ��Ϣ ��ֵ�� q 
	p->p = pnew ;  //   ���ɽ��ָ��  Ϊ�µĽ�� 
	pnew->p = q ;  //�½��� ָ��  ԭ������ λ�õĽ�� 
	printf("����ɹ�\n");
	traverse(head);
}
int Get(PNODE head,int i) //����Ų��ҵ�ǰ�ӵ� 
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
	}// ͨ��ѭ�����жϵ�ǰ�ж��ٸ��ڵ�  ���ҽ���Ҫ �����Ľ�㸳ֵ �� p 
	if(i>delete_position-1||NULL==p)  //�ж������Ƿ�Ϊ�� 
	{
		printf("ɾ��ʧ��") ;
		exit(-1) ;
	}	 
	PNODE n = (PNODE)malloc(sizeof(NODE));
	if(NULL == n)
	{
		printf("��̬�ڴ����ʧ��"); 
	}
	n = p->p ; 	 //��  ��Ҫɾ���Ľ���ָ��  ��ֵ��  n 
	p->p = n->p ; // �� n����һ��ָ���Ǹ�ֵ��   ��ɾ�����ǰ�Ľ��   
	printf("ɾ���ɹ�\n");
	traverse(head);
//	free(head);  //��Ϊfree��ǰ���� ���� �˲�֮��� ����Ϊ��  һֱ��ѭ�� 
}
void select1(PNODE head,int val)//��λ�ò� �Ƿ��������� 
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
		printf(	"\t��%d��\n",val);
	}    
	else
	{
		printf("����ʧ��\n");
	} 	
}
void select2(PNODE head,int val)//��ֵ�� ���ֵ�ڵڼ������ 
{
        int j=1;
        PNODE p = head->p ; 
        while(p&&p->data!=val)
		{
            p=p->p;
            ++j;
        }
        if(p){
        	printf("��Ҫ���ҵĽ��Ϊ��%d��",j);
        }else{
		printf("ssss"); //ʧ�ܣ�����0
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
//	printf("�������ĳ�����%d\n",len);
//	printf("������Ҫ����ڵ��λ��(�����Դ���%d)",len);
//	scanf("%d",&insert);
//	
//	printf("������Ҫ����ڵ��ֵ");
//	scanf("%d",&insert_val);
	
	Insert(head,1,99);
	int delete_position = 2 ;
	delete_val(head,delete_position);
	
	int val = 1 ;
//	select1(head,2);
	select2(head,val);

//	printf("\t��%d��\n",position); 

	clock_t start, stop;
	start = clock();
	
	stop = clock();
	double duration = ((double)(stop - start)) / CLK_TCK;
	printf("\t����ʱ���ǣ�%lf", duration);  //��������ʱ�� 
	
	return 0;
} 
