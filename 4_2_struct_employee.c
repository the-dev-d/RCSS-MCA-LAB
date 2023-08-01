#include <stdio.h>
#include <string.h>
#define MAX 100

struct Employee {
    int eno;
    char ename[50];
    double esal;
    int dno;
};

void searchEmployeeByNumber(struct Employee employees[], int n, int eno) {
    int i;
    for (i = 0; i < n; i++) {
        if (employees[i].eno == eno) {
            printf("Employee found:\n Employee Number: %d\n Employee Name: %s\n Employee Salary: %f\n Department Number: %d\n",
            employees[i].eno, employees[i].ename, employees[i].esal, employees[i].dno);
            
            return;
        }
    }
    printf("Employee with number %d not found.\n", eno);
}

void sortEmployeesByName(struct Employee employees[], int n) {
    int i, j;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (strcmp(employees[j].ename, employees[j + 1].ename) > 0) {
                struct Employee temp = employees[j];
                employees[j] = employees[j + 1];
                employees[j + 1] = temp;
            }
        }
    }
}

void sortEmployeesBySalary(struct Employee employees[], int n) {
    int i, j;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (employees[j].esal > employees[j + 1].esal) {
                struct Employee temp = employees[j];
                employees[j] = employees[j + 1];
                employees[j + 1] = temp;
            }
        }
    }
}

int deleteEmployeeByNumber(struct Employee employees[], int n, int eno) {
    int i;
    for (i = 0; i < n; i++) {
        if (employees[i].eno == eno) {
            for (int j = i; j < n - 1; j++) {
                employees[j] = employees[j + 1];
            }
            n--;
            printf("Employee with number %d deleted successfully.\n", eno);
            return n;
        }
    }
    printf("Employee with number %d not found.\n", eno);
    return n;
}

void insertEmployee(struct Employee employees[], int i, int n) {
    if(i == n) {
        printf("Memory full");
        return;
    }
    printf("\nEnter details for Employee\n");
    printf("Employee Number: ");
    scanf("%d", &employees[i].eno);
    printf("Employee Name: ");
    scanf(" %[^\n]", employees[i].ename);
    printf("Employee Salary: ");
    scanf("%lf", &employees[i].esal);
    printf("Department Number: ");
    scanf("%d", &employees[i].dno);
}

void displayEmployees(struct Employee employees[], int n) {
    printf("Employee Details:\n");
    printf("ENO\tENAME\t\tESALARY\tDNO\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%s\t%f\t%d\n", employees[i].eno, employees[i].ename, employees[i].esal, employees[i].dno);
    }
}

int main() {
    struct Employee employees[MAX];
    int n, i=0;

    printf("Enter the number of employees (less than 100 ): ");
    scanf("%d", &n);

    int choice;
    do {
        printf("\n\nMenu:\n");
        printf("1. Insert \n2. Search by eno \n3. Sort by name \n4. Sort by salary\n5. Delete by eno\n 6.Display \n7.Delete \nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                insertEmployee(employees, i, n);
                i++;
                break;

            case 2:
                int eno;
                printf("Enter the Employee Number to search: ");
                scanf("%d", &eno);
                searchEmployeeByNumber(employees, i, eno);
                break;

            case 3:
                sortEmployeesByName(employees, i);
                printf("Employees sorted by Name successfully.\n");
                break;

            case 4:
                sortEmployeesBySalary(employees, i);
                printf("Employees sorted by Salary successfully.\n");
                break;

            case 5:
                printf("Enter the Employee Number to delete: ");
                scanf("%d", &eno);
                i = deleteEmployeeByNumber(employees, i, eno);
                break;

            case 6:
                displayEmployees(employees, i);
                break;

            case 7:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 7);

    return 0;
}
