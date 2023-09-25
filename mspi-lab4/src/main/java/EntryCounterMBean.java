public interface EntryCounterMBean {
    void countEntry(boolean success);
    int getEntryCount();
    int getFailEntryCount();
}
