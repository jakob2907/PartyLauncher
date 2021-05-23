package games.Chess;

import java.util.ArrayList;
import java.util.HashMap;

//FIXME LoadPositionFromArray() überprüfen -> Array nach Methode falsch, vor allem bei schwarz

public class Notation {

    Chess chess;

    int[] squares = new int[64];

    public Notation(Chess chess) {
        this.chess = chess;
    }


    //funktioniert
    public int[]  LoadPositionFromFEN(String fen)
    {
        HashMap<Character, Integer> pieceType = new HashMap<>();
        pieceType.put('k', Var.king);
        pieceType.put('q', Var.queen);
        pieceType.put('n', Var.knight);
        pieceType.put('p', Var.pawn);
        pieceType.put('b', Var.bishop);
        pieceType.put('r', Var.rook);
        
        char[] fenBoard = fen.toCharArray();
        int file = 0, rank = 7;

        for (char symbol: fenBoard) {

            if(symbol == '/')
            {
                file = 0;
                rank--;
            }else{
                if(Character.isDigit(symbol))
                {
                    file += (int) Character.getNumericValue(symbol);
                }else
                {
                    //K,Q,R,B,N,P -> White; k,q,r,b,n,p -> black

                    int pieceColor = (Character.isUpperCase(symbol)) ? Var.white : Var.black;
                    int pieceTyp = pieceType.get(Character.toLowerCase(symbol));


                    squares[rank * 8 + file] = pieceTyp + pieceColor;

                    file ++;
                }
            }
        }
        //System.out.println();

        return squares;
    }


    //Probleme mit Array
    public String LoadPositionFromArray(int[] square)
    {
        HashMap<Integer, Character> TypePiece= new HashMap<>();

        //Black

        TypePiece.put(Var.king + 10, 'k');
        TypePiece.put(Var.queen + 10, 'q');
        TypePiece.put(Var.knight + 10, 'n');
        TypePiece.put(Var.pawn + 10, 'p');
        TypePiece.put(Var.bishop + 10, 'b');
        TypePiece.put(Var.rook + 10, 'r');

        //White

        TypePiece.put(Var.king, 'K');
        TypePiece.put(Var.queen, 'Q');
        TypePiece.put(Var.knight, 'N');
        TypePiece.put(Var.pawn, 'P');
        TypePiece.put(Var.bishop, 'B');
        TypePiece.put(Var.rook, 'R');

        StringBuilder fen = new StringBuilder("");
        int rank = 0;
        int file = 0;

        for (int i = 0; i < square.length; i++) {

            if(i % (7+rank*8) == 0)
            {
                fen.append("/");
                rank++;
                file = 0;
            }
            else if(square[i] == 0)
            {
                int space = 0;
                for (int next = i; next < square.length; next++)
                {
                    if(square[next] == 0 && space != 8 && i % (7+rank*8) != 0)
                    {
                        space++;
                    }
                    else
                    {
                        fen.append(space);
                        i = next;

                    }
                    file++;
                }

            }else if(square[i] != 0) {

                Character figur = TypePiece.get(square[i]);

                if(square[i] < 7)
                {
                    char c = Character.toUpperCase(figur);
                    fen.append(c);
                }
                else if(square[i] > 10)
                {
                    char c = Character.toLowerCase(figur);
                    fen.append(c);
                }
                file++;
            }

        }
        return fen.toString();
    }

}
