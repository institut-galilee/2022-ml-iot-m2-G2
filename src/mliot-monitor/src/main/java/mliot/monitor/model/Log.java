package mliot.monitor.model;

public class Log {

    private long mills;
    private String severity;

    public long getMills() {
        return mills;
    }

    public void setMills(long mills) {
        this.mills = mills;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Log{" +
                "mills=" + mills +
                ", severity='" + severity + '\'' +
                '}';
    }
}
