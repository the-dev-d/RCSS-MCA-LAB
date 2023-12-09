#include <stdio.h>
#include <malloc.h>
#define MAX 100

struct node
{
    int data;
    struct node *left, *right;
};
typedef struct node NODE;

struct node_stack
{
    int top;
    NODE *stack[MAX];
};
typedef struct node_stack NODE_STACK;

NODE *root = NULL;
NODE_STACK node_stacker;

void push(NODE *node)
{

    if (node_stacker.top + 1 == MAX)
    {
        printf("Stack overflow ");
        return;
    }

    node_stacker.stack[++node_stacker.top] = node;
}

NODE *pop()
{
    if (node_stacker.top == -1)
    {
        printf("Stack undeflow");
        return NULL;
    }

    return node_stacker.stack[node_stacker.top--];
}

NODE *createNode(int data)
{

    NODE *node = (NODE *)malloc(sizeof(NODE));
    node->data = data;
    node->left = node->right = NULL;

    return node;
}

void insert(int data)
{

    if (root == NULL)
    {
        root = createNode(data);
        return;
    }
    NODE *t = root;
    while (1)
    {

        if (t->data > data && t->left != NULL)
            t = t->left;

        else if (t->data > data)
        {
            t->left = createNode(data);
            break;
        }
        else if (t->data < data && t->right != NULL)
            t = t->right;

        else if (t->data < data)
        {
            t->right = createNode(data);
            break;
        }
    }
}

void inorderTraversal()
{

    NODE *t = root;
    while (t != NULL || node_stacker.top != -1)
    {
        while (t != NULL)
        {
            push(t);
            t = t->left;
        }
        t = pop();
        printf("%d ", t->data);
        t = t->right;
    }
}

void preorderTraversal()
{

    NODE *t = root;
    while (t != NULL || node_stacker.top != -1)
    {

        while (t != NULL)
        {
            printf("%d ", t->data);
            push(t);
            t = t->left;
        }
        t = pop();
        t = t->right;
    }
}

void main()
{
    node_stacker.top = -1;
    int elem;
    while (1)
    {
        scanf("%d", &elem);
        insert(elem);
        preorderTraversal();
        printf("\n");
        inorderTraversal();
        printf("\n\n\n");
    }
}