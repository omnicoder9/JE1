package org.example.publickey;

import org.example.primality.PrimalityTest;

public class RSA {

    public static boolean isPrime(long n){
        if(PrimalityTest.millerRabin((int)n,4).equals("prime")) return true;
        return false;
    }

    public static long getLargeRandomNumber(){
        long max = 100000000;//100 million
        long min = 10000000;//10 million
        long num = (long) ((Math.random()*(max-min))+min);
        while(!isPrime(num)){
            num = (long) ((Math.random()*(max-min))+min);
        }
        return num;
    }

    public static long RSA1 () {
        //1. choose two large prime number p and q

        return -1;
    }
}
