import java.util.Scanner;

// my id: 206576902

/*
The program receives a number from the user and in each function performs a different action on it:
In function #1,
the program will start from the first prime number (2) and check if its complement is prime input. If not go to the next primary and check again.
If so print data.

In function #2,
the program will work similarly to program #1 but will check complementary numbers in the subtraction to the input.

In function #3,
the program will run from the first prime number and count all the primes up to the input.

In function #4
The program will run, check and store the elements of the input and print.

The program also counts the time it took for the program to run
*/

/*
pseudocode for main

num = nextInt  - recive input.
seifAlef - call the function.
..Bet       ..
..          ..
..          ..

 long endTime - stop the time after the  functions end.


*/
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ex0 {
    public static void main(String[] args) {
        System.out.println("Enter an even number greater than 4");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();                 //change the number to check the program.
        while (num <= 4 || num % 2 != 0)
        {
            System.out.printf("greater than 4 , Even...");
            num = sc.nextInt();
        }
        long startTime = System.currentTimeMillis();  // start time
        seifAlef(num);                          //call the functions
        sefBet(num);
        seifGimel(num);
        seifDaled(num);
        long endTime = System.currentTimeMillis();           //start time calculate
        long elapsedTime = (endTime - startTime) / 1000;
        System.out.println();
        System.out.println("E: 206576902");
        System.out.println("F: Caoculate time is:" + elapsedTime + "s");

    }

    //seifAlef Function (Finds two prime numbers that sum to the given number):
    /*
    pseudocode for seifAlef
    * 1. for(p1<num) - Checks if the input is greater than the current initial to continue running
    * 1.1 if( primeNum(p1) == true ) - If P1 is prime set P2 to its complement for input.
    * 1.1.1 p2 = num-p1 - set P2 to its complement for input.
    * 1.1.1 if( if() ) - If P2 is also initial print results and exit the loop
    * 1.1.2 brake -  print results and exit the loop.
    *
    * */
    public static void seifAlef (  int num){                    //Takes the number num as input.
        int p2;
        for (int p1 = 2; p1 < num; p1++) {
            if (primeNum(p1) == true) {                         //send p1 and check if it is prime.
                p2 = num - p1;                                  //p2 is the difference between num and p1
                if (primeNum(p2)) {                              //check if the difference is a prime too and print result
                    System.out.println("A: the two prime numbers equals to " + num + " are: " + p1 + " and " + p2);
                    break;
                }
            }
        }
    }
    /*
    pseudocode for seifBet
    * 1.         for(p1 < num)  - Checks if the input is greater than the current initial to continue running.
    * 1.1        if(primeNum(p1)) - If P1 is prime set P2 to its complement for input.
    * 1.1.1      p2 = num-p1 - set P2 to its complement for input.
    * 1.1.2      if (primeNum(p2)) - If P2 is also initial print results and exit the loop
    * 1.1.2.2    brake - print and brake the loop.
    * */
    public static void sefBet( int num) {
        int p2;
        for (int p1 = 2; p1 < num; p1++) {
            if (primeNum(p1) == true) {                             //send p1 and check if it is prime.
                p2 = num + p1;                                          //p2 is the difference between num and p1
                if (primeNum(p2)) {                                  //check if the difference is a prime too and print result
                    System.out.println("B: the two prime numbers subtracted from each other will get- " + num + " are: " + p1 + " and " + p2);
                    break;
                }
            }
        }
    }

    /*
    pseudocode for seifGimel
    * 1         p2 = 0 -
    * 2         for(i<=num) - Test run until input
    * 2.1       if (primeNum(i)) - Checking if the number is prime
    * 2.1.1     p2++ - If prime, increase P2 by 1
    * 3         ..println() -   Print result
    * */

    public static void seifGimel(int num){                              // seifGimel Function (Counts the number of primes up to num):
        int p2=0;                                                       //Initializes a counter p2 to count prime numbers.
        for (int i=2 ; i<=num ; i++){
            if (primeNum(i)==true){                                    //add p2 by 1 if found one more number
                p2++;
                //System.out.println(p2);
            }
        }
        System.out.println("C: total prime numbers are: "+p2+"in [2,"+num+"]");
    }
    /*
    pseudocode for seifDalet
    * 1             while ()  - Checking if a number is a factor
    * 1.1           System...() - print factor
    * 1.2           num=num/2  - Input division
    * 1.3           if() - Checking if the number is still divisible
    * 1.3.1         system...() - print for next factor
    * 2             for() - Running over all numbers up to the input that could be factors
    * 2.1           while() - Printing all the factors of the number
    * 2.1.1         system...() - print factor
    * 2.1.2         num=num/2  - Input division
    * 2.1.3         if() - print * if still dividable
    * 3         if() -  print last factor.
    * */

    //seifDaled Function (Finds prime factors of num):
    public static void seifDaled(int num){
        while (num % 2 == 0 && num != 1){
            System.out.print(2);
            num=num/2;
            if (num != 1)
                System.out.print("*");
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0 && primeNum(i)) {
                System.out.print(i);
                num = num / i;
                if (num != 1) System.out.print("*");
            }
        }
        if (num > 2) {
            System.out.print(num);
        }
    }



    /*
    pseudocode for primeNum
    * 1         Defining variables
    * 2         if() -   condition that the first is different from 2
    * 3         if() - condition that the first one is greater than 2
    * 4         if() - condition If the number is not prime, return false
    * 5         for() - Run to the root of the number
    * 5.1       if() - Checking if a number is divisible by I to its root.
    * 5.1.1     return false if yes
    * 6         else return true
    *
    * */
    public static boolean primeNum ( int prime) {                                //primeNum Function (Checks if a number is prime). takes a number prime as input.
        int i;
        if (prime == 2) return true;
        if (prime < 2) return false;
        if (prime % 2 == 0) return false;
        for (i = 3; i <= Math.sqrt(prime); i = i + 2) {
            if (prime % i == 0 || prime % 2==0 ) {
                return false;
            }
        }
        return true;
    }
}