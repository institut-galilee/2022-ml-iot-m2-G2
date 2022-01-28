// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

/**
 * Protobuf type {@code KnownStudentResponse}
 */
public final class KnownStudentResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:KnownStudentResponse)
    KnownStudentResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use KnownStudentResponse.newBuilder() to construct.
  private KnownStudentResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private KnownStudentResponse() {
    firstName_ = "";
    lastName_ = "";
    cardNumber_ = "";
    profilePhoto_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new KnownStudentResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private KnownStudentResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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

            firstName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            lastName_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            cardNumber_ = s;
            break;
          }
          case 34: {

            profilePhoto_ = input.readBytes();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return mliot.monitor.generated.Monitor.internal_static_KnownStudentResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return mliot.monitor.generated.Monitor.internal_static_KnownStudentResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            mliot.monitor.generated.KnownStudentResponse.class, mliot.monitor.generated.KnownStudentResponse.Builder.class);
  }

  public static final int FIRST_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object firstName_;
  /**
   * <code>string first_name = 1;</code>
   * @return The firstName.
   */
  @java.lang.Override
  public java.lang.String getFirstName() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstName_ = s;
      return s;
    }
  }
  /**
   * <code>string first_name = 1;</code>
   * @return The bytes for firstName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LAST_NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object lastName_;
  /**
   * <code>string last_name = 2;</code>
   * @return The lastName.
   */
  @java.lang.Override
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>string last_name = 2;</code>
   * @return The bytes for lastName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CARD_NUMBER_FIELD_NUMBER = 3;
  private volatile java.lang.Object cardNumber_;
  /**
   * <code>string card_number = 3;</code>
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
   * <code>string card_number = 3;</code>
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

  public static final int PROFILE_PHOTO_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString profilePhoto_;
  /**
   * <code>bytes profile_photo = 4;</code>
   * @return The profilePhoto.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getProfilePhoto() {
    return profilePhoto_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, firstName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, lastName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cardNumber_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, cardNumber_);
    }
    if (!profilePhoto_.isEmpty()) {
      output.writeBytes(4, profilePhoto_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, firstName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, lastName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cardNumber_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, cardNumber_);
    }
    if (!profilePhoto_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, profilePhoto_);
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
    if (!(obj instanceof mliot.monitor.generated.KnownStudentResponse)) {
      return super.equals(obj);
    }
    mliot.monitor.generated.KnownStudentResponse other = (mliot.monitor.generated.KnownStudentResponse) obj;

    if (!getFirstName()
        .equals(other.getFirstName())) return false;
    if (!getLastName()
        .equals(other.getLastName())) return false;
    if (!getCardNumber()
        .equals(other.getCardNumber())) return false;
    if (!getProfilePhoto()
        .equals(other.getProfilePhoto())) return false;
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
    hash = (37 * hash) + FIRST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstName().hashCode();
    hash = (37 * hash) + LAST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + CARD_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getCardNumber().hashCode();
    hash = (37 * hash) + PROFILE_PHOTO_FIELD_NUMBER;
    hash = (53 * hash) + getProfilePhoto().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.KnownStudentResponse parseFrom(
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
  public static Builder newBuilder(mliot.monitor.generated.KnownStudentResponse prototype) {
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
   * Protobuf type {@code KnownStudentResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:KnownStudentResponse)
      mliot.monitor.generated.KnownStudentResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return mliot.monitor.generated.Monitor.internal_static_KnownStudentResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return mliot.monitor.generated.Monitor.internal_static_KnownStudentResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              mliot.monitor.generated.KnownStudentResponse.class, mliot.monitor.generated.KnownStudentResponse.Builder.class);
    }

    // Construct using mliot.monitor.generated.KnownStudentResponse.newBuilder()
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
      firstName_ = "";

      lastName_ = "";

      cardNumber_ = "";

      profilePhoto_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return mliot.monitor.generated.Monitor.internal_static_KnownStudentResponse_descriptor;
    }

    @java.lang.Override
    public mliot.monitor.generated.KnownStudentResponse getDefaultInstanceForType() {
      return mliot.monitor.generated.KnownStudentResponse.getDefaultInstance();
    }

    @java.lang.Override
    public mliot.monitor.generated.KnownStudentResponse build() {
      mliot.monitor.generated.KnownStudentResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public mliot.monitor.generated.KnownStudentResponse buildPartial() {
      mliot.monitor.generated.KnownStudentResponse result = new mliot.monitor.generated.KnownStudentResponse(this);
      result.firstName_ = firstName_;
      result.lastName_ = lastName_;
      result.cardNumber_ = cardNumber_;
      result.profilePhoto_ = profilePhoto_;
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
      if (other instanceof mliot.monitor.generated.KnownStudentResponse) {
        return mergeFrom((mliot.monitor.generated.KnownStudentResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(mliot.monitor.generated.KnownStudentResponse other) {
      if (other == mliot.monitor.generated.KnownStudentResponse.getDefaultInstance()) return this;
      if (!other.getFirstName().isEmpty()) {
        firstName_ = other.firstName_;
        onChanged();
      }
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        onChanged();
      }
      if (!other.getCardNumber().isEmpty()) {
        cardNumber_ = other.cardNumber_;
        onChanged();
      }
      if (other.getProfilePhoto() != com.google.protobuf.ByteString.EMPTY) {
        setProfilePhoto(other.getProfilePhoto());
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
      mliot.monitor.generated.KnownStudentResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (mliot.monitor.generated.KnownStudentResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object firstName_ = "";
    /**
     * <code>string first_name = 1;</code>
     * @return The firstName.
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string first_name = 1;</code>
     * @return The bytes for firstName.
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string first_name = 1;</code>
     * @param value The firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      firstName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string first_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFirstName() {
      
      firstName_ = getDefaultInstance().getFirstName();
      onChanged();
      return this;
    }
    /**
     * <code>string first_name = 1;</code>
     * @param value The bytes for firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      firstName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object lastName_ = "";
    /**
     * <code>string last_name = 2;</code>
     * @return The lastName.
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string last_name = 2;</code>
     * @return The bytes for lastName.
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string last_name = 2;</code>
     * @param value The lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      lastName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastName() {
      
      lastName_ = getDefaultInstance().getLastName();
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 2;</code>
     * @param value The bytes for lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      lastName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object cardNumber_ = "";
    /**
     * <code>string card_number = 3;</code>
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
     * <code>string card_number = 3;</code>
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
     * <code>string card_number = 3;</code>
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
     * <code>string card_number = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCardNumber() {
      
      cardNumber_ = getDefaultInstance().getCardNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string card_number = 3;</code>
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

    private com.google.protobuf.ByteString profilePhoto_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes profile_photo = 4;</code>
     * @return The profilePhoto.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getProfilePhoto() {
      return profilePhoto_;
    }
    /**
     * <code>bytes profile_photo = 4;</code>
     * @param value The profilePhoto to set.
     * @return This builder for chaining.
     */
    public Builder setProfilePhoto(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      profilePhoto_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes profile_photo = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearProfilePhoto() {
      
      profilePhoto_ = getDefaultInstance().getProfilePhoto();
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


    // @@protoc_insertion_point(builder_scope:KnownStudentResponse)
  }

  // @@protoc_insertion_point(class_scope:KnownStudentResponse)
  private static final mliot.monitor.generated.KnownStudentResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new mliot.monitor.generated.KnownStudentResponse();
  }

  public static mliot.monitor.generated.KnownStudentResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<KnownStudentResponse>
      PARSER = new com.google.protobuf.AbstractParser<KnownStudentResponse>() {
    @java.lang.Override
    public KnownStudentResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new KnownStudentResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<KnownStudentResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<KnownStudentResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public mliot.monitor.generated.KnownStudentResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
