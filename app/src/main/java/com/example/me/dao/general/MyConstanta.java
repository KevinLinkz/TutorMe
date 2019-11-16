package com.example.me.dao.general;

import android.content.Context;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyConstanta {
    public static List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
    public static int intIDEvent = 1;
    public static boolean isParent = false;

    public MyConstanta(Context context, int newYear, int newMonth) {
        BasicActivity.intRepeat = 0;
        init(context, newYear, newMonth);
    }

    public static void add(Context context, int newYear, int newMonth, int newDay,
                           int hourStart, int minuteStart,
                           int hourEnd, int minuteEnd, int eventColor,
                           String strTutor, int intTypeRepeat) {


        BasicActivity.intRepeat = 0;
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = (Calendar) startTime.clone();
        WeekViewEvent event;
        int intCountDate = 0;

        switch (intTypeRepeat) {
            case 0:
                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hourStart);
                startTime.set(Calendar.MINUTE, minuteStart);
                startTime.set(Calendar.YEAR, newYear);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.DAY_OF_MONTH, newDay);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, hourEnd);
                endTime.set(Calendar.MINUTE, minuteEnd);
                endTime.set(Calendar.MONTH, newMonth - 1);
                endTime.set(Calendar.YEAR, newYear);
                event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, strTutor, "Kevin Hertanto"), startTime, endTime);
                event.setColor(eventColor);
                events.add(event);
                intIDEvent++;
                break;
            case 1:

                for (int i = 0; i < 4; i++) {

                    startTime = Calendar.getInstance();
                    startTime.set(Calendar.HOUR_OF_DAY, hourStart);
                    startTime.set(Calendar.MINUTE, minuteStart);
                    startTime.set(Calendar.DAY_OF_MONTH, newDay);
                    endTime = (Calendar) startTime.clone();
                    endTime.set(Calendar.HOUR_OF_DAY, hourEnd);
                    endTime.set(Calendar.MINUTE, minuteEnd);
                    event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, strTutor, "Kevin Hertanto"), startTime, endTime);
                    event.setColor(eventColor);
                    events.add(event);
                    intIDEvent++;
                    newDay += 7;
                }
                break;
            case 2:

                for (int i = 0; i < 12; i++) {

                    startTime = Calendar.getInstance();
                    startTime.set(Calendar.HOUR_OF_DAY, hourStart);
                    startTime.set(Calendar.MINUTE, minuteStart);
                    startTime.set(Calendar.DAY_OF_MONTH, newDay);
                    endTime = (Calendar) startTime.clone();
                    endTime.set(Calendar.HOUR_OF_DAY, hourEnd);
                    endTime.set(Calendar.MINUTE, minuteEnd);
                    event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, strTutor, "Kevin Hertanto"), startTime, endTime);
                    event.setColor(eventColor);
                    events.add(event);
                    intIDEvent++;
                    newDay += 7;
                }
                break;


        }


    }

    public void init(Context context, int newYear, int newMonth) {
        if (events.size() == 0) {

            if (MyConstanta.isParent) {
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 13);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                WeekViewEvent event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, "Vocal", "My Son"), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_04));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 7);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, "English", "My Son"), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 13);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 2);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitleAdd(startTime, "Vocal", "My Son"), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_04));
                events.add(event);
                intIDEvent++;

            } else {


                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 13);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                WeekViewEvent event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 15);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 16);
                endTime.set(Calendar.MINUTE, 30);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;


                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 7);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                //KUNING
                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 17);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 19);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 1);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 17);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 2);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 3);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 17);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 14);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 2);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 1);
                startTime.set(Calendar.HOUR_OF_DAY, 13);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 4);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 13);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, -1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 1);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

//            startTime = Calendar.getInstance();
//            startTime.set(Calendar.HOUR_OF_DAY, 13);
//            startTime.set(Calendar.MINUTE, 0);
//            startTime.set(Calendar.MONTH, newMonth - 1);
//            startTime.set(Calendar.YEAR, newYear);
//            startTime.add(Calendar.DATE, 1);
//            endTime = (Calendar) startTime.clone();
//            endTime.add(Calendar.HOUR, 1);
//            endTime.set(Calendar.MONTH, newMonth - 1);
//            event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
//            event.setColor(context.getResources().getColor(R.color.event_color_04));
//            events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 19);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_04));
                events.add(event);
                intIDEvent++;

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
                startTime.set(Calendar.HOUR_OF_DAY, 15);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(intIDEvent, getEventTitle(startTime), startTime, endTime);
                event.setColor(context.getResources().getColor(R.color.event_color_03));
                events.add(event);
                intIDEvent++;

            }
        }

    }

    protected static String getEventTitle(Calendar time) {
        return String.format("Tutor on %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.DAY_OF_MONTH), time.get(Calendar.MONTH) + 1);
    }

    protected static String getEventTitleAdd(Calendar time, String strTutor, String strUser) {
        return String.format(strUser + " Booking " + strTutor + " on %02d:%02d at %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.DAY_OF_MONTH), time.get(Calendar.MONTH) + 1);
    }
}
