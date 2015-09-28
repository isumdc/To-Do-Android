package etbrady.todo.models;

/**
 * Created by etbrady on 9/28/15.
 */
public class Chore {


    private String title;
    private boolean isComplete;

    public Chore(String title) {
        this.title = title;
        this.isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
