package edu.bsu.cs222;

import edu.bsu.cs222.WikiUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void UserInput(){
        WikiUser wikiUser = new WikiUser();
        String input = "hockey";
        String output = wikiUser.UserInput2(input);
        Assertions.assertEquals(input,output);
        System.out.println(output);
    }

}
