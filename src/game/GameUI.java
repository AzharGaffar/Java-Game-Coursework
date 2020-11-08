package game;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameUI extends Container {
    private JButton pauseButton;
    private JButton restartButton;
    private JPanel mainPanel;
    private JButton saveButton;
    private JButton loadButton;
    private JButton volDownButton;
    private JButton volUpButton;
    private Game game;
    private boolean pressedPause;
    private double currentVolume = 1;
    private int count = 0;
    private int newCount = 0;
    private int levelNumber;
    private float timothyHealth;
    private String loadLevelNumber;
    private String loadHealthNumber;

    /**
     * all necessary buttons for the player to choose from
     *
     * @param game
     */
    public GameUI(Game game) {
        this.game = game;
//Pauses game
        pauseButton.addActionListener(e -> {
            if (!pressedPause) {
                game.getWorld().stop();
                pauseButton.setText("Resume");
                pressedPause = true;
            } else {
                game.getWorld().start();
                pauseButton.setText("Pause");
                pressedPause = false;
            }
        });
//restart game
        restartButton.addActionListener(e -> {
            game.setLevel(game.getLevel() - 1);
            game.goNextLevel();
        });

        //save game
        saveButton.addActionListener(e -> {
            try {

                levelNumber = game.getLevel();//levelNumber Saving
                FileWriter fileWriterLevel = new FileWriter("levelNumber.txt");
                PrintWriter printWriterLevel = new PrintWriter(fileWriterLevel);
                printWriterLevel.println(levelNumber);
                printWriterLevel.close();

                timothyHealth = game.currMaxHealth;//health Saving
                FileWriter fileWriterHealth = new FileWriter("healthNumber.txt");
                PrintWriter printWriterHealth = new PrintWriter(fileWriterHealth);
                printWriterHealth.println(timothyHealth);
                printWriterHealth.close();


            } catch (IOException e1) {
                System.out.println("Save didn't work");
            }
            System.out.println("Saved!");
        });

        //load game
        loadButton.addActionListener(e -> {
            try {
                //Load Level
                FileReader fileReaderLevel = new FileReader("levelNumber.txt");
                BufferedReader bufferedReaderLevel = new BufferedReader(fileReaderLevel);
                loadLevelNumber = bufferedReaderLevel.readLine();
                bufferedReaderLevel.close();
                int levelNumber = Integer.parseInt(loadLevelNumber);
                game.setLevel(levelNumber);

                //Load Health
                FileReader fileReaderHealth = new FileReader("healthNumber.txt");
                BufferedReader bufferedReaderHealth = new BufferedReader(fileReaderHealth);
                loadHealthNumber = bufferedReaderLevel.readLine();
                bufferedReaderHealth.close();
                int healthNumber = Integer.parseInt(loadHealthNumber);
                //timothyDalton.setLifeCount(healthNumber);
            } catch (IOException e1) {
                System.out.println("Load didn't work");
            }
            System.out.println("Loaded!");
        });

        //increases volume
        volUpButton.addActionListener(e -> {
            if (newCount < 5) {
                currentVolume = currentVolume + 0.1d;
                newCount++;
            }
            Level1.background1Music.setVolume(currentVolume);
            Level1.voiceOver1.setVolume(currentVolume);
            Level2.background2Music.setVolume(currentVolume);
            Level2.voiceOver2.setVolume(currentVolume);
            Level3.background3Music.setVolume(currentVolume);
            Level3.voiceOver3.setVolume(currentVolume);
            Door.doorSound.setVolume(currentVolume);
            Door.openDoor.setVolume(currentVolume);
            Enemy2.enemyDeath.setVolume(currentVolume);
            GunCoin.gunCoinSound.setVolume(currentVolume);
            Key.keySound.setVolume(currentVolume);
            Heart.heartSound.setVolume(currentVolume);
            TimothyDalton.deathSound.setVolume(currentVolume);
        });

        //decreases volume
        volDownButton.addActionListener(e -> {
            if (count < 5) {
                currentVolume = currentVolume / 2;
                count++;
            }
            Level1.background1Music.setVolume(currentVolume);
            Level1.voiceOver1.setVolume(currentVolume);
            Level2.background2Music.setVolume(currentVolume);
            Level2.voiceOver2.setVolume(currentVolume);
            Level3.background3Music.setVolume(currentVolume);
            Level3.voiceOver3.setVolume(currentVolume);
            Door.doorSound.setVolume(currentVolume);
            Door.openDoor.setVolume(currentVolume);
            Enemy2.enemyDeath.setVolume(currentVolume);
            GunCoin.gunCoinSound.setVolume(currentVolume);
            Key.keySound.setVolume(currentVolume);
            Heart.heartSound.setVolume(currentVolume);
            TimothyDalton.deathSound.setVolume(currentVolume);
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
