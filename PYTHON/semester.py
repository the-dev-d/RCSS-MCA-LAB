class Reps:
    def __init__(self, charge_of, charge_name):
        self.charge_of = charge_of;
        self.charge_name = charge_name;

    def describe(self):
        print(f"{self.charge_name} is in charge of {self.charge_of}");


class_rep = Reps("class", "sivanand");
placement_rep = Reps("placement", "gracen")

class_rep.describe()
placement_rep.describe()