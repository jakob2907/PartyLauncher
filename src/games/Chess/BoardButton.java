package games.Chess;

import com.sun.org.apache.xml.internal.utils.IntVector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.HashMap;

public class BoardButton extends Button {

    String fieldName;
    int file, rank;

    boolean markiert = false;

    Chess chess;

    IntVector move;

    public BoardButton(int file, int rank, Chess chess)
    {
        super();

        this.chess = chess;

        setMaxSize(50,50);


        setOnAction(event -> {

            System.out.println("pressed");

            move = new IntVector();

            //Reihenfole -> file,rank
            move.addElement(file);
            move.addElement(rank);

            chess.addmove(move);

            /*
            if(markiert){
                chess.switchColor("mark", file, rank);
            }else
            {
                chess.switchColor("remark", file, rank);
            }

             */


        });
    }

}
