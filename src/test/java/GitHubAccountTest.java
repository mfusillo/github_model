import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private GitHubAccount gitHubAccount;
    private Repository repository1;
    private Repository repository2;
    private Commit commit1;
    private Commit commit2;
    private Commit commit3;

    @Before
    public void before(){
        gitHubAccount = new GitHubAccount("mfusillo", "Matteo Fusillo", AccountType.PRO);
        repository1 = new Repository("card_game", "A cool card game", RepositoryType.PUBLIC);
        repository2 = new Repository("shop_inventory", "An inventory for a shop", RepositoryType.PRIVATE);
        commit1 = new Commit("File structure set up", 233);
        commit2 = new Commit("Create card class", 256);
        commit3 = new Commit("File structure set up", 366);
        repository1.getCommits().add(commit1);
        repository1.getCommits().add(commit2);
        repository2.getCommits().add(commit3);
        gitHubAccount.getRepositories().put(repository1.getName(), repository1);
        gitHubAccount.getRepositories().put(repository2.getName(), repository2);

    }

    @Test
    public void can_find_repository_by_name(){
        assertEquals(repository1, gitHubAccount.getRepositories().get("card_game"));
    }

    @Test
    public void can_change_account_type(){
        gitHubAccount.setAccountType(AccountType.FREE);
        assertEquals(AccountType.FREE, gitHubAccount.getAccountType());
    }

    @Test
    public void can_get_repo_with_most_commits(){
        assertEquals(repository1, gitHubAccount.findRepoByMostCommits());
    }

}
