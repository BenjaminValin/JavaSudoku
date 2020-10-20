package be.technifutur.java2020.sudoku.common;

public abstract class AbstractSudokuVue {

    private String name;
    private String canevas;
    private String grilleVide;
    private int length;
    private AbstractSudokuModele modele;


    protected AbstractSudokuVue(String n, String c, String g) {
        name = new String(n);
        canevas = new String(c);
        grilleVide = new String(g);
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

    public void setLength(){

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
                if (modele.isEmpty(x, y)) {
                    conversion[cpt] = '.';
                } else {
                    conversion[cpt] = exemple.getValue(x, y);
                }
                cpt++;
            }
        }
        System.out.printf(canevas.replace(".", "%s"), conversion);
    }

}
