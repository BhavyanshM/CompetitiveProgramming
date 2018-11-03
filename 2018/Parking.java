import java.util.Scanner;

public class Parking {

    static void print(String arg){
        System.out.println(arg);
    }

    static int n, t = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            n = scan.nextInt();
            int[] pos = new int[n];
            int min = 100;
            int max = -1;
            for(int j = 0; j<n; j++){
                int temp = scan.nextInt();
                if(temp<min) min = temp;
                if(temp>max) max = temp;
            }
            print((max - min)*2 + "");
        }
    }
}
