// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: monitor.proto

package mliot.monitor.generated;

public final class Monitor {
  private Monitor() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmptyMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmptyMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StudentDisconnectionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StudentDisconnectionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HandDeviceMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HandDeviceMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HighAccelerationMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HighAccelerationMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UnAuthorizedMonitorMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UnAuthorizedMonitorMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PhoneCameraRecognitionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PhoneCameraRecognitionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_WebCameraRecognitionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_WebCameraRecognitionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FaceRecognitionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FaceRecognitionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StudentFraudMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StudentFraudMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_QRCodeVerificationMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_QRCodeVerificationMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ScreenshotTextRecognitionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ScreenshotTextRecognitionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BrowserSizeMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BrowserSizeMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SpeechRecognitionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SpeechRecognitionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MovementDetectionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MovementDetectionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StudentConnectionMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StudentConnectionMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StudentConnectionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StudentConnectionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_KnownStudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_KnownStudentResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmonitor.proto\032\014common.proto\"\016\n\014EmptyMe" +
      "ssage\"2\n\033StudentDisconnectionMessage\022\023\n\013" +
      "card_number\030\001 \001(\t\"e\n\021HandDeviceMessage\022\023" +
      "\n\013card_number\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\r\n\005" +
      "mills\030\003 \001(\003\022\033\n\010severity\030\004 \001(\0162\t.Severity" +
      "\"k\n\027HighAccelerationMessage\022\023\n\013card_numb" +
      "er\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\r\n\005mills\030\003 \001(\003" +
      "\022\033\n\010severity\030\004 \001(\0162\t.Severity\"n\n\032UnAutho" +
      "rizedMonitorMessage\022\023\n\013card_number\030\001 \001(\t" +
      "\022\017\n\007message\030\002 \001(\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010seve" +
      "rity\030\004 \001(\0162\t.Severity\"q\n\035PhoneCameraReco" +
      "gnitionMessage\022\023\n\013card_number\030\001 \001(\t\022\017\n\007m" +
      "essage\030\002 \001(\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010severity\030" +
      "\004 \001(\0162\t.Severity\"o\n\033WebCameraRecognition" +
      "Message\022\023\n\013card_number\030\001 \001(\t\022\017\n\007message\030" +
      "\002 \001(\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010severity\030\004 \001(\0162\t" +
      ".Severity\"j\n\026FaceRecognitionMessage\022\023\n\013c" +
      "ard_number\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\r\n\005mil" +
      "ls\030\003 \001(\003\022\033\n\010severity\030\004 \001(\0162\t.Severity\"g\n" +
      "\023StudentFraudMessage\022\023\n\013card_number\030\001 \001(" +
      "\t\022\017\n\007message\030\002 \001(\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010sev" +
      "erity\030\004 \001(\0162\t.Severity\"m\n\031QRCodeVerifica" +
      "tionMessage\022\023\n\013card_number\030\001 \001(\t\022\017\n\007mess" +
      "age\030\002 \001(\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010severity\030\004 \001" +
      "(\0162\t.Severity\"\227\001\n ScreenshotTextRecognit" +
      "ionMessage\022\023\n\013card_number\030\001 \001(\t\022\027\n\017recog" +
      "nized_text\030\002 \001(\t\022\031\n\021similarity_report\030\003 " +
      "\003(\t\022\r\n\005mills\030\004 \001(\003\022\033\n\010severity\030\005 \001(\0162\t.S" +
      "everity\"f\n\022BrowserSizeMessage\022\023\n\013card_nu" +
      "mber\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\r\n\005mills\030\003 \001" +
      "(\003\022\033\n\010severity\030\004 \001(\0162\t.Severity\"\215\001\n\030Spee" +
      "chRecognitionMessage\022\023\n\013card_number\030\001 \001(" +
      "\t\022\025\n\rspoken_speech\030\002 \001(\t\022\031\n\021similarity_r" +
      "eport\030\003 \003(\t\022\r\n\005mills\030\004 \001(\003\022\033\n\010severity\030\005" +
      " \001(\0162\t.Severity\"l\n\030MovementDetectionMess" +
      "age\022\023\n\013card_number\030\001 \001(\t\022\017\n\007message\030\002 \001(" +
      "\t\022\r\n\005mills\030\003 \001(\003\022\033\n\010severity\030\004 \001(\0162\t.Sev" +
      "erity\"U\n\030StudentConnectionMessage\022\023\n\013car" +
      "d_number\030\001 \001(\t\022\017\n\007address\030\002 \001(\t\022\023\n\013port_" +
      "number\030\003 \001(\005\">\n\031StudentConnectionRespons" +
      "e\022\020\n\010exam_url\030\001 \001(\t\022\017\n\007api_url\030\002 \001(\t\"i\n\024" +
      "KnownStudentResponse\022\022\n\nfirst_name\030\001 \001(\t" +
      "\022\021\n\tlast_name\030\002 \001(\t\022\023\n\013card_number\030\003 \001(\t" +
      "\022\025\n\rprofile_photo\030\004 \001(\014*/\n\010Severity\022\n\n\006N" +
      "ORMAL\020\000\022\013\n\007WARNING\020\001\022\n\n\006SEVERE\020\0022\333\010\n\016Mon" +
      "itorService\022>\n\022fetchKnownStudents\022\r.Empt" +
      "yMessage\032\025.KnownStudentResponse\"\0000\001\022M\n\022o" +
      "nStudentConnected\022\031.StudentConnectionMes" +
      "sage\032\032.StudentConnectionResponse\"\000\022A\n\022on" +
      "MovementDetected\022\031.MovementDetectionMess" +
      "age\032\016.EmptyResponse\"\000\022K\n\034onMicrophoneSpe" +
      "echRecognized\022\031.SpeechRecognitionMessage" +
      "\032\016.EmptyResponse\"\000\022J\n!onBrowserSizeNotFi" +
      "ttingScreenSize\022\023.BrowserSizeMessage\032\016.E" +
      "mptyResponse\"\000\022Q\n\032onScreenshotTextRecogn" +
      "ized\022!.ScreenshotTextRecognitionMessage\032" +
      "\016.EmptyResponse\"\000\022J\n\032onQRCodeVerificatio" +
      "nFailed\022\032.QRCodeVerificationMessage\032\016.Em" +
      "ptyResponse\"\000\022=\n\023onStudentNotAllowed\022\024.S" +
      "tudentFraudMessage\032\016.EmptyResponse\"\000\022@\n\023" +
      "onFaceNotRecognized\022\027.FaceRecognitionMes" +
      "sage\032\016.EmptyResponse\"\000\022N\n\034onWebCameraObj" +
      "ectsRecognized\022\034.WebCameraRecognitionMes" +
      "sage\032\016.EmptyResponse\"\000\022R\n\036onPhoneCameraO" +
      "bjectsRecognized\022\036.PhoneCameraRecognitio" +
      "nMessage\032\016.EmptyResponse\"\000\022F\n\025onUnAuthor" +
      "izedMonitor\022\033.UnAuthorizedMonitorMessage" +
      "\032\016.EmptyResponse\"\000\022G\n\031onHighAcceleration" +
      "Noticed\022\030.HighAccelerationMessage\032\016.Empt" +
      "yResponse\"\000\022@\n\030onHandDeviceStateChanged\022" +
      "\022.HandDeviceMessage\032\016.EmptyResponse\"\000\022G\n" +
      "\025onStudentDisconnected\022\034.StudentDisconne" +
      "ctionMessage\032\016.EmptyResponse\"\000B\033\n\027mliot." +
      "monitor.generatedP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          mliot.monitor.generated.Common.getDescriptor(),
        });
    internal_static_EmptyMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EmptyMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmptyMessage_descriptor,
        new java.lang.String[] { });
    internal_static_StudentDisconnectionMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_StudentDisconnectionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StudentDisconnectionMessage_descriptor,
        new java.lang.String[] { "CardNumber", });
    internal_static_HandDeviceMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_HandDeviceMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HandDeviceMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_HighAccelerationMessage_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_HighAccelerationMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HighAccelerationMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_UnAuthorizedMonitorMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_UnAuthorizedMonitorMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UnAuthorizedMonitorMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_PhoneCameraRecognitionMessage_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_PhoneCameraRecognitionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PhoneCameraRecognitionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_WebCameraRecognitionMessage_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_WebCameraRecognitionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_WebCameraRecognitionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_FaceRecognitionMessage_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_FaceRecognitionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FaceRecognitionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_StudentFraudMessage_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_StudentFraudMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StudentFraudMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_QRCodeVerificationMessage_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_QRCodeVerificationMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_QRCodeVerificationMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_ScreenshotTextRecognitionMessage_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ScreenshotTextRecognitionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ScreenshotTextRecognitionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "RecognizedText", "SimilarityReport", "Mills", "Severity", });
    internal_static_BrowserSizeMessage_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_BrowserSizeMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BrowserSizeMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_SpeechRecognitionMessage_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_SpeechRecognitionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SpeechRecognitionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "SpokenSpeech", "SimilarityReport", "Mills", "Severity", });
    internal_static_MovementDetectionMessage_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_MovementDetectionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MovementDetectionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Message", "Mills", "Severity", });
    internal_static_StudentConnectionMessage_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_StudentConnectionMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StudentConnectionMessage_descriptor,
        new java.lang.String[] { "CardNumber", "Address", "PortNumber", });
    internal_static_StudentConnectionResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_StudentConnectionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StudentConnectionResponse_descriptor,
        new java.lang.String[] { "ExamUrl", "ApiUrl", });
    internal_static_KnownStudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_KnownStudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_KnownStudentResponse_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "CardNumber", "ProfilePhoto", });
    mliot.monitor.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
