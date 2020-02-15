import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GitHubTest {

    GitHub github;
    GitHubAccount gitHubAccount1;
    GitHubAccount gitHubAccount2;
    GitHubAccount gitHubAccount3;

    @Before
    public void before(){
        github = new GitHub();
        gitHubAccount3 = new GitHubAccount("mfusillo", "Matteo Fusillo", AccountType.PRO);
        gitHubAccount2 = new GitHubAccount("arogers", "Aaron Rogers", AccountType.FREE);
        gitHubAccount1 = new GitHubAccount("smichaels", "Sean Michaels", AccountType.PRO);
        github.getAccounts().add(gitHubAccount1);
        github.getAccounts().add(gitHubAccount2);
        github.getAccounts().add(gitHubAccount3);
    }

    @Test
    public void can_sort_accounts_by_username_in_alphabetic_order(){
        github.sortByUsername();
        ArrayList<GitHubAccount> accountsSortedByUsername = new ArrayList<GitHubAccount>();
        accountsSortedByUsername.add(gitHubAccount2);
        accountsSortedByUsername.add(gitHubAccount3);
        accountsSortedByUsername.add(gitHubAccount1);
        assertEquals(accountsSortedByUsername, github.getAccounts());
        assertEquals("arogers", github.getAccounts().get(0).getUsername());
        assertEquals("smichaels", github.getAccounts().get(2).getUsername());
    }



}
