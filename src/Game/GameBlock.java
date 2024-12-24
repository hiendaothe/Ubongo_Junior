package Game;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GameBlock extends JComponent {
    private boolean[][] shape; // 2D array to represent the shape of the block
    private Color color; // Color of the block
    private static final int CELL_SIZE = 50;
    private boolean isMouseInputEnabled = true;
    private int x = 0;
    private int y = 0;
    private Point location;
    public GameBlock(boolean[][] shape, Color color, Rectangle bounds) {
        this.shape = shape;
        this.color = color;
        setOpaque(false);
        // Set the preferred size based on the shape's dimensions
        setBounds(bounds);
        
        MouseAdapter ma = new MouseAdapter() {
        private Point initialClickPoint;

        @Override
        public void mousePressed(MouseEvent e) {
            if(isMouseInputEnabled){
                initialClickPoint = e.getPoint();
                bringToFront();
                
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(isMouseInputEnabled){
                int deltaX = e.getX() - initialClickPoint.x;
                int deltaY = e.getY() - initialClickPoint.y;
                int newX = x + deltaX; // Proposed new x-coordinate
                int newY = y + deltaY;
                Rectangle bounds = getParent().getBounds();
                int maxWidth = bounds.width - getWidth();
                int maxHeight = bounds.height - getHeight();

                // Adjust newX and newY to be within the bounds
                newX = Math.max(0, Math.min(newX, maxWidth));
                newY = Math.max(0, Math.min(newY, maxHeight));

                // Update x and y with the new position
                x = newX;
                y = newY;

                // Set the new location for the GameBlock
                setLocation(newX, newY);
            }    
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if (isMouseInputEnabled) {
               location = getLocation();
               if (SwingUtilities.isRightMouseButton(e)) {
                    rotate();
            } else if (e.getClickCount() == 2) {
                mirror();
            }
        }
        }
            
        @Override
        public void mouseReleased(MouseEvent e) {
            if((isMouseInputEnabled) ){
                // Check if the block is within the board bounds
                if (getParent() instanceof GameBoard) {
                    
                    new Soundplay("Sound/drop.wav");
                    
                    GameBoard board = (GameBoard) getParent();
                    Point nearestGridPos = board.calculateNearestGridPosition(getLocation());
                    // Snap the block to the nearest grid position
                    x = nearestGridPos.x;
                    y = nearestGridPos.y;
                    setLocation(x, y);

                    // Check if the puzzle is solved
                    board.checkPuzzleSolved();
                }
        
            }
        }
        
        
        
        private void bringToFront() {
            getParent().setComponentZOrder(GameBlock.this, 0);
            getParent().repaint();
        }
    };

    addMouseListener(ma);
    addMouseMotionListener(ma);        
    }
    
    public void setMouseInputEnabled(boolean enable) {
        isMouseInputEnabled = enable;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        repaint();
    }
    
    public boolean[][] getShape() {
        return this.shape; // Assuming 'shape' is the 2D array representing the block's shape
    }
    
    public Point getPosition() {
        return new Point(x, y);
    }   
    

    public void rotate() {
        boolean[][] rotatedShape = new boolean[shape[0].length][shape.length];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                rotatedShape[j][shape.length - 1 - i] = shape[i][j];
            }
        }
        shape = rotatedShape;
        revalidate();
        repaint();
    }
    
    public void mirror() {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length / 2; j++) {
                boolean temp = shape[i][j];
                shape[i][j] = shape[i][shape[i].length - j - 1];
                shape[i][shape[i].length - j - 1] = temp;
            }
        }
        revalidate();
        repaint();
    }
    

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j]) {
                    g2d.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE); // Draw each square of the block
                }
            }
        }
    }
}
