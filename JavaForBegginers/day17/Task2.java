package day17;

public class Task2 {
    static void main(String[] args) {
        ChessPiece[][] chessBoard = new ChessPiece[8][8];
        chessBoard[0][0] = ChessPiece.ROOK_BLACK;
        chessBoard[0][1] = ChessPiece.EMPTY;
        chessBoard[0][2] = ChessPiece.EMPTY;
        chessBoard[0][3] = ChessPiece.EMPTY;
        chessBoard[0][4] = ChessPiece.EMPTY;
        chessBoard[0][5] = ChessPiece.ROOK_BLACK;
        chessBoard[0][6] = ChessPiece.KING_BLACK;
        chessBoard[0][7] = ChessPiece.EMPTY;
        chessBoard[1][0] = ChessPiece.EMPTY;
        chessBoard[1][1] = ChessPiece.ROOK_WHITE;
        chessBoard[1][2] = ChessPiece.EMPTY;
        chessBoard[1][3] = ChessPiece.EMPTY;
        chessBoard[1][4] = ChessPiece.PAWN_BLACK;
        chessBoard[1][5] = ChessPiece.PAWN_BLACK;
        chessBoard[1][6] = ChessPiece.EMPTY;
        chessBoard[1][7] = ChessPiece.PAWN_BLACK;
        chessBoard[2][0] = ChessPiece.PAWN_BLACK;
        chessBoard[2][1] = ChessPiece.EMPTY;
        chessBoard[2][2] = ChessPiece.HORSE_BLACK;
        chessBoard[2][3] = ChessPiece.EMPTY;
        chessBoard[2][4] = ChessPiece.EMPTY;
        chessBoard[2][5] = ChessPiece.EMPTY;
        chessBoard[2][6] = ChessPiece.PAWN_BLACK;
        chessBoard[2][7] = ChessPiece.EMPTY;
        chessBoard[3][0] = ChessPiece.QUEEN_BLACK;
        chessBoard[3][1] = ChessPiece.EMPTY;
        chessBoard[3][2] = ChessPiece.EMPTY;
        chessBoard[3][3] = ChessPiece.ELEPHANT_WHITE;
        chessBoard[3][4] = ChessPiece.EMPTY;
        chessBoard[3][5] = ChessPiece.EMPTY;
        chessBoard[3][6] = ChessPiece.EMPTY;
        chessBoard[3][7] = ChessPiece.EMPTY;
        chessBoard[4][0] = ChessPiece.EMPTY;
        chessBoard[4][1] = ChessPiece.EMPTY;
        chessBoard[4][2] = ChessPiece.EMPTY;
        chessBoard[4][3] = ChessPiece.ELEPHANT_BLACK;
        chessBoard[4][4] = ChessPiece.PAWN_WHITE;
        chessBoard[4][5] = ChessPiece.EMPTY;
        chessBoard[4][6] = ChessPiece.EMPTY;
        chessBoard[4][7] = ChessPiece.EMPTY;
        chessBoard[5][0] = ChessPiece.EMPTY;
        chessBoard[5][1] = ChessPiece.EMPTY;
        chessBoard[5][2] = ChessPiece.EMPTY;
        chessBoard[5][3] = ChessPiece.EMPTY;
        chessBoard[5][4] = ChessPiece.ELEPHANT_WHITE;
        chessBoard[5][5] = ChessPiece.PAWN_WHITE;
        chessBoard[5][6] = ChessPiece.EMPTY;
        chessBoard[5][7] = ChessPiece.EMPTY;
        chessBoard[6][0] = ChessPiece.PAWN_WHITE;
        chessBoard[6][1] = ChessPiece.EMPTY;
        chessBoard[6][2] = ChessPiece.EMPTY;
        chessBoard[6][3] = ChessPiece.QUEEN_WHITE;
        chessBoard[6][4] = ChessPiece.EMPTY;
        chessBoard[6][5] = ChessPiece.PAWN_WHITE;
        chessBoard[6][6] = ChessPiece.EMPTY;
        chessBoard[6][7] = ChessPiece.EMPTY;
        chessBoard[7][0] = ChessPiece.EMPTY;
        chessBoard[7][1] = ChessPiece.EMPTY;
        chessBoard[7][2] = ChessPiece.EMPTY;
        chessBoard[7][3] = ChessPiece.EMPTY;
        chessBoard[7][4] = ChessPiece.EMPTY;
        chessBoard[7][5] = ChessPiece.ROOK_WHITE;
        chessBoard[7][6] = ChessPiece.KING_WHITE;
        chessBoard[7][7] = ChessPiece.EMPTY;

        Chessboard chessboard = new Chessboard(chessBoard);
        Chessboard.print(chessBoard);

    }
}
