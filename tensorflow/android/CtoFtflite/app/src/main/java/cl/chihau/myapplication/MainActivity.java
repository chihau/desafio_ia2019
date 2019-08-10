package cl.chihau.myapplication;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static MappedByteBuffer loadModelFile(AssetManager assets, String modelFilename)
            throws IOException {
        AssetFileDescriptor fileDescriptor = assets.openFd(modelFilename);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public void convertir(View view) {
        try {
            EditText etC = findViewById(R.id.etC);
            TextView tvF = findViewById(R.id.tvF);

            float celsius = 0;

            if (etC.getText().toString().length() > 0) {
                celsius = Float.valueOf(etC.getText().toString());
            } else {
                etC.setText("0");
            }

            Interpreter tflite = new Interpreter(loadModelFile(getAssets(), "my_model.tflite"));
            float[] in = {celsius};
            float[][] out = new float[1][1];
            tflite.run(in, out);

            tvF.setText(String.valueOf(out[0][0]));
            Log.d("CtoF", "out: " + out[0][0]);
        } catch (IOException e) {
            Log.e("CtoF", "Error: " + e.getMessage());
        }
    }


}
