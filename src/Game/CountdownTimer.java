
package Game;

import java.awt.*;
import javax.swing.*;

public class CountdownTimer extends JProgressBar {
    private javax.swing.Timer timer;
    private int countdownValue;
    private int originalCountdownValue = 0;
    private TimeFinishListener finishListener;

    public CountdownTimer(int time) {
        super(0, time);
        originalCountdownValue = time;
        setStringPainted(true);
        setPreferredSize(new Dimension(245, 40));
        Font font = new Font("Ravie", 0, 20);
        setFont(font);
        // Đặt màu chữ
        Color begin = new Color(55, 217, 104);
        setForeground(begin);

        countdownValue = originalCountdownValue;
//----------------------------------------------------------------
        timer = new javax.swing.Timer(1000, e -> {
            Color over;
            if (countdownValue > 0) {
                if (countdownValue <= 10) {
                    over = Color.red;
                    setForeground(over);
                }
                else if (countdownValue <= 30) {
                    over = new Color(225,198,0);
                    setForeground(over);
                }
                else if (countdownValue <= 40) {
                    over = new Color(55, 217, 104);
                    setForeground(over);
                }
                setValue(countdownValue);
                setString(Integer.toString(countdownValue--));
            } else if (countdownValue == 0) {
                setString("Time's up!");
                finishListener.onTimerFinish();
                timer.stop();
            }

        });

        startCountdown();
    }

    private void startCountdown() {
        setValue(countdownValue);
        setString(Integer.toString(countdownValue));
        timer.start();
    }
    
    public void setFinishListener(TimeFinishListener listener) {
        this.finishListener = listener;
    }
    
    public void resetAndStart() {
        countdownValue = originalCountdownValue; // Reset the countdown value
        setString(Integer.toString(countdownValue)); // Update the display
        setValue(countdownValue);
        timer.restart(); // Restart the timer
    }
    
    public void stopTime(){
        timer.stop();
    }

}