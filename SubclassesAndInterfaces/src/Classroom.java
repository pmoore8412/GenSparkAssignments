public class Classroom extends Room {

    private int numStudents;

    //constructors
    public Classroom(double side1, double side2, int floor, int numStudents) {

        if(side1 >= side2) {
            setLength(side1);
            setWidth(side2);
        }
        else {
            setLength(side2);
            setWidth(side1);
        }
        setFloor(floor);
        this.numStudents = numStudents;

    }

    //getters
    public int getNumStudents() {
        return numStudents;
    }

    //setters
    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    @Override
    public String toString() {
        return super.toString() + " capacity = " + this.numStudents + " students";
    }

}
