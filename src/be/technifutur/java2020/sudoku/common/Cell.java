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

    public boolean add(Area area) { //Méthode add() de la classe Set, elle vérifie si la position de la cellule est contenue dans la zone
        boolean add = false;
        if(area.getPositionSet().contains(this.position)) { //Méthode contains() de la classe Set
            add = areaSet.add(area);
        }
        return add;
    }

    public void setValue(char value) {
        int valOld = Character.getNumericValue(this.value);
        int valNew = Character.getNumericValue(value);
        boolean used = false;
        boolean empty = isEmpty();

        Iterator<Area> iterator = areaSet.iterator();
        while (iterator.hasNext() && !used) {
            if (!(iterator.next().contains(valNew))) {
                used = true;
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
