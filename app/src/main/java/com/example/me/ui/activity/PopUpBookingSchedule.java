package com.example.me.ui.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;
import com.example.me.dao.calendar.DatePickerFragment;
import com.example.me.dao.calendar.MyEvent;
import com.example.me.dao.calendar.TimePickerFragment;
import com.example.me.dao.general.MyConstanta;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PopUpBookingSchedule extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private String strCallback = "";
    private final DialogFragment dialogTimeFragment = new TimePickerFragment();
    private final DialogFragment dialogDateFragment = new DatePickerFragment();
    private String hourStart = "";
    private String minuteStart = "";
    private String hourEnd = "";
    private String minuteEnd = "";
    private int day = 0;
    private int month = 0;
    private int year = 0;
    private int intAmount = 0;
    private final Bundle args = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_booking_schedule);

        //GET EXTRA
        Bundle bundle = getIntent().getExtras();

        final MyEvent myEvent = getIntent().getParcelableExtra("MyEvent");

        final TextView lblTitle = findViewById(R.id.lblCreateEvent);
        final TextInputEditText txtDate = findViewById(R.id.txtDate);
        final TextInputEditText txtStartTime = findViewById(R.id.txtStartTime);
        final TextInputEditText txtEndTime = findViewById(R.id.txtEndTime);
        final TextInputEditText txtLocation = findViewById(R.id.txtLocation);
        final Button btnPay = findViewById(R.id.btnPay);
        final Button btnReschedule = findViewById(R.id.btnReschedule);
        final Button btnCancel = findViewById(R.id.btnCancel);
        final Spinner spnType = findViewById(R.id.spnType);
        final Spinner spnTypeTutor = findViewById(R.id.spnTypeTutor);
        final Spinner spnTypeRepeat = findViewById(R.id.spnTypeRepeat);
        final TextView lblType = findViewById(R.id.lblType);
        final TextView lblPrice = findViewById(R.id.lblPrice);
        final TextView lblTypeTutor = findViewById(R.id.lblTypeTutor);
        final TextView lblTypeRepeat = findViewById(R.id.lblTypeRepeat);

        String strAction = bundle.getString("Action");
        hourStart = bundle.getString("HoursStart");
        minuteStart = "00";
//        minuteStart = bundle.getString("MinuteStart");
        hourEnd = bundle.getString("HoursEnd");
        minuteEnd = "00";
//        minuteEnd = bundle.getString("MinuteEnd");
        day = bundle.getInt("Day");
        month = bundle.getInt("Month");
        year = bundle.getInt("Year");
        txtDate.setText(bundle.getInt("Day") + "-" + bundle.getInt("Month") + "-" + bundle.getInt("Year"));
        txtStartTime.setText(hourStart + ":" + minuteStart);
        txtEndTime.setText(hourEnd + ":" + minuteEnd);

        //POP UP
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        if (strAction.equalsIgnoreCase("View")) {
            getWindow().setLayout((int) (width * 0.8), (int) (height * 0.45));

            txtLocation.setText("BCA Learning Institute, Sentul City, West Java");
            lblTitle.setText("View Event");
            txtDate.setEnabled(false);
            txtStartTime.setEnabled(false);
            txtEndTime.setEnabled(false);
            txtLocation.setEnabled(false);

            lblType.setVisibility(View.GONE);
            lblTypeTutor.setVisibility(View.GONE);
            lblTypeRepeat.setVisibility(View.GONE);
            lblPrice.setVisibility(View.GONE);
            spnType.setVisibility(View.GONE);
            spnTypeTutor.setVisibility(View.GONE);
            spnTypeRepeat.setVisibility(View.GONE);
            btnPay.setVisibility(View.GONE);
            btnReschedule.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);

        } else {
            btnPay.setVisibility((strAction.equalsIgnoreCase("Reschedule")) ? View.INVISIBLE : View.VISIBLE);
            btnReschedule.setVisibility((strAction.equalsIgnoreCase("Booking")) ? View.INVISIBLE : View.VISIBLE);
            lblTitle.setText((strAction.equalsIgnoreCase("Reschedule")) ? "Reschedule" : "Booking");

        }

        //BUTTON
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempDate[] = txtDate.getText().toString().split("-");
                String tempStartTime[] = txtStartTime.getText().toString().split(":");
                String tempEndTime[] = txtEndTime.getText().toString().split(":");
                int intDay = Integer.parseInt(tempDate[0]);
                int intMonth = Integer.parseInt(tempDate[1]);
                int intYear = Integer.parseInt(tempDate[2]);
                int intStartHourTime = Integer.parseInt(tempStartTime[0]);
                int intStartMinuteTime = Integer.parseInt(tempStartTime[1]);
                int intEndHourTime = Integer.parseInt(tempEndTime[0]);
                int intEndMinuteTime = Integer.parseInt(tempEndTime[1]);
                MyConstanta.add(PopUpBookingSchedule.this,
                        intYear, intMonth, intDay, intStartHourTime,
                        intStartMinuteTime, intEndHourTime, intEndMinuteTime,
                        getApplicationContext().getResources().getColor(R.color.event_color_04),
                        String.valueOf(spnTypeTutor.getSelectedItem()),
                        spnTypeRepeat.getSelectedItemPosition());
                finish();
