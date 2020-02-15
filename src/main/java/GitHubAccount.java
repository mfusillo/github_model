import java.lang.reflect.Array;
import java.util.*;

public class GitHubAccount {

    private String username;
    private String name;
    private HashMap<String, Repository> repositories;
    private AccountType accountType;

    public GitHubAccount(String username, String name, AccountType accountType) {
        this.username = username;
        this.name = name;
        this.accountType = accountType;
        this.repositories = new HashMap<String, Repository>();
    }

    public String getUsername() {
        return username;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public HashMap<String, Repository> getRepositories() {
        return repositories;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Repository findRepoByMostCommits() {

        HashMap<Repository, Integer> repositoriesByNumberOfCommits = new HashMap<Repository, Integer>();

        for (Repository repository : this.repositories.values()) {
            repositoriesByNumberOfCommits.put(repository, repository.getCommits().size());
        }

        int maxNumberOfCommits = Collections.max(repositoriesByNumberOfCommits.values());

        for (Map.Entry<Repository, Integer> repository : repositoriesByNumberOfCommits.entrySet()){
            if (repository.getValue() == maxNumberOfCommits){
                return repository.getKey();
            }
        }
        return null;
    }

    public static Comparator<GitHubAccount> nameComparator = new Comparator<GitHubAccount>() {
        public int compare(GitHubAccount o1, GitHubAccount o2) {
            return o1.getUsername().compareTo(o2.getUsername());
        }
    };

}
