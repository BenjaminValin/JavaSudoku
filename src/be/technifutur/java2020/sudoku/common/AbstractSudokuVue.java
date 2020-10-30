package be.technifutur.java2020.sudoku.common;

public abstract class AbstractSudokuVue {

    private String name;
    private String grille;
    private String grilleVide;
    private int length;
    private AbstractSudokuModele modele;


    protected AbstractSudokuVue(String n, String c, String g, int l) {
        name = new String(n);
        grille = new String(c);
        grilleVide = new String(g);
        length = l;
    }

    public String getName() {
        return this.name;
    }

    public void setModele(AbstractSudokuModele exemple){
        this.modele = exemple;
    }

    public AbstractSudokuModele getModele(){
        return this.modele;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void afficheGrilleVide(){
        System.out.printf(grilleVide);
    }

    public void afficheGrille(AbstractSudokuModele exemple) {
        Character[] conversion = new Character[length * length];
        int cpt = 0;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (exemple.isEmpty(x, y)) {
                    conversion[cpt] = '.';
                } else {
                    conversion[cpt] = exemple.getValue(x, y);
                }
                cpt++;
            }
        }
        System.out.printf(grille.replace(".", "%s"), conversion);
    }

}
