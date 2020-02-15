import java.util.ArrayList;
import java.util.Collections;

public class GitHub {

    private ArrayList<GitHubAccount> accounts;

    public GitHub(){
        accounts = new ArrayList<GitHubAccount>();
    }

    public ArrayList<GitHubAccount> getAccounts() {
        return accounts;
    }

    public ArrayList<GitHubAccount> sortByUsername(){
        Collections.sort(this.accounts, GitHubAccount.nameComparator);
        return this.accounts;
    }

}
