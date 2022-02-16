package mliot.monitor.model;

import mliot.monitor.generated.Severity;

public class Log {

    private String date;
    private Severity severity;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Log{" +
                "date='" + date + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
