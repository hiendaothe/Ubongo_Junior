/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author ADMIN
 */
public class Soundplay {
    Clip clip;
    public Soundplay(String filepath) {
        try {
            InputStream soundStream = getClass().getClassLoader().getResourceAsStream(filepath);
            //add buffer for mark/reset support
            InputStream bufferedIn = new BufferedInputStream(soundStream);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}