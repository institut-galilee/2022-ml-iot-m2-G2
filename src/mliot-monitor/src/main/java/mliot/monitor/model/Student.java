package mliot.monitor.model;

import mliot.monitor.util.ColorHelper;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String cardNumber;

    private String address;
    private int portNumber;

    private String statusColor;

    List<Warning> warningLog;
    List<Report> reportLog;

    public Student() {

        this.statusColor = ColorHelper.COLOR_STUDENT_OFFLINE;

        this.warningLog = new ArrayList<>();
        this.reportLog = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public List<Warning> getWarningLog() {
        return this.warningLog;
    }

    public void addWarning(Warning warning) {
        this.warningLog.add(warning);
    }

    public List<Report> getReportLog() {
        return this.reportLog;
    }

    public void addReport(Report report) {
        this.reportLog.add(report);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", address='" + address + '\'' +
                ", portNumber=" + portNumber +
                ", statusColor='" + statusColor + '\'' +
                ", messageLog=" + warningLog +
                ", reportLog=" + reportLog +
                '}';
    }
}
