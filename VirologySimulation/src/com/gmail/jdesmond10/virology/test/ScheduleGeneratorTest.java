package com.gmail.jdesmond10.virology.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.gmail.jdesmond10.virology.data.EmptyScheduleGenerator;
import com.gmail.jdesmond10.virology.data.LectureScheduler;
import com.gmail.jdesmond10.virology.data.RandomSimulationStarter;
import com.gmail.jdesmond10.virology.main.Student;

import ec.util.MersenneTwisterFast;
import sim.engine.Schedule;

public class ScheduleGeneratorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEmptyScheduleGeneratorRuns() {
        // Simply tests if the generateNewSchedule function builds a scheduler
        // with at least one lecture.
        LectureScheduler l = new EmptyScheduleGenerator(
                new MersenneTwisterFast()).generateSchedule();

        assertTrue(l.getNumberOfLectures() > 0);
    }

    @Test
    public void testLectureSchedulerHandlesRegistration() {
        LectureScheduler l = new EmptyScheduleGenerator(
                new MersenneTwisterFast()).generateSchedule();

        for (int i = 100; i > 0; i--) {
            l.registerStudentForClasses(new Student());
        }
    }

    @Test
    public void testRandomSimulationStarter() {
        RandomSimulationStarter r = new RandomSimulationStarter(
                new MersenneTwisterFast(), new Schedule());
        r.init();
        assertFalse(r.getStudentList().isEmpty());
    }
}
