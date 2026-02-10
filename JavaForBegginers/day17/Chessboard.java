package day17;

public class Chessboard {
    public Chessboard(ChessPiece[][] chessPiece) {
    }

    public static void print(ChessPiece[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int r = 0; r < chessBoard[i].length; r++) {
                System.out.print(chessBoard[i][r]);
            }
            System.out.println();
        }
    }

}
