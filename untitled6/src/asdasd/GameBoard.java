package asdasd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard extends JFrame implements MouseListener {
    public final int TILE_SIDE_COUNT = 15;
    protected Monsters[][] monsters;
    protected Monsters selectedMonster;
    int rowStart, colStart;
    int gameTurn=0;
    JLabel labelPo = new JLabel();
    JLabel labelPt = new JLabel();

    public GameBoard() {
        this.monsters = new Monsters[15][15];
        this.add(labelPt);
        this.add(labelPo);
        this.setLayout(null);

        setTitle("Cards against Humans");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addMouseListener(this);
        PlayerOneSpawn();
        PlayerTwoSpawn();
    }
    public void PlayerOneSpawn(){
        this.monsters = new Monsters[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        for (int i = 0; i<6;i++) {
            int YellowCord = ThreadLocalRandom.current().nextInt(1, 7);


            switch (YellowCord) {
                case 1 -> this.monsters[0][i] = (new Monsters(0, i, 5, 5,5,5, "Drunken Knight", Color.blue));
                case 2 -> this.monsters[0][i] = (new Monsters(0,i, 10,1,4,5, "Sofisticated Sam", Color.red));
                case 3 -> this.monsters[0][i] = (new Monsters(0, i, 5,4,1,10, "Sand Turtle", Color.cyan));
                case 4 -> this.monsters[0][i] = (new Monsters(0, i, 8,1,10,5,"Magic cat", Color.green));
                case 5 -> this.monsters[0][i] = (new Monsters(0, i, 4,10,8,6,"Reckless canibal", Color.magenta));
                case 6 -> this.monsters[0][i] = (new Monsters(0, i, 10,5,8,2,"Dog eating bug", Color.orange));
            }
        }
    }
    public void PlayerTwoSpawn(){
        this.monsters = new Monsters[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        for (int i = 0; i<6;i++) {
            int BlackCord = ThreadLocalRandom.current().nextInt(1, 7);

            switch (BlackCord) {
                case 1 -> this.monsters[14][0] = (new Monsters(14, 0, 5, 5,5,5, "Drunken Knight", Color.blue));
                case 2 -> this.monsters[14][1] = (new Monsters(14, 1, 10,1,4,5, "Sofisticated Sam", Color.red));
                case 3 -> this.monsters[14][2] = (new Monsters(14, 2, 5,4,1,10, "Sand Turtle", Color.cyan));
                case 4 -> this.monsters[14][3] = (new Monsters(14, 3, 8,1,10,5,"Magic cat", Color.green));
                case 5 -> this.monsters[14][4] = (new Monsters(14, 4, 4,10,8,6,"Reckless canibal", Color.magenta));
                case 6 -> this.monsters[14][5] = (new Monsters(14, 5, 10,5,8,2,"Dog eating bug", Color.orange));
            }
        }
    }

    @Override

    public void paint(Graphics g) {
        super.paint(g);
        GameTile tile = new GameTile(0,0);
        tile.render(g);
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                renderGamePiece(g, row, col);
            }
        }

    }






    private Monsters getMonster(int row, int col) {
        return this.monsters[row][col];

    }

    private boolean hasMonster(int row, int col) {
        return this.getMonster(row, col) != null;
    }




    private void renderGamePiece(Graphics g, int row, int col) {
        if (this.hasMonster(row, col)) {
            Monsters p = (Monsters) this.getMonster(row, col);
            p.render(g);

        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimentionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimentionBasedOnCoordinates(e.getX());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    private int getBoardDimentionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }
}
