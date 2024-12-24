
package Board;

    public class BoardLayout2{
        //Monkey, giraffe
        public static final boolean[][] BOARD_SHAPE_1 = {
            {true, true, true, true},
            {false, true, true, true},
            {false, true, true, false},
            {false, false, true, false},
            {false, false, true, false}
        };
        //crocodile, lion
        public static final boolean[][] BOARD_SHAPE_2 = {
            {false, true, true, true},
            {true, true, true, false},
            {true, true, true, false},
            {false, false, true, false},
        };
        
        //tucan, ostrich
         public static final boolean[][] BOARD_SHAPE_3 = {
             {false, true, false},
             {true, true, true},
             {true, true, true},
             {false, true, true}
         };
         
         //snake, giraffe
          public static final boolean[][] BOARD_SHAPE_4 = {
              {false, true, true},
              {true, true, true},
              {true, true, true},
              {true, false, true},
              {true, false, false},
          };
          
          //snake, monkey
           public static final boolean[][] BOARD_SHAPE_5 = {
               {true, true, false, false},
               {true, true, true, true},
               {true, true, false, false},
               {true, false, false, false},
               {true, false, false,false}
           };
           
           //tucan, groundhog
           public static final boolean[][] BOARD_SHAPE_6 = {
               {true, true, true},
               {true, true, false},
               {false, true, false}
           };
           
           //crocodile, gecko
           public static final boolean[][] BOARD_SHAPE_7 = {
               {false, false, false, true},
               {false, false, true, true},
               {true, true, true, true},
               {true, false, true, true}
           };
           
           //zebra, gecko
           public static final boolean[][] BOARD_SHAPE_8 = {
               {true, true, true, true},
               {false, true, true, true},
               {false, true, false, false},
               {false, true, false, false}
           };
           
           //zebra, ostrich
           public static final boolean[][] BOARD_SHAPE_9 = {
               {true, true, true, true},
               {false, true, true, true},
               {false, true, false, true}
           };
           
           //gecko, lion
           public static final boolean[][] BOARD_SHAPE_10 = {
               {true, true, true},
               {true, true, true},
               {true, true, false},
               {true, true, false}
                   
           };
    }