#include <stdio.h>
#include <string.h>
#include <ctype.h>


#define MAX_SIZE 100

// Function to check if a character is an operator
int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

// Function to get the precedence of an operator
int precedence(char op) {
    switch (op) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}

// Function to convert infix expression to postfix
void infixToPostfix(char infix[], char postfix[]) {
    char opStack[MAX_SIZE];
    int top = -1;
    int i, j;

    for (i = 0, j = 0; infix[i] != '\0'; i++) {
        char ch = infix[i];

        if (ch == ' ')
            continue;

        if (isdigit(ch) || isalpha(ch)) {
            postfix[j++] = ch;
        } else if (isOperator(ch)) {
            while (top >= 0 && precedence(opStack[top]) >= precedence(ch)) {
                postfix[j++] = opStack[top--];
            }
            opStack[++top] = ch;
        } else if (ch == '(') {
            opStack[++top] = ch;
        } else if (ch == ')') {
            while (top >= 0 && opStack[top] != '(') {
                postfix[j++] = opStack[top--];
            }
            if (top >= 0 && opStack[top] == '(') {
                top--;
            }
        }
    }

    while (top >= 0) {
        postfix[j++] = opStack[top--];
    }

    postfix[j] = '\0';
}

int main() {
    
    char infix[MAX_SIZE];
    char postfix[MAX_SIZE];

    printf("Enter infix string : ");
    scanf("%s", infix);

    infixToPostfix(infix, postfix);

    printf("Postfix expression: %s\n", postfix);

    return 0;
}
