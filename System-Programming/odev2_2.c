#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int
main(int argc,char *argv[])
{
	if(argc != 4){
                puts("Girilen argüman sayisi hatali");
                exit(EXIT_FAILURE);
        }

        int a = atoi(argv[2]);
        int b = atoi(argv[3]);
	if ((strncmp(argv[1],"topla",5) == 0)) 
		printf("%d",a+b);
	else if ((strncmp(argv[1],"cikar",5) == 0))
		printf("%d",a-b);
	else if ((strncmp(argv[1],"carp",4) == 0))
		printf("%d",a*b);
	else if ((strncmp(argv[1],"bol",3) == 0))
		 printf("%d",a/b);
	else
		puts ("Girdiginiz argumanlari dogru seciniz");
}

