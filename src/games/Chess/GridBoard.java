package games.Chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GridBoard extends GridPane {

    BoardButton[] squares = new BoardButton[64];

    public GridBoard(Chess chess)
    {
        super();

        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));
        getRowConstraints().add(new RowConstraints(50));


        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));
        getColumnConstraints().add(new ColumnConstraints(50));

        int file = 0, rank = 0;

        for (int i = 0; i < squares.length; i++) {

            BoardButton b = new BoardButton(file,rank,chess);
            squares[i] = b;
            this.add(b, file, rank);

            file++;

            //System.out.print(file);

            if(file == 8)
            {
                file = 0;
                rank++;
            }
        }
    }
}
