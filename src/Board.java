import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;
public class Board extends JComponent implements Runnable, KeyListener {
    Dimension preferredSize = null;
    Ellipse2D.Double ball;
    private int PlayerCont1, PlayerCont2;
    private Paddle rs;
    public Board(int contPlayer1, int contPlayer2){
        this.PlayerCont1 = contPlayer1;
        this.PlayerCont2 = contPlayer2;
    }
    public Board() {
        setOpaque(true);
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        ball = new Ellipse2D.Double(20,320,30,30);
        rs = new Paddle();
        BallRunner bola = new BallRunner(ball, rs);
        Thread t1 = new Thread(bola);
        t1.start();
        Thread t2 = new Thread(this);
        t2.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isOpaque()) {
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());

        }
        Graphics2D  g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        String line = String.valueOf(ball.getX());;
        g2.drawString(Integer.toString(BallRunner.puntos1()),(250),(60));
        g2.drawString(Integer.toString(BallRunner.puntos2()),(640-250),(60));
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(Color.white);
        g2.drawLine(320,0,320,480);
        g2.fill(ball);
        g2.fill(rs.getRectangle1());
        g2.fill(rs.getRectangle2());
    }
    public Dimension getPreferredSize() {
        if (preferredSize == null) {
            return new Dimension(640, 480);
        } else {
            return super.getPreferredSize();
        }
    }
    public void setPreferredSize(Dimension newPrefSize) {
        preferredSize = newPrefSize;
        super.setPreferredSize(newPrefSize);
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        char charr = e.getKeyChar();
        switch (charr) {
            case 'w':
            case 'W':
                rs.up1();
                break;
            case 's':
            case 'S':
                rs.down1();
                break;
            case 'i':
            case 'I':
                rs.up2();
                break;
            case 'k':
            case 'K':
                rs.down2();
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void run() {
        while(true){
            repaint();
            try{
                Thread.sleep(150);
                //aki
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}