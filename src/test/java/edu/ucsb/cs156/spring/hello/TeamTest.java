package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team team2;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
        team2 = new Team("not-real");

    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object(){
        assert(team.equals(team));
    }

    @Test
    public void equals_different_class(){
        assert(!(team.equals(null)));
    }

    @Test
    public void equals_all_fields(){
        assert(!(team.equals(team2)));
        assert(!(team.name.equals(team2.name)));

    }

    @Test
    public void hashCodeValue(){
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
