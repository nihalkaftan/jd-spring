package service;

import implemetation.Mentor;

public class MentorAccounts {
    Mentor mentor;
    public MentorAccounts(Mentor mentor){
        this.mentor = mentor;
    }
    public void manageAccount(){
        this.mentor.createAccount();
    }
}
