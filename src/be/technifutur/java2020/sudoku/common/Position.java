package be.technifutur.java2020.sudoku.common;

public class Position {
    private int line;
    private int column;

    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    //La position est figée, sa valeur ne peut être donnée que dans le constructeur, et jamais modifiée ailleurs
}
