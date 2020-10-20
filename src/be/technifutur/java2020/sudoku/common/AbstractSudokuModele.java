package be.technifutur.java2020.sudoku.common;

public abstract class AbstractSudokuModele {

    public static final char EMPTY = 0;                                 //Valeur 0 par défaut
    private char[][] grille;                                            //Grille

    protected AbstractSudokuModele(int nbLigne, int nbCol){             //Constructeur initialisant une grille, il s'adapte selon ce que le descendant lui donne
        grille = new char[nbLigne][nbCol];
    }

    public void setValue (char value, int l, int c) {                   //Vérifie si la valeur est correcte, puis la place
        if (this.isValid(value) && this.isPositionValid(l, c)) {
            grille[l][c] = value;
        }
    }

    public char getValue(int l, int c){                                 //Retourne la valeur à une position si celle-ci est correcte
        char val = 0;
        if(this.isPositionValid(l,c)) {
            val = grille[l][c];
        }
        return val;
    }

    public abstract boolean isValid(char value);

    public abstract boolean isPositionValid (int l, int c);

    public boolean isEmpty (int l, int c){                              //Vérifie si la position entrée est vide
        boolean empty = true;
        if(this.isPositionValid(l,c)) {
            empty = grille[l][c] == EMPTY;
        }
        return empty;
    }

    public void removeValue(int l, int c){                              //Permet de retirer une valeur
        if(this.isPositionValid(l,c)) {
           grille[l][c] = EMPTY;
        }
    }
}
