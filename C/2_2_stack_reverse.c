#include<stdio.h>
#define SIZE 30
char stack[SIZE];
int top = -1;

void push(char item) {
    if(top + 1 == SIZE) {
        printf("ERROR : Stack overflow!! \n");
        return;
    }
    stack[++top] = item;
}
char pop() {
    if(top == -1) {

        printf("ERROR : Stack underflow!! \n");
        return '\0';
    }
    return stack[top--];
}
int main() {

    char ch,n = 0;
    printf("Enter a string (max 30 letters) : ");
    do {
        scanf("%c", &ch);
        push(ch);
        n++;
        
    }while(ch != '\n');
    
    pop();
    printf("Reverse is : ");
    for(n--; n>0; n--) {
        printf("%c", pop());
    }
    
    return 0;
}