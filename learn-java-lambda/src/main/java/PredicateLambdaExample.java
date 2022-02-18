import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambdaExample {
    public static void main(String[] args) {
        List<ValueVo> list = Arrays.asList(
                new ValueVo(new BigDecimal(10)),
                new ValueVo(new BigDecimal(1)),
                new ValueVo(new BigDecimal(4)),
                new ValueVo(new BigDecimal(13)),
                new ValueVo(new BigDecimal(44)),
                new ValueVo(new BigDecimal(22)),
                new ValueVo(new BigDecimal(54)),
                new ValueVo(new BigDecimal(7))
        );

        Predicate<BigDecimal> b = (i) -> i.intValue() > 19;

        System.out.println(b.test(new BigDecimal(18)));
        System.out.println(b.test(new BigDecimal(20)));
    }
}
