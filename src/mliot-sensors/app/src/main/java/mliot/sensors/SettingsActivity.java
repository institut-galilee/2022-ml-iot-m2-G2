package mliot.sensors;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

import mliot.sensors.util.Prefs;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private EditText portEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        portEditText = findViewById(R.id.port);
        addressEditText = findViewById(R.id.address);

        portEditText.setOnEditorActionListener(this);
        findViewById(R.id.open).setOnClickListener(this);

        if (Prefs.getServerPort(this) >= 0) {
            portEditText.setText(String.valueOf(Prefs.getServerPort(this)));
        }

        if (StringUtils.isNotEmpty(Prefs.getServerAddress(this))) {
            addressEditText.setText(Prefs.getServerAddress(this));
        }
    }

    @Override
    public void onClick(View v) {
        save();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
            save();
            return true;
        }
        return false;
    }

    private void save() {
        String portRegex = "^((6553[0-5])|(655[0-2][0-9])|(65[0-4][0-9]{2})|(6[0-4][0-9]{3})|([1-5][0-9]{4})|([0-5]{0,5})|([0-9]{1,4}))$";
        if (!(Patterns.IP_ADDRESS.matcher(getServerAddress()).matches() || Patterns.DOMAIN_NAME.matcher(getServerAddress()).matches())) {
            portEditText.setError(null);
            addressEditText.setError(getString(R.string.settings_server_address_mandatory));
            addressEditText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
        } else if (!Pattern.compile(portRegex).matcher(getServerPort()).matches()) {
            addressEditText.setError(null);
            portEditText.setError(getString(R.string.settings_server_port_mandatory));
            portEditText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
        } else {
            Prefs.putServerAddress(this, getServerAddress());
            Prefs.putServerPort(this, Integer.parseInt(getServerPort()));
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }

    private String getServerPort() {
        return portEditText.getText().toString();
    }

    private String getServerAddress() {
        return addressEditText.getText().toString();
    }
}