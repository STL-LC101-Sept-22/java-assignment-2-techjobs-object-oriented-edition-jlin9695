package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getName(),"Product tester");
        assertEquals(job1.getEmployer().getName(),"ACME");
        assertEquals(job1.getLocation().getValue(),"Desert");
        assertEquals(job1.getPositionType().getValue(),"Quality control");
        assertEquals(job1.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job2.equals(job1));
        //System.out.println(equals);
    }



    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String description = job1.toString();
        assertEquals(description.charAt(0),'\n');
        assertEquals(description.charAt(description.length()-1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String description = job1.toString();
        /*System.out.println(description.length());
        System.out.println(description.indexOf('P'));
        System.out.println(description.indexOf('A'));
        System.out.println(description.indexOf("Desert"));
        System.out.println(description.indexOf('Q'));
        System.out.println(description.indexOf("Per"));*/
        assertEquals(description.charAt(5),'1');
        assertEquals(description.charAt(14), 'P');
        assertEquals(description.charAt(40),'A');
        assertEquals(description.charAt(56),'D');
        assertEquals(description.charAt(79),'Q');
        assertEquals(description.charAt(113),'P');

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Forest"), new PositionType("Quality control"),
                new CoreCompetency());
        String description = job1.toString();
        //System.out.println(description.indexOf("Data not available"));
        assertEquals(description.charAt(113),'D');
    }

    /*@Test
    public void testToStringHandlesAllEmptyFields(){
        Job job1 = new Job();
        String description = job1.toString();
        //System.out.println(description.indexOf("Data not available"));
        assertEquals(description,"OOPS! This job does not seem to exist.");
    }*/
}
