package FiksturOlusturucu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        System.out.println("'q' veya '0' girene kadar takım eklemeye devam edebilirsiniz.");
        addTeam(teams);
        addBayTeam(teams);
        //arrayPrint(teams);
        ArrayList<String> matchList = match(teams);
        //arrayPrint(matchList);
        //System.out.println("--------------------------");
        printMatch(matchList);

    }

    public static void addTeam(ArrayList array){ // Takım sayısı almak yerine kullanıcıdan bitti komutu alıyoruz.
        Scanner sc = new Scanner(System.in);
        String team;
        while (true){
            team = sc.nextLine();
            if(team.equals("0") || team.equals("q")){
                break;
            }
            array.add(team);
        }
    }

    public static void addBayTeam(ArrayList array){ // Tek ise takımlar 'bay' adında bir takım ekliyoruz.
        if(array.size()%2 == 1){
            array.add("Bay");
        }
    }

    public static void arrayPrint(ArrayList<String> array){
        for(String str : array){
            System.out.println(str);
        }
    }

    public static ArrayList<String> match(ArrayList<String> array){
        ArrayList matchList = new ArrayList<>();
        Collections.shuffle(array); // takımları karıştırıyoruz.
        String str = "";
        String str2 = "";
        int size = array.size();
        for(int away = size/2; away<size; away++){ // 4-5-6-7 takımlar away olarak oynar ligin ilk yarısını.(8 elemanlı bir lig için)
            for(int home = 0; home<size/2; home++){ // 0-1-2-3 takımlar home olarak oynar ligin ilk yarısını.(8 elemanlı bir lig için)
                if(home+away >= size){
                    int ha = (home+away)%(size/2);
                    str += array.get(home) + " vs " + array.get(ha) + "\n";
                    str2 += array.get(ha) + " vs " + array.get(home) + "\n";
                }else {
                    str += array.get(home) + " vs " + array.get(home+ away) + "\n";
                    str2 += array.get(home+ away) + " vs " + array.get(home) + "\n";
                }

            }
            matchList.add(str);
            matchList.add(str2);
            str = "";
            str2= "";
        }

        return matchList;
    }

    //MatchListe ligin birinci yarısı tek sayılar 2. yarısı çift sayılar olarak tutuluyor.
    public static void printMatch(ArrayList<String> array){
        for(int i = 0; i<array.size(); i+=2){
            System.out.println(array.get(i));
        }
        for(int i = 1; i<array.size(); i+=2){
            System.out.println(array.get(i));
        }
    }

}

