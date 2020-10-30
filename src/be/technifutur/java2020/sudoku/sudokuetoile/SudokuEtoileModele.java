package be.technifutur.java2020.sudoku.sudokuetoile;

import be.technifutur.java2020.sudoku.common.AbstractSudokuModele;
import be.technifutur.java2020.sudoku.common.Cell;
import be.technifutur.java2020.sudoku.common.Position;

import java.util.Map;

public class SudokuEtoileModele extends AbstractSudokuModele {

    /*protected SudokuEtoileModele(){
        super(21,21);
    }*/

    public boolean isValid(char value){                                 //Vérifie si la valeur entrée est valide
        boolean valid = false;

        if(Character.isDigit(value)) {
            int val = Character.getNumericValue(value);
            valid = val >= 1 && val <= 9;
        }
        return valid;
    }

    @Override
    public int getNbCase() {
        return 0;
    }

    @Override
    public Map<Position, Cell> getGrille() {
        return null;
    }

    public boolean isPositionValid (int l, int c){                      //Vérifie si la position entrée est valide
        return l>=0 && l<21 && c>=0 && c<21;
    }

}