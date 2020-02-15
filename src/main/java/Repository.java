import java.util.ArrayList;

public class Repository {

    private String name;
    private String description;
    private RepositoryType repositoryType;
    private ArrayList<Commit> commits;

    public Repository(String name, String description, RepositoryType repositoryType) {
        this.name = name;
        this.description = description;
        this.repositoryType = repositoryType;
        this.commits = new ArrayList<Commit>();
    }

    public String getName() {
        return name;
    }


    public ArrayList<Commit> getCommits() {
        return commits;
    }

    public Commit findCommitById(int uniqueId) {
        for (Commit commit : commits){
            if (commit.getUniqueId() == uniqueId){
                return commit;
            }
        }
        return null;
    }

    public ArrayList<Commit> revert(int commitUniqueId){
        Commit commit = findCommitById(commitUniqueId);
        ArrayList<Commit> revertedRepo = new ArrayList<Commit>();
        for (int i = 0; i <= this.commits.indexOf(commit); i++){
            revertedRepo.add(this.commits.get(i));
        }
        return revertedRepo;
    }

}
