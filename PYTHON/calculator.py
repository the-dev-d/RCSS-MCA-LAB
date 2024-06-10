
a = int(input("Enter first operand :"))
b = int(input("Enter second operand :"))

operator = input(" + , - , / , * : Enter operator : ")

print("Result : ")
match operator:
    case '+': print(a+b)
    case '-': print(a-b)
    case '*': print(a*b)
    case '/': print(a/b)
    case _:
        print("Unknown operator")

