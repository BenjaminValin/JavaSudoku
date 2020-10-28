package be.technifutur.java2020.sudoku.common;

import java.util.Map;

public abstract class AbstractSudokuModele {

    public static final char EMPTY = 0;                                 //Valeur 0 par défaut
    //private Map<Position,Cell> grille;

    public void setValue (char value, int l, int c) {                   //Vérifie si la valeur est correcte, puis la place
        setValue(value, new Position(l,c));
    }

    public void setValue (char value, Position p) {
        if (this.isValid(value) && this.isPositionValid(p)) {
            Cell cell = getCell(p);
            cell.setValue(value);
        }
    }

    public void removeValue(int l, int c){                              //Retire une valeur erronée
        removeValue(new Position(l,c));
    }

    public void removeValue(Position p){
        if(this.isPositionValid(p)) {
            getCell(p).removeValue();
        }
    }

    public char getValue(int l, int c){                                 //Retourne la valeur à une position si celle-ci est correcte
        getValue(new Position(l,c));
    }

    public char getValue(Position p){
        char val = 0;
        if(this.isPositionValid(p)) {
            val = getCell(p).getValue();
        }
        return val;
    }

    public abstract boolean isValid(char value);

    public abstract Map<Position,Cell> getGrille();

    public boolean isPositionValid (int l, int c){
        return isPositionValid(new Position(l,c));
    }

    public boolean isPositionValid(Position position) {
        return this.getGrille().containsKey(position);
    }

    public boolean isEmpty (int l, int c){                            //Vérifie si la position entrée est vide
        isEmpty(new Position(l,c));
    }

    public boolean isEmpty (Position p){
        boolean empty = true;
        if(this.isPositionValid(p)) {
            Cell cell = getGrille().get(p);
            empty = cell.getValue() == EMPTY;
        }
        return empty;
    }

    private Cell getCell(Position p){                                   //Permet de donner la valeur contenue dans une cellule grâce à sa position
        Cell cell = getGrille().get(p);
        return cell;
    }

}
