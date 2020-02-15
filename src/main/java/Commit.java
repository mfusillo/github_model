public class Commit {

    private String description;
    private int uniqueId;

    public Commit(String description, int uniqueId){
        this.description = description;
        this.uniqueId = uniqueId;
    }

    public int getUniqueId() {
        return uniqueId;
    }
}
