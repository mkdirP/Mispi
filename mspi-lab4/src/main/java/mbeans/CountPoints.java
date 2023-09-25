package mbeans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import webBack.Entry;
import webBack.EntryDao;
import webBack.MainBean;

@Data
@SessionScoped
@ManagedBean(name = "lab4")
public class CountPoints extends NotificationBroadcasterSupport implements CountPointsMBean {

    private List<Entry> all_entries = new ArrayList<Entry>();
    private ArrayList<Entry> fifteen_entries = new ArrayList<Entry>();
    private ArrayList<Entry> not_in_range = new ArrayList<Entry>();
    private EntryDao entryDao;
    private MainBean mainBean;
    private Entry entry;
    private int nums_total = all_entries.size();
    private int nums_not_hit = not_in_range.size();
    public boolean repeated = false;
    private int sequenceNumber = 0;
    private static final CountPoints countPoints = new CountPoints();
    public static CountPoints getInstance() {
        return countPoints;
    }

    public void countPoints() {
        setRepeated(true);
        if(all_entries.size() % 15 != 0){
            setRepeated(false);
            return;
        }
        if(this.repeated){
            countPoints.sendMessage();
        }
        countPoints.setRepeated(repeated);
    }

    public void sendMessage(){
        sendNotification(new Notification("Repeat", this, sequenceNumber++,
                System.currentTimeMillis(), "Points are multiples of 15"));
    }
    public boolean isRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }


    public void addDot(){
        all_entries = mainBean.getEntries();
        for (Entry entry1 : all_entries){
            if(!entry.isResult()){
                not_in_range.add(entry);
            }
            if(all_entries.size()% 15 == 0){
                fifteen_entries.remove(0);
                fifteen_entries.add(entry);
            }else {
                fifteen_entries.add(entry);
            }
            countPoints();
            nums_total = all_entries.size();
            nums_not_hit = not_in_range.size();
        }

    }
}