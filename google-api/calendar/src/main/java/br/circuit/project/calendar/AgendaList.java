package br.circuit.project.calendar;



import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

import java.io.IOException;
import java.util.List;

public class AgendaList {

    public static void main(String[] args) throws IOException {
        Calendar calendarService = Quickstart.getCalendarService();

        CalendarList calendarList = calendarService.calendarList().list().setPageToken(null).execute();
        List<CalendarListEntry> items = calendarList.getItems();

        for (CalendarListEntry calendarListEntry : items) {
            String id = calendarListEntry.getId();
            System.out.println(calendarListEntry.getSummary());
        }
    }
}
