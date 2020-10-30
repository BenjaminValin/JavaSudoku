package be.technifutur.java2020.sudoku.sudoku4x4;

import be.technifutur.java2020.sudoku.Sudoku;
import be.technifutur.java2020.sudoku.common.AbstractSudokuVue;

public class Sudoku4x4Vue extends AbstractSudokuVue implements Sudoku {

    public Sudoku4x4Vue(){
        super("Grille 4x4","" +
                "+-----+-----+\n"+
                "| . . | . . |\n"+
                "| . . | . . |\n"+
                "+-----+-----+\n"+
                "| . . | . . |\n"+
                "| . . | . . |\n"+
                "+-----+-----+\n",
                "" +
                        "+-----+-----+"+
                        "| . . | . . |"+
                        "| . . | . . |"+
                        "+-----+-----+"+
                        "| . . | . . |"+
                        "| . . | . . |"+
                        "+-----+-----+", 4);
    }

    private Sudoku4x4Modele modele;

    public String canevas = "" +
            "+-----+-----+\n"+
            "| . . | . . |\n"+
            "| . . | . . |\n"+
            "+-----+-----+\n"+
            "| . . | . . |\n"+
            "| . . | . . |\n"+
            "+-----+-----+\n";

    @Override
    public void afficheGrilleVide() {
        System.out.println("+-----+-----+");
        System.out.println("| . . | . . |");
        System.out.println("| . . | . . |");
        System.out.println("+-----+-----+");
        System.out.println("| . . | . . |");
        System.out.println("| . . | . . |");
        System.out.println("+-----+-----+");
    }

    public void afficheGrille(Sudoku4x4Modele exemple) {
        Character [] conversion = new Character[4*4];
        int cpt=0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (exemple.isEmpty(x, y)) {
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
