package mbeans;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;
/**
 * @author x1761
 */
public class JmxListener implements ServletContextListener {
//    public static final String PB = "JMX:type=mbean,name=";
    public static final String RB = "JMX:type=mbean,name=CountPoints";

    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        try {
            final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName RBName = new ObjectName(RB);
//            ObjectName RBName = new ObjectName(RB);
            mBeanServer.registerMBean(CountPoints.getInstance(), RBName);
//            mBeanServer.registerMBean(AverageInterval.getInstance(), PBName);

            JmxNotificationListener jmxNotificationListener = new JmxNotificationListener();
            mBeanServer.addNotificationListener(RBName, jmxNotificationListener, null, null);
//            mBeanServer.addNotificationListener(RBName, jmxNotificationListener, null, null);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void contextDestroyed(final ServletContextEvent servletContextEvent) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName PBName = new ObjectName(RB);
//            ObjectName RBName = new ObjectName(RB);

            mBeanServer.unregisterMBean(PBName);
//            mBeanServer.unregisterMBean(RBName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
