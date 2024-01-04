package org.example.publickey;

import org.example.primality.PrimalityTest;

public class RSA {

    public static boolean isPrime(long n){
        if(PrimalityTest.millerRabin((int)n,4).equals("prime")) return true;
        return false;
    }

    public static long getLargeRandomPrimeNumber(){
        long max = 100000000;//100 million
        long min = 10000000;//10 million
        long num = (long) ((Math.random()*(max-min))+min);
        while(!isPrime(num)){
            num = (long) ((Math.random()*(max-min))+min);
        }
        return num;
    }

    public static long euclideanGCD(long a, long b) {
        while (!(b==0)){
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static long RSA1 () {
        //1. choose two large prime number p and q
        long p = getLargeRandomPrimeNumber();
        long q = getLargeRandomPrimeNumber();
        //2. comput n=pq
        long n = p*q;
        //3. compute the carmichael function for n (lambda(n)), i.e. find the smallest possible integer m such that a^m = 1 mod n holds for every integer a coprime to n.
        //lambda(n) = lcm(p-1, q-1)
        //lcm(a,b) = abs(a*b)/gcd(a,b)
        long a = p-1, b=q-1;
        long lambda_n = a*b/euclideanGCD(a,b);
        //4. choose an integer 2<e<lambda_n that is coprime to lambda n
        long e = 65537;



        return -1;
    }
}
