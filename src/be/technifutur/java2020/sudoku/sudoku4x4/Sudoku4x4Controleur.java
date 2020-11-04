package be.technifutur.java2020.sudoku.sudoku4x4;

import be.technifutur.java2020.sudoku.common.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        while(!ctrl.valeur.equalsIgnoreCase("q") && Cell.casesRemplies < modele.getNbCase()){
            ctrl.start();
        }
        if (Cell.casesRemplies == modele.getNbCase()){
            System.out.println("Victoire!");
        } else {
            System.out.println("Au revoir");
        }
    }

    private Sudoku4x4Modele modele;
    private Sudoku4x4Vue vue;
    Scanner scan = new Scanner(System.in);
    public String valeur;
    private char num, p1, p2, ltest, ctest;
    private int lig, col;

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
        System.out.println(Cell.casesRemplies + " cases déjà remplies");
    }

    /*public void start(){
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
                System.out.println(Cell.casesRemplies + " cases remplies");
            }
        }
    }*/

    public void start(){
        System.out.println("Donne-moi le chiffre à entrer dans le sudoku, le chiffre correspondant à la ligne, et le chiffre correspondant à la colonne :");
        System.out.println("(Vous devez placer un point entre chaque valeur)");
        System.out.println("Pour quitter , entrez uniquement q/Q");
        this.valeur = scan.nextLine();
        if (!this.valeur.equalsIgnoreCase("q")) {
            Pattern p = Pattern.compile("([1-4])\\.([1-4])\\.([1-4])");                         //Expression régulière obligeant trois nombres entre 1 et 4 séparés par deux points
            Matcher m = p.matcher(this.valeur);                                                 //Chaîne de caractères à comparer avec l'expression régulière
            boolean ok = m.matches();                                                           //OK est true si la chaine de caractères respecte l'expression régulière
            if(ok){
                int line = Integer.parseUnsignedInt(m.group(2));
                int column = Integer.parseUnsignedInt(m.group(3));
                char val = m.group(1).charAt(0);
                modele.setValue(val,line,column);
                vue.afficheGrille(modele);
                System.out.println(Cell.casesRemplies + " cases remplies");
            } else {
                System.out.println("Erreur. Merci de rentrer des données valides");
            }
        }
    }
}
