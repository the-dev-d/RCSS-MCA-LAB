//create a class called mobile in C#, class should have following attributes or methods. 
// fields are brand, model, battery lvel.
// methods are MakeCall(phoneno), ChargeBattery(amount), useBattery(amount), printMobile()

// After creating the class, create an instance of Mobile class, set branch and model, call chargeBattery to charge up to 50%.
// Call makeCall() method to simulate making a calll.
// Call useBattery() method to simulate battery usage.
// print details of mobile using print details method.

using System;
using MobileClasses;
public class MobileUses {

    public static void Main(string[] args) {

        Mobile mobile = new Mobile();
        mobile.Brand = "SAMSUNG";
        mobile.Model = "Z Fold";

        Console.Write("Dial number : ");
        string dial = Console.ReadLine();
        mobile.MakeCall(dial);
        mobile.ChargeBattery((short)(50 - mobile.Battery));
        Console.WriteLine("Battery charged up to " + mobile.Battery + "%");

        mobile.useBattery((short)20);
        mobile.PrintDetails();

    }
}