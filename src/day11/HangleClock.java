package day11;

import java.time.LocalTime;
import java.util.Arrays;

public class HangleClock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    String[][] arrHour;
    String[][] arrTensMin;
    String[][] arrUnitsMin;
    int rowIndexHour;

    public HangleClock() {
        arrHour = new String[][]{
                {"한","두","세","네","다","섯"},
                {"여","섯","일","곱","여","덟"},
                {"아","홉","열","한","두","시"}
        };
        arrTensMin = new String[][]{
                {"자","이","삼","사","오","십"},
        };
        arrUnitsMin = new String[][]{
                {"정","일","이","삼","사","오"},
                {"오","육","칠","팔","구","분"}
        };
    }

    public void start() {
        LocalTime localTime = LocalTime.now();
        TimeIntoKorean timeKor = new TimeIntoKorean(localTime);
        String hour =timeKor.hour();
        String tensMin = timeKor.tensMin();
        String unitsMin = timeKor.unitsMin();

        setRowIndex(timeKor);
        changeArrHour(hour);
        if(timeKor.isOverTenMinute()){
            changeArrMin(tensMin,arrTensMin);
        }
        changeArrMin(unitsMin,arrUnitsMin);

        System.out.println(Arrays.deepToString(arrHour));
        System.out.println(Arrays.deepToString(arrTensMin));
        System.out.println(Arrays.deepToString(arrUnitsMin));
    }

    private void changeArrMin(String min,String[][] arrMin) {
        for(int c =0 ; c<min.length();c++){
            String s = min.charAt(c)+"";
            for(int i =0;i<arrMin.length;i++){
                for(int j =0;j<arrMin[i].length;j++){
                    arrMin[i][j] = highlight(s,arrMin[i][j]);
                }
            }
        }
    }

    private void changeArrHour(String hour) {
        for(int c =0 ; c<hour.length();c++){
            String s = hour.charAt(c)+"";
            for(int i =rowIndexHour;i<arrHour.length;i++){
                for(int j =0;j<arrHour[i].length;j++){
                    arrHour[i][j] = highlight(s,arrHour[i][j]);
                }
            }
        }
    }

    private void setRowIndex(TimeIntoKorean timeKor) {
        if(timeKor.isOverTenHour()){
            this.rowIndexHour =2;
        }
    }

    public String highlight(String s, String content){
            if(s.equals(content)){
                return ANSI_RED+content+ANSI_RESET;
            }
        return content;
    }
}
