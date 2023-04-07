package ThreadlerinYarisi;

import java.util.ArrayList;

public class Threads implements Runnable {
    private ArrayList<Integer> arr;
    static private ArrayList<Integer> oddNum = new ArrayList<>();
    static private ArrayList<Integer> evenNum = new ArrayList<>();

    public Threads(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
         for(int i = 0; i < arr.size(); i++){
             if(i%2 == 0){
                 evenNum.add(arr.get(i));
             }else {
                 oddNum.add(arr.get(i));
             }
         }
    }

    public ArrayList<Integer> getOddNum() {
        return oddNum;
    }

    public ArrayList<Integer> getEvenNum() {
        return evenNum;
    }

}
