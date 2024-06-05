l1 = [1,2,3,4,5, ["some"]]
l2 = l1
l2.append(6)

print(l1, l2)

# ! shallow copy only
l2 = l1.copy()
l2.append(7)

l2[5].append("thing")
print(l1, l2)


