import java.util.*;
import java.math.BigInteger;
public class DiffeHellmanBigInt
{
    final static BigInteger one = new BigInteger("1"); 
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in); 
        BigInteger p;
        System.out.println("Enter the approximate value of p you want."); 
        String ans = stdin.next();
        p = getNextPrime(ans);
        System.out.println("Your prime is "+p+".");
        System.out.println("Now, enter a number in between 2 and p-1."); 
        BigInteger g = new BigInteger(stdin.next());
        System.out.println("Person A: enter your secret number now."); 
        BigInteger a = new BigInteger(stdin.next());
        BigInteger RESULTa = g.modPow(a,p);
        System.out.println("Person A sends to person B "+RESULTa+".");
        System.out.println("Person B: enter your secret number now."); 
        BigInteger b = new BigInteger(stdin.next());
        BigInteger RESULTb = g.modPow(b,p);
        System.out.println("Person B sends to person A "+RESULTb+".");
        BigInteger KeyACalculates = RESULTb.modPow(a,p); 
        BigInteger KeyBCalculates = RESULTa.modPow(b,p);
        System.out.println("A takes "+RESULTb+" raises it to the power "+a+" mod "+p); 
        System.out.println("The Key A calculates is "+KeyACalculates+".");
        System.out.println("B takes "+RESULTa+" raises it to the power "+b+" mod "+p); 
        System.out.println("The Key B calculates is "+KeyBCalculates+".");
    }

    public static BigInteger getNextPrime(String ans)
    {
      BigInteger test = new BigInteger(ans); 
      while (!test.isProbablePrime(99))
        test = test.add(one); return test;
    }
}



