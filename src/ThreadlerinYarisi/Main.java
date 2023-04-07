package ThreadlerinYarisi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> parts = new ArrayList<ArrayList<Integer>>();

        for(int i = 1; i <10001; i++ ){
            numbers.add(i);
        }
        for(int i = 0; i < 4; i++){
            ArrayList<Integer> part = new ArrayList<Integer>(numbers.subList(i*2500,(i+1)*2500)) ;
            parts.add(part);
        }

        Threads t1 = new Threads(parts.get(0));
        Threads t2 = new Threads(parts.get(1));
        Threads t3 = new Threads(parts.get(2));
        Threads t4 = new Threads(parts.get(3));
        t1.run();
        t2.run();
        t3.run();
        t4.run();

        System.out.println(t1.getEvenNum());
        System.out.println(t1.getOddNum());














    }
}
