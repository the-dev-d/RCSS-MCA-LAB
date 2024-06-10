class Reps:
    def __init__(self, charge_of, charge_name):
        self.charge_of = charge_of;
        self.charge_name = charge_name;

    def describe(self):
        print(f"{self.charge_name.capitalize()} is in charge of {self.charge_of.capitalize()}");

    def is_in_charge(self, name):
        return self.charge_name.lower() == name


class_rep = Reps("class", "sivanand");
placement_rep = Reps("placement", "gracen")

class_rep.describe()
placement_rep.describe()

print(class_rep.is_in_charge("gracen"))