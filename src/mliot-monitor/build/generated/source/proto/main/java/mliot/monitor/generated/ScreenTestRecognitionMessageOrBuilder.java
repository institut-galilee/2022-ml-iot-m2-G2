// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

public interface ScreenTestRecognitionMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ScreenTestRecognitionMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string card_number = 1;</code>
   * @return The cardNumber.
   */
  java.lang.String getCardNumber();
  /**
   * <code>string card_number = 1;</code>
   * @return The bytes for cardNumber.
   */
  com.google.protobuf.ByteString
      getCardNumberBytes();

  /**
   * <code>string recognized_text = 2;</code>
   * @return The recognizedText.
   */
  java.lang.String getRecognizedText();
  /**
   * <code>string recognized_text = 2;</code>
   * @return The bytes for recognizedText.
   */
  com.google.protobuf.ByteString
      getRecognizedTextBytes();

  /**
   * <code>repeated string similarity_report = 3;</code>
   * @return A list containing the similarityReport.
   */
  java.util.List<java.lang.String>
      getSimilarityReportList();
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @return The count of similarityReport.
   */
  int getSimilarityReportCount();
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @param index The index of the element to return.
   * @return The similarityReport at the given index.
   */
  java.lang.String getSimilarityReport(int index);
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the similarityReport at the given index.
   */
  com.google.protobuf.ByteString
      getSimilarityReportBytes(int index);

  /**
   * <code>int64 mills = 4;</code>
   * @return The mills.
   */
  long getMills();

  /**
   * <code>.Severity severity = 5;</code>
   * @return The enum numeric value on the wire for severity.
   */
  int getSeverityValue();
  /**
   * <code>.Severity severity = 5;</code>
   * @return The severity.
   */
  mliot.monitor.generated.Severity getSeverity();
}