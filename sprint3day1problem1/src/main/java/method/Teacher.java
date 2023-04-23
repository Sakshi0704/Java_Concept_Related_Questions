package method;

public class Teacher implements Collage {
    public void teaches(){
        System.out.println("Teacher teaches");
    }


    @Override
    public void doJob() {
        System.out.println("Job is started...");
        teaches();
    }
}
