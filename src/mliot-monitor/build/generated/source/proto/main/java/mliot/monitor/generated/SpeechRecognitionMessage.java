// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

/**
 * Protobuf type {@code SpeechRecognitionMessage}
 */
public final class SpeechRecognitionMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SpeechRecognitionMessage)
    SpeechRecognitionMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SpeechRecognitionMessage.newBuilder() to construct.
  private SpeechRecognitionMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SpeechRecognitionMessage() {
    cardNumber_ = "";
    spokenSpeech_ = "";
    similarityReport_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    severity_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SpeechRecognitionMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SpeechRecognitionMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            cardNumber_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            spokenSpeech_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              similarityReport_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            similarityReport_.add(s);
            break;
          }
          case 32: {

            mills_ = input.readInt64();
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            severity_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        similarityReport_ = similarityReport_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return mliot.monitor.generated.Monitor.internal_static_SpeechRecognitionMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return mliot.monitor.generated.Monitor.internal_static_SpeechRecognitionMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            mliot.monitor.generated.SpeechRecognitionMessage.class, mliot.monitor.generated.SpeechRecognitionMessage.Builder.class);
  }

  public static final int CARD_NUMBER_FIELD_NUMBER = 1;
  private volatile java.lang.Object cardNumber_;
  /**
   * <code>string card_number = 1;</code>
   * @return The cardNumber.
   */
  @java.lang.Override
  public java.lang.String getCardNumber() {
    java.lang.Object ref = cardNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cardNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string card_number = 1;</code>
   * @return The bytes for cardNumber.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCardNumberBytes() {
    java.lang.Object ref = cardNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cardNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SPOKEN_SPEECH_FIELD_NUMBER = 2;
  private volatile java.lang.Object spokenSpeech_;
  /**
   * <code>string spoken_speech = 2;</code>
   * @return The spokenSpeech.
   */
  @java.lang.Override
  public java.lang.String getSpokenSpeech() {
    java.lang.Object ref = spokenSpeech_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      spokenSpeech_ = s;
      return s;
    }
  }
  /**
   * <code>string spoken_speech = 2;</code>
   * @return The bytes for spokenSpeech.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSpokenSpeechBytes() {
    java.lang.Object ref = spokenSpeech_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      spokenSpeech_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SIMILARITY_REPORT_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList similarityReport_;
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @return A list containing the similarityReport.
   */
  public com.google.protobuf.ProtocolStringList
      getSimilarityReportList() {
    return similarityReport_;
  }
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @return The count of similarityReport.
   */
  public int getSimilarityReportCount() {
    return similarityReport_.size();
  }
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @param index The index of the element to return.
   * @return The similarityReport at the given index.
   */
  public java.lang.String getSimilarityReport(int index) {
    return similarityReport_.get(index);
  }
  /**
   * <code>repeated string similarity_report = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the similarityReport at the given index.
   */
  public com.google.protobuf.ByteString
      getSimilarityReportBytes(int index) {
    return similarityReport_.getByteString(index);
  }

  public static final int MILLS_FIELD_NUMBER = 4;
  private long mills_;
  /**
   * <code>int64 mills = 4;</code>
   * @return The mills.
   */
  @java.lang.Override
  public long getMills() {
    return mills_;
  }

  public static final int SEVERITY_FIELD_NUMBER = 5;
  private int severity_;
  /**
   * <code>.Severity severity = 5;</code>
   * @return The enum numeric value on the wire for severity.
   */
  @java.lang.Override public int getSeverityValue() {
    return severity_;
  }
  /**
   * <code>.Severity severity = 5;</code>
   * @return The severity.
   */
  @java.lang.Override public mliot.monitor.generated.Severity getSeverity() {
    @SuppressWarnings("deprecation")
    mliot.monitor.generated.Severity result = mliot.monitor.generated.Severity.valueOf(severity_);
    return result == null ? mliot.monitor.generated.Severity.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cardNumber_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cardNumber_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(spokenSpeech_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, spokenSpeech_);
    }
    for (int i = 0; i < similarityReport_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, similarityReport_.getRaw(i));
    }
    if (mills_ != 0L) {
      output.writeInt64(4, mills_);
    }
    if (severity_ != mliot.monitor.generated.Severity.NORMAL.getNumber()) {
      output.writeEnum(5, severity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cardNumber_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cardNumber_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(spokenSpeech_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, spokenSpeech_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < similarityReport_.size(); i++) {
        dataSize += computeStringSizeNoTag(similarityReport_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSimilarityReportList().size();
    }
    if (mills_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, mills_);
    }
    if (severity_ != mliot.monitor.generated.Severity.NORMAL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, severity_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof mliot.monitor.generated.SpeechRecognitionMessage)) {
      return super.equals(obj);
    }
    mliot.monitor.generated.SpeechRecognitionMessage other = (mliot.monitor.generated.SpeechRecognitionMessage) obj;

    if (!getCardNumber()
        .equals(other.getCardNumber())) return false;
    if (!getSpokenSpeech()
        .equals(other.getSpokenSpeech())) return false;
    if (!getSimilarityReportList()
        .equals(other.getSimilarityReportList())) return false;
    if (getMills()
        != other.getMills()) return false;
    if (severity_ != other.severity_) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CARD_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getCardNumber().hashCode();
    hash = (37 * hash) + SPOKEN_SPEECH_FIELD_NUMBER;
    hash = (53 * hash) + getSpokenSpeech().hashCode();
    if (getSimilarityReportCount() > 0) {
      hash = (37 * hash) + SIMILARITY_REPORT_FIELD_NUMBER;
      hash = (53 * hash) + getSimilarityReportList().hashCode();
    }
    hash = (37 * hash) + MILLS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMills());
    hash = (37 * hash) + SEVERITY_FIELD_NUMBER;
    hash = (53 * hash) + severity_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.SpeechRecognitionMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(mliot.monitor.generated.SpeechRecognitionMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code SpeechRecognitionMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SpeechRecognitionMessage)
      mliot.monitor.generated.SpeechRecognitionMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return mliot.monitor.generated.Monitor.internal_static_SpeechRecognitionMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return mliot.monitor.generated.Monitor.internal_static_SpeechRecognitionMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              mliot.monitor.generated.SpeechRecognitionMessage.class, mliot.monitor.generated.SpeechRecognitionMessage.Builder.class);
    }

    // Construct using mliot.monitor.generated.SpeechRecognitionMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      cardNumber_ = "";

      spokenSpeech_ = "";

      similarityReport_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      mills_ = 0L;

      severity_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return mliot.monitor.generated.Monitor.internal_static_SpeechRecognitionMessage_descriptor;
    }

    @java.lang.Override
    public mliot.monitor.generated.SpeechRecognitionMessage getDefaultInstanceForType() {
      return mliot.monitor.generated.SpeechRecognitionMessage.getDefaultInstance();
    }

    @java.lang.Override
    public mliot.monitor.generated.SpeechRecognitionMessage build() {
      mliot.monitor.generated.SpeechRecognitionMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public mliot.monitor.generated.SpeechRecognitionMessage buildPartial() {
      mliot.monitor.generated.SpeechRecognitionMessage result = new mliot.monitor.generated.SpeechRecognitionMessage(this);
      int from_bitField0_ = bitField0_;
      result.cardNumber_ = cardNumber_;
      result.spokenSpeech_ = spokenSpeech_;
      if (((bitField0_ & 0x00000001) != 0)) {
        similarityReport_ = similarityReport_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.similarityReport_ = similarityReport_;
      result.mills_ = mills_;
      result.severity_ = severity_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof mliot.monitor.generated.SpeechRecognitionMessage) {
        return mergeFrom((mliot.monitor.generated.SpeechRecognitionMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(mliot.monitor.generated.SpeechRecognitionMessage other) {
      if (other == mliot.monitor.generated.SpeechRecognitionMessage.getDefaultInstance()) return this;
      if (!other.getCardNumber().isEmpty()) {
        cardNumber_ = other.cardNumber_;
        onChanged();
      }
      if (!other.getSpokenSpeech().isEmpty()) {
        spokenSpeech_ = other.spokenSpeech_;
        onChanged();
      }
      if (!other.similarityReport_.isEmpty()) {
        if (similarityReport_.isEmpty()) {
          similarityReport_ = other.similarityReport_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureSimilarityReportIsMutable();
          similarityReport_.addAll(other.similarityReport_);
        }
        onChanged();
      }
      if (other.getMills() != 0L) {
        setMills(other.getMills());
      }
      if (other.severity_ != 0) {
        setSeverityValue(other.getSeverityValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      mliot.monitor.generated.SpeechRecognitionMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (mliot.monitor.generated.SpeechRecognitionMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object cardNumber_ = "";
    /**
     * <code>string card_number = 1;</code>
     * @return The cardNumber.
     */
    public java.lang.String getCardNumber() {
      java.lang.Object ref = cardNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cardNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string card_number = 1;</code>
     * @return The bytes for cardNumber.
     */
    public com.google.protobuf.ByteString
        getCardNumberBytes() {
      java.lang.Object ref = cardNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cardNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string card_number = 1;</code>
     * @param value The cardNumber to set.
     * @return This builder for chaining.
     */
    public Builder setCardNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cardNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string card_number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCardNumber() {
      
      cardNumber_ = getDefaultInstance().getCardNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string card_number = 1;</code>
     * @param value The bytes for cardNumber to set.
     * @return This builder for chaining.
     */
    public Builder setCardNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cardNumber_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object spokenSpeech_ = "";
    /**
     * <code>string spoken_speech = 2;</code>
     * @return The spokenSpeech.
     */
    public java.lang.String getSpokenSpeech() {
      java.lang.Object ref = spokenSpeech_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        spokenSpeech_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string spoken_speech = 2;</code>
     * @return The bytes for spokenSpeech.
     */
    public com.google.protobuf.ByteString
        getSpokenSpeechBytes() {
      java.lang.Object ref = spokenSpeech_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        spokenSpeech_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string spoken_speech = 2;</code>
     * @param value The spokenSpeech to set.
     * @return This builder for chaining.
     */
    public Builder setSpokenSpeech(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      spokenSpeech_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string spoken_speech = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSpokenSpeech() {
      
      spokenSpeech_ = getDefaultInstance().getSpokenSpeech();
      onChanged();
      return this;
    }
    /**
     * <code>string spoken_speech = 2;</code>
     * @param value The bytes for spokenSpeech to set.
     * @return This builder for chaining.
     */
    public Builder setSpokenSpeechBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      spokenSpeech_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList similarityReport_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureSimilarityReportIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        similarityReport_ = new com.google.protobuf.LazyStringArrayList(similarityReport_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @return A list containing the similarityReport.
     */
    public com.google.protobuf.ProtocolStringList
        getSimilarityReportList() {
      return similarityReport_.getUnmodifiableView();
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @return The count of similarityReport.
     */
    public int getSimilarityReportCount() {
      return similarityReport_.size();
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param index The index of the element to return.
     * @return The similarityReport at the given index.
     */
    public java.lang.String getSimilarityReport(int index) {
      return similarityReport_.get(index);
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the similarityReport at the given index.
     */
    public com.google.protobuf.ByteString
        getSimilarityReportBytes(int index) {
      return similarityReport_.getByteString(index);
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param index The index to set the value at.
     * @param value The similarityReport to set.
     * @return This builder for chaining.
     */
    public Builder setSimilarityReport(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSimilarityReportIsMutable();
      similarityReport_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param value The similarityReport to add.
     * @return This builder for chaining.
     */
    public Builder addSimilarityReport(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSimilarityReportIsMutable();
      similarityReport_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param values The similarityReport to add.
     * @return This builder for chaining.
     */
    public Builder addAllSimilarityReport(
        java.lang.Iterable<java.lang.String> values) {
      ensureSimilarityReportIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, similarityReport_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSimilarityReport() {
      similarityReport_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string similarity_report = 3;</code>
     * @param value The bytes of the similarityReport to add.
     * @return This builder for chaining.
     */
    public Builder addSimilarityReportBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureSimilarityReportIsMutable();
      similarityReport_.add(value);
      onChanged();
      return this;
    }

    private long mills_ ;
    /**
     * <code>int64 mills = 4;</code>
     * @return The mills.
     */
    @java.lang.Override
    public long getMills() {
      return mills_;
    }
    /**
     * <code>int64 mills = 4;</code>
     * @param value The mills to set.
     * @return This builder for chaining.
     */
    public Builder setMills(long value) {
      
      mills_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 mills = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearMills() {
      
      mills_ = 0L;
      onChanged();
      return this;
    }

    private int severity_ = 0;
    /**
     * <code>.Severity severity = 5;</code>
     * @return The enum numeric value on the wire for severity.
     */
    @java.lang.Override public int getSeverityValue() {
      return severity_;
    }
    /**
     * <code>.Severity severity = 5;</code>
     * @param value The enum numeric value on the wire for severity to set.
     * @return This builder for chaining.
     */
    public Builder setSeverityValue(int value) {
      
      severity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Severity severity = 5;</code>
     * @return The severity.
     */
    @java.lang.Override
    public mliot.monitor.generated.Severity getSeverity() {
      @SuppressWarnings("deprecation")
      mliot.monitor.generated.Severity result = mliot.monitor.generated.Severity.valueOf(severity_);
      return result == null ? mliot.monitor.generated.Severity.UNRECOGNIZED : result;
    }
    /**
     * <code>.Severity severity = 5;</code>
     * @param value The severity to set.
     * @return This builder for chaining.
     */
    public Builder setSeverity(mliot.monitor.generated.Severity value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      severity_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Severity severity = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearSeverity() {
      
      severity_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:SpeechRecognitionMessage)
  }

  // @@protoc_insertion_point(class_scope:SpeechRecognitionMessage)
  private static final mliot.monitor.generated.SpeechRecognitionMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new mliot.monitor.generated.SpeechRecognitionMessage();
  }

  public static mliot.monitor.generated.SpeechRecognitionMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SpeechRecognitionMessage>
      PARSER = new com.google.protobuf.AbstractParser<SpeechRecognitionMessage>() {
    @java.lang.Override
    public SpeechRecognitionMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SpeechRecognitionMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SpeechRecognitionMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SpeechRecognitionMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public mliot.monitor.generated.SpeechRecognitionMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

