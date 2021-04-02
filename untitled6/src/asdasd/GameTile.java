package asdasd;

import java.awt.*;

public class GameTile {

    public static final int TILE_SIZE = 50;

    private float row;
    private float col;
    private float tileSize;


    public GameTile(float row, float col) {

        this.row        = row;
        this.col        = col;
        this.tileSize   = 50;
    }

    public void render(Graphics g){
        RenderBorders(g);

    }



    public void RenderBorders(Graphics g){
        g.setColor(Color.black);
        for (int i=100; i<=700 ;i+=50){
            for(int j=8;j<=608;j+=50){
                if(i<700&&j<608) {
                    g.fillRect(j, i, 2, 50);
                    g.fillRect(j, i, 50, 2);
                }  if(i==700&&j<608){
                    g.fillRect(j, i, 50, 2);
                }
                if(i<700&&j==608){
                    g.fillRect(j, i, 2, 52);
                }

            }
        }
    }

    }
