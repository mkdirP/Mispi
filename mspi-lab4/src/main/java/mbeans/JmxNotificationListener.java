package mbeans;

import javax.management.Notification;
import javax.management.NotificationListener;

public class JmxNotificationListener implements NotificationListener {
    /**
     * Invoked when a JMX notification occurs.
     * The implementation of this method should return as soon as possible, to avoid
     * blocking its notification broadcaster.
     *
     * @param notification The notification.
     * @param handback     An opaque object which helps the listener to associate
     *                     information regarding the MBean emitter. This object is passed to the
     *                     addNotificationListener call and resent, without modification, to the
     */

    public void handleNotification(Notification notification, Object handback) {
        System.out.println(notification.getMessage());
    }
}
