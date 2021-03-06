// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

/**
 * Protobuf type {@code StudentConnectionResponse}
 */
public final class StudentConnectionResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:StudentConnectionResponse)
    StudentConnectionResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StudentConnectionResponse.newBuilder() to construct.
  private StudentConnectionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StudentConnectionResponse() {
    examUrl_ = "";
    apiUrl_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new StudentConnectionResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StudentConnectionResponse(
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

            examUrl_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            apiUrl_ = s;
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
    return mliot.monitor.generated.Monitor.internal_static_StudentConnectionResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return mliot.monitor.generated.Monitor.internal_static_StudentConnectionResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            mliot.monitor.generated.StudentConnectionResponse.class, mliot.monitor.generated.StudentConnectionResponse.Builder.class);
  }

  public static final int EXAM_URL_FIELD_NUMBER = 1;
  private volatile java.lang.Object examUrl_;
  /**
   * <code>string exam_url = 1;</code>
   * @return The examUrl.
   */
  @java.lang.Override
  public java.lang.String getExamUrl() {
    java.lang.Object ref = examUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      examUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string exam_url = 1;</code>
   * @return The bytes for examUrl.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExamUrlBytes() {
    java.lang.Object ref = examUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      examUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int API_URL_FIELD_NUMBER = 2;
  private volatile java.lang.Object apiUrl_;
  /**
   * <code>string api_url = 2;</code>
   * @return The apiUrl.
   */
  @java.lang.Override
  public java.lang.String getApiUrl() {
    java.lang.Object ref = apiUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      apiUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string api_url = 2;</code>
   * @return The bytes for apiUrl.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getApiUrlBytes() {
    java.lang.Object ref = apiUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      apiUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(examUrl_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, examUrl_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(apiUrl_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, apiUrl_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(examUrl_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, examUrl_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(apiUrl_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, apiUrl_);
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
    if (!(obj instanceof mliot.monitor.generated.StudentConnectionResponse)) {
      return super.equals(obj);
    }
    mliot.monitor.generated.StudentConnectionResponse other = (mliot.monitor.generated.StudentConnectionResponse) obj;

    if (!getExamUrl()
        .equals(other.getExamUrl())) return false;
    if (!getApiUrl()
        .equals(other.getApiUrl())) return false;
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
    hash = (37 * hash) + EXAM_URL_FIELD_NUMBER;
    hash = (53 * hash) + getExamUrl().hashCode();
    hash = (37 * hash) + API_URL_FIELD_NUMBER;
    hash = (53 * hash) + getApiUrl().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static mliot.monitor.generated.StudentConnectionResponse parseFrom(
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
  public static Builder newBuilder(mliot.monitor.generated.StudentConnectionResponse prototype) {
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
   * Protobuf type {@code StudentConnectionResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:StudentConnectionResponse)
      mliot.monitor.generated.StudentConnectionResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return mliot.monitor.generated.Monitor.internal_static_StudentConnectionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return mliot.monitor.generated.Monitor.internal_static_StudentConnectionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              mliot.monitor.generated.StudentConnectionResponse.class, mliot.monitor.generated.StudentConnectionResponse.Builder.class);
    }

    // Construct using mliot.monitor.generated.StudentConnectionResponse.newBuilder()
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
      examUrl_ = "";

      apiUrl_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return mliot.monitor.generated.Monitor.internal_static_StudentConnectionResponse_descriptor;
    }

    @java.lang.Override
    public mliot.monitor.generated.StudentConnectionResponse getDefaultInstanceForType() {
      return mliot.monitor.generated.StudentConnectionResponse.getDefaultInstance();
    }

    @java.lang.Override
    public mliot.monitor.generated.StudentConnectionResponse build() {
      mliot.monitor.generated.StudentConnectionResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public mliot.monitor.generated.StudentConnectionResponse buildPartial() {
      mliot.monitor.generated.StudentConnectionResponse result = new mliot.monitor.generated.StudentConnectionResponse(this);
      result.examUrl_ = examUrl_;
      result.apiUrl_ = apiUrl_;
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
      if (other instanceof mliot.monitor.generated.StudentConnectionResponse) {
        return mergeFrom((mliot.monitor.generated.StudentConnectionResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(mliot.monitor.generated.StudentConnectionResponse other) {
      if (other == mliot.monitor.generated.StudentConnectionResponse.getDefaultInstance()) return this;
      if (!other.getExamUrl().isEmpty()) {
        examUrl_ = other.examUrl_;
        onChanged();
      }
      if (!other.getApiUrl().isEmpty()) {
        apiUrl_ = other.apiUrl_;
        onChanged();
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
      mliot.monitor.generated.StudentConnectionResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (mliot.monitor.generated.StudentConnectionResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object examUrl_ = "";
    /**
     * <code>string exam_url = 1;</code>
     * @return The examUrl.
     */
    public java.lang.String getExamUrl() {
      java.lang.Object ref = examUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        examUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string exam_url = 1;</code>
     * @return The bytes for examUrl.
     */
    public com.google.protobuf.ByteString
        getExamUrlBytes() {
      java.lang.Object ref = examUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        examUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string exam_url = 1;</code>
     * @param value The examUrl to set.
     * @return This builder for chaining.
     */
    public Builder setExamUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      examUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string exam_url = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExamUrl() {
      
      examUrl_ = getDefaultInstance().getExamUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string exam_url = 1;</code>
     * @param value The bytes for examUrl to set.
     * @return This builder for chaining.
     */
    public Builder setExamUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      examUrl_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object apiUrl_ = "";
    /**
     * <code>string api_url = 2;</code>
     * @return The apiUrl.
     */
    public java.lang.String getApiUrl() {
      java.lang.Object ref = apiUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        apiUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string api_url = 2;</code>
     * @return The bytes for apiUrl.
     */
    public com.google.protobuf.ByteString
        getApiUrlBytes() {
      java.lang.Object ref = apiUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        apiUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string api_url = 2;</code>
     * @param value The apiUrl to set.
     * @return This builder for chaining.
     */
    public Builder setApiUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      apiUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string api_url = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearApiUrl() {
      
      apiUrl_ = getDefaultInstance().getApiUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string api_url = 2;</code>
     * @param value The bytes for apiUrl to set.
     * @return This builder for chaining.
     */
    public Builder setApiUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      apiUrl_ = value;
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


    // @@protoc_insertion_point(builder_scope:StudentConnectionResponse)
  }

  // @@protoc_insertion_point(class_scope:StudentConnectionResponse)
  private static final mliot.monitor.generated.StudentConnectionResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new mliot.monitor.generated.StudentConnectionResponse();
  }

  public static mliot.monitor.generated.StudentConnectionResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StudentConnectionResponse>
      PARSER = new com.google.protobuf.AbstractParser<StudentConnectionResponse>() {
    @java.lang.Override
    public StudentConnectionResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StudentConnectionResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StudentConnectionResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StudentConnectionResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public mliot.monitor.generated.StudentConnectionResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

