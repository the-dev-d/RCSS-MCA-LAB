#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head;

struct node *create_node(int data) {
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

void insert_last(int data) {
    struct node *temp, *newNode = create_node(data);
    if (head == NULL) {
        head = newNode;
        return;
    }

    temp = head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    return;
}

void display() {
    struct node *temp = head;

    printf("\n\n");
    while (temp != NULL) {
        printf("%d --> ", temp->data);
        temp = temp->next;
    }
}

void bubbleSort() {
    
    int swap;
    struct node *trav, *delim = NULL;
    
    if(head == NULL)
        return;
    
    do {
        
        swap = 0;
        trav = head;
        
        while(trav->next != delim) {
            
            if(trav->data > trav->next->data) {
                
                int temp = trav->data;
                trav->data = trav->next->data;
                trav->next->data = temp;
                
                swap = 1;
            }
            trav = trav->next;
        }
        delim = trav;
        
    }while(swap);
}

void reverse() {
    struct node *prev = NULL;
    struct node *current = head;
    struct node *nextNode = NULL;

    while (current != NULL) {
        nextNode = current->next;
        current->next = prev;
        prev = current;
        current = nextNode;
    }

    head = prev;
}

int main() {
    int opt, data;
    do {

        printf("\n\n1.Insert \n2.Display \n3.Reverse \n4.Sort \n5.Exit \nEnter your option : ");
        scanf("%d", &opt);

        switch (opt) {

        case 1:
            printf("Enter element : ");
            scanf("%d", &data);
            insert_last(data);
            break;

        case 2:
            display();
            break;

        case 3:
            reverse();
            printf("List Reversed\n");
            break;

        case 4:
            bubbleSort();
        }
    } while (opt != 5);

    return 0;
}
