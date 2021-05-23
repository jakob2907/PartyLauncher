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
        pieceType.put('k', Var.king * 10);
        pieceType.put('q', Var.queen * 10);
        pieceType.put('n', Var.knight * 10);
        pieceType.put('p', Var.pawn * 10);
        pieceType.put('b', Var.bishop * 10);
        pieceType.put('r', Var.rook * 10);
        
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

        TypePiece.put(Var.king * 10 + Var.black, 'k');
        TypePiece.put(Var.queen * 10 + Var.black, 'q');
        TypePiece.put(Var.knight * 10 + Var.black, 'n');
        TypePiece.put(Var.pawn * 10 + Var.black, 'p');
        TypePiece.put(Var.bishop * 10 + Var.black, 'b');
        TypePiece.put(Var.rook * 10 + Var.black, 'r');

        //White

        TypePiece.put(Var.king * 10 + Var.white, 'K');
        TypePiece.put(Var.queen * 10 + Var.white, 'Q');
        TypePiece.put(Var.knight * 10 + Var.white, 'N');
        TypePiece.put(Var.pawn * 10 + Var.white, 'P');
        TypePiece.put(Var.bishop * 10 + Var.white, 'B');
        TypePiece.put(Var.rook * 10 + Var.white, 'R');

        StringBuilder fen = new StringBuilder("");
        int rank = 7;
        int file = 0;

        for (int i = 0; i < square.length; i = i) {

            if(i % (7+rank*8) == 0)
            {
                fen.append("/");
                rank--;
                file = 0;

                i++;
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
                    i++;
                }

            }else if(square[i] != 0) {

                Character figur = TypePiece.get(square[i]);

                //Schwarz

                if(square[i] % 10 == 0)
                {
                    char c = Character.toUpperCase(figur);
                    fen.append(c);
                }

                //Weiß

                else if(square[i] % 10 != 0)
                {
                    char c = Character.toLowerCase(figur);
                    fen.append(c);
                }
                file++;
                i = i + 2;
            }
        }
        return fen.toString();
    }

}
