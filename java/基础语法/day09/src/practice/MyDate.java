package practice;
/*
* MyDate类包含
* private: year, month, day
* 每一个成员都有getter和setter方法
* */
public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(){}
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "birthday{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate) {
            MyDate myDate = (MyDate)o;
            int result = this.year - myDate.year;
            if (result == 0) {
                result = this.month - myDate.month;
                if(result == 0) {
                    result = this.day - myDate.day;
                }
            }
            return result;
        }
        throw new ClassCastException("类型不匹配");
    }
}
