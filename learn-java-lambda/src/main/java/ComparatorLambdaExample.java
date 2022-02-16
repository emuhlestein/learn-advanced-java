import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaExample {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 7, 2, 7, 8, 1, 90);

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);

        list.sort(comparatorLambda);

        System.out.println(list.toString());

        // don't need types for parameters
        Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b);

        list = Arrays.asList(4, 7, 2, 7, 8, 1, 90);

        list.sort(comparatorLambda1);

        System.out.println(list.toString());

    }
}
