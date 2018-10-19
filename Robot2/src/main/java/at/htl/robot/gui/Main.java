package at.htl.robot.gui;
import at.htl.robot.model.Direction;
import at.htl.robot.model.Robot;
import processing.core.PApplet;

public class Main extends PApplet {
    // Hier die Member-Attribute eintragen
    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    int leftMargin = 50;
    int upperMargin = 100;
    int boxLength = 50;
    Robot robot;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        robot = new Robot();

        robot.setX(1);
        robot.setY(2);
    }
    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {
        textSize(40);
        text("Smoni der kleine Roboter", 50, 40);
        textSize(30);
        text("press <f> to move forward , <l> to turn left", 50, 80);

        if (robot.getDirection() == Direction.NORTH){
            text("Direction:", 570, 200);
            textSize(60);
            text("NORTH", 570, 270);
        } else if (robot.getDirection() == Direction.WEST){
            text("Direction:", 570, 200);
            textSize(60);
            text("WEST", 570, 270);
        } else if (robot.getDirection() == Direction.SOUTH){
            text("Direction:", 570, 200);
            textSize(60);
            text("SOUTH", 570, 270);
        } else if (robot.getDirection() == Direction.EAST) {
            text("Direction:", 570, 200);
            textSize(60);
            text("EAST", 570, 270);
        }

        strokeWeight(2);

        for (int i = 0; i < 11; i++) {
            line(
                    leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength);

            line(
                    leftMargin + i * boxLength,
                    upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength);
        }
        drawRobot();
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot() {
        int boxCenterX = leftMargin - boxLength / 2 + robot.getX() * boxLength;
        int boxCenterY = leftMargin - boxLength / 2 + robot.getY() * boxLength;

        if (robot.getDirection() == Direction.WEST || robot.getDirection() == Direction.EAST) {
            ellipse(
                    boxCenterX,
                    boxCenterY,
                    (int) (boxLength * 0.8),
                    (int) (boxLength * 0.5)
            );
        } else if (robot.getDirection() == Direction.SOUTH || robot.getDirection() == Direction.NORTH){
            ellipse(
                    boxCenterX,
                    boxCenterY,
                    (int) (boxLength * 0.5),
                    (int) (boxLength * 0.8)
            );
        }
    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            deleteAll();
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            deleteAll();
            robot.rotateLeft();
        }

    }

}
