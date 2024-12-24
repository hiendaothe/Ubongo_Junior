
package Board;

public class BoardLayout3 {
    //gecko, groundhog, ostrich
    public static final boolean[][] BOARD_SHAPE_1 = {
        {false, true, false, false},
        {true, true, true, false},
        {true, true, true, true},
        {true, true, true, true}
    };
    
    //ostrich, snake, lion
    public static final boolean[][] BOARD_SHAPE_2 = {
        {true, true, true, false},
        {true, true, true, true},
        {true, true, true, false},
        {true, true, true, true},
        {false, true, false, false}
    };
    
    //lion, groundhog gecko
    public static final boolean[][] BOARD_SHAPE_3 = {
        {false, false, true, true},
        {false, true, true, true},
        {false, true, true, true},
        {true, true, true, true}
    };
    
    //tucan, cheetah, crocodile
    public static final boolean[][] BOARD_SHAPE_4 = {
        {true, true, true, true},
        {false, true, true, true},
        {false, true, true, true},
        {false, true, true, false}
    };
    
    //tucan, cheetah, zebra
    public static final boolean[][] BOARD_SHAPE_5 = {
        {false, true, true, false},
        {false, true, true, false},
        {false, true, true, true},
        {true, true, true, true}
    };
    
    //gecko, groundhog, tucan
    public static final boolean[][] BOARD_SHAPE_6 = {
        {false, false, false, true},
        {false, true, true, true},
        {false, true, true, true},
        {true, true, true, true}
    };
    
    //crocodile, groundhog, gecko
    public static final boolean[][] BOARD_SHAPE_7 = {
        {true, true, true, true},
        {true, true, true, true},
        {false, true, true, false},
        {false, true, true, false}
    };
    
    //snake, monkey, cheetah
    public static final boolean[][] BOARD_SHAPE_8 = {
        {true, false, true},
        {true, true, true},
        {true, true, true},
        {true, true, false},
        {true, true, true}
    };
    
    //ostrich, tucan, cheetah
    public static final boolean[][] BOARD_SHAPE_9 = {
        {false, true, false, false},
        {true, true, true, true},
        {true, true, true, true},
        {false, false, true, true},
        {false, false, false, true}
    };
    
    //snake, cheetah, tucan
    public static final boolean[][] BOARD_SHAPE_10 = {
        {false, false, true, true},
        {false, true, true, true},
        {false, true, true, true},
        {true, true, true, true}
    };
    
}
