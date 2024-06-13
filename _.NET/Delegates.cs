using System;
public delegate void DoThisAfter(string name);
class Delegates {

    public static void doStuffAnd(DoThisAfter param) {
        Console.WriteLine("Stuff is done...");

        param("boss");
    }

    public static void Main(string[] args) {

        Delegates.doStuffAnd((name) => Console.WriteLine("Stuff done " + name ));

    }
}