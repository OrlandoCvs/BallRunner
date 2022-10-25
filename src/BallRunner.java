
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BallRunner implements Runnable {

    public static final int MAX_X = 640;
    public static final int MAX_Y = 480;
    public static final int SIGN = -1;
    public static int DX = 10;
    public static int DY = 10;
    private Ellipse2D.Double ball;
    private Paddle rs;
    private int ballX;
    private int ballY;
    public static int contPLAYER1 = 0;
    public static int contPLAYER2 = 0;
    private int determinarX, determinarY;
    private int signoX = 1;
    private int signoY = 1;
    public BallRunner(Shape shape, Paddle p) {
        ball = ( Ellipse2D.Double) shape;
        rs = p;
        ballX = 320;
        ballY = 240;
        ball.x = ballX ;
        ball.y = ballY;
    }
    public static int puntos1(){
        return contPLAYER1;
    }
    public static int puntos2(){
        return contPLAYER2;
    }
    @Override
    public void run() {
        int dirY = 1;
        int dirX = 1;
        int bxmin, bxmax, bymin, bymax;
        while( true ) {
            bxmin = (int)ball.getMinX();
            bxmax = (int)ball.getMaxX();
            bymin = (int)ball.getMinY();
            bymax = (int)ball.getMaxY();
            if( rs.check1(bxmin,bymin) || rs.check1(bxmin,bymax)) {
                // sX = sX * SIGN;
                dirX = dirX * SIGN;
                ballX = ballX + (DX*dirX);
                ballY = ballY + (DY*dirY);
                ball.x = ballX;
                ball.y = ballY;
                continue;
            }
            if( rs.check2(bxmax,bymin) || rs.check2(bxmax,bymax)) {
                // sX = sX * SIGN;
                dirX = dirX * SIGN;
                ballX = ballX + (DX*dirX);
                ballY = ballY + (DY*dirX);
                ball.x = ballX ;
                ball.y = ballY;
                continue;
            }
            if(ball.x == MAX_X){
                ballX = 310;
                ball.x = ballX;
                ballY = 240;
                ball.y = ballY;
                contPLAYER1++;
            }
            if(ball.x == 0){
                ballX = 310;
                ball.x = ballX;
                ballY = 240;
                ball.y = ballY;
                contPLAYER2++;
            }
            if(ball.y == MAX_Y || ball.y == 0){
                dirY = dirY*SIGN;
            }
            ballX = ballX + (DX*dirX);
            ballY = ballY + (DY*dirY);
            ball.x = ballX ;
            ball.y = ballY;
            try {
                Thread.sleep(150L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
