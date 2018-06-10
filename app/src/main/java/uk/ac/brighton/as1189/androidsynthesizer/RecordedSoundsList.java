package uk.ac.brighton.as1189.androidsynthesizer;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 28/03/2018.
 */

public class RecordedSoundsList extends ListActivity {
    public ListView recordedSoundListView;
    MotionEvent mo;

    List<MotionEvent> recordedSoundList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorded_sounds);
        recordedSoundListView = findViewById(R.id.recordedSoundList);
        recordedSoundList = new ArrayList<>();
        recordedSoundList.add(mo);
        ArrayAdapter<MotionEvent> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                recordedSoundList);

    }
}
