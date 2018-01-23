package bookingSystem;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<BookedInfo> bookingList = new ArrayList<>();

    public List<BookedInfo> showBookedList() {
        return bookingList;
    }

    public void reserve(String name, int begin, int end) {
        if (bookingList.isEmpty()){
            BookedInfo info = new BookedInfo(name, begin, end);
            bookingList.add(info);
            info.reservationInfo();
        }
        else if (check(begin, end)){
            BookedInfo info = new BookedInfo(name, begin, end);
            bookingList.add(info);
            info.reservationInfo();
        }
        else throw new IllegalArgumentException();
    }

    public boolean check(int begin, int end){
        for (int i = 0; i < bookingList.size(); i++){
            BookedInfo info = bookingList.get(i);
            if ((begin < info.getBegin() && end < info.getBegin())
                    || (begin > info.getEnd() && end > info.getEnd()))
                return true;
        } return false;
    }
}
