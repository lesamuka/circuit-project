package br.circuit.project.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class InsertEvent {

    public static void main(String[] args) throws IOException {
        Calendar calendarService = Quickstart.getCalendarService();

        String CALENDAR_ID = "cu4f5tvqcf3jn8dr39kgdk1nb8@group.calendar.google.com";

        Event event = new Event()
                .setSummary("Google I/O 2015")
                //.setLocation("800 Howard St., San Francisco, CA 94103")
                .setDescription("A chance to hear more about Google's developer products.");

//        DateTime startDateTime = new DateTime("2017-12-13T00:00:00-00:00");
        
        DateTime startDateTime = new DateTime(new Date());
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/Sao_Paulo");
        event.setStart(start);

//        DateTime endDateTime = new DateTime("2017-12-13T00:00:00-00:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/Sao_Paulo");
        event.setEnd(end);

//        String[] recurrence = new String[]{"RRULE:FREQ=DAILY;COUNT=2"};
//        event.setRecurrence(Arrays.asList(recurrence));
//
//        EventAttendee[] attendees = new EventAttendee[]{
//            new EventAttendee().setEmail("lpage@example.com"),
//            new EventAttendee().setEmail("sbrin@example.com"),};
//        event.setAttendees(Arrays.asList(attendees));
        
//        EventReminder[] reminderOverrides = new EventReminder[]{ new EventReminder().setMethod("email").setMinutes(24 * 60), new EventReminder().setMethod("popup").setMinutes(10),};
//        Event.Reminders reminders = new Event.Reminders().setUseDefault(false).setOverrides(Arrays.asList(reminderOverrides));
//        event.setReminders(reminders);
        event = calendarService.events().insert(CALENDAR_ID, event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());
    }
}
