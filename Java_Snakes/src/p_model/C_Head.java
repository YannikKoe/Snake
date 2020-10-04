package p_model;

public class C_Head {
    Enum_Route dir = Enum_Route.RIGHT;
    int x,y;

    public C_Head(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Enum_Route getDir() {
        return dir;
    }

    public void setDir(Enum_Route dir) {
        this.dir = dir;
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
