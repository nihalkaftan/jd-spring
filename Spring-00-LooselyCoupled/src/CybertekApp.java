import implemetation.Mentor;
import service.FullTimeMentor;
import service.MentorAccounts;

public class CybertekApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        MentorAccounts mentor = new MentorAccounts(fullTime);
        mentor.manageAccount();

    }
}
