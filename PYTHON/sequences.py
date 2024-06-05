quantities = list((1,2,3,4,5))
fruits = ["Apple", "Orange", "Pineapple", "Grape", "Mango"]

print(type(quantities))
print(type(fruits))

# * hetrogenious data types
print("\n")

random_bag = ["a", 2, 3.0, 4+7j , (6,9), {1,2,2,3}]
print("Popped", random_bag.pop(0))
print("Last element", random_bag[-1])
print("Length", len(random_bag))

# * Dictionary

print("\n")
me = {
    "name": "Dhaivath Lal",
    "username": "the-dev-d",
    "phone": "000-000-0069",
    "marks": {
        "c": 100,
        "java": 100,
        "python": 100
    }
}

# * Accessing
print("\n")

print(me['name']);
print(me.get("name"));

# * Update
print("\n")

me["marks"]["c"] = 98
me.get("marks").update({"c": 97})

# * Remove
print("\n")
print(me.popitem())

