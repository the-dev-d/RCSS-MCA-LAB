using System;
class TypeCasting {

    public static void Main() {
        
        int a = 7;

        // Widening
        double d = a;
        d+=0.69;

        Console.WriteLine("Widened : " + d);

        // Narrowing
        Console.WriteLine("Widened : " + (int)d);

    }
}