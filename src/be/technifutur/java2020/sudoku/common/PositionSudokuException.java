package be.technifutur.java2020.sudoku.common;

public class PositionSudokuException extends SudokuException {

    public PositionSudokuException() {
    }

    public PositionSudokuException(String message) {
        super(message);
    }

    public PositionSudokuException(String message, Throwable cause) {
        super(message, cause);
    }

    public PositionSudokuException(Throwable cause) {
        super(cause);
    }

    public PositionSudokuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
