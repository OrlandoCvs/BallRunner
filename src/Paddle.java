import java.awt.geom.Rectangle2D;
public class Paddle {
    private Rectangle2D.Double r1;
    private Rectangle2D.Double r2;
    public static final int WIDTH = 90;
    public static final int HEIGHT = 20;

    private final int[] yPositions = {10, 90, 150, 240, 330,400,470};
    private int pos = 3;

    public Paddle() {
        super();
        r1 = new Rectangle2D.Double(10, 240, HEIGHT, WIDTH);
        r2 = new Rectangle2D.Double(610, 240, HEIGHT, WIDTH);
    }

    public void up1() {
        if( pos > 0 ) {
            pos--;
            r1.y = yPositions[pos];
        }
    }
    public void down1() {
        if( pos < 6) {
            pos++;
            r1.y = yPositions[pos];
        }
    }
    public void up2() {
        if( pos > 0 ) {
            pos--;
            r2.y = yPositions[pos];
        }
    }
    public void down2() {
        if( pos < 6 ) {
            pos++;
            r2.y = yPositions[pos];
        }
    }
    public Rectangle2D.Double getRectangle1() {
        return r1;
    }
    public Rectangle2D.Double getRectangle2() {
        return r2;
    }
    public boolean check1( int x, int y) {
        return r1.contains(x,y);
    }
    public boolean check2( int x, int y) {
        return r2.contains(x,y);
    }
}
