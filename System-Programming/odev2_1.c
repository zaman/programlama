#include <stdio.h>
#include <stdlib.h>

void topla(int a,int c)
{
	printf ("%d", a + c);
}

void cikar (int a ,int c)
{
	printf("%d", a -c);
}

void carp(int a ,int c)
{
	printf("%d", a * c);

}

void bol (int a, int c)
{
	printf("%d", a / c);
}

int
main(int argc , char *argv[])
{
	
	if(argc != 4){
		puts("Girilen argüman sayisi hatali");
		exit(EXIT_FAILURE);
	}
	int a = atoi(argv[1]);
	int c = atoi(argv[3]);
	switch (*argv[2]) {
		case '+' : topla(a,c);
			break;
		case '-' : cikar(a,c);
			break;
		case 'x' : carp(a,c);
			break;
		case '/' : bol(a,c);
			break;
		default:
			puts("girdiginiz argumanlari dikkatli seciniz");
			break;
	}
	return 0;
}	
