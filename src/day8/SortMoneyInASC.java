package day8;

import java.util.Comparator;

 public class SortMoneyInASC implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof BookDetail && o2 instanceof BookDetail)){
            return -1;
        }
        Integer money1 =((BookDetail) o1).getSum();
        Integer money2 =((BookDetail) o2).getSum();

        return money1.compareTo(money2);
    }
}
