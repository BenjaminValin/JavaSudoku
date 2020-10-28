package be.technifutur.java2020.sudoku.common;

import java.util.Set;

public class Possibilities {

    private int data; //0b111111111;

    public Possibilities(Set<Integer> initialValues){
        for (int val : initialValues) {
            add(val);
        }
    }

    public Possibilities(int max){
        data = (1 << max) -1;
    }

    /*

    Il peut y avoir plusieurs constructeurs pour une même classe

    Autres possibilités :

    public Possibilities(int... initialValues){
        for (int val : initialValues) {                                         //Foreach qui ajoute chaque valeur passée en paramètre
            add(val);
        }
    }

    public Possibilities(int max){
        for (int i=1; i<=max;i++) {
            add(i);
        }
    }
*/



    public boolean add(int i){                                                  //Ajoute une possibilité
        boolean ok = false;
        if (!this.contains(i)){
            this.data = this.data | (1<<(i-1));                                 //this.data | = (1<<(i-1)) fonctionne aussi
            ok = true;
        }
        return ok;
    }

    public boolean remove(int i){                                               //Retire une possibilité
        boolean ok = false;
        if (this.contains(i)){
            this.data = (this.data  ^ (1<<(i-1)));                              //this.data = (this.data & ~(1<<(i-1))) fonctionne aussi
            ok = true;
        }
        return ok;
    }

    public boolean contains(int i){                                             //Vérifie si un nombre est possible
        boolean ok = (this.data & (1 << (i - 1))) != 0;
        return ok;
    }

    public int size(){                                                          //Compte le nombre de possibilités restantes
        return Integer.bitCount(this.data);
    }

    @Override
    public String toString() {
        return "Possibilities{" +
                "data=" + data +
                '}';
    }

    /*
    public static void main(String[] args) {

        Possibilities p = new Possibilities(9);

        System.out.println(p.remove(5));
        System.out.println(p.remove(2));
        System.out.println(p.remove(1));
        System.out.println(p.remove(8));
        System.out.println("Possibilités restantes pour cette case : " + p.size());
        System.out.println("Le chiffre 1 est-il déjà placé? : " + p.contains(1));
        System.out.println(p.add(2));
        System.out.println(p.add(6));
        System.out.println(p.add(8));System.out.println(p.remove(5));
        System.out.println("Possibilités restantes pour cette case : " + p.size());
        System.out.println(p.remove(2));
        System.out.println("Le chiffre 6 est-il déjà placé? : " + p.contains(6));
        System.out.println("Le chiffre 2 est-il déjà placé? : " + p.contains(2));
        System.out.println("Possibilités déjà utilisées pour cette case : " + p.size());

    }*/
}