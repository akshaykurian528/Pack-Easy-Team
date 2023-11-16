package com.example.pack_easy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.VideoView;
import com.bumptech.glide.Glide;
import com.example.pack_easy.R;




import com.example.pack_easy.databinding.ReminderBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class Reminder extends AppCompatActivity {

    private ReminderBinding binding;
    private MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rmenu, menu);
        return true;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ReminderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();
        getSupportActionBar().setTitle("Reminder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        binding.selectedTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showTimePicker();

            }
        });

        binding.selectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePicker();

            }
        });


        binding.setAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm();

            }
        });

        binding.dismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                cancelAlarm();

            }
        });



        ImageView gifImageView = findViewById(R.id.gifImageView);
        Glide.with(this)
                .asGif()
                .load(R.drawable.alarm)
                .into(gifImageView);

    }



    private void cancelAlarm() {

        Intent intent = new Intent(this, AlarmReciever.class);

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        if(alarmManager == null){

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }

        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm cancelled", Toast.LENGTH_SHORT).show();

    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReciever.class);

        if (calendar == null || binding.selectedTime.getText().toString().isEmpty() || binding.selectedDate.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please select both date and time for the alarm.", Toast.LENGTH_SHORT).show();
            return;
        }

        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        // Get the current time
        Calendar now = Calendar.getInstance();

        if (calendar.before(now)) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }


        calendar.add(Calendar.HOUR_OF_DAY, -1);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, "Alarm set successfully, you will be notified 1 hour before you leave from home", Toast.LENGTH_LONG).show();
    }




    private void showTimePicker() {
        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        picker.show(getSupportFragmentManager(), "foxandroid");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar selectedTime = Calendar.getInstance();
                selectedTime.set(Calendar.HOUR_OF_DAY, picker.getHour());
                selectedTime.set(Calendar.MINUTE, picker.getMinute());

                if (calendar == null) {
                    Toast.makeText(Reminder.this, "Please select a date first.", Toast.LENGTH_SHORT).show();
                } else {
                    Calendar now = Calendar.getInstance();


                    if (calendar.get(Calendar.YEAR) == now.get(Calendar.YEAR) &&
                            calendar.get(Calendar.MONTH) == now.get(Calendar.MONTH) &&
                            calendar.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH)) {

                        now.add(Calendar.HOUR_OF_DAY, 1);

                        if (selectedTime.after(now)) {
                            // Time is at least 1 hour in the future
                            setTimeAndCalendar(selectedTime);
                        } else {
                            Toast.makeText(Reminder.this, "Please select a time at least 1 hour in the future.", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        setTimeAndCalendar(selectedTime);
                    }
                }
            }
        });
    }


    private void setTimeAndCalendar(Calendar selectedTime) {
        if (picker.getHour() > 12) {
            binding.selectedTime.setText(
                    String.format("%02d", (picker.getHour() - 12)) + " : " + String.format("%02d", picker.getMinute()) + " PM"
            );
        } else {
            binding.selectedTime.setText(picker.getHour() + " : " + picker.getMinute() + " AM");
        }

        calendar.set(Calendar.HOUR_OF_DAY, picker.getHour());
        calendar.set(Calendar.MINUTE, picker.getMinute());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }




    private void showDatePicker() {

        if (calendar == null) {
            calendar = Calendar.getInstance();
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                Calendar now = Calendar.getInstance();


                if (selectedDate.before(now)) {
                    Toast.makeText(Reminder.this, "Please select a future date.", Toast.LENGTH_SHORT).show();
                    return; // Don't update the calendar or UI
                }


                String formattedDate = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year);


                binding.selectedDate.setText(formattedDate);


                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }





    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "foxandroidReminderChannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("foxandroid",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }
}