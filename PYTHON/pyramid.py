
rows = int(input("Enter rows : "))
# rows = 4;

for i in range(rows):
    for j in range(0, rows - i):
        print(" ", end="")

    for k in range(0, (i+1)*2-1):
        print("*", end="")

    print()
