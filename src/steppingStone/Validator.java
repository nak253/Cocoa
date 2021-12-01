package steppingStone;

public class Validator {
    public boolean correctInput(String input) {
        String s = input.toLowerCase();
        if(s.equals("w")||s.equals("s")){
            return true;
        }
        return false;
    }
}