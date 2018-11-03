import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N_Queens {

    static void print(String arg){
        System.out.print(arg);
    }

    static int n = -1;
    static int count = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(n != 0){
            count = 0;
            n = scan.nextInt();
            int[] a = new int[n];
            Arrays.fill(a, -1);
            backtrack(a,-1);
        }
    }

    static void backtrack(int[] a, int k){
//        print("Vector:" + Arrays.toString(a) + "\n");
        if(k==n-1){
            print("END:" + Arrays.toString(a) + ":" + ++count + "\n");
        }else{
            k = k + 1;
            ArrayList<Integer> candidates = construct_candidates(a,k);
            for(Integer opt: candidates){
                a[k] = opt;
                backtrack(a, k);
            }
        }
    }

    static ArrayList<Integer> construct_candidates(int[] a, int k){
        ArrayList<Integer> cands = new ArrayList<>();
        Boolean good = true;
        for(int i = 0; i<n; i++){
            good = true;
            for(int j = 0; j<k; j++){
                if(i == a[j] || (j+a[j])==(k+i) || (j-a[j])==(k-i)){
                    good = false;
                    break;
                }
            }
            if(good)cands.add(i);
        }
        return cands;
    }
}
