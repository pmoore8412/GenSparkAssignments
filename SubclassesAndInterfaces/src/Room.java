public class Room implements Comparable<Room> {

    private double width;
    private double length;
    private int floor;

    //constructors
    public Room() {
        this.width = 10;
        this.length = 12.5;
        this.floor = 1;
    }

    public Room(double side1, double side2, int floor) {

        if(side1 >= side2) {
            this.width = side2;
            this.length = side1;
        }
        else {
            this.width = side1;
            this.length = side2;
        }
        this.floor = floor;

    }

    //getters
    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public int getFloor() {
        return floor;
    }

    //setters

    public void setWidth(double width) {
        if(width > 0)
            this.width = width;
    }

    public void setLength(double length) {
        if(length > 0)
            this.length = length;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return this.length + " x " + this.width + " on floor " + this.floor;
    }


    public int compareTo(Room rm) {
        if (this.floor == rm.getFloor()) {
            if (this.length == rm.getLength()) {
                if (this.width == rm.getWidth())
                    return 0;
                else if (this.width > rm.getWidth())
                    return 1;
                else
                    return -1;
            }
            else if (this.length > rm.getLength())
                return 1;
            else
                return -1;
        }
        else if (this.floor > rm.getFloor())
            return 1;
        else
            return -1;

    }
}
