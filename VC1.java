public class VC1
{
   public static String encipher(String s, String key)
   {
    StringBuilder builder = new StringBuilder(); 
    for(int i = 0; i < s.length(); i ++)
    {
     if(s.charAt(i) < 65 || s.charAt(i) > 90)
     { //ASCII character (capital letter)
        throw new IllegalArgumentException("" +"Open text must contain only capital letters");
     }
     //add shift modularly
     char encyphered = s.charAt(i) + getShift(key, i) > 90 ? (char)((s.charAt(i) + getShift(key, i)) - 26) : (char)(s.charAt(i) + getShift(key, i));
     builder.append(encyphered);
    }
    return builder.toString();
   }
   
   public static String decipher(String s, String key)
   {
     StringBuilder builder = new StringBuilder(); 
     for(int i = 0; i < s.length(); i++)
     {
       if(s.charAt(i) < 65 || s.charAt(i) > 90)
       { //ASCII character (capital letter)
         throw new IllegalArgumentException("" +"Ciphertext must contain only capital letters");
       }
       //subtract shift modularly
       char decyphered = s.charAt(i) - getShift(key, i) < 65 ? (char)((s.charAt(i) - getShift(key, i)) + 26) : (char)(s.charAt(i) - getShift(key, i)); builder.append(decyphered);
     }
     return builder.toString();
   }
   private static int getShift(String key, int i)
   {
    if(key.charAt(i % key.length()) < 65 || key.charAt(i % key.length()) > 90)
    {
     throw new IllegalArgumentException("" +"Key phrase must contain only capital letters");
    }
    return ((int)key.charAt(i % key.length())) - 65;
   }
   public static void main (String [] args)
   {
     String text = "MANOJKARTHICK";//only capital letters 
     String key = "MANO";
     String enciphered = encipher(text, key); System.out.println("IMPLEMENTATION OF VIGENERE CIPHER");
     System.out.println("CIPHER TEXT IS:"+enciphered); 
     System.out.println("DECIPHERED TEXT IS:"+decipher(enciphered, key));
   }
}

