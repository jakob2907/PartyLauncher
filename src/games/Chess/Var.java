package games.Chess;

import javafx.scene.image.Image;

public class Var {
    static int king = 1;
    static int queen = 2;
    static int rook = 3;
    static int bishop = 4;
    static int knight = 5;
    static int pawn = 6;

    static int white = 0;
    static int black = 10;

    static final String startFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"; // w KQkq - 0 1

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

    static int[] lightColor = new int[]{209, 181, 151};
    static int[] darkColor = new int[]{173,142,108};
    static int[] markColor = new int[]{252, 224, 8};
}
