package p_model;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Setter und Getter des Foods. Zufaellige Position fuer die Platzierung des Foods.
 */
public class C_Food {
    int x, y;

    public C_Food(){
        this.x = ThreadLocalRandom.current().nextInt(0,15);
        this.y = ThreadLocalRandom.current().nextInt(0,15);
    }

    public void m_reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,15);
        this.y = ThreadLocalRandom.current().nextInt(0,15);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
