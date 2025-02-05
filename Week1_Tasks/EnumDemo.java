enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumDemo {
    public static void main(String[] args) {
        DaysOfWeek day = DaysOfWeek.SATURDAY;

        if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY) {
            System.out.println("Holiday");
        } else {
            System.out.println("Not Holiday");
        }
    }
}