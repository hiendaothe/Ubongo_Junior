
package Block;

import java.awt.Rectangle;

public class BlockLayout{
        public static final boolean[][] GECKO_BLOCK = {
            {true, true, true, true},
            {true, false, false, false}
        }; 
        public static final Rectangle GeckoBound = new Rectangle(4*50, 4*50);
        
        public static final boolean[][] MONKEY_BLOCK = {
            {true, true, false, false},
            {false, true, true, true}
        };
        public static final Rectangle MonkeyBound = new Rectangle(4*50, 4*50);
        
        public static final boolean [][] GIRAFFE_BLOCK = {
            {true, false},
            {true, false},
            {true, true},
            {true, true}
        };
        public static final Rectangle GiraffeBound = new Rectangle(4*50, 4*50);
        
        public static final boolean[][] LION_BLOCK = {
            {true, true, true},
            {true, true, false}    
        };
        public static final Rectangle LionBound = new Rectangle(3*50, 3*50);
        
        public static final boolean[][] CROCODILE_BLOCK = {
            {false, false, true},
            {true, true, true},
            {true, false, false}
        };
        public static final Rectangle CrocodileBound = new Rectangle(3*50, 3*50);
        
        public static final boolean[][] TUCAN_BLOCK = {
            {true, true, false},
            {false, true, true}
        };
        public static final Rectangle TucanBound = new Rectangle(3*50, 3*50);
        
        public static final boolean[][] GROUNDHOG_BLOCK = {
            {true},
            {true}
        };
        public static final Rectangle GroundHogBound = new Rectangle(2*50, 2*50);
        
        public static final boolean[][] SNAKE_BLOCK = {
            {false, true, false, false},
            {true, true, true, true}
        };
        public static final Rectangle SnakeBound = new Rectangle(4*50, 4*50);
        
        public static final boolean[][] OSTRICH_BLOCK = {
            {true, false, false},
            {true, true, true},
            {false, true, false}
        };
        public static final Rectangle OstrichBound = new Rectangle(3*50, 3*50);
        
        public static final boolean[][] ZEBRA_BLOCK = {
            {true, false, false},
            {true, true, true}      
        };
        public static final Rectangle ZebraBound = new Rectangle(3*50, 3*50);
        
        public static final boolean[][] CHEETAH_BLOCK = {
            {true, true, true}
        };
        public static final Rectangle CheetahBound = new Rectangle(3*50, 3*50);
        
    }