//                Intent i = new Intent(PopUpBookingSchedule.this, PinWallet.class);
                Intent i = new Intent(PopUpBookingSchedule.this, Receipt.class)
                        .putExtra("Type", String.valueOf(spnType.getSelectedItem()))
                        .putExtra("Subject", String.valueOf(spnTypeTutor.getSelectedItem()))
                        .putExtra("Repeat", String.valueOf(spnTypeRepeat.getSelectedItem()))
                        .putExtra("Price", NumberFormatIndonesia(intAmount) + ",00")
                        .putExtra("Date", txtDate.getText().toString())
                        .putExtra("Time", txtStartTime.getText() + " - " + txtEndTime.getText())
                        .putExtra("Location", txtLocation.getText().toString())
                        .putExtra("Total", Calculation(intAmount));
                startActivity(i);
            }
        });

        btnReschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeekViewEvent viewEvent = new WeekViewEvent(myEvent.getId(), myEvent.getName(), myEvent.getStartTime(), myEvent.getEndTime());
                MyConstanta.events.remove(viewEvent);

                String tempDate[] = txtDate.getText().toString().split("-");
                String tempStartTime[] = txtStartTime.getText().toString().split(":");
                String tempEndTime[] = txtEndTime.getText().toString().split(":");
                int intDay = Integer.parseInt(tempDate[0]);
                int intMonth = Integer.parseInt(tempDate[1]);
                int intYear = Integer.parseInt(tempDate[2]);
                int intStartHourTime = Integer.parseInt(tempStartTime[0]);
                int intStartMinuteTime = Integer.parseInt(tempStartTime[1]);
                int intEndHourTime = Integer.parseInt(tempEndTime[0]);
                int intEndMinuteTime = Integer.parseInt(tempEndTime[1]);
                MyConstanta.add(PopUpBookingSchedule.this,
                        intYear, intMonth, intDay, intStartHourTime,
                        intStartMinuteTime, intEndHourTime, intEndMinuteTime,
                        myEvent.getColor(),
                        String.valueOf(spnTypeTutor.getSelectedItem()),
                        spnTypeRepeat.getSelectedItemPosition());
                Toast.makeText(getApplicationContext(), "Reshcedule Sucessfull", Toast.LENGTH_SHORT).show();

                finish();
                Intent i = new Intent(PopUpBookingSchedule.this, BasicActivity.class);
                startActivity(i);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //TextView
        txtDate.setInputType(InputType.TYPE_NULL);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putInt("Day", day);
                args.putInt("Month", month);
                args.putInt("Year", year);
                dialogDateFragment.setArguments(args);
                dialogDateFragment.show(getSupportFragmentManager(), "date picker");

            }
        });
        txtStartTime.setInputType(InputType.TYPE_NULL);
        txtStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCallback = "Start Time";
                args.putInt("Hour", Integer.parseInt(hourStart));
                args.putInt("Minute", Integer.parseInt(minuteStart));
                dialogTimeFragment.setArguments(args);
                dialogTimeFragment.show(getSupportFragmentManager(), "time picker");


            }
        });
        txtEndTime.setInputType(InputType.TYPE_NULL);
        txtEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCallback = "Start Time";
                strCallback = "End Time";

                args.putInt("Hour", Integer.parseInt(hourEnd));
                args.putInt("Minute", Integer.parseInt(minuteEnd));
                dialogTimeFragment.setArguments(args);
                dialogTimeFragment.show(getSupportFragmentManager(), "time picker");
            }
        });

        txtLocation.setInputType(InputType.TYPE_NULL);
        txtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLocation.setText("BCA Learning Institute, Sentul City, West Java");
                Intent i = new Intent(PopUpBookingSchedule.this, GoogleMap.class);
                startActivity(i);
            }
        });

        //SPINER
        List<String> list = new ArrayList<String>();
        list.add("Trial");
        list.add("Book");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(dataAdapter);

        spnType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        lblPrice.setVisibility(View.GONE);
                        lblTypeRepeat.setVisibility(View.GONE);
                        spnTypeRepeat.setVisibility(View.GONE);
                        break;
                    case 1:
                        lblType.setVisibility(View.VISIBLE);
                        spnType.setVisibility(View.VISIBLE);
                        lblTypeTutor.setVisibility(View.VISIBLE);
                        spnTypeTutor.setVisibility(View.VISIBLE);
                        lblPrice.setVisibility(View.VISIBLE);
                        lblTypeRepeat.setVisibility(View.VISIBLE);
                        spnTypeRepeat.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        list = new ArrayList<String>();
        list.add("English");
        list.add("Math");
        list.add("Vocal");
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTypeTutor.setAdapter(dataAdapter);

        spnTypeTutor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        intAmount = 75000;
                        break;
                    case 1:
                        intAmount = 60000;
                        break;
                    case 2:
                        intAmount = 55000;
                        break;
                }

                lblPrice.setText("Price           =    " + Calculation(intAmount));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        list = new ArrayList<String>();
        list.add("No Repeat");
        list.add("Every Week");
