public class Holiday {

    private String name;
    private int day;
    private String month;

    //constructors
    public Holiday() {}

    public Holiday(String name, int day, String month) {

        this.name = name;
        this.day = day;
        this.month = month;

    }

    //getters
    public int getDay() {

        return day;

    }

    public String getName() {

        return name;

    }

    public String getMonth() {

        return month;

    }

    //setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean inSameMonth(Holiday firstHoliday, Holiday secondHoliday) {

        if (firstHoliday.getMonth() == secondHoliday.getMonth())
            return true;

        return false;

    }

    public double aveDate(Holiday [] holidays) {
        double ave = 0;

        for(int i = 0; i < holidays.length; i++) {

            ave = ave + holidays[i].day;

        }

        return ave / holidays.length;

    }

}
