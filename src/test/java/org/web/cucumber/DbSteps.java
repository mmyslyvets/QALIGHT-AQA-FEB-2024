package org.web.cucumber;

import io.cucumber.java.en.Given;
import org.collections.web.dto.PersonDto;
import org.collections.web.util.CucumberContainer;

import static org.testng.Assert.assertNotNull;

public class DbSteps {

    @Given("I pick a random person from DB as {string}")
    public void pickRandomPerson(String alias){
        PersonDto randomPerson = PersonDto.getRandomPersonFromDB();
        assertNotNull(randomPerson, "Failed to extract random person from DB");

        CucumberContainer.map.put(alias,
                randomPerson.getName().getFirst() + " " + randomPerson.getName().getLast());
    }
}
