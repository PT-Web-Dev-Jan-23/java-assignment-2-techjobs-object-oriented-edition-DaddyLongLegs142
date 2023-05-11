package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job Job1 = new Job();
        Job Job2 = new Job();
        assertNotEquals(Job1, Job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(Job1.getEmployer() instanceof Employer);
        assertEquals("ACME", Job1.getEmployer().toString());
        assertTrue(Job1.getLocation() instanceof Location);
        assertEquals("Desert", Job1.getLocation().toString());
        assertTrue(Job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", Job1.getPositionType().toString());
        assertTrue(Job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", Job1.getCoreCompetency().toString());
        assertTrue(Job1.getName() instanceof String );
        assertEquals("Product tester", Job1.getName());
    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(Job1.toString().charAt(0), '\n');
        assertEquals(Job1.toString().charAt(Job1.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n", Job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job Job = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        assertEquals("\nID: 1\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n", Job.toString());
    }

}
