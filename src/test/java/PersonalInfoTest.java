/*
===================================
== edited by
== Saskia Wohlers
===================================
*/

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalInfoTest {

    @Test
    public void should_change_region() {

        //Given
        PersonalInfo personalinfo = new PersonalInfo("Super", "Chonk", new Date(1800, 12, 31), PersonalInfo.sex.uni, PersonalInfo.relationshipStatus.no_information);
        String newRegion = "Valhalla";

        //When
        personalinfo.changeRegion(newRegion);
        String result = personalinfo.getRegion();

        //Then
        assertEquals("Valhalla", result, "newregion should be Valhalla");
    }

    @Test  // needs probably boundaries like "taken" or something
    public void should_change_relationshipStatus() {

        //Given
        PersonalInfo personalinfo = new PersonalInfo("Super", "Chonk", new Date(1800, 12, 31), PersonalInfo.sex.uni, PersonalInfo.relationshipStatus.no_information);
        PersonalInfo.relationshipStatus newrelationshipStatus = PersonalInfo.relationshipStatus.taken;

        //When
        personalinfo.changeRelationshipStatus(newrelationshipStatus);
        PersonalInfo.relationshipStatus result = personalinfo.getRelationshipStatus();

        //Then
        assertEquals("taken", result, "RelationshipStatus should be taken");
    }

    @Test  // needs boundaries like max. letters or so
    public void should_change_occupation() {

        //Given
        PersonalInfo personalinfo = new PersonalInfo("Super", "Chonk", new Date(1800, 12, 31), PersonalInfo.sex.uni, PersonalInfo.relationshipStatus.no_information);
        String newoccupation = "Computer Scientist";

        //When
        personalinfo.changeOccupation(newoccupation);
        String result = personalinfo.getOccupation();

        //Then
        assertEquals("Computer Scientist", result, "Occupation should be Computer scientist");
    }

    @Test
    public void should_change_profilePicture() {

        //Given
        PersonalInfo personalinfo = new PersonalInfo("Super", "Chonk", new Date(1800, 12, 31), PersonalInfo.sex.uni, PersonalInfo.relationshipStatus.no_information);
        String newprofilePicture = "PiggyPicture";

        //When
        personalinfo.changeprofilePicture(newprofilePicture);
        String result = personalinfo.getProfilePicture();

        //Then
        assertEquals("PiggyPicture", result, "profilePicture should be PiggyPicture");
    }

}