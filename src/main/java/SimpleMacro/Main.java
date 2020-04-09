package SimpleMacro;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public KeyboardController keyboard;
    public MouseController mouse;

    public static void main(String[] args) throws AWTException, InterruptedException {

        Main main = new Main();
        main.run();


    }

    public void run() throws AWTException, InterruptedException {

        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        Scanner in = new Scanner(System.in);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        this.mouse = new MouseController();
        GlobalScreen.addNativeMouseListener(this.mouse);
        this.keyboard = new KeyboardController();
        GlobalScreen.addNativeKeyListener(this.keyboard);

        Thread.sleep(2000);

        ArrayList<MouseController.Location> locations = new ArrayList<>();

        int mcount = 2; // right, center-bottom
        for(int i = 0; i <mcount ; i++) {
            MouseController.Location location = getLocation();
            locations.add(location);
            System.out.println("saved " + i);
        }

        Thread.sleep(1000 * 5);

        int pageCount = 206;

        for(int i = 0; i < pageCount; i++) {

            keyboard.press(157, 16, 53); //command + shift + 5

            mouse.move(locations.get(1));
            mouse.press(1);

            Thread.sleep(6000);


            mouse.move(locations.get(0));
            mouse.press(1);
            Thread.sleep(1000);
        }


//        keyboard.press(157  , 16, 53); //command + shift + 5




    }

    private MouseController.Location getLocation() throws InterruptedException {

        mouse.clicked = null;
        while (mouse.clicked == null) {
            System.out.println("loof");
            Thread.sleep(500);
        }
        MouseController.Location location = mouse.clicked;
        mouse.clicked = null;
        return location;
    }
}
