package Sort.pkg;

public class Student {
    private final String DEFAULT_NAME = "DEFAULT NAME";
    private final int[] DEFAULT_MARKS = {1};
    private String name;
    private int[] marks;
    private double avg;

    public Student(String name, int ... marks) {
        this.name = name;
        if (marks.length >0) {
            this.marks = marks;
        }
        else {
            this.marks = DEFAULT_MARKS;
        }
        int i = 0;
        while (i < marks.length) {
            if (marks[i] < 1 || marks[i] > 5) {
                this.marks[i] = 1;
            }
            i++;
        }
        this.avg = 0;
        i = 0;
        while (i < marks.length) {
            this.avg = this.avg + marks[i];
            i++;
        }
        if (marks.length >0) {
            this.avg = this.avg / marks.length;
        }
        else {
            this.avg = 1;
        }
    }

    public Student() {
        this.name = DEFAULT_NAME;
        this.marks = DEFAULT_MARKS;
        this.avg = 0;
        int i = 0;
        while (i < DEFAULT_MARKS.length) {
            this.avg = this.avg + DEFAULT_MARKS[i];
            i++;
        }
        this.avg = this.avg / DEFAULT_MARKS.length;
    }

    public String getName() {
        return name;
    }

    public double getAvg() {
        return avg;
    }

    public int GetMark(int i) {
        if (i < marks.length) {
            return this.marks[i];
        }
        else {
            return 1;
        }
    }

    public String getMarksStr() {
        String st = "";
        int i = 0;
        while (i < marks.length) {
            if (i > 0) {
                st = st + ",";
            }
            st = st + marks[i];
            i++;
        }
        return st;
    }

}
