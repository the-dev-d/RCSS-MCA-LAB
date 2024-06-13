//create a class called mobile in C#, class should have following attributes or methods. 
// fields are brand, model, battery lvel.
// methods are MakeCall(phoneno), ChargeBattery(amount), useBattery(amount), printMobile()

// After creating the class, create an instance of Mobile class, set branch and model, call chargeBattery to charge up to 50%.
// Call makeCall() method to simulate making a calll.
// Call useBattery() method to simulate battery usage.
// print details of mobile using print details method.

using System;

namespace MobileClasses {

        abstract class Mobile {

        private string brand;
        private string model;

        public Mobile(string brand, string model) {
            this.brand = brand;
            this.model = model;
        }

        public Mobile() {
            this.battery = 0;
        }

        public string Brand {
            get { return brand; }
            set { brand = value; }
        }

        public string Model {
            get { return model; }
            set { model = value; }
        }

        private short battery;
        public short Battery {
            get { return battery; }
        }

        public void MakeCall(string phone) {
            Console.WriteLine("Calling "+ phone + " ...");
        }

        public void ChargeBattery(short amount) {
            if(this.battery + amount > 100) {
                Console.WriteLine("Battery full");
                this.battery = 100;
                return;
            }
            battery+=amount;
        }

        public void useBattery(short amount) {
            if(this.battery - amount < 0) {
                Console.WriteLine("Battery down");
                this.battery = 0;
                return;
            }
            this.battery-=amount;
        }

        public virtual void PrintDetails() {
            Console.WriteLine("Brand: " + this.brand);
            Console.WriteLine("Model: " + this.model);
            Console.WriteLine("Battery at " + this.battery + "%");
        }

        abstract public void StartDevice();

        abstract public void UseDevice();

    }


    class Smartphone : Mobile {

        protected string osVersion;

        public string OsVersion {
            get { return osVersion; }
            set { osVersion = value; }
        }

        public Smartphone(string brand, string model, string osVersion): base(brand, model) {
            this.osVersion = osVersion;
        }

        public override void StartDevice() {
            Console.WriteLine("Powering on " + this.brand + " " + this.model);
        }

        public override void UseDevice() {
            Console.WriteLine("Using...");
        }

        public override void PrintDetails() {
            Console.WriteLine($"Version : {this.osVersion}");
            base.PrintDetails();
        }
        
    }

    class FeaturedPhone : Mobile {

        protected int buttonCount;

        public FeaturedPhone(string brand, string model, int count): base(brand, model) {
            this.buttonCount = count;
        }

        public override void StartDevice() {
            Console.WriteLine("Powering on " + this.brand + " " + this.model);
        }

        public override void UseDevice() {
            Console.WriteLine("Using...");
        }

        public override void PrintDetails() {
            Console.WriteLine($"Button count : {this.buttonCount}");
            base.PrintDetails();
        }
        
    }

    class Driver {
        public static void Main(string[] args) {

            Smartphone smartphone = new Smartphone("SAMSUNG", "A14", "Q");
            smartphone.StartDevice();

            FeaturedPhone featuredPhone = new FeaturedPhone("SAMSUNG", "Z FOLD", 7);
            featuredPhone.StartDevice();

            smartphone.PrintDetails();
            featuredPhone.PrintDetails();

        }
    }

}