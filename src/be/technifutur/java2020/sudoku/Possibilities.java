package be.technifutur.java2020.sudoku;

import be.technifutur.java2020.sudoku.sudoku4x4.Sudoku4x4Controleur;

public class Possibilities {
    private int data = 0b000000000;

    public boolean add(int i){                                              //Ajoute une possibilité
        boolean ok = false;
        System.out.println("Ajout de " + i);
        if ((this.data & (1<<(i-1))) != 0){
            ok = false;
        } else {
            this.data = this.data | (1<<(i-1));
            ok = true;
        }
        System.out.println(Integer.toBinaryString(this.data));
        return ok;
    }

    public boolean remove(int i){                                           //Retire une possibilité
        boolean ok = true;
        System.out.println("Retrait de " + i);
        if ((this.data & (1<<(i-1))) != 0){
            this.data = (this.data  ^ (1<<(i-1)));
            ok = true;
        } else {
            ok = false;
        }
        System.out.println(Integer.toBinaryString(this.data));
        return ok;
    }

    public boolean contains(int i){                                      //Vérifie si un nombre est possible
        boolean ok = true;
        if (((this.data & (1<<(i-1))) != 0)) {
            ok = true;
        } else {
            ok = false;
        }

        return ok;
    }

    public int size(){                                              //Compte le nombre de possibilités restantes
        int count = 0;
        for(int c = 1; c<=9;c++){
            if (((this.data & (1<<(c-1))) != 0)) {
                count++;
            }
        }
        return (9-count);
    }

    public static void main(String[] args) {

        Possibilities p = new Possibilities();

        int test = 5;
        boolean verif;
        System.out.println(p.add(5));
        System.out.println(p.add(2));
        System.out.println(p.add(6));
        System.out.println(p.add(8));
        System.out.println(p.add(9));
        System.out.println(p.add(1));
        System.out.println(p.remove(1));
        System.out.println(p.remove(5));
        System.out.println(p.remove(8));
        System.out.println(p.remove(2));
        System.out.println(p.contains(6));
        System.out.println(p.contains(2));
        System.out.println("Possibilités restantes : " + p.size());

    }
}
