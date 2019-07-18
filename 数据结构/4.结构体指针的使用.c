#include <stdio.h>

struct Student
{
	int id;
	char name[200];
 } ;

void f(struct Student *pst)
{
	pst->id =99;
 } 
void g(struct Student st)
{
	printf("%d  %s",st.id,st.name);
	//耗内存   耗时间    
	
}

void g1(struct Student * st)
{
	printf("%d  %s",st->id,st->name); 
	//通过指针指向  直接对成员进行操作   避免复制内存  节约空间 	 
}
//使用 结构体指针对结构体里的成员进行赋值 
int main()
{
	printf("123\n");
	
	struct Student st={1000,"123"};
	
	struct Student * pst ;
	pst = &st ;
	pst->id = 919;
	
	f(&st);
	g(st);
	g1(&st);
	// pst->id 等价于  *(pst) .id   ==  st.id   
	//pst 指向  结构体中的 id 成员
	
	 

	return 0;
} 
