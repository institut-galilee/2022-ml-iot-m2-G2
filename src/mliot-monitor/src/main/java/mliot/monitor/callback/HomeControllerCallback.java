package mliot.monitor.callback;

import mliot.monitor.model.Student;

public interface HomeControllerCallback {
    void onStudentRequested(Student student);
}
