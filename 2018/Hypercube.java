import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Hypercube {
    static void print(String arg){
        System.out.print(arg);
    }

//    static HashMap<String, Character> map;
//    static int count = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
//        print(Arrays.toString(input));
        int n = Integer.parseInt(input);
        String a = scan.next();
        String b = scan.next();
        print(a + "|" + b + "|" + input +"|");
        if(n == 1){
            print("" + 0);
        }
        else {
            print("" + (grayToDecimal(b) - grayToDecimal(a) - 1));
        }
    }

    static int grayToDecimal(String gray){
        String binary = "" + gray.charAt(0);
        for(int i = 0; i<gray.length()-1; i++){
            binary += xor(gray.charAt(i+1),binary.charAt(i)) ;
        }
        return Integer.parseInt(binary, 2);
    }

    static char xor(char a, char b){
        return (a=='0' && b=='1') || (a=='1' && b=='0') ? '1':'0';
    }

//    static int greyPosition(String s, int ones){
//        if(s.length() == 1 && ones % 2 == 0){
////            print("ONE\n");
//            return (s.equals("0") ? 0 : 1);
//        }else if(s.length()==1 && ones % 2 == 1){
////            print("TWO\n");
//            return (s.equals("0") ? 1 : 0);
//        }
//
//        if(ones % 2 == 0){
////            print("THREE\n");
//            return s.charAt(0) == '0' ? greyPosition(s.substring(1), ones) : (greyPosition(s.substring(1), ones + 1) + (int)Math.pow(2, s.length()-1));
//        }else{
////            print("FOUR\n");
//            return s.charAt(0) == '1' ? greyPosition(s.substring(1), ones + 1) : (greyPosition(s.substring(1), ones) + (int)Math.pow(2, s.length()-1));
//        }
//    }
//
//    public static void yarg(String prefix, int n) {
//        if (n == 0) {
//            print(prefix + ":" + count++  +"\n" );
//        }
//        else {
//            gray(prefix + "1", n - 1);
//            yarg(prefix + "0", n - 1);
//        }
//    }
//
//    // append order n gray code to end of prefix string, and print
//    public static void gray(String prefix, int n) {
//        if (n == 0) {
//            print(prefix + ":" + count++ + "\n");
//        }
//        else {
//            gray(prefix + "0", n - 1);
//            yarg(prefix + "1", n - 1);
//        }
//    }
}
