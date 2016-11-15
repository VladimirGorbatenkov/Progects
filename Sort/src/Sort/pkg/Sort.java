package Sort.pkg;

public class Sort {
    public static void main (String args []) {
        Student[] std = new Student[5];

        std[0] = new Student("Vasya",3,3,2,4);
        std[1] = new Student("Petya",4,3,2,4);
        std[2] = new Student();
        std[3] = new Student("Masha",2,3,2,4);
        std[4] = new Student("Dasha",1,3,2,4);

        int i = 0;
        while (i < std.length) {
            System.out.println(std[i].getName() + " "+ std[i].getMarksStr() + "      " + std[i].getAvg());
            i++;
        }

        bubbleSort(std);

        System.out.println("");
        i = 0;
        while (i < std.length) {
            System.out.println(std[i].getName() + " "+ std[i].getMarksStr() + "      " + std[i].getAvg());
            i++;
        }
    }

    public static void bubbleSort(Student arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getAvg() > arr[j + 1].getAvg()) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
