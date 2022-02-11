package mliot.sensors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.head).setOnClickListener(this);
        findViewById(R.id.hand).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.head) {
            startActivity(new Intent(this, HeadActivity.class));
        }
        if (view.getId() == R.id.hand) {
            startActivity(new Intent(this, HandActivity.class));
        }
    }
}