import java.util.ArrayList;
import java.util.List;

public class Calendar {
    int[] calendar;
    Calendar() {
        calendar = new int[20];
    }

    public void getAvailableDays() {
        int start = 0;
        for(int i = 0 ; i < 20 ; i++) {
            if(calendar[i] == 1) {
                if(start != i) {
                    System.out.println("Available from day: " + (start + 1) + " to end day: " + (i));
                }
                start = i + 1;
            }
        }
        if(start != 20) {
            System.out.println("from day: " + (start + 1) + " to end day: " + 20);
        }
    }

    public void displayDates() {
        for(int i = 0 ; i < 20 ; i++) {
            System.out.println(i + 1 + " " + calendar[i]);
        }
    }

    public boolean isAvailable(int start, int end) {
        if(start < 0 || end > 20) {
            System.out.println("Date range not supported");
            return false;
        }
        for(int i = start - 1 ; i <= end - 1 ; i++) {
            if(calendar[i] != 0){
                System.out.println("Car is not available from day: " + start + " to end day: " + end);
                return false;
            }
        }
        System.out.println("Car is available from day: " + start + " to end day: " + end);
        return true;
    }

    public boolean blockTheCalendar(int start, int end) {
        if(start < 0 || end > 20) {
            System.out.println("Date range not supported");
            return false;
        }
        for(int i = start - 1 ; i <= end - 1 ; i++) {
            if(calendar[i] != 0){
                System.out.println("Cant book. Dates range overlapping with booked date");
                return false;
            }
        }
        for(int i = start - 1 ; i <= end - 1 ; i++) {
            calendar[i] = 1;
        }
        System.out.println("Booked from day: " + start + " to end day: " + end);
        return true;

    }

    public boolean unblockTheCalendar(int start, int end) {
        if(start < 0 || end > 20) {
            System.out.println("Date range not supported");
            return false;
        }

        for(int i = start - 1 ; i <= end - 1 ; i++) {
            calendar[i] = 0;
        }
        System.out.println("Unbooked from day: " + start + " to end day: " + end);
        return true;

    }
}
