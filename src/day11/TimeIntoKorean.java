package day11;

import java.time.LocalTime;

public class TimeIntoKorean {
    static String[] koreanHour = new String[]{"열","한", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉"};
    static String[] koreanMin = new String[]{"십","일","이","삼","사","오","육","칠","팔","구"};

    private int hour;
    private int min;

    private boolean noon;
    private boolean midNigth;
    private boolean overTenHour;
    private boolean overTenMinute;

    public TimeIntoKorean(LocalTime time) {
        this.hour = time.getHour();
        this.min = time.getMinute();
    }

    public boolean isOverTenHour() {
        return overTenHour;
    }

    public boolean isOverTenMinute() {
        return overTenMinute;
    }

    public boolean isNoonOrMidNigth() {
        if(this.hour==12&&this.min==0){
            this.noon = true;
            return true;
        }
        if(this.hour==0&&this.min==0){
            this.midNigth = false;
            return true;
        }
        return false;
    }

    public String hour(){
        String stringHour = "";

        if((this.hour/10)>=1){
            stringHour += koreanHour[0];
            this.overTenHour = true;
        }
        if((hour%10)!=0){
            stringHour += koreanHour[this.hour%10];
        }
        stringHour +="시";
        return stringHour;
    }

    public String tensMin(){
        String StringMin = "";
        if((this.min/10)!=0){
            StringMin +=koreanMin[this.min/10];
            StringMin +=koreanMin[0];
            this.overTenMinute = true;
        }
        return StringMin;
    }

    public String unitsMin(){
        String StringMin = "";
        if((this.min%10)!=0){
            StringMin += koreanMin[this.min%10];
        }
        StringMin +="분";
        return StringMin;
    }
}
