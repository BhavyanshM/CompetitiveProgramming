import java.util.Scanner;

public class Friday_13th {

    static void print(String arg){
        System.out.print(arg);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            int mod = 1;
            int count = 0;
            scan.nextInt();
            int M = scan.nextInt();
            for(int j = 0; j<M; j++){
                int days = scan.nextInt();
                if(mod==1 && days >= 13){
                    count++;
                }
                mod += days;
                mod %= 7;
            }
            print(count + "\n");
        }
    }
}
