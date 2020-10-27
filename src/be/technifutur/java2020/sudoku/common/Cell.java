package be.technifutur.java2020.sudoku.common;

import java.util.HashSet;
import java.util.Set;

public class Cell {

    //CTRL + clic permet de voir le code source d'une méthode.

    private Position position;
    private Set<Area> areaSet;

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

    /*private Possibilities line;
    private Possibilities column;
    private Possibilities square;
    private char valeur;
    private boolean modif;

    public void addLine(Possibilities p){

    }

    public void addColumn(Possibilities p){

    }

    public void addSquare(Possibilities p){

    }

    public void remove(Possibilities p){

    }

    public void isValid(){

    }

    public void isEmpty(){

    }

    public void setValue(char c){
        this.valeur = c;
    }

    public char getValue(){
        return this.valeur;
    }*/

}
