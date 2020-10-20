package be.technifutur.java2020.sudoku.sudoku4x4;

import java.util.Scanner;

public class Sudoku4x4Controleur {

    public static void main(String[] args) {
        Sudoku4x4Controleur ctrl = new Sudoku4x4Controleur();
        Sudoku4x4Vue vue = new Sudoku4x4Vue();
        Sudoku4x4Modele modele = new Sudoku4x4Modele();

        ctrl.start();
        while(!ctrl.valeur.equalsIgnoreCase("q") ){
            modele.setValue(ctrl.num,ctrl.lig,ctrl.col);
            vue.afficheGrille(modele);
            ctrl.start();
        }
    }

    private Sudoku4x4Modele modele;
    private Sudoku4x4Vue vue;
    Scanner scan = new Scanner(System.in);
    String valeur;
    char num, p1, p2, ltest, ctest;
    int lig, col;

    public void setVue(Sudoku4x4Vue exemple){
        this.vue = exemple;
    }
    public void setModele(Sudoku4x4Modele exemple){
        this.modele = exemple;
    }

    public void start(){
        System.out.println("Donne-moi le chiffre à entrer dans le sudoku, le chiffre correspondant à la ligne, et le chiffre correspondant à la colonne :");
        System.out.println("(Vous devez placer un point entre chaque valeur)");
        System.out.println("Pour quitter , entrez uniquement q/Q");
        this.valeur = scan.nextLine();
        this.verify();
    }

    public void verify() {
        if (!this.valeur.equalsIgnoreCase("q")) {
            this.num = valeur.charAt(0);
            this.p1 = valeur.charAt(1);
            this.ltest = valeur.charAt(2);
            this.p2 = valeur.charAt(3);
            this.ctest = valeur.charAt(4);
            if (valeur.length() != 5 || !Character.isDigit(this.num) || !(this.p1 == '.') || !Character.isDigit(this.ltest) || !(this.p2 == '.') || !Character.isDigit(this.ctest)) {
                System.out.println("Erreur. Merci de rentrer des données valides");
                this.start();
            } else {
                this.lig = Character.getNumericValue(valeur.charAt(2)) -1;         //permet de convertir un chiffre de type char en chiffre de type int
                this.col = Character.getNumericValue(valeur.charAt(4)) -1;
            }
        }
    }
}
