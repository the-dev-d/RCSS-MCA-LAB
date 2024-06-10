names = ["Dhaivath", "Abhijith", "Devana", "Joyce", "Shelvin"];

if "Devana" in  names: 
    print("😏")
else:
    print("😐")


for name in names:
    print(name)

names.sort()

print("\n\n==SORTED==\n")

i = 0;
l = len(names)
while i < l:
    print(names[i])
    i=i+1