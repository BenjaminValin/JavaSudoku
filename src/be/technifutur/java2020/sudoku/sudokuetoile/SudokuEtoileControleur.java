package be.technifutur.java2020.sudoku.sudokuetoile;

import java.util.Scanner;

public class SudokuEtoileControleur {

    public static void main(String[] args) {
        SudokuEtoileControleur ctrl = new SudokuEtoileControleur();
        SudokuEtoileVue vue = new SudokuEtoileVue();
        SudokuEtoileModele modele = new SudokuEtoileModele();
        ctrl.start();
        while(!ctrl.valeur.equalsIgnoreCase("q") ){
            modele.setValue(ctrl.num,ctrl.lig,ctrl.col);
            vue.afficheGrille(modele);
            ctrl.start();
        }

    }

    private SudokuEtoileVue vue;
    private SudokuEtoileModele modele;
    Scanner scan = new Scanner(System.in);
    String valeur;
    char num, p1, p2, ltesta, ltestb, ctesta, ctestb;
    int lig, col;

    public void setVue(SudokuEtoileVue vue) {
        this.vue = vue;
    }

    public void setModele(SudokuEtoileModele exemple){
        this.modele = exemple;
    }

    public void start(){
        System.out.println("Donne-moi le chiffre à entrer dans le sudoku, les chiffres correspondant à la ligne (exemple : 01, 14), et les chiffres correspondant à la colonne :");
        System.out.println("(Vous devez placer un point entre chaque valeur)");
        System.out.println("Pour quitter , entrez uniquement q/Q");
        this.valeur = scan.nextLine();
        this.verify();
    }

    public void verify() {
        if (!this.valeur.equalsIgnoreCase("q")) {
            if (valeur.length() != 7){
                System.out.println("Erreur. Merci de rentrer des données valides");
                this.start();
            } else {
                this.num = valeur.charAt(0);
                this.p1 = valeur.charAt(1);
                this.ltesta = valeur.charAt(2);
                this.ltestb = valeur.charAt(3);
                this.p2 = valeur.charAt(4);
                this.ctesta = valeur.charAt(5);
                this.ctestb = valeur.charAt(6);
                if (!Character.isDigit(this.num) || !(this.p1 == '.') || !Character.isDigit(this.ltesta) || !Character.isDigit(this.ltestb) || !(this.p2 == '.') || !Character.isDigit(this.ctesta) || !Character.isDigit(this.ctestb)) {
                    System.out.println("Erreur. Merci de rentrer des données valides");
                    this.start();
                } else {
                    this.lig = Character.getNumericValue(valeur.charAt(2)) * 10 + Character.getNumericValue(valeur.charAt(3)) - 1;
                    this.col = Character.getNumericValue(valeur.charAt(5)) * 10 + Character.getNumericValue(valeur.charAt(6)) - 1;
                }
            }
        }
    }
}
