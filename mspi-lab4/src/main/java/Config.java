import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.management.ManagementFactory;

@WebListener
public class Config implements ServletContextListener {
    public static final String ENTRY_COUNTER_NAME = "se.ifmo.lab4:name=EntryCounterMBean";
    public static final String INTERVAL_COUNTER_NAME = "se.ifmo.lab4:name=IntervalCounterMBean";



    public void contextInitialized(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName counterName = new ObjectName(ENTRY_COUNTER_NAME);
            mBeanServer.registerMBean(EntryCounter.getInstance(), counterName);
            ObjectName intervalCounterName = new ObjectName(INTERVAL_COUNTER_NAME);
            mBeanServer.registerMBean(IntervalCounter.getInstance(), intervalCounterName);
        } catch (Exception e) {
            System.out.println("Error creating MBeans: " + e);
        }
    }


    public void contextDestroyed(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName counterName = new ObjectName(ENTRY_COUNTER_NAME);
            ObjectName intervalCounterName = new ObjectName(INTERVAL_COUNTER_NAME);
            mBeanServer.unregisterMBean(counterName);
            mBeanServer.unregisterMBean(intervalCounterName);
        } catch(Exception e) {
            System.out.println("Error unregistering MBeans: " + e);
        }
    }
}
