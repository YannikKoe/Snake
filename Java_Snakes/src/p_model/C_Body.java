package p_model;
/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Setter und Getter (u.A. auch "wait" für den move) für den Body der Schlange
 */
public class C_Body {
    int x,y;
    boolean wait = true;

    public C_Body(int x, int y) {
        this.x = x;
        this.y = y;
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

    public boolean m_isWaiting() {
        return wait;
    }

    public void m_setWaiting(boolean wait) {
        this.wait = wait;
    }
}
