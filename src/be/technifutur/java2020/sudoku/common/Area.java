package be.technifutur.java2020.sudoku.common;

import java.util.HashSet;
import java.util.Set;

public class Area {

    private Possibilities possibility;
    private AreaType type;
    private Set<Position> positionSet = new HashSet<>();

    public Area(int size, AreaType type, Position first){
        possibility = new Possibilities(size);                                  //Crée un ensemble de possibilités de la taille de la zone
        this.type = type;
        this.positionSet = new HashSet<>();                                     //Donne la première position pour la zone

        switch(type){                                                           //Initialise la zone selon le paramètre passé
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
                Position positionNew = new Position(first.getLine()+i, first.getColumn()+i);
                positionSet.add(positionNew);
            }
        }
    }


    public Set<Position> getPositionSet(){
        return positionSet;
    }

    public void addPosition(int x, int y){
        Position position = new Position(x, y);
    }

    public static void main(String[] args) {
        Area area = new Area(9, AreaType.LINE, new Position(5,0));
        System.out.println(area.positionSet.size());

        Area area2 = new Area(9, AreaType.COLUMN, new Position(0,6));
        System.out.println(area.positionSet.size());

        Area area3 = new Area(9, AreaType.SQUARE, new Position(3,3));
        System.out.println(area.positionSet.size());
    }
}
