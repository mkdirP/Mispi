package mbeans;

public class AverageInterval implements AverageIntervalMBean{

    private long sum;
    private long num;

    public void update(long nextInterval) {
        sum += nextInterval;
        num++;
    }

    public double getAverageInterval() {
        return (sum / (double) num) / 1000;
    }
}
