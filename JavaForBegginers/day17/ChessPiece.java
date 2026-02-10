package day17;

public enum ChessPiece {
    KING_WHITE(100, "Король (белый) ♔"),
    KING_BLACK(100, "Король (черный) ♚"),
    QUEEN_WHITE(9, "Ферзь (белый)  ♕"),
    QUEEN_BLACK(9, "Ферзь (чёрный)  ♛"),
    ELEPHANT_WHITE(3.5, "Слон (белый)  ♗"),
    ELEPHANT_BLACK(3.5, "Слон (чёрный)  ♝"),
    ROOK_WHITE(5, "Ладья(белая) ♖"),
    ROOK_BLACK(5, "Ладья(чёрная) ♜"),
    HORSE_WHITE(3, "Конь(белый) ♘"),
    HORSE_BLACK(3, "Конь(чёрный) ♞"),
    PAWN_WHITE(1, "Пешка(белая) ♙"),
    PAWN_BLACK(1, "Пешка(чёрная) ♟"),
    EMPTY(-1,"_");


    double valueOfTheFigure;
    String nameFigure;

    ChessPiece(double valueOfTheFigure, String nameFigure) {
        this.valueOfTheFigure = valueOfTheFigure;
        this.nameFigure = nameFigure;
    }

    @Override
    public String toString() {
        char lastChar = nameFigure.charAt(nameFigure.length() - 1);
        return String.valueOf(lastChar);
    }

}
