import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams_API {

    public static void main(String[] args){

        int[] nums = {23, 39, 84, 33, 128, 4, 34, 93, 101, 53};
        List<Integer> list = Arrays.stream(nums).sorted().map(x -> (int)Math.pow(-1, x)*x).sorted().map(x -> (int)Math.pow(-1, x)*x).boxed().collect(Collectors.toList());

        System.out.println(list);

    }


}
