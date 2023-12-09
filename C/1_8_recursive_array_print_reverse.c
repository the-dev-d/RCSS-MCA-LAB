#include<stdio.h>

void recursive_order_print(int ar[], int pos) {

    printf(" %d |",ar[pos]);

    if(pos > 0)
        recursive_order_print(ar, pos-1);

}

int main() {

    int ar[40], size, i, item;

    printf("Enter size of array (less than 40) : ");
    scanf("%d", &size);

    for (i = 0; i<size; i++)
    {
        printf("Enter element %d : ", i+1);
        scanf("%d", &ar[i]);
    } 

    printf("===========PRINTING IN RECURSION============\n\n");
    recursive_order_print(ar, size-1);

    return 0;
}