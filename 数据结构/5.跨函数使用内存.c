#include <stdio.h>
#include <malloc.h> 

//  ����һ������  ������ 

struct Student 
{
	int id ;
	int age ;
};
struct Student* CreateStudent(void) ;
void Show (struct Student *) ;

struct Student* CreateStudent(void) 
{
	struct Student * p =( struct Student *) malloc (sizeof(struct Student));
	p->id = 99 ; 
	p->age = 99 ;
	return p;
}
void Show (struct Student *pst) 
{
	printf("%d  %d\n",pst->id,pst->age);
}

int main()
{
	struct Student *ps ;
	ps = CreateStudent ();
	Show (ps) ;
	return 0;
} 
