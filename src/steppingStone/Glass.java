package steppingStone;

public class Glass extends Element{

    private boolean broken;

    public Glass(){}

    public void breakGlass() {
        this.broken = true;
    }

    @Override
    public String toString() {
        if (this.broken ==true){
            return "x";
        }
        return " ";
    }
}