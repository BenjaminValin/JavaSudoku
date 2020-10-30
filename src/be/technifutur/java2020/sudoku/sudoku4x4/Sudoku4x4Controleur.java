package be.technifutur.java2020.sudoku.sudoku4x4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku4x4Controleur {

    public static void main(String[] args) throws FileNotFoundException {
        Sudoku4x4Controleur ctrl = new Sudoku4x4Controleur();
        Sudoku4x4Vue vue = new Sudoku4x4Vue();
        Sudoku4x4Modele modele = new Sudoku4x4Modele();
        vue.setModele(modele);
        ctrl.setModele(modele);
        ctrl.setVue(vue);
        vue.afficheGrille(modele);
        ctrl.baseData();
        vue.afficheGrille(modele);
        ctrl.start();
        while(!ctrl.valeur.equalsIgnoreCase("q") ){
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

    public Sudoku4x4Vue getVue() {
        return vue;
    }

    public void setModele(Sudoku4x4Modele exemple){
        this.modele = exemple;
    }

    public Sudoku4x4Modele getModele() {
        return modele;
    }

    public void baseData() throws FileNotFoundException {
        File sudoku = new File("sudoku4.txt");
        Scanner scanner = new Scanner(sudoku);
        String stock = "";
        char c = ' ';
        int i = 0;
        while (scanner.hasNextLine()){
            stock = scanner.next();
            for(int j=0; j<stock.length();j++){
                c = stock.charAt(j);
                this.modele.setValue(c,i,j);
                //System.out.println("Caractère " + c +", ligne " + i + ", colonne " + j);
            }
            i++;
        }
    }

    public void start(){
        System.out.println("Donne-moi le chiffre à entrer dans le sudoku, le chiffre correspondant à la ligne, et le chiffre correspondant à la colonne :");
        System.out.println("(Vous devez placer un point entre chaque valeur)");
        System.out.println("Pour quitter , entrez uniquement q/Q");
        this.valeur = scan.nextLine();
        if (!this.valeur.equalsIgnoreCase("q")) {
            this.num = valeur.charAt(0);
            this.p1 = valeur.charAt(1);
            this.ltest = valeur.charAt(2);
            this.p2 = valeur.charAt(3);
            this.ctest = valeur.charAt(4);
            if (valeur.length() != 5 || !Character.isDigit(this.num) || !(this.p1 == '.') || !Character.isDigit(this.ltest) || !(this.p2 == '.') || !Character.isDigit(this.ctest)) {
                System.out.println("Erreur. Merci de rentrer des données valides");
            } else {
                this.lig = Character.getNumericValue(valeur.charAt(2));         //permet de convertir un chiffre de type char en chiffre de type int
                this.col = Character.getNumericValue(valeur.charAt(4));
                modele.setValue(this.num,this.lig,this.col);
                vue.afficheGrille(modele);
            }
        }
    }
}
