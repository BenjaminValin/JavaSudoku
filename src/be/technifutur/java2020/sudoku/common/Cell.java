package be.technifutur.java2020.sudoku.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cell {

    //CTRL + clic permet de voir le code source d'une méthode.

    private Position position;
    private Set<Area> areaSet;
    public static final char EMPTY = 0;
    private char value = EMPTY;


    public Cell(Position position){
        this.position = position;
        areaSet = new HashSet<>();
    }

    public Position getPosition() {
        return position;
    }

    public void setValue(char value) throws SudokuException {
        int valOld = Character.getNumericValue(this.value);
        int valNew = Character.getNumericValue(value);
        boolean used = false;
        boolean empty = isEmpty();
        if (valOld == valNew) {
            throw new SudokuException("Oups, c'est la même valeur que tu tentes de rentrer une seconde fois");
        } else {
            Iterator<Area> iterator = areaSet.iterator();
            while (iterator.hasNext() && !used) {
                Area zone = iterator.next();
                if (!(zone.contains(valNew))) {
                    throw new SudokuException("La valeur existe déjà dans la zone " + zone.getType());
                }
            }
            if (!used && empty) {
                for (Area a : areaSet) {
                    a.remove(valNew);
                }
                this.value = value;
            } else {
                if(!used){
                    for(Area a : areaSet){
                        a.add(valOld);
                        a.remove(valNew);
                    }
                    this.value = value;
                }
            }
        }
    }

    public boolean add(Area area) { //Méthode add() de la classe Set, elle vérifie si la position de la cellule est contenue dans la zone
        boolean add = false;
        if(area.getPositionSet().contains(this.position)) { //Méthode contains() de la classe Set
            add = areaSet.add(area);
        }
        return add;
    }

    public void removeValue() {
        int val = Character.getNumericValue(this.value);
            for(Area a : areaSet){
                a.add(val);
            }
            this.value = EMPTY;
    }

    public char getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                ", areaSet=" + areaSet +
                '}';
    }

    /*private Possibilities line;
    private Possibilities column;
    private Possibilities square;
    private boolean modif;
    private char value;

    public void addLine(Possibilities p){

    }

    public void addColumn(Possibilities p){

    }

    public void addSquare(Possibilities p){

    }

    public void remove(Possibilities p){

    }

    public void isValid(){

    }*/

    public boolean isEmpty(){
        boolean empty = false;
        if (this.value == EMPTY){
            empty = true;
        }
        return empty;
    }

}
