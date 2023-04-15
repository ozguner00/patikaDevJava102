package ThreadlerinYarisi;

import java.util.ArrayList;

public class Threads implements Runnable {
    private ArrayList<Integer> arr;
    static private ArrayList<Integer> oddNum = new ArrayList<>();
    static private ArrayList<Integer> evenNum = new ArrayList<>();
    private int sleepTime; //Threadleri sırayla çalıştırabilmek için.
    public Threads(ArrayList<Integer> arr,int sleepTime) {
        this.arr = arr;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.sleepTime);
            //System.out.println("Aktif Thread :" + Thread.currentThread().getName());
            synchronized(arr){//1 Thread oddNum ile çalışmaya başladığı zaman oddNum listesini kullanmaya devam ettiği müddetçe diğer Thread başlayamıyor.
                for(int i = 0; i < this.arr.size(); i++){
                    if(i%2 == 0){
                        evenNum.add(this.arr.get(i));
                    }else {
                        oddNum.add(this.arr.get(i));
                    }
                }
            }
            if(oddNum.size() > 3751){ //Son thread durduğu zaman diziyi yazdırmak için eklendi.
                System.out.println(getEvenNum());
                System.out.println(getOddNum());
            }
        }catch (Exception e){
            System.out.println("Error Message :"  + e.getMessage());
        }

    }

    public ArrayList<Integer> getOddNum() {
        return oddNum;
    }

    public ArrayList<Integer> getEvenNum() {
        return evenNum;
    }

}
