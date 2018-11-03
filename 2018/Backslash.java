import java.util.Arrays;
import java.util.Scanner;

public class Backslash {
    static void print(String arg){
        System.out.print(arg);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){

            int levels = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();

            for(int i = 0; i<s.length(); i++){
                if((s.charAt(i) >= '!' && s.charAt(i) <= '*') || (s.charAt(i) >= '[' && s.charAt(i) <= ']')){
                    char[] chars = new char[(int)Math.pow(2, levels)-1];
                    Arrays.fill(chars, '\\');
                    String backs = new String(chars);
                    print(backs);
                }print("" + s.charAt(i));
            }
            print("\n");
            if(!scan.hasNext())
                break;
        }
    }
}
