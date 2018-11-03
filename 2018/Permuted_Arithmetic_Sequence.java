import java.util.Arrays;
import java.util.Scanner;

public class Permuted_Arithmetic_Sequence {

    static void print(String arg){
        System.out.print(arg);
    }

    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            int m = scan.nextInt();
            int[] nums = new int[m];
            int[] sorted_nums = new int[m];
            for(int j = 0; j<m; j++){
                nums[j] = scan.nextInt();
            }

            sorted_nums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted_nums);

//            print(Arrays.toString(nums) + "\n");
//            print(Arrays.toString(sorted_nums) + "\n");
            if(arithmetic(nums)){
                print("arithmetic\n");
            }else if(arithmetic(sorted_nums)){
                print("permuted arithmetic\n");
            }else{
                print("non-arithmetic\n");
            }
        }
    }

    static boolean arithmetic(int[] a){
        boolean good = true;
        int gap = a[1] - a[0];
        for(int i = 1; i<a.length - 1; i++){
            if(gap != a[i+1] - a[i]){
                good = false;
                break;
            }
        }
        return good;
    }
}
