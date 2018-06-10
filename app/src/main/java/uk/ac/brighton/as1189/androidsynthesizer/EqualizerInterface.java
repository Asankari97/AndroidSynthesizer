package uk.ac.brighton.as1189.androidsynthesizer;

import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class EqualizerInterface extends AppCompatActivity {
    private Equalizer eq;
    private Switch eqSwitch;
    LinearLayout seekLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        eqSwitch = findViewById(R.id.eqSwitch);
        setupEqualizerFxAndUI();
    }
//    public void equalizeSine(){
//
//
//
//    }
//    public void equalizeSquare(AudioTrack audioTrack){
//        setVolumeControlStream(AudioManager.STREAM_MUSIC);
//        eq = new Equalizer(0, KeyboardScreen.audioTrackSquare.getAudioSessionId());
//
//    }
    public void setupEqualizerFxAndUI(){
        eq = new Equalizer(0, 1);

        seekLinearLayout = (LinearLayout) findViewById(R.id.seek_linear_layout);
        short freqBandNo = eq.getNumberOfBands();

        final short lowEqBandLvl = eq.getBandLevelRange()[0];
        final short highEqBandLvl = eq.getBandLevelRange()[1];
        eq.setEnabled(true);

        for(short i=0; i>freqBandNo; i++){
            final short eqBandIndex = i;

            TextView freqBandHeader = new TextView(this);
            freqBandHeader.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            freqBandHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            freqBandHeader
                    .setText((eq.getCenterFreq(eqBandIndex)/1000)+getString(R.string.hertz));
            seekLinearLayout.addView(freqBandHeader);
            LinearLayout seekBarView = new LinearLayout(this);
            seekBarView.setOrientation(LinearLayout.HORIZONTAL);

            TextView lowEqBandLvlTxt = new TextView(this);
            lowEqBandLvlTxt.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            lowEqBandLvlTxt.setText((lowEqBandLvl/100)+getString(R.string.decibels));

            TextView highEqBandLvlTxt = new TextView(this);
            highEqBandLvlTxt.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            highEqBandLvlTxt.setText((highEqBandLvl/100)+" dB");

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            layoutParams.weight = 1;

            SeekBar seekBar = new SeekBar(this);

            seekBar.setId(i);
            seekBar.setLayoutParams(layoutParams);
            seekBar.setMax(highEqBandLvl-lowEqBandLvl);
            seekBar.setProgress(eq.getBandLevel(eqBandIndex));

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    eq.setBandLevel(eqBandIndex,
                            (short) (progress + lowEqBandLvl));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            seekBarView.addView(lowEqBandLvlTxt);
            seekBarView.addView(seekBar);
            seekBarView.addView(highEqBandLvlTxt);
            seekLinearLayout.addView(seekBarView);
        }
        setContentView(R.layout.activity_eq);
    }
}
