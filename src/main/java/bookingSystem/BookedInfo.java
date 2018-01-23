package bookingSystem;

public class BookedInfo {
    private int begin;
    private int end;
    private String name;

    public BookedInfo(String name, int begin, int end){
        if (begin > 0 && begin <= 24 && end > begin && end <= 24){
            this.name = name;
            this.begin = begin;
            this.end = end;
        } else throw new IllegalArgumentException();
    }

    public void reservationInfo(){
        System.out.println("Booked by " + name + " for " + begin + " to " + end + " hours.");
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
