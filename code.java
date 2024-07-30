import java.util.*;
class Main 
{
    private static final String DIGITS = "0123456789";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String message = sc.nextLine();
        int shift=sc.nextInt();
        String encodedMessage = encodeMessage(message, shift);
        System.out.println("Encoded Message: " + encodedMessage);
    }
    public static String encodeMessage(String message, int shift) 
    {
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) 
        {
            if (DIGITS.indexOf(c) != -1)
                encodedMessage.append(shiftChar(c, DIGITS, shift));
            else if (LOWER_CASE.indexOf(c) != -1)
                encodedMessage.append(shiftChar(c, LOWER_CASE, shift));
            else if (UPPER_CASE.indexOf(c) != -1)
                encodedMessage.append(shiftChar(c, UPPER_CASE, shift));
            else if (SPECIAL_CHARS.indexOf(c) != -1)
                encodedMessage.append(shiftChar(c, SPECIAL_CHARS, shift));
            else
                encodedMessage.append(c);
        }
        return encodedMessage.toString();
    }
    private static char shiftChar(char c, String charSet, int shift) {
        int idx = charSet.indexOf(c);
        return charSet.charAt((idx + shift) % charSet.length());
    }
}
