package be.technifutur.java2020.sudoku.sudoku9x9;

import be.technifutur.java2020.sudoku.common.AbstractSudokuModele;

public class Sudoku9x9Modele extends AbstractSudokuModele {

    protected Sudoku9x9Modele(){
        super(9,9);
    }

    public boolean isValid(char value){                                 //Vérifie si la valeur entrée est valide
        boolean valid = false;

        if(Character.isDigit(value)) {
            int val = Character.getNumericValue(value);
            valid = val >= 1 && val <= 9;
        }
        return valid;
    }

    public boolean isPositionValid (int l, int c){                      //Vérifie si la position entrée est valide
        return l>=0 && l<9 && c>=0 && c<9;
    }
}
