package be.technifutur.java2020.sudoku;

import be.technifutur.java2020.sudoku.sudoku4x4.Sudoku4x4Controleur;
import be.technifutur.java2020.sudoku.sudoku4x4.Sudoku4x4Modele;
import be.technifutur.java2020.sudoku.sudoku4x4.Sudoku4x4Vue;
import be.technifutur.java2020.sudoku.sudoku9x9.Sudoku9x9Controleur;
import be.technifutur.java2020.sudoku.sudoku9x9.Sudoku9x9Modele;
import be.technifutur.java2020.sudoku.sudoku9x9.Sudoku9x9Vue;
import be.technifutur.java2020.sudoku.sudokuetoile.SudokuEtoileControleur;
import be.technifutur.java2020.sudoku.sudokuetoile.SudokuEtoileModele;
import be.technifutur.java2020.sudoku.sudokuetoile.SudokuEtoileVue;

import java.util.Scanner;

public class MenuSudoku {

    public void newSudoku(){
        Sudoku[] menu = new Sudoku[]{
                new Sudoku4x4Vue(), new Sudoku9x9Vue(), new SudokuEtoileVue()
        };
        Scanner scan = new Scanner(System.in);
        int input;

        displayMenu(menu);
        input = scan.nextInt();
        while (input != 0) {
            int choice = input-1;
            if( choice< menu.length && choice >= 0){
                switch (choice){
                    case 1:
                        Sudoku4x4Controleur ctrl4 = new Sudoku4x4Controleur();
                        Sudoku4x4Modele modele4 = new Sudoku4x4Modele();
                        Sudoku4x4Vue vue4 = new Sudoku4x4Vue();
                        break;
                    case 2:
                        Sudoku9x9Controleur ctrl9 = new Sudoku9x9Controleur();
                        Sudoku9x9Modele modele9 = new Sudoku9x9Modele();
                        Sudoku9x9Vue vue9 = new Sudoku9x9Vue();
                        break;
                    case 3:
                        SudokuEtoileControleur ctrlE = new SudokuEtoileControleur();
                        SudokuEtoileModele modeleE = new SudokuEtoileModele();
                        SudokuEtoileVue vueE = new SudokuEtoileVue();
                        break;
                }
                menu[choice].afficheGrilleVide();
            }else {
                System.out.println("Choix impossible");
            }
            displayMenu(menu);
            input = scan.nextInt();
        }
        System.out.println("Au revoir !");
    }

    private static void displayMenu(Sudoku[] menu) {
        System.out.println();
        System.out.println("Le jeu du Sudoku");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i].getName());
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }
}
