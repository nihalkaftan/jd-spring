import service.FullTimeMentor;
import service.MentorAccounts;

public class CybertekApp {
    public static void main(String[] args) {
        //PartTimeMentor partTime = new PartTimeMentor();
        FullTimeMentor fullTime = new FullTimeMentor();
        MentorAccounts mentor = new MentorAccounts(fullTime);
        mentor.manageAccount();



    }
}
