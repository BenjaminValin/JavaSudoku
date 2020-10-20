package be.technifutur.java2020.sudoku.sudoku9x9;

import be.technifutur.java2020.sudoku.Sudoku;

public class Sudoku9x9Vue implements Sudoku {

    private String name = ("Grille 9X9");

    public String canevas = "" +
            "+-------+-------+-------+\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "+-------+-------+-------+\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "+-------+-------+-------+\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |\n"+
            "+-------+-------+-------+\n";

    private Sudoku9x9Modele modele;

    public String getName() {
        return this.name;
    }

    public void setModele(Sudoku9x9Modele exemple){
        this.modele = exemple;
    }

    @Override
    public void afficheGrilleVide(){
        System.out.println("Grille 9X9 vide");
        System.out.println("+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+");
    }


    public void afficheGrille(Sudoku9x9Modele exemple) {
        Character [] conversion = new Character[9*9];
        int cpt=0;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (modele.isEmpty(x, y)) {
                    conversion[cpt] = '.';
                } else {
                    conversion[cpt] = exemple.getValue(x, y);
                }
                cpt++;
            }
        }
        System.out.printf(canevas.replace(".","%s"),conversion);
    }
}
