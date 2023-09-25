import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class EntryCounter extends NotificationBroadcasterSupport implements EntryCounterMBean {
    private int sequenceNumber = 0;
    private int entryCount = 0;
    private int failEntryCount = 0;
    private static final EntryCounter singleton = new EntryCounter();

    public static EntryCounter getInstance() {
        return singleton;
    }


    public void countEntry(boolean success) {
        entryCount++;
        if (!success) failEntryCount++;
        if (entryCount % 15 == 0) sendNotification(new Notification("multiple_of_15", this, sequenceNumber++, "Number of points reached " + entryCount));
    }


    public int getEntryCount() {
        return entryCount;
    }


    public int getFailEntryCount() {
        return failEntryCount;
    }

    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }

    public void setSuccessEntryCount(int entryCount) {
        this.failEntryCount = entryCount;
    }
}
