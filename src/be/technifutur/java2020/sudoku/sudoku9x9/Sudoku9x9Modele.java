package be.technifutur.java2020.sudoku.sudoku9x9;

import be.technifutur.java2020.sudoku.common.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sudoku9x9Modele extends AbstractSudokuModele {

    /*protected Sudoku9x9Modele(){
        super(9,9);
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
        // construire la map
        HashMap<Position, Cell> map = new HashMap<>();
        // construire les Area
        ArrayList<Area> lineList = new ArrayList<>();
        Area[] columnTab = new Area[9];
        Area[] squareTab = new Area[9];
        for (int i=0;i<9;i++){
            lineList.add(new Area (9, AreaType.LINE,new Position(i,0)));
            columnTab[i] = new Area (9,AreaType.COLUMN,new Position(0,i));
            squareTab[i] = new Area (9,AreaType.COLUMN,new Position(i/3*3,i%3*3));

        }
        // construire les Cell
        // construire les Position
        //Associer le tout
        for(int l = 0; l < 9; l++){
            for(int c = 0; c < 9; c++){
                Position p = new Position(l, c);
                Cell cell = new Cell(p);
                map.put(p, cell);
                cell.add(lineList.get(l));
                cell.add(columnTab[c]);
                cell.add(squareTab[((l/3)*3)+(c/3)]);
            }
        }
        return map;
    }

    public boolean isPositionValid (int l, int c){                      //Vérifie si la position entrée est valide
        return l>=0 && l<9 && c>=0 && c<9;
    }
}
