package com.example.me.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.example.me.R;
import com.example.me.dao.calendar.MyEvent;
import com.example.me.dao.general.MyConstanta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class BookingSchedule extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener, WeekView.EmptyViewLongPressListener {
    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;
    private WeekView mWeekView;
    private MyConstanta myConstanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_schedule);

        // Get a reference for the week view in the layout.
        mWeekView = (WeekView) findViewById(R.id.weekView);

        // Show a toast message about the touched event.
        mWeekView.setOnEventClickListener(this);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);

        // Set long press listener for empty view
        mWeekView.setEmptyViewLongPressListener(this);

        //Init
        Calendar currentTime = Calendar.getInstance();
        myConstanta = new MyConstanta(this, currentTime.get(Calendar.YEAR), currentTime.get(Calendar.MONTH) + 1);


        // Set up a date time interpreter to interpret how the date and time will be formatted in
        // the week view. This is optional.
//        setupDateTimeInterpreter(false);

//        mWeekViewType = TYPE_DAY_VIEW;
//        mWeekView.setNumberOfVisibleDays(1);
//
//        // Lets change some dimensions to best fit the view.
//        mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
//        mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
//        mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
    }

    private void setupDateTimeInterpreter(final boolean shortDate) {
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                // All android api level do not have a standard way of getting the first letter of
                // the week day name. Hence we get the first char programmatically.
                // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
                if (shortDate)
                    weekday = String.valueOf(weekday.charAt(0));
                return weekday.toUpperCase() + format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(BookingSchedule.this, MainActivity.class);
        startActivity(i);

    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        return null;
    }


    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
        MyEvent myEvent = new MyEvent(event.getId(),event.getName(),event.getStartTime(),event.getEndTime());

        Intent i = new Intent(BookingSchedule.this, PopUpBookingSchedule.class);
        i.putExtra("Day", event.getStartTime().get(Calendar.DAY_OF_MONTH));
        i.putExtra("Month", event.getStartTime().get(Calendar.MONTH) + 1);
        i.putExtra("Year", event.getStartTime().get(Calendar.YEAR));
        i.putExtra("HoursStart",String.format("%02d",event.getStartTime().get(Calendar.HOUR_OF_DAY)));
        i.putExtra("MinuteStart",String.format("%02d",event.getStartTime().get(Calendar.MINUTE)));
        i.putExtra("HoursEnd",String.format("%02d",event.getEndTime().get(Calendar.HOUR_OF_DAY)));
        i.putExtra("MinuteEnd",String.format("%02d",event.getEndTime().get(Calendar.MINUTE)));
        i.putExtra("Action","View");
        i.putExtra("MyEvent",myEvent);

        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

        Toast.makeText(this, "Reschedule Event" , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
        MyEvent myEvent = new MyEvent(event.getId(),event.getName(),event.getStartTime(),event.getEndTime());
        myEvent.setColor(event.getColor());

        Intent i = new Intent(BookingSchedule.this, PopUpBookingSchedule.class);
        i.putExtra("Day", event.getStartTime().get(Calendar.DAY_OF_MONTH));
        i.putExtra("Month", event.getStartTime().get(Calendar.MONTH) + 1);
        i.putExtra("Year", event.getStartTime().get(Calendar.YEAR));
        i.putExtra("HoursStart",String.format("%02d",event.getStartTime().get(Calendar.HOUR_OF_DAY)));
        i.putExtra("MinuteStart",String.format("%02d",event.getStartTime().get(Calendar.MINUTE)));
        i.putExtra("HoursEnd",String.format("%02d",event.getEndTime().get(Calendar.HOUR_OF_DAY)));
        i.putExtra("MinuteEnd",String.format("%02d",event.getEndTime().get(Calendar.MINUTE)));
        i.putExtra("Action","Reschedule");
        i.putExtra("MyEvent",myEvent);

        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

        Toast.makeText(this, "Reschedule Event" , Toast.LENGTH_SHORT).show();

    }

    public WeekView getWeekView() {
        return mWeekView;
    }

    protected String getEventTitle(Calendar time) {
        return String.format("Tutor on %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH) + 1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onEmptyViewLongPress(Calendar time) {
        Intent i = new Intent(BookingSchedule.this, PopUpBookingSchedule.class);
        i.putExtra("Day", time.get(Calendar.DAY_OF_MONTH));
        i.putExtra("Month", time.get(Calendar.MONTH) + 1);
        i.putExtra("Year", time.get(Calendar.YEAR));
        i.putExtra("HoursStart",String.format("%02d",time.get(Calendar.HOUR_OF_DAY)));
        i.putExtra("MinuteStart",String.format("%02d",time.get(Calendar.MINUTE)));
        i.putExtra("HoursEnd",String.format("%02d",time.get(Calendar.HOUR_OF_DAY)+1));
        i.putExtra("MinuteEnd",String.format("%02d",time.get(Calendar.MINUTE)));
        i.putExtra("Action","Booking");


        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        Toast.makeText(this, "Create Event", Toast.LENGTH_SHORT).show();
    }

}
