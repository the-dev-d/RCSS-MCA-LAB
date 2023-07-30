#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include<stdlib.h>

#define MAX_SIZE 100

int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

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

void infixToPostfix(char infix[], char postfix[]) {
    char opStack[MAX_SIZE];
    int top = -1;
    int i, j;

    for (i = 0, j = 0; infix[i] != '\0'; i++) {
        char ch = infix[i];

        if (ch == ' ')
            continue;

        if (isdigit(ch)) {
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
        else {
            printf("Invalid token, Quitting");
            exit(0);
        }
    }

    while (top >= 0) {
        postfix[j++] = opStack[top--];
    }

    postfix[j] = '\0';
}

int applyOperator(char op, int operand1, int operand2) {
    switch (op) {
        case '+':
            return operand1 + operand2;
        case '-':
            return operand1 - operand2;
        case '*':
            return operand1 * operand2;
        case '/':
            return operand1 / operand2;
        default:
            exit(0);
    }
}

void evaluatePostfix(char postfix[]) {
    
    int i;
    int stack[MAX_SIZE];
    int top = -1;

    for(i=0; postfix[i] != '\0'; i++) {

        if(isdigit(postfix[i])) {
            stack[++top] = postfix[i] - '0';
        }
        else if(isOperator(postfix[i])) {
            int buffer = stack[top--];
            stack[++top] = applyOperator(postfix[i], stack[top--], buffer);
        }

    }

    printf("%d", stack[0]);
}

int main() {
    
    char infix[MAX_SIZE];
    char postfix[MAX_SIZE];

    printf("Enter infix string : ");
    scanf("%s", infix);

    infixToPostfix(infix, postfix);

    printf("Postfix expression: %s\n", postfix);
    evaluatePostfix(postfix);

    return 0;
}
