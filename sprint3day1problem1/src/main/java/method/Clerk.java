package method;

public class Clerk implements Collage {
    public void registerStudent(){
        System.out.println("enroll the Student in Collage");
    }
    @Override
    public void doJob() {
        System.out.println("Job is started...");
        registerStudent();
    }
}
