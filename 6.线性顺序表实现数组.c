#include <stdio.h>
#include <stdbool.h>
#include <malloc.h>
#include <stdlib.h>
typedef struct Arr
{
	int *p ; //存储的是数组第一个元素的地址 
	int len ; //数组所能容纳的最大元素的个数 
	int cnt ; //当前数组有效元素的个数 
}ar; 
void init(ar  *pArr, int lenth) ;
bool append(ar  *pArr, int val);
bool insert(ar  *pArr, int pos,int val);// pos 的值从1开始 
bool delete_arr(ar  *pArr, int pos,int *pVal);
int get();
bool empty(ar  *pArr);
bool full();
void sort(ar  *pArr);
void show(ar  *pArr);
void inversion(ar  *pArr);//倒置 


bool empty(ar  *pArr)
{
	if(0==pArr->cnt)
		return true ;
	else
		return false ;
	
}

void init(ar  *pArr, int lenth)
{
	//该函数功能为初始化数组    
	pArr->p = (int *)malloc (sizeof(int) * lenth) ;
	// 将首地址 给  指针变量 *p
	if (NULL == pArr->p) 
	{
		printf("动态内存分配失败") ;
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
		printf("数组为空\n"); 
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
	//该函数功能为  为数组追加元素 且默认追加到数组末尾   
	if(full(pArr))
	{
		return false ;
	}
	//不满的时追加 
	else
	{
		 pArr->p[pArr->cnt] = val ;
		 (pArr->cnt)++ ;
		 return true ; 
	}
}

bool insert(ar  *pArr, int pos,int val)
{
	//该函数功能为插入元素  pos 代表位置   val代表插入的值 
	int i;
	
	if(full(pArr))
		return false ;
	
	if(pos<1||pos>pArr->cnt+1) //不可以比有效个数还多 
	{
		return false ;
	}
	for(i=pArr->cnt-1;i>=pos-1 ;--i)
	{
		pArr->p[i+1] = pArr->p[i] ;
	}
	//将所有元素插入位置之后的元素往后挪一个位置
	pArr->p[pos-1]=val ;
	 
	
	pArr->cnt++ ;  //有效个数加1   要不然只输出未添加之前的 个数 
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
	// 将要删除的值  赋给 pval    
	for(i=pos ;i<pArr->cnt ;i++)
	{
		pArr->p[i-1] = pArr->p [i] ;
	}
	(pArr->cnt) -- ; 
	return true ; 
}

void inversion(ar  *pArr)
{
	printf("倒置\n");
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
	printf("开始排序，从小到大\n");
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
	printf("排序结束\n");
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
		printf("删除的元素是%d\n",val) ;
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
