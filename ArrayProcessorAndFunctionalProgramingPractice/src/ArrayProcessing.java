import java.util.Arrays;

public class ArrayProcessing {

    public static final ArrayProcessor MIN = array -> Arrays.stream(array).summaryStatistics().getMin();
    public static final ArrayProcessor MAX = array -> Arrays.stream(array).summaryStatistics().getMax();
    public static final ArrayProcessor AVERAGE = array -> Arrays.stream(array).summaryStatistics().getAverage();
    public static final ArrayProcessor SUM = array -> Arrays.stream(array).summaryStatistics().getSum();

    public static ArrayProcessor counter(double value) {

        return array -> Arrays.stream(array)
                .filter(arrElement -> arrElement == value)
                .count();

    }

}
