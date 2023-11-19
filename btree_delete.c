#include <stdio.h>
#include <malloc.h>
struct node
{
    int data;
    struct node *left;
    struct node *right;
};
typedef struct node NODE;
NODE *root = NULL;
NODE *create_node(int e)
{
    NODE *node = (NODE *)malloc(sizeof(NODE));
    node->data = e;
    node->left = node->right = NULL;
    return node;
}
void insert(int e)
{
    NODE *node = create_node(e);
    NODE *p, *t = root;
    if (root == NULL)
    {
        root = node;
        return;
    }
    while (t != NULL)
    {
        p = t;
        if (e > t->data)
            t = t->right;

        else if (e < t->data)
            t = t->left;
    }
    if (p->data > e)
    {
        p->left = node;
    }
    else
    {
        p->right = node;
    }
}

void delete(int key)
{

    NODE *p = NULL, *t = root;

    if (root->data == key && root->left == NULL && root->right == NULL)
    {
        root = NULL;
        return;
    }

    if (root->left != NULL && root->right == NULL && root->data == key)
    {

        root = root->left;

        return;
    }

    if (root->right != NULL && root->left == NULL && root->data == key)
    {

        root = root->right;

        return;
    }

    while (t != NULL && t->data != key)
    {

        if (t->data > key)
        {
            p = t;
            t = t->left;
        }
        if (t->data < key)
        {
            p = t;
            t = t->right;
        }
    }

    if (t == NULL)
    {
        printf("Element not found");
        return;
    }

    if (t->left == NULL && t->right == NULL)
    {

        if (p->left == t)
        {
            p->left = NULL;
        }
        else if (p->right == t)
        {
            p->right = NULL;
        }
    }
    else if (t->left == NULL && t->right != NULL)
    {

        if (p->left == t)
        {
            p->left = p->left->right;
        }
        else
        {
            p->right = p->right->right;
        }
    }
    else if (t->right == NULL && t->left != NULL)
    {

        if (p->left == t)
        {
            p->left = p->left->left;
        }
        else
        {
            p->right = p->right->left;
        }
    }
    else
    {

        NODE *trav = t->right;
        while (trav->left != NULL)
            trav = trav->left;

        int temp = trav->data;
        delete (trav->data);
        t->data = temp;
    }
}

void inorder(NODE *node)
{

    if (node == NULL)
        return;

    inorder(node->left);
    printf("%d -> ", node->data);
    inorder(node->right);
}

int main()
{
    insert(50);
    insert(40);
    insert(100);
    insert(30);
    insert(45);
    insert(20);
    insert(35);
    insert(42);
    insert(48);
    insert(70);
    insert(150);

    inorder(root);

    delete (45);

    printf("\n\n");
    inorder(root);
    return 0;
}
