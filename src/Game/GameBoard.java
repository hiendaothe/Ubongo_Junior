package Game;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameBoard extends JPanel {
    private final boolean[][] boardShape;
    private final List<GameBlock> blocks;
    private static final int CELL_SIZE = 50;
    int offsetX = 50; // Horizontal offset
    int offsetY = 50; // Vertical offset
    private Image backgroundImage;

    public GameBoard(boolean[][] boardShape) {
        setLayout(null);
        this.boardShape = boardShape; // This is your custom shape definition
        setPreferredSize(new Dimension(500, 500)); // Set your preferred size
        blocks = new ArrayList<>();
    }

    public void setBackgroundImage(String imagePath) throws IOException {
        backgroundImage = ImageIO.read(getClass().getResource(imagePath));
    }

    public Point calculateNearestGridPosition(Point currentPos) {
        //int x = currentPos.x - (currentPos.x % CELL_SIZE);
        //int y = currentPos.y - (currentPos.y % CELL_SIZE);
        int x = CELL_SIZE * (int)(currentPos.x / CELL_SIZE);
        int y = CELL_SIZE * (int)(currentPos.y / CELL_SIZE);
        return new Point(x, y);
    }
    
    public boolean isPuzzleSolved() {
    boolean[][] currentBoardState = new boolean[boardShape.length][boardShape[0].length];

    for (GameBlock block : blocks) {
        boolean[][] blockShape = block.getShape();
        Point blockPosition = block.getPosition(); // Assuming you have a method to get the block's position
        for (int i = 0; i < blockShape.length; i++) {
            for (int j = 0; j < blockShape[i].length; j++) {
                if (blockShape[i][j]) {
                    
                    int row = (blockPosition.y / CELL_SIZE + i) - 4;
                    int col = (blockPosition.x / CELL_SIZE + j) - 3;

                    if (row < 0 || row >= currentBoardState.length ||
                        col < 0 || col >= currentBoardState[row].length) {
                        return false; // Block is out of bounds
                    }

                        currentBoardState[row][col] = true;
                    }
                }
            }
        }

    // Compare with the board shape
        for (int i = 0; i < boardShape.length; i++) {
            for (int j = 0; j < boardShape[i].length; j++) {
                if (boardShape[i][j] != currentBoardState[i][j]) {
                    System.err.println("Mismatch at row " + i + ", col " + j);
                    return false; // Shapes do not match
                }
            }
        }
        
        System.out.println("Board is solved");
        return true; // Puzzle is solved
    }

    
    
    public List<GameBlock> getGameBlocks() {
        return blocks;
    }
    
    public void addGameBlock(GameBlock block) {
        this.add(block);
        blocks.add(block);
    }
    
    public void checkPuzzleSolved() {
        if (isPuzzleSolved()) {
            for (GameBlock block : getGameBlocks()) { // You need to have access to the blocks
                
                new Soundplay("Sound/done.wav");
               
                block.setColor(Color.GREEN);
                block.setMouseInputEnabled(false);
                repaint();
            }
        }
    }
    

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    
    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    // Set the color for the custom shapes (the filled squares)
    g2d.setColor(Color.WHITE);

    // Loop through the shape array
    for (int i = 0; i < boardShape.length; i++) {
        for (int j = 0; j < boardShape[i].length; j++) {

            // Calculate the top-left corner of the current square
            int x = 3 * offsetX + j * 50; // Include the offset directly in the calculation
            int y = 4 * offsetY + i * 50; // Include the offset directly in the calculation

            if (boardShape[i][j]) {
                // If the current square is part of the shape, fill it
                g2d.fillRect(x, y, 50, 50);

                // Set the color for the grid lines
                g2d.setColor(Color.BLACK); // Change the color to black for visibility
                g2d.drawRect(x, y, 50, 50); // Draw the grid line for the current square

                // Set the color back to white for the next filled square
                g2d.setColor(Color.WHITE);
            }
        }
    }
}

}



