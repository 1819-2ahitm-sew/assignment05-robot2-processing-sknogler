package at.htl.robot.model;

public class Robot {

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.SOUTH;


    //region getter and setter

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    public int stepForward() {
        if (this.direction == Direction.NORTH){
            if (y == 2){
                this.y = 2;
            } else {
                y -= 1;
            }
        } else if (this.direction == Direction.WEST){
            if (x == 1){
                this.x = 1;
            } else {
                x -= 1;
            }
        } else if (this.direction == Direction.SOUTH){
            if (y == 11){
                this.y = 11;
            } else {
                y += 1;
            }
        } else if (this.direction == Direction.EAST) {
            if (x == 10) {
                this.x = 10;
            } else {
                x += 1;
            }
        }
        return x;
    }

    public Direction rotateLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
        }
        return this.direction;
    }
}
