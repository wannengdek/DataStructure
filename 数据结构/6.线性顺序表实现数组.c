#include <stdio.h>
#include <stdbool.h>
#include <malloc.h>
#include <stdlib.h>
typedef struct Arr
{
	int *p ; //�洢���������һ��Ԫ�صĵ�ַ 
	int len ; //�����������ɵ����Ԫ�صĸ��� 
	int cnt ; //��ǰ������ЧԪ�صĸ��� 
}ar; 
void init(ar  *pArr, int lenth) ;
bool append(ar  *pArr, int val);
bool insert(ar  *pArr, int pos,int val);// pos ��ֵ��1��ʼ 
bool delete_arr(ar  *pArr, int pos,int *pVal);
int get();
bool empty(ar  *pArr);
bool full();
void sort(ar  *pArr);
void show(ar  *pArr);
void inversion(ar  *pArr);//���� 


bool empty(ar  *pArr)
{
	if(0==pArr->cnt)
		return true ;
	else
		return false ;
	
}

void init(ar  *pArr, int lenth)
{
	//�ú�������Ϊ��ʼ������    
	pArr->p = (int *)malloc (sizeof(int) * lenth) ;
	// ���׵�ַ ��  ָ����� *p
	if (NULL == pArr->p) 
	{
		printf("��̬�ڴ����ʧ��") ;
		exit(-1) ; 
	}
	else
	{
		pArr->len =lenth ;
		pArr->cnt = 0 ;
	}
	return ; 
	 
} 

void show(ar  *pArr)
{
	if(empty(pArr))
	{
		printf("����Ϊ��\n"); 
	}
	else
	{
		int i =0 ;
		for(i =0 ; i<pArr->cnt ;i++)
		{
			printf("%d\n",pArr->p[i]) ;
		}
	} 
	printf("--------show-----\n");
}

bool full(ar  *pArr)
{
	if(pArr->cnt==pArr->len)
		return true ;
	else
		return false ;
}

bool append(ar  *pArr, int val)
{
	//�ú�������Ϊ  Ϊ����׷��Ԫ�� ��Ĭ��׷�ӵ�����ĩβ   
	if(full(pArr))
	{
		return false ;
	}
	//������ʱ׷�� 
	else
	{
		 pArr->p[pArr->cnt] = val ;
		 (pArr->cnt)++ ;
		 return true ; 
	}
}

bool insert(ar  *pArr, int pos,int val)
{
	//�ú�������Ϊ����Ԫ��  pos ����λ��   val��������ֵ 
	int i;
	
	if(full(pArr))
		return false ;
	
	if(pos<1||pos>pArr->cnt+1) //�����Ա���Ч�������� 
	{
		return false ;
	}
	for(i=pArr->cnt-1;i>=pos-1 ;--i)
	{
		pArr->p[i+1] = pArr->p[i] ;
	}
	//������Ԫ�ز���λ��֮���Ԫ������Ųһ��λ��
	pArr->p[pos-1]=val ;
	 
	
	pArr->cnt++ ;  //��Ч������1   Ҫ��Ȼֻ���δ���֮ǰ�� ���� 
	return true ;
}

bool delete_arr(ar  *pArr, int pos,int *pVal)
{
	int i ;
	if(empty(pArr))
		return false ;
	if(pos<1 || pos >pArr->cnt)
		return false ;
	*pVal = pArr->p[pos-1] ;
	// ��Ҫɾ����ֵ  ���� pval    
	for(i=pos ;i<pArr->cnt ;i++)
	{
		pArr->p[i-1] = pArr->p [i] ;
	}
	(pArr->cnt) -- ; 
	return true ; 
}

void inversion(ar  *pArr)
{
	printf("����\n");
	int i =0 ;
	int j= pArr->cnt-1;
	int t ;
	
	while(i<j)
	{
		t = pArr->p[i] ;
		pArr->p[i] = pArr->p[j] ;
		pArr->p[j] = t ;
		++i ;
		--j; 
 	}
 	
 	return ;
	
}

void sort(ar  *pArr)
{
	printf("��ʼ���򣬴�С����\n");
	int i, j,t; int m=0;
	for(i=0; i<pArr->cnt ;i++)
	{
		for(j=i+1;j<pArr->cnt;j++)
		{
			if(pArr->p[i]>pArr->p[j])
			{
				t = pArr->p[i] ;
				pArr->p[i] = pArr->p[j] ;
				pArr->p[j] = t ;
				
				for(m=0;m<pArr->cnt;m++)
				{
					printf("%3d  ",pArr->p[m]);
				}
				printf("\n");
			}
			
		}
	}
	printf("�������\n");
}
void f(int * a)
{
	*a=100;
}
int main()
{
	
	ar  arr ;
	int val ;
	 
	init(&arr,6) ;
	show(&arr) ;
	append(&arr,1) ; 
	append(&arr,2) ;
	append(&arr,55) ;
	append(&arr,412) ;
	append(&arr,5) ;
	
	insert(&arr,1,88) ; 
	show(&arr) ;
	if
	(delete_arr(&arr, 4 ,&val) )
	{
		printf("success\n") ;
		printf("ɾ����Ԫ����%d\n",val) ;
	}
	else
	{
		printf("false") ;
	}
		show(&arr) ;
	printf("------------------\n");
	sort(&arr);
	show(&arr);
	inversion(&arr);
	show(&arr);
	//printf("%d" ,Arr.len) ;
	return 0;
} 
