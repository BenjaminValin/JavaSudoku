package be.technifutur.java2020.sudoku.sudoku4x4;

import be.technifutur.java2020.sudoku.common.*;

import java.util.*;

public class Sudoku4x4Modele extends AbstractSudokuModele {

    public boolean isValid(char value){                                 //Vérifie si la valeur entrée est valide
        boolean valid = false;

        if(Character.isDigit(value)) {
            int val = Character.getNumericValue(value);
            valid = val >= 1 && val <= 4;
        }
        return valid;
    }

    /*@Override
    public Map<Position, Cell> getGrille() {
        // Construire le stockage d'Area
        Set<Area> stockArea = new HashSet<>();
        // construire la map
        HashMap<Position, Cell> map = new HashMap<>();
        // construire les Cell
        // construire les Position
        for (int l=0;l<4;l++){
            for (int c=0;c<4;c++){
                Position p = new Position (l,c);
                map.put(p,new Cell(p));
            }
        }
        // construire les Area
        for (int x=0;x<4;x++){
            Position pl = new Position(x,0);
            Area al = new Area (4,AreaType.LINE,pl);
            stockArea.add(al);
            Position pc = new Position(0,x);
            Area ac = new Area (4,AreaType.COLUMN,pc);
            stockArea.add(ac);
        }
        for (int l=0;l<4;l=l+2){
            for (int c=0;c<4;c=c+2){
                Position p = new Position (l,c);
                Area a = new Area (4,AreaType.SQUARE,p);
                stockArea.add(a);
            }
        }
        // Associer le tout
        for (int l=0;l<4;l++){
            for (int c=0;c<4;c++){
                Position p = new Position (l,c);
                for(Area a : stockArea){
                    map.get(p).add(a);
                }
            }
        }
        return map;
    }*/

    @Override
    public Map<Position, Cell> getGrille() {
        // construire la map
        HashMap<Position, Cell> map = new HashMap<>();
        // construire les Area
        //Area[] lineTab = new Area[4];
        ArrayList<Area> lineList = new ArrayList<>();
        Area[] columnTab = new Area[4];
        Area[] squareTab = new Area[4];
        for (int i=0;i<4;i++){
            lineList.add(new Area (4,AreaType.LINE,new Position(i,0)));
            columnTab[i] = new Area (4,AreaType.COLUMN,new Position(0,i));
            squareTab[i] = new Area (4,AreaType.COLUMN,new Position(i/2*2,i%2*2));

        }
        // construire les Cell
        // construire les Position
        //Associer le tout
        for(int l = 0; l < 4; l++){
            for(int c = 0; c < 4; c++){
                Position p = new Position(l, c);
                Cell cell = new Cell(p);
                map.put(p, cell);
                cell.add(lineList.get(l));
                cell.add(columnTab[c]);
                cell.add(squareTab[((l/2)*2)+(c/2)]);
            }
        }
        return map;
    }

    public int getNbCase(){
        return 4*4;
    }

    /*public static void main(String[] args) {
        Sudoku4x4Modele test = new Sudoku4x4Modele();
        Map<Position, Cell> mapTest = new HashMap<>();
        mapTest = test.getGrille();

        for(Map.Entry e : mapTest.entrySet()){
            System.out.println(e);
        }
    }*/

    void testListeDeListe(){
        ArrayList<List<Position>> lists = new ArrayList<>();
    }

}
