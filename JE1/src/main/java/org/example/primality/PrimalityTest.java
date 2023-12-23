package org.example.primality;

public class PrimalityTest {

    public static String trialDivision(int m){
        if (m < 3) throw new IllegalArgumentException("input must be >= 3");
        for (int i=2; i<=Math.sqrt(m); i++){
            if (m%i == 0){
                return "composite";
            }
        }
        return "prime";
    }

    public static String millerRabin(int m, int k){
        if (m<3) throw new IllegalArgumentException("input m must be greater than 2");
        if (k<1) throw new IllegalArgumentException("input k must be at least 1");
        if (m%2 == 0) return "composite";

        int s = 0;
        int minus1 = m-1;
        while(minus1%2 == 0){
            minus1 /= 2;
            s += 1;
        }
        int d = (int)(minus1 / Math.pow(2,s));
        for (int i=0; i<k; i++){
            int min = 2;
            int max = m-2;
            int a = (int)(Math.random()*(max-min+1)+min);
            int x = (int)(Math.pow(a,d)%m);
            int y = -1;//initialize y to arbitrary value
            for (int j=0; j<s; j++){
                y = (x*x)%m;
                if(y==1 && x!=1 && x!=m-1){
                    return "composite";
                }
                x = y;
            }
            if (y != 1) return "composite";


        }

        return "prime";
    }
    public static void main(String[] args){
        //String str = trialDivision(2);
        System.out.println("5 is " + trialDivision(5));
        System.out.println("3 is " + trialDivision(3));
        System.out.println("407 is " + trialDivision(407));
        System.out.println("409 is " + trialDivision(409));
        System.out.println("251 is " + trialDivision(251));
        System.out.println("254 is " + trialDivision(254));
        System.out.println("1049 is " + trialDivision(1049));


    }
}
