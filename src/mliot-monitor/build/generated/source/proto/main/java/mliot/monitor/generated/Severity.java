// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

/**
 * Protobuf enum {@code Severity}
 */
public enum Severity
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NORMAL = 0;</code>
   */
  NORMAL(0),
  /**
   * <code>WARNING = 1;</code>
   */
  WARNING(1),
  /**
   * <code>SEVERE = 2;</code>
   */
  SEVERE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NORMAL = 0;</code>
   */
  public static final int NORMAL_VALUE = 0;
  /**
   * <code>WARNING = 1;</code>
   */
  public static final int WARNING_VALUE = 1;
  /**
   * <code>SEVERE = 2;</code>
   */
  public static final int SEVERE_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Severity valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Severity forNumber(int value) {
    switch (value) {
      case 0: return NORMAL;
      case 1: return WARNING;
      case 2: return SEVERE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Severity>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Severity> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Severity>() {
          public Severity findValueByNumber(int number) {
            return Severity.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return mliot.monitor.generated.Monitor.getDescriptor().getEnumTypes().get(0);
  }

  private static final Severity[] VALUES = values();

  public static Severity valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Severity(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Severity)
}
