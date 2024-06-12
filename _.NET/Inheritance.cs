//create a sub class Android then use methods and properties inside base class

using System;
using MobileClasses;
class Android : Mobile, ICamera, IGps {

    private string version;

    public Android(string version, string brand, string model): base(brand, model) {
        this.version = version;
    }

    public new void PrintDetails() {
        Console.WriteLine("Version : " + version);
        base.PrintDetails();
    }

    public void TakePhoto() {

        Console.WriteLine("📸 Click .. 😜 You look good");
    }

    public void GetLocation() {
        Console.WriteLine("Location identified : You are here");
    }
}

class MainClass {

    public static void Main(string[] args) {

        Android android = new Android("Q", "SAMSUNG", "galaxy z fold");
        android.ChargeBattery(50);
        android.PrintDetails();

        Console.WriteLine("\n\n===OTHER====\n\n");

        android.TakePhoto();
        android.GetLocation();
    }
}