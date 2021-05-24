package games.Chess;

import javafx.scene.image.Image;

public class Var {

    /*

    Schwarz IndentifaktorInt * 10 -> durch 10 Teilbar und endet auf 0

    30 50 40 10 20 40 50 30
    60 60 60 60 60 60 60 60
    00 00 00 00 00 00 00 00
    00 00 00 00 00 00 00 00
    00 00 00 00 00 00 00 00
    00 00 00 00 00 00 00 00
    61 61 61 61 61 61 61 61
    31 51 41 11 21 41 51 31

    Weiss IndentifaktorInt * 10 + 1 -> nicht durch 10 teilbar und endet auf 1

     */

    static int squareHeight = 50;

    static int king = 1;
    static int queen = 2;
    static int rook = 3;
    static int bishop = 4;
    static int knight = 5;
    static int pawn = 6;

    static int white = 1;
    static int black = 0;

    static final String startFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"; // w KQkq - 0 1

    /*
    static Image king_white = new Image("graphics/Chess/King_white.png");
    static Image queen_white = new Image("graphics/Chess/Queen_white.png");
    static Image rook_white = new Image("graphics/Chess/Rook_white.png");
    static Image bishop_white = new Image("graphics/Chess/Bishop_white.png");
    static Image knight_white = new Image("graphics/Chess/Knight_white.png");
    static Image pawn_white = new Image("graphics/Chess/Pawn_white.png");

    static Image king_black = new Image("graphics/Chess/King_black.png");
    static Image queen_black = new Image("graphics/Chess/Queen_black.png");
    static Image rook_black = new Image("graphics/Chess/Rook_black.png");
    static Image bishop_black = new Image("graphics/Chess/Bishop_black.png");
    static Image knight_black = new Image("graphics/Chess/Knight_black.png");
    static Image pawn_black = new Image("graphics/Chess/Pawn_black.png");

     */

    static int[] lightColor = new int[]{209, 181, 151};
    static int[] darkColor = new int[]{173,142,108};
    static int[] markColor = new int[]{252, 224, 8};
}
