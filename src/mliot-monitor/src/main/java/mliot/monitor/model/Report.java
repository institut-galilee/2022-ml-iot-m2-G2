package mliot.monitor.model;

import java.util.List;

public class Report extends Log {

    private String recognizedText;
    private List<String> similarityReport;

    public String getRecognizedText() {
        return recognizedText;
    }

    public void setRecognizedText(String recognizedText) {
        this.recognizedText = recognizedText;
    }

    public List<String> getSimilarityReport() {
        return similarityReport;
    }

    public void setSimilarityReport(List<String> similarityReport) {
        this.similarityReport = similarityReport;
    }

    @Override
    public String toString() {
        return "Report{" +
                "recognizedText='" + recognizedText + '\'' +
                ", similarityReport=" + similarityReport +
                '}';
    }
}
