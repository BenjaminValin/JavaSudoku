package be.technifutur.java2020.sudoku;

public class Possibilities {

    private int data = 0b000000000;

    public Possibilities(int... initialValues){
        for (int val : initialValues) {                                         //Foreach qui ajoute chaque valeur passée en paramètre
            add(val);
        }
    }

    public boolean add(int i){                                                  //Ajoute une possibilité
        boolean ok = false;
        System.out.println("Ajout de " + i);
        if (!this.contains(i)){
            this.data = this.data | (1<<(i-1));                                 //this.data | = (1<<(i-1)) fonctionne aussi
            ok = true;
        }
        System.out.println(Integer.toBinaryString(this.data));
        return ok;
    }

    public boolean remove(int i){                                               //Retire une possibilité
        boolean ok = false;
        System.out.println("Retrait de " + i);
        if (this.contains(i)){
            this.data = (this.data  ^ (1<<(i-1)));                              //this.data = (this.data & ~(1<<(i-1))) fonctionne aussi
            ok = true;
        }
        System.out.println(Integer.toBinaryString(this.data));
        return ok;
    }

    public boolean contains(int i){                                             //Vérifie si un nombre est possible
        boolean ok = (this.data & (1 << (i - 1))) != 0;
        return ok;
    }

    public int size(){                                                          //Compte le nombre de possibilités restantes
        return Integer.bitCount(this.data);
    }

    public static void main(String[] args) {

        Possibilities p = new Possibilities(1,4,6,7);

        System.out.println(p.add(5));
        System.out.println(p.add(2));
        System.out.println(p.add(6));
        System.out.println(p.add(8));
        System.out.println(p.add(8));
        System.out.println(p.add(9));
        System.out.println(p.add(1));
        System.out.println("Possibilités restantes pour cette case : " + p.size());
        System.out.println("Le chiffre 1 est-il déjà placé? : " + p.contains(1));
        System.out.println(p.remove(1));
        System.out.println(p.remove(5));
        System.out.println("Possibilités restantes pour cette case : " + p.size());
        System.out.println(p.remove(8));
        System.out.println(p.remove(2));
        System.out.println("Le chiffre 6 est-il déjà placé? : " + p.contains(6));
        System.out.println("Le chiffre 2 est-il déjà placé? : " + p.contains(2));
        System.out.println("Possibilités déjà utilisées pour cette case : " + p.size());

    }
}