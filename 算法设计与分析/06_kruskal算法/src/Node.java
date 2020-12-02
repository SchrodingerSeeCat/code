public class Node {
    private int i;
    private int j;
    private int height;

    public Node(int i, int j, int height) {
        this.i = i;
        this.j = j;
        this.height = height;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getHeight() {
        return height;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}