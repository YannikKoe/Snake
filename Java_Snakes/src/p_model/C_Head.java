package p_model;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Beinhaltet neben Setter und Getter die fuer den Keyhandler notwendige Methoden
 */
public class C_Head {
	//Damit sich die Schlange am Anfang nach rechts bewegt
    Enum_Route o_coordinate = Enum_Route.RIGHT;
    int x,y;

    public C_Head(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Enum_Route getCoordinate() {
        return o_coordinate;
    }

    public void setCoordinate(Enum_Route coordinate) {
        this.o_coordinate = coordinate;
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
