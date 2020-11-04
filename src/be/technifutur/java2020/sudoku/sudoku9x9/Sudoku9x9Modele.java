package be.technifutur.java2020.sudoku.sudoku9x9;

import be.technifutur.java2020.sudoku.common.*;

import java.util.*;

public class Sudoku9x9Modele extends AbstractSudokuModele {

    /*protected Sudoku9x9Modele(){
        super(9,9);
    }*/

    private HashMap<Position, Cell> map;

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
        if (map == null){
            // Construire le stockage d'Area
            Set<Area> stockArea = new HashSet<>();
            // construire la map
            map = new HashMap<>();
            // construire les Cell
            // construire les Position
            for (int l=0;l<9;l++){
                for (int c=0;c<9;c++){
                    Position p = new Position (l,c);
                    map.put(p,new Cell(p));
                }
            }
            Cell.casesRemplies = 0;
            // construire les Area
            for (int x=0;x<9;x++){
                Position pl = new Position(x,0);
                Area al = new Area (9,AreaType.LINE,pl);
                stockArea.add(al);
                Position pc = new Position(0,x);
                Area ac = new Area (9,AreaType.COLUMN,pc);
                stockArea.add(ac);
            }
            for (int l=0;l<9;l=l+3){
                for (int c=0;c<9;c=c+3){
                    Position p = new Position (l,c);
                    Area a = new Area (9,AreaType.SQUARE,p);
                    stockArea.add(a);
                }
            }
            // Associer le tout
            for (int l=0;l<9;l++){
                for (int c=0;c<9;c++){
                    Position p = new Position (l,c);
                    for(Area a : stockArea){
                        map.get(p).add(a);
                    }
                }
            }
        }
        return map;
    }

    public boolean isPositionValid (int l, int c){                      //Vérifie si la position entrée est valide
        return l>=0 && l<9 && c>=0 && c<9;
    }
}
