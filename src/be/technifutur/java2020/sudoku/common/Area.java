package be.technifutur.java2020.sudoku.common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


public class Area {

    private Possibilities possibility;
    private AreaType type;
    private Set<Position> positionSet;

    public Area(int size, AreaType type, Position first){
        this.possibility = new Possibilities(size);                                     //Crée un ensemble de possibilités de la taille de la zone
        this.type = type;
        this.positionSet = new LinkedHashSet<>();                                       //Stocke l'adresse d'un ensemble de positions pour la zone

        switch(type){                                                                   //Initialise la zone selon le paramètre passé
            case LINE:
                initLine(size, first);
                break;
            case COLUMN:
                initColumn(size, first);
                break;
            case SQUARE:
                initSquare(size, first);
                break;
        }
    }

    private void initLine(int size, Position first) {
        for(int i = 0; i < size; i++){
            Position positionNew = new Position(first.getLine(), first.getColumn()+i);
            positionSet.add(positionNew);
        }
    }

    private void initColumn(int size, Position first) {
        for(int i = 0; i < size; i++){
            positionSet.add(new Position(first.getLine()+i, first.getColumn()));
        }
    }

    private void initSquare(int size, Position first) {
        int sqrtSize = (int)Math.sqrt(size);
        for(int i = 0; i < sqrtSize; i++){
            for(int j = 0; j < sqrtSize; j++){
                Position positionNew = new Position(first.getLine()+i, first.getColumn()+j);
                positionSet.add(positionNew);
            }
        }
    }

    public AreaType getType() {
        return type;
    }

    public Set<Position> getPositionSet(){
        return Collections.unmodifiableSet(positionSet);
    }

// Méthodes déléguées (code -> Generate... -> Delegate Methods...) :
    public boolean add(int i) {
        return possibility.add(i);
    }

    public boolean remove(int i) {
        return possibility.remove(i);
    }

    public boolean contains(int i) {
        return possibility.contains(i);
    }

    public int size() {
        return possibility.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(possibility, area.possibility) &&
                type == area.type &&
                Objects.equals(positionSet, area.positionSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possibility, type, positionSet);
    }

    @Override
    public String toString() {
        return "Area{" +
                "possibility=" + possibility +
                ", type=" + type +
                ", positionSet=" + positionSet +
                '}';
    }

    /*   public static void main(String[] args) {
        Area area = new Area(9, AreaType.LINE, new Position(5,0));
        System.out.println(area.positionSet.size());
        for (Position p : area.getPositionSet()){
            System.out.println(p.toString());
        }

        Area area2 = new Area(9, AreaType.COLUMN, new Position(0,6));
        System.out.println(area2.positionSet.size());
        for (Position p : area2.getPositionSet()){
            System.out.println(p.toString());
        }

        Area area3 = new Area(9, AreaType.SQUARE, new Position(3,3));
        System.out.println(area3.positionSet.size());
        for (Position p : area3.getPositionSet()){
            System.out.println(p.toString());
        }
    }*/
}
