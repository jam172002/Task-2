package task2;

public class WaitingList {
    private String nameofWaiter;
    private String currentLevel;
    private String requiredLevel;

    //constructor

    public WaitingList(String nameofWaiter, String currentLevel, String requiredLevel) {
        this.nameofWaiter = nameofWaiter;
        this.currentLevel = currentLevel;
        this.requiredLevel = requiredLevel;
    }

    //getter and setter

    public String getNameofWaiter() {
        return nameofWaiter;
    }

    public void setNameofWaiter(String nameofWaiter) {
        this.nameofWaiter = nameofWaiter;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
