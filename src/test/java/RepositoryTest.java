import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepositoryTest {

    private Repository repository;
    private Commit commit1;
    private Commit commit2;
    private Commit commit3;

    @Before
    public void before(){
        repository = new Repository("card_game", "A cool card game", RepositoryType.PUBLIC);
        commit1 = new Commit("File structure set up", 233);
        commit2 = new Commit("Create card class", 256);
        commit3 = new Commit("Create player class", 288);
    }

    @Test
    public void can_add_commit(){
        repository.getCommits().add(commit1);
        repository.getCommits().add(commit2);
        assertEquals(2, repository.getCommits().size());
    }

    @Test
    public void can_get_commit_by_uniqueId(){
        repository.getCommits().add(commit1);
        repository.getCommits().add(commit2);
        assertEquals(commit1, repository.findCommitById(233));
    }

    @Test
    public void can_revert_repo_to_given_commit(){
        ArrayList<Commit> commitsRevertedToCommit2 = new ArrayList<Commit>();
        commitsRevertedToCommit2.add(commit1);
        commitsRevertedToCommit2.add(commit2);
        repository.getCommits().add(commit1);
        repository.getCommits().add(commit2);
        repository.getCommits().add(commit3);
        assertEquals(commitsRevertedToCommit2, repository.revert(256));
    }

}
