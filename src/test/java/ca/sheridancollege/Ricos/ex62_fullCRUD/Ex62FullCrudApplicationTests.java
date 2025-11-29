package ca.sheridancollege.Ricos.ex62_fullCRUD;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import ca.sheridancollege.Ricos.ex62_fullCRUD.beans.Appointment;
import ca.sheridancollege.Ricos.ex62_fullCRUD.controllers.AppointmentController;
import ca.sheridancollege.Ricos.ex62_fullCRUD.database.DatabaseAccess;

@SpringBootTest
public class Ex62FullCrudApplicationTests{

    @Autowired
    private AppointmentController controller;

    @Autowired
    private DatabaseAccess da;

    /*
      @Test
    void testInsertNewAppointment() {

        Appointment appt = new Appointment();
        appt.setAppointmentId(10L);
        appt.setFirstName("Alice");
        appt.setEmail("alice@example.com");
        appt.setAppointmentDate(LocalDate.now());
        appt.setAppointmentTime(LocalTime.of(9, 30));

        Model model = new ConcurrentModel();

        controller.insertAppointment(model, appt);

        var list = da.getAppointmentListById(10L);

        assertEquals(1, list.size());
        assertEquals("Alice", list.get(0).getFirstName());
        assertEquals("alice@example.com", list.get(0).getEmail());
    }

    // ---------------------------------------------------------------------
    // FUNCTIONAL TEST #2 - Update Existing Appointment
    // ---------------------------------------------------------------------
    @Test
    void testUpdateExistingAppointment() {

        // Insert initial record
        Appointment orig = new Appointment();
        orig.setAppointmentId(20L);
        orig.setFirstName("Original");
        orig.setEmail("orig@example.com");
        orig.setAppointmentDate(LocalDate.now());
        orig.setAppointmentTime(LocalTime.of(10, 0));

        da.insertAppointment(orig);

        // Prepare updated record
        Appointment updated = new Appointment();
        updated.setAppointmentId(20L);
        updated.setFirstName("Updated");
        updated.setEmail("new@example.com");
        updated.setAppointmentDate(LocalDate.now());
        updated.setAppointmentTime(LocalTime.of(11, 15));

        Model model = new ConcurrentModel();

        controller.insertAppointment(model, updated);

        var list = da.getAppointmentListById(20L);

        assertEquals(1, list.size());
        assertEquals("Updated", list.get(0).getFirstName());
        assertEquals("new@example.com", list.get(0).getEmail());
    }

    
    */
    // ---------------------------------------------------------------------
    // FUNCTIONAL TEST #1 - Insert New Appointment
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // NON-FUNCTIONAL TEST - Index loads under 200 ms
    // ---------------------------------------------------------------------
    @Test
    void testIndexLoadsFast() {

        Model model = new ConcurrentModel();

        long start = System.currentTimeMillis();
        controller.index(model);
        long duration = System.currentTimeMillis() - start;

        assertTrue(duration < 200,
            "index() took too long: " + duration + "ms");
    }

    // ---------------------------------------------------------------------
    // SMOKE TEST #1 - Context Loads
    // ---------------------------------------------------------------------
    @Test
    void testContextLoads() {
        assertNotNull(controller);
    }

    // ---------------------------------------------------------------------
    // SMOKE TEST #2 - index() returns correct view name
    // ---------------------------------------------------------------------
    @Test
    void testIndexReturnsCorrectView() {
        Model model = new ConcurrentModel(); //Model is the object Spring MVC uses to pass data to the HTML page (Thymeleaf). concurrent model stores data into model
        String view = controller.index(model);
        assertEquals("index", view);
    }
}
