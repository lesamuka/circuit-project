package br.circuit.project.calendar;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import java.io.IOException;
import java.util.List;

public class EventoList {

    public static void main(String[] args) throws IOException {
        Calendar calendarService = Quickstart.getCalendarService();

        String CALENDAR_ID  = "cu4f5tvqcf3jn8dr39kgdk1nb8@group.calendar.google.com";
        Events events = calendarService.events().list(CALENDAR_ID).setPageToken(null).execute();

        List<Event> items = events.getItems();
        for (Event event : items) {
            System.out.println(event.getSummary());
            System.out.println(event.getStart());
        }
    }
}
