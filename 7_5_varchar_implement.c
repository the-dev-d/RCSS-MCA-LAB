#include <stdio.h>
#include<malloc.h>
int main()
{


    char inputBuffer;
    int size = 1;
    char *varchar = (char*) malloc(sizeof(char));
    
    do {
        
        scanf("%c", &inputBuffer);
        varchar = (char*) realloc(varchar, size * sizeof(char));
        if(inputBuffer == '\n') {
            varchar[size] = '\0';
            break;
        }
        varchar[size++] = inputBuffer;
        
    }while(1);
    
    varchar[size - 1] = '\0';
    
    printf("\n%s", varchar);

    return 0;
}