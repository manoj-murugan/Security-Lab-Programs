import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; 
public class HashTextTest
{
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        System.out.println("Shared Hash Key Value is:"+sha1("Yuvashree Lakshmi"));
    }
    static String sha1(String input) throws NoSuchAlgorithmException
    {
      MessageDigest mDigest = MessageDigest.getInstance("SHA1"); 
      byte[] result= mDigest.digest(input.getBytes());
      StringBuffer sb = new StringBuffer(); 
      for (int i = 0; i <result.length; i++)
      {
        sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
      }
      return sb.toString();
    }
}



