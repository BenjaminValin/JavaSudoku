package be.technifutur.java2020.sudoku.sudokuetoile;

import be.technifutur.java2020.sudoku.Sudoku;

public class SudokuEtoileVue implements Sudoku {

    private String name = ("Grille en étoile");

    public String canevas = "" +
            "+-------+-------+-------+       +-------+-------+-------+\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+       +-------+-------+-------+\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+-------+-------+-------+-------+\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+-------+-------+-------+-------+\n"+
            "                | . . . | . . . | . . . |\n"+
            "                | . . . | . . . | . . . |\n"+
            "                | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+-------+-------+-------+-------+\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . | . . . | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+-------+-------+-------+-------+\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+       +-------+-------+-------+\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "| . . . | . . . | . . . |       | . . . | . . . | . . . |\n"+
            "+-------+-------+-------+       +-------+-------+-------+\n";

    public String getName() {
        return this.name;
    }

    @Override
    public void afficheGrilleVide(){
        System.out.println("Grille Etoile vide");

        System.out.println("+-------+-------+-------+       +-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+       +-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("                | . . . | . . . | . . . |");
        System.out.println("                | . . . | . . . | . . . |");
        System.out.println("                | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . | . . . | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+       +-------+-------+-------+");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("| . . . | . . . | . . . |       | . . . | . . . | . . . |");
        System.out.println("+-------+-------+-------+       +-------+-------+-------+");
    }

    public void afficheGrille(SudokuEtoileModele exemple){

        Character [] conversion = new Character[(21*21)];
        int cpt=0;
        Boolean valid;
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {
                valid = isValid(x,y);
                if (valid) {
                    if (exemple.getValue(x, y) == 0) {
                        conversion[cpt] = '.';
                    } else {
                        conversion[cpt] = exemple.getValue(x, y);
                    }
                }
                cpt++;
            }
        }

        System.out.printf(canevas.replace(".","%s"),conversion);
    }

    public boolean isValid(int l, int c){
        boolean valid = true;
        if ((((l>=0 && l<6) || (l>=15 && l<21)) && (c>=8 && c<12)) || (((c>=0 && c<6) || (c>=15 && c<21)) && (l>=8 && l<12))){
            valid = false;
        }
        return valid;
    }
}


