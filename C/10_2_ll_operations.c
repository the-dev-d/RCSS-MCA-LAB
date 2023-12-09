#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node {
    char data[50]; // Assuming a maximum string length of 50 characters
    struct node *next;
};

struct node *head;

struct node *create_node(const char *data) {
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    if (newNode) {
        strcpy(newNode->data, data);
        newNode->next = NULL;
    }
    return newNode;
}

void insert_last(const char *data) {
    struct node *temp, *newNode = create_node(data);
    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    if (head == NULL) {
        head = newNode;
        return;
    }

    temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}

void display() {
    struct node *temp = head;
    printf("\nLinked List of Strings:\n");
    while (temp != NULL) {
        printf("%s --> ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void bubbleSort() {
    int swapped;
    struct node *ptr1;
    struct node *lptr = NULL;

    if (head == NULL)
        return;

    do {
        swapped = 0;
        ptr1 = head;

        while (ptr1->next != lptr) {
            if (strcmp(ptr1->data, ptr1->next->data) > 0) {
                char temp[50];
                strcpy(temp, ptr1->data);
                strcpy(ptr1->data, ptr1->next->data);
                strcpy(ptr1->next->data, temp);
                swapped = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    } while (swapped);
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

void delete(char data[50]) {
    
    if(head == NULL) {
        printf("List empty\n");
        return;
    }
    struct node *t = head, *prev = NULL;
    while(t!=NULL && strcmp(t->data, data)) {
        prev = t;
        t=t->next;
    }
    if(t==NULL) {
        printf("Element not found\n");
        return;
    }
    if(prev == NULL) {
        head = head->next;
        return;
    }
    prev->next = t->next;
    
}

void reversePrint(struct node *current) {
    if (current == NULL) {
        return;
    }
    reversePrint(current->next);
    printf("%s --> ", current->data);
}

int main() {
    int opt;
    char data[50];

    do {
        printf("\n1. Insert\n2. Sort\n3. Reverse Print\n4. Display\n5. Delete\n6.Exit \nEnter your option: ");
        scanf("%d", &opt);

        switch (opt) {
            case 1:
                printf("Enter a string: ");
                scanf("%s", data);
                insert_last(data);
                break;

            case 2:
                bubbleSort();
                printf("List Sorted\n");
                break;

            case 3:
                reversePrint(head);
                printf("\nList Printed in Reverse Order\n");
                break;

            case 4:
                display();
                break;
                
            case 5:
                printf("Enter string to delete: ");
                scanf("%s", data);
                delete(data);
                break;
        }
    } while (opt != 6);

    // Free the memory allocated for the linked list
    struct node *current = head;
    while (current != NULL) {
        struct node *temp = current;
        current = current->next;
        free(temp);
    }

    return 0;
}
