package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team team3;
    Team team2;
    Team team4;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
        team2 = new Team("not-real");
        team3 = new Team("test-team");
        team4 = new Team("n");

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
    public void equals_all_fields(){ //no fine
        team4.addMember("te");
        assert(!(team.equals(team4)));
    }

    @Test
    public void bothEquals(){ // both fine
        team.addMember("t");
        team3.addMember("t");
        assert(team.equals(team3));
    }

    @Test
    public void oneFalse(){ //same name not member
        team3.addMember("t");
        assert(!(team.equals(team3)));
        assert(!(team.equals("test")));
    }

    @Test
    public void lastOne(){ //same member not name
        team2.addMember("te");
        team4.addMember("te");
        assert(!(team2.equals(team4)));
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
