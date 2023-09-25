public class IntervalCounter implements IntervalCounterMBean {
     long lastClick = 0;
     int totalClicks = 0;
     long clickIntervalsSum = 0;

     private static final IntervalCounter instance = new IntervalCounter();

     public static IntervalCounter getInstance() {
         return instance;
     }


    public void updateInterval() {
        System.out.println("Updating interval");
        if (totalClicks == 0) {
            lastClick = System.currentTimeMillis();
        }
        totalClicks++;
        clickIntervalsSum += System.currentTimeMillis() - lastClick;
        lastClick = System.currentTimeMillis();
    }


    public float getMeanInterval() {
        return clickIntervalsSum / (float) totalClicks / 1000;
    }
}
