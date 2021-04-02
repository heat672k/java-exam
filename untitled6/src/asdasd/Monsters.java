package asdasd;

import java.awt.*;

public class Monsters extends Cards {

    public Monsters(int row, int col, int attack, int speed, int mana, int defense, String Id, Color color) {
        this.row = row;
        this.col = col;
        this.attack = attack;
        this.speed = speed;
        this.mana = mana;
        this.defense = defense;
        this.Id = Id;
        this.color = color;
    }
    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
        g.setColor(this.color);
        g.fillOval(x+10, y, 48, 48);
    }

}