//        list.add("Every Month");
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTypeRepeat.setAdapter(dataAdapter);
        spnTypeRepeat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblPrice.setText("Price           =    " + Calculation(intAmount));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (strCallback.equalsIgnoreCase("Start Time")) {
            TextInputEditText txtStartTime = findViewById(R.id.txtStartTime);
            txtStartTime.setText(String.format("%02d:%02d", hourOfDay, minute));
        } else if (strCallback.equalsIgnoreCase("End Time")) {
            TextInputEditText txtEndTime = findViewById(R.id.txtEndTime);
            txtEndTime.setText(String.format("%02d:%02d", hourOfDay, minute));

        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        TextInputEditText txtDate = findViewById(R.id.txtDate);
        txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
    }

    public String Calculation(int intAmount) {
        double dblCalculation = intAmount;
        Spinner spnTypeRepeat = findViewById(R.id.spnTypeRepeat);
        switch (spnTypeRepeat.getSelectedItemPosition()) {
            case 0:
                dblCalculation = intAmount * 1;
                break;
            case 1:
                dblCalculation = intAmount * 4;
                break;
            case 2:
                dblCalculation = intAmount * 12;
                break;

        }
        return NumberFormatIndonesia(dblCalculation);

    }

    public String NumberFormatIndonesia(double dblAmount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        return nf.format(dblAmount) ;
    }
}
