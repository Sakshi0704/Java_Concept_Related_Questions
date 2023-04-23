package method;

public class Main {
    public static void main(String[] args) {
        Job job = new Job();
        job.setC(new Teacher());
        job.doJob();
    }
}
