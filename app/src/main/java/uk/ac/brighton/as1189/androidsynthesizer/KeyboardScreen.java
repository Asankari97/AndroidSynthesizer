package uk.ac.brighton.as1189.androidsynthesizer;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class KeyboardScreen extends AppCompatActivity {

    View c2, c2sharp, d2, d2sharp, e2, f2, f2sharp, g2, g2sharp, a2, a2sharp, b2,
            c3, c3sharp, d3, d3sharp, e3, f3, f3sharp, g3, g3sharp, a3, a3sharp, b3,
            c4, c4sharp, d4, d4sharp, e4, f4, f4sharp, g4, g4sharp, a4, a4sharp, b4,
            c5, c5sharp, d5, d5sharp, e5, f5, f5sharp, g5, g5sharp, a5, a5sharp, b5;

    Switch sineSwitch, squareSwitch;

    static SeekBar toneDecay;

    public static int length = 2;

    private static int sampleRate = 8000;

    private static int sampleAmount = length * sampleRate;

    private static double[] sampleSine = new double[sampleAmount];

    private static double[] sampleSquare = new double[sampleAmount];

    private static double freqOfTone = 0;

    private static final byte[] generatedSine = new byte[2 * sampleAmount];

    private static final byte[] generatedSquare = new byte[2 * sampleAmount];

    public static AudioTrack audioTrackSine;

    public static AudioTrack audioTrackSquare;

    Button goToEq;

    static Vibrator vib;

    static boolean isSineActivited = false, isSquareActivited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_screen);
        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        sineSwitch = findViewById(R.id.sineSwitch);
        squareSwitch = findViewById(R.id.squareSwitch);
        toneDecay = findViewById(R.id.toneDecay);
        toneDecay.setMax(10);
        toneDecay.setProgress(2);

        toneDecay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                length = toneDecay.getProgress();
                Context context = getApplicationContext();

                String sampleRateText = "Decay: " + String.valueOf((length * 1000)) + " ms";

                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, sampleRateText, duration);
                toast.show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        goToEq = findViewById(R.id.goToEq);
        goToEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEqualizerActivity();
            }
        });
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        c2 = findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 65.41;
                genSine();
                playSine();
                genSquare();
                playSquare();


            }
        });
        c2sharp = findViewById(R.id.c2sharp);
        c2sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 69.30;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        d2 = findViewById(R.id.d2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 73.42;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        d2sharp = findViewById(R.id.d2sharp);
        d2sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 77.78;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        e2 = findViewById(R.id.e2);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 82.41;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        f2 = findViewById(R.id.f2);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 87.31;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        f2sharp = findViewById(R.id.f2sharp);
        f2sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 92.50;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        g2 = findViewById(R.id.g2);
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 98.00;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        g2sharp = findViewById(R.id.g2sharp);
        g2sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 103.83;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        a2 = findViewById(R.id.a2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 110.00;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        a2sharp = findViewById(R.id.a2sharp);
        a2sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 116.54;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 123.47;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        c3 = findViewById(R.id.c3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 130.81;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        c3sharp = findViewById(R.id.c3sharp);
        c3sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 138.59;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        d3 = findViewById(R.id.d3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 146.83;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        d3sharp = findViewById(R.id.d3sharp);
        d3sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 155.56;
                genSine();
                playSine();
                genSquare();
                playSquare();


            }
        });
        e3 = findViewById(R.id.e3);
        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 164.81;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        f3 = findViewById(R.id.f3);
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 174.61;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        f3sharp = findViewById(R.id.f3sharp);
        f3sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 185.00;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        g3 = findViewById(R.id.g3);
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 196.00;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        g3sharp = findViewById(R.id.g3sharp);
        g3sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 207.65;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        a3 = findViewById(R.id.a3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 220.00;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        a3sharp = findViewById(R.id.a3sharp);
        a3sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 233.08;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 246.94;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        c4 = findViewById(R.id.c4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 261.63;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        c4sharp = findViewById(R.id.c4sharp);
        c4sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 277.18;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        d4 = findViewById(R.id.d4);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 293.66;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        d4sharp = findViewById(R.id.d4sharp);
        d4sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 311.13;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        e4 = findViewById(R.id.e4);
        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 329.63;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        f4 = findViewById(R.id.f4);
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 349.23;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        f4sharp = findViewById(R.id.f4sharp);
        f4sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 369.99;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        g4 = findViewById(R.id.g4);
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 392.00;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        g4sharp = findViewById(R.id.g4sharp);
        g4sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 415.30;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        a4 = findViewById(R.id.a4);
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 440.00;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        a4sharp = findViewById(R.id.a4sharp);
        a4sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 466.16;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 493.88;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        c5 = findViewById(R.id.c5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 523.25;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        c5sharp = findViewById(R.id.c5sharp);
        c5sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 554.37;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        d5 = findViewById(R.id.d5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 587.33;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        d5sharp = findViewById(R.id.d5sharp);
        d5sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 622.25;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        e5 = findViewById(R.id.e5);
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 659.26;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        f5 = findViewById(R.id.f5);
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 698.46;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        f5sharp = findViewById(R.id.f5sharp);
        f5sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 739.99;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        g5 = findViewById(R.id.g5);
        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 783.99;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        g5sharp = findViewById(R.id.g5sharp);
        g5sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 830.61;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });
        a5 = findViewById(R.id.a5);
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 880.00;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        a5sharp = findViewById(R.id.a5sharp);
        a5sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 932.33;
                genSine();
                playSine();
                genSquare();
                playSquare();
            }
        });
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = 987.77;
                genSine();
                playSine();
                genSquare();
                playSquare();

            }
        });

        sineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isSineActivited = true;
                } else {
                    isSineActivited = false;
                }
            }
        });

        squareSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isSquareActivited = true;
                } else {
                    isSquareActivited = false;
                }
            }
        });
    }

    public void startEqualizerActivity() {
        Intent mIntent = new Intent(this, EqualizerInterface.class);
        startActivity(mIntent);
        finish();
    }

    public static void genSine() {
        if (isSineActivited) {
            for (int i = 0; i < sampleAmount; ++i) {
                sampleSine[i] = Math.sin(2 * Math.PI * i / (sampleRate / freqOfTone));
            }
            int idx = 0;
            for (final double dVal : sampleSine) {
                final short val = (short) ((dVal * 32767));
                generatedSine[idx++] = (byte) (val & 0x00ff);
                generatedSine[idx++] = (byte) ((val & 0xff00) >>> 8);

            }
        }
    }

    public static void playSine() {

        audioTrackSine = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat.CHANNEL_CONFIGURATION_STEREO,
                AudioFormat.ENCODING_PCM_16BIT, sampleAmount,
                AudioTrack.MODE_STATIC, 0);
        audioTrackSine.write(generatedSine, 0, sampleAmount);
        audioTrackSine.play();
        vib.vibrate(10);
        audioTrackSine.flush();
        audioTrackSine.stop();
        audioTrackSine.release();

    }

    static void genSquare() {
        if (isSquareActivited) {
            for (int i = 0; i < sampleAmount; ++i) {
                sampleSquare[i] = (0.5 * Math.signum(Math.sin(freqOfTone * 2 * Math.PI * i / sampleRate)));
            }
            int idx = 0;
            for (final double dVal : sampleSquare) {
                final short val = (short) ((dVal * 32767));
                generatedSquare[idx++] = (byte) (val & 0x00ff);
                generatedSquare[idx++] = (byte) ((val & 0xff00) >>> 8);

            }

        }
    }

    public static void playSquare() {
        new Thread(new Runnable() {
            public void run() {
                audioTrackSquare = new AudioTrack(AudioManager.STREAM_MUSIC,
                        sampleRate, AudioFormat.CHANNEL_CONFIGURATION_STEREO,
                        AudioFormat.ENCODING_PCM_16BIT, sampleAmount,
                        AudioTrack.MODE_STATIC, 1);
                audioTrackSquare.write(generatedSquare, 0, sampleAmount);
                audioTrackSquare.play();
                audioTrackSquare.flush();
                audioTrackSquare.stop();
                audioTrackSquare.release();
            }
        }).start();
    }

}