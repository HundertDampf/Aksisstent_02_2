package com.example.ims.aksisstent02.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ims.aksisstent02.R;
import com.example.ims.aksisstent02.objects.Lesson;
import com.example.ims.aksisstent02.objects.Timetable;
import com.example.ims.aksisstent02.services.FileMaker;
import com.example.ims.aksisstent02.services.TimetableDAO;
import com.example.ims.aksisstent02.services.XStreamer;

import java.util.List;

public class StuplaActivity extends AppCompatActivity {
    private String className;

    TextView[] monTextView = new TextView[12];
    TextView[] tueTextView = new TextView[12];
    TextView[] wenTextView = new TextView[12];
    TextView[] thuTextView = new TextView[12];
    TextView[] friTextView = new TextView[12];

    Button btnDay;
    TextView viewDetailsSubject;
    TextView viewDetailsTeacher;
    TextView viewDetailsRoom;

    Timetable tt;
    XStreamer streamer;
    FileMaker fileMaker;

    public StuplaActivity() {
        System.out.println("guggibuu");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stupla);

        streamer = new XStreamer();
        fileMaker = new FileMaker();

        className = streamer.fromXmlUser(fileMaker.getTimetableFromFile(MainActivity.mainContext, "user")).getKlasse();

        int[] monId = {R.id.mon1, R.id.mon2, R.id.mon3, R.id.mon4, R.id.mon5, R.id.mon6, R.id.mon7, R.id.mon8, R.id.mon9, R.id.mon10, R.id.mon11, R.id.mon12};
        int[] tueId = {R.id.tue1, R.id.tue2, R.id.tue3, R.id.tue4, R.id.tue5, R.id.tue6, R.id.tue7, R.id.tue8, R.id.tue9, R.id.tue10, R.id.tue11, R.id.tue12};
        int[] wenId = {R.id.wen1, R.id.wen2, R.id.wen3, R.id.wen4, R.id.wen5, R.id.wen6, R.id.wen7, R.id.wen8, R.id.wen9, R.id.wen10, R.id.wen11, R.id.wen12};
        int[] thuId = {R.id.thu1, R.id.thu2, R.id.thu3, R.id.thu4, R.id.thu5, R.id.thu6, R.id.thu7, R.id.thu8, R.id.thu9, R.id.thu10, R.id.thu11, R.id.thu12};
        int[] friId = {R.id.fri1, R.id.fri2, R.id.fri3, R.id.fri4, R.id.fri5, R.id.fri6, R.id.fri7, R.id.fri8, R.id.fri9, R.id.fri10, R.id.fri11, R.id.fri12};
        System.out.println(monId);

        btnDay = (Button) findViewById(R.id.btnDay);
        viewDetailsSubject = (TextView) findViewById(R.id.viewLessonSubject);
        viewDetailsTeacher = (TextView) findViewById(R.id.viewLessonTeacher);
        viewDetailsRoom = (TextView) findViewById(R.id.viewLessonRoom);

        for (int i = 0; i < 12; i++) {
            monTextView[i] = (TextView) findViewById(monId[i]);
            tueTextView[i] = (TextView) findViewById(tueId[i]);
            wenTextView[i] = (TextView) findViewById(wenId[i]);
            thuTextView[i] = (TextView) findViewById(thuId[i]);
            friTextView[i] = (TextView) findViewById(friId[i]);
        }

        tt = loadTt(className);


        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StuplaActivity.this, StuplaTagActivity.class)); //open Tagesansicht

            }
        });
        for (int i = 0; i < 12; i++) {
            if (monTextView[i].getText().toString() != "") {
                final int j = i;
                monTextView[i].setOnClickListener(new View.OnClickListener() {

                                                      @Override
                                                      public void onClick(View v) {
//                                                          viewDetails.getBackground().setAlpha(255);
                                                          viewDetailsSubject.setText(tt.getLessonMon().get(j).getSubject());
                                                          viewDetailsTeacher.setText(tt.getLessonMon().get(j).getTeacher());
                                                          viewDetailsRoom.setText(tt.getLessonMon().get(j).getRoom());
                                                      }
                                                  }
                );
            }

            if (tueTextView[i].getText().toString() != "") {
                final int j = i;
                tueTextView[i].setOnClickListener(new View.OnClickListener() {

                                                      @Override
                                                      public void onClick(View v) {
//                                                          viewDetails.getBackground().setAlpha(255);
                                                          viewDetailsSubject.setText(tt.getLessonTue().get(j).getSubject());
                                                          viewDetailsTeacher.setText(tt.getLessonTue().get(j).getTeacher());
                                                          viewDetailsRoom.setText(tt.getLessonTue().get(j).getRoom());
                                                      }
                                                  }
                );
            }

            if (wenTextView[i].getText().toString() != "") {
                final int j = i;
                wenTextView[i].setOnClickListener(new View.OnClickListener() {

                                                      @Override
                                                      public void onClick(View v) {
//                                                          viewDetails.getBackground().setAlpha(255);
                                                          viewDetailsSubject.setText(tt.getLessonWen().get(j).getSubject());
                                                          viewDetailsTeacher.setText(tt.getLessonWen().get(j).getTeacher());
                                                          viewDetailsRoom.setText(tt.getLessonWen().get(j).getRoom());
                                                      }
                                                  }
                );
            }

            if (thuTextView[i].getText().toString() != "") {
                final int j = i;
                thuTextView[i].setOnClickListener(new View.OnClickListener() {

                                                      @Override
                                                      public void onClick(View v) {
//                                                          viewDetails.getBackground().setAlpha(255);
                                                          viewDetailsSubject.setText(tt.getLessonThu().get(j).getSubject());
                                                          viewDetailsTeacher.setText(tt.getLessonThu().get(j).getTeacher());
                                                          viewDetailsRoom.setText(tt.getLessonThu().get(j).getRoom());
                                                      }
                                                  }
                );
            }

            if (friTextView[i].getText().toString() != "") {
                final int j = i;
                friTextView[i].setOnClickListener(new View.OnClickListener() {

                                                      @Override
                                                      public void onClick(View v) {
//                                                          viewDetails.getBackground().setAlpha(255);
                                                          viewDetailsSubject.setText(tt.getLessonFri().get(j).getSubject());
                                                          viewDetailsTeacher.setText(tt.getLessonFri().get(j).getTeacher());
                                                          viewDetailsRoom.setText(tt.getLessonFri().get(j).getRoom());
                                                      }
                                                  }
                );
            }
        }
    }


    public Timetable loadTt(String className) {
        Timetable timetable;
        TimetableDAO timeDao = new TimetableDAO();
        timetable = timeDao.getTimetable(className, MainActivity.mainContext);

        List<Lesson> lessonMon = timetable.getLessonMon();
        List<Lesson> lessonTue = timetable.getLessonTue();
        List<Lesson> lessonWen = timetable.getLessonWen();
        List<Lesson> lessonThu = timetable.getLessonThu();
        List<Lesson> lessonFri = timetable.getLessonFri();

        for (int i = 0; i < 12; i++) {
            monTextView[i].setText(getSafeSubject(lessonMon, i));
            tueTextView[i].setText(getSafeSubject(lessonTue, i));
            wenTextView[i].setText(getSafeSubject(lessonWen, i));
            thuTextView[i].setText(getSafeSubject(lessonThu, i));
            friTextView[i].setText(getSafeSubject(lessonFri, i));

        }
        return timetable;
    }

    private String getSafeSubject(List<Lesson> lesson, int index) {
        if (lesson.size() > index) {
            if (lesson.get(index) != null) {
                return lesson.get(index).getSubject();
            }
        }
        return "";
    }
}
