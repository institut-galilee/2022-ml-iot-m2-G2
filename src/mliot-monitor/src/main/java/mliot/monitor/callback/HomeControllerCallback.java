package mliot.monitor.callback;

import com.google.gson.JsonObject;

public interface HomeControllerCallback {
    void onStudentRequested(JsonObject studentObject);
}
