#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *next;
} node;

node* top = NULL;

node* create_node(int data) {
    node* newNode = (node*) malloc(sizeof(node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void push(int data) {
    node* newNode = create_node(data); 
    newNode->next = top;
    top = newNode;
    printf("Pushed %d onto the stack.\n", data);
}

int pop() {
    if(top == NULL) {
        printf("ERROR: Stack underflow.\n");
        return -1; 
    }
    node *temp = top;
    top = top->next;
    return temp->data;
}


int main() {
    int choice, data;
    
    do {
        printf("\nMenu:\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                printf("Enter the value to push: ");
                scanf("%d", &data);
                push(data);
                break;
            case 2:
                data = pop();
                printf("Popped %d from the stack.\n", data);
                break;
            case 3:
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 3);

    return 0;
}
