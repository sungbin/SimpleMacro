//package SimpleMacro;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.InputEvent;
//
//import org.jnativehook.GlobalScreen;
//import org.jnativehook.NativeHookException;
//import org.jnativehook.mouse.NativeMouseEvent;
//import org.jnativehook.mouse.NativeMouseInputListener;
//
//public class MouseController implements NativeMouseInputListener {
//    private Robot robot;
//    public Location clicked = null;
//    public Dragged dragged = null;
//
//    public void nativeMouseClicked(NativeMouseEvent e) {
////		System.out.println("Mouse Clicked: " + e.getClickCount());
//    }
//
//    public void nativeMousePressed(NativeMouseEvent e) {
////		System.out.println("Mouse Pressed: " + e.getButton());
//        clicked = new Location(e.getX(),e.getY());
////		System.out.println("clicked update - x: " + e.getX() + ", y: " + e.getY());
//    }
//
//    public void nativeMouseReleased(NativeMouseEvent e) {
////		System.out.println("Mouse Released: " + e.getButton());
//        dragged = new Dragged(clicked,new Location(e.getX(),e.getY()));
//    }
//
//    public MouseController() throws AWTException {
//        super();
//
//        robot = new Robot();
//    }
//
//    public void move(int x, int y) {
//        robot.mouseMove(x, y);
//    }
//    public void move(Location l) {
//        move(l.x, l.y);
//    }
//
//    public void drag(Dragged d) throws InterruptedException {
//        move(d.first);
//        press();
//        Thread.sleep(2);
//        move(d.second);
//        release();
//    }
//
//    public void press(int count) throws InterruptedException {
//        for(int i = 0; i < count; i++) {
//            press();
//            Thread.sleep((long) (1000 * Math.random() / 4.0));
//            release();
//        }
//    }
//
//    public void press() {
//        robot.mousePress(InputEvent.BUTTON1_MASK);
//    }
//
//    public void release() {
//        robot.mouseRelease(InputEvent.BUTTON1_MASK);
//    }
//
//
//    public void nativeMouseMoved(NativeMouseEvent e) {
////		System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
//    }
//
//    public void nativeMouseDragged(NativeMouseEvent e) {
////		System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
//        dragged = new Dragged(clicked,new Location(e.getX(),e.getY()));
//    }
//
//    /**
//     * example run
//     *
//     * @param args
//     * @throws AWTException
//     */
//    public static void main(String[] args) throws AWTException {
//        try {
//            GlobalScreen.registerNativeHook();
//        } catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//
//            System.exit(1);
//        }
//
//        // Construct the example object.
//        MouseController example = new MouseController();
//
//        // Add the appropriate listeners.
//        GlobalScreen.addNativeMouseListener(example);
//    }
//
//    public static class Location {
//        Location(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//        int x;
//        int y;
//    }
//
//    public static class Dragged {
//        Dragged(Location l1, Location l2) {
//            first = l1;
//            second = l2;
//        }
//        Location first;
//        Location second;
//    }
//}