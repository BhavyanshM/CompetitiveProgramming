import java.util.Scanner;

public class Eating_Out {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int sum = scan.nextInt() +scan.nextInt()+scan.nextInt();
//        System.out.println(sum);
        System.out.println(sum <= t * 2 ? "possible":"impossible");
    }

}
