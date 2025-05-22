package desafio.itau.springboot.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    private long count;
    private BigDecimal sum;
    private BigDecimal min;
    private BigDecimal max;
    private double avg;

    public StatisticsResponse(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = format(statistics.getSum());
        this.min = format(statistics.getMin());
        this.max = format(statistics.getMax());
        this.avg = statistics.getAverage();
    }

    public double getCount() {
        return count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }

    private BigDecimal format(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
