import java.math.BigDecimal;

public class ValueVo {
    private BigDecimal value;

    public ValueVo(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
