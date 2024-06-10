class Hero:
    def __init__(self,name):
        self.name = name;

    def who_are_you(self):
        print(f"I'm {self.name}", end="")
        if(self.name.lower() == "batman"):
            print(" 🦇")


hero = Hero(input("Hero name : "))
hero.who_are_you()