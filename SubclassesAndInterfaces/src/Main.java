import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //compareTo test
        Room [] rooms = new Room[6];

        rooms[0] = new Room(12, 5, 1);
        rooms[1] = new Room(16, 3, 1);
        rooms[2] = new Room(12, 4, 2);
        rooms[3] = new Room(16, 6, 1);
        rooms[4] = new Room(12, 6, 1);
        rooms[5] = new Room(12, 3, 2);

        Arrays.sort(rooms);
        
        for(int i = 0; i < rooms.length; i++)
            System.out.println(rooms[i].toString());

        System.out.println();

        //listOfClassrooms test
        Room [] rooms2 = new Room[10];

        rooms2[0] = new Classroom(12,12,1,33);
        rooms2[1] = new Classroom(4,12,3,96);
        rooms2[2] = new Classroom(100,14,9,1203);
        rooms2[3] = new Room(12,25,65);
        rooms2[4] = new Room(89,65,1192);
        rooms2[5] = new Classroom(10,14,3,69);
        rooms2[6] = new Classroom(10,18,69,420);
        rooms2[7] = new Room(12,12,5);
        rooms2[8] = new Classroom(35,25,789,65000);
        rooms2[9] = new Room(12,12,1);

        List<Classroom> classroomList = listOfClassrooms(rooms2);
        System.out.println("Number of Classrooms in list: " + classroomList.size() + " ->");
        classroomList.forEach(n -> {System.out.println(n);});

    }

    public static List<Classroom> listOfClassrooms(Room [] rooms) {

        List<Classroom> classroomList = Arrays.stream(rooms)
                .filter(room -> room instanceof Classroom)
                .map(room -> (Classroom) room).collect(Collectors.toList());
        return classroomList;

    }
}