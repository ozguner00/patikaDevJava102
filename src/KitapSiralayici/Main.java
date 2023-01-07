package KitapSiralayici;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>();

        books.add(new Book("Veba Geceleri",544,"Orhan Pamuk",2021));
        books.add(new Book("Var Mısın?",320,"Doğan Cüceloğlu",2021));
        books.add(new Book("Sefiller",1724,"Viktor Hugo",1862));
        books.add(new Book("Türklerin Tarihi",608,"İlber Ortaylı",2015));
        books.add(new Book("Otomatik Portakal",176,"Anthony Burgess",1961));

        for(Book o :books){
            System.out.println(o.getBookName());
        }
        System.out.println("*********************");

        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNumberOfPage()-o2.getNumberOfPage();
            }
        });

        books2.addAll(books);

        for(Book o :books2){
            System.out.println(o.getBookName());
        }

    }
}
