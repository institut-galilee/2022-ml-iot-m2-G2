// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

public interface FaceRecognitionMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FaceRecognitionMessage)
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
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>int64 mills = 3;</code>
   * @return The mills.
   */
  long getMills();

  /**
   * <code>.Severity severity = 4;</code>
   * @return The enum numeric value on the wire for severity.
   */
  int getSeverityValue();
  /**
   * <code>.Severity severity = 4;</code>
   * @return The severity.
   */
  mliot.monitor.generated.Severity getSeverity();
}
