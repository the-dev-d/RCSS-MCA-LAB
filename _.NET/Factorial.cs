using  System;

class Factorial {

    static int findFactorial(int n) {
        if(n == 0)
            return 1;

        return n * findFactorial(n - 1);
    }
    public static void Main(string[] args) {

        Console.WriteLine("Enter a number : ");
        int n = int.Parse(Console.ReadLine());

        Console.WriteLine("Factorial of " + n +" is : " + findFactorial(n));

    }
}