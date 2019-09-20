package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {

    @Test
    public void guest_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 1, 3);

        assertThat(match.getGuestGoals(), is(3));
        assertThat(match.getHomeGoals(), is(0));
    }

    @Test
    public void home_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        assertThat(match.getGuestGoals(), is(0));
        assertThat(match.getHomeGoals(), is(3));
    }

    @Test
    public void draw() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 2, 2);

        assertThat(match.getGuestGoals(), is(1));
        assertThat(match.getHomeGoals(), is(1));
    }
}