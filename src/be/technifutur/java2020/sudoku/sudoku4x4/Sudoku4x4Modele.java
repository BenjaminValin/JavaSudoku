package be.technifutur.java2020.sudoku.sudoku4x4;

import be.technifutur.java2020.sudoku.common.AbstractSudokuModele;

public class Sudoku4x4Modele extends AbstractSudokuModele {

    protected Sudoku4x4Modele(){
        super(4,4);
    }

    public boolean isValid(char value){                                 //Vérifie si la valeur entrée est valide
        boolean valid = false;

        if(Character.isDigit(value)) {
            int val = Character.getNumericValue(value);
            valid = val >= 1 && val <= 4;
        }
        return valid;
    }

    public boolean isPositionValid (int l, int c){                      //Vérifie si la position entrée est valide
        return l>=0 && l<4 && c>=0 && c<4;
    }

}
