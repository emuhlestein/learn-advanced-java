import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JavaLambdaMain {
    public static void main(String[] args) {
        List<ValueVo> list = Arrays.asList(
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(null),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(10))
        );
        int value = list.stream().filter(v -> v.getValue() != null).mapToInt(v -> v.getValue().intValue()).sum();
        System.out.println("Value: " + value);

        BigDecimal sum = list.stream().filter(v -> v.getValue() != null).map(v -> v.getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum: " + sum);

    }
}
