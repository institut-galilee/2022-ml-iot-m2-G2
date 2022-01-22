# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: sink.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='sink.proto',
  package='',
  syntax='proto3',
  serialized_options=b'\n\023mliot.sensors.protoP\001',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\nsink.proto\"\x1c\n\x08Response\x12\x10\n\x08received\x18\x01 \x01(\x08\"#\n\x0c\x41udioMessage\x12\x13\n\x0b\x61udio_frame\x18\x01 \x01(\x0c\"#\n\x0cVideoMessage\x12\x13\n\x0bvideo_frame\x18\x01 \x01(\x0c\"!\n\x0cRangeMessage\x12\x11\n\tmax_range\x18\x01 \x01(\x02\"6\n\x13\x41\x63\x63\x65lerationMessage\x12\t\n\x01x\x18\x01 \x01(\x02\x12\t\n\x01y\x18\x02 \x01(\x02\x12\t\n\x01z\x18\x03 \x01(\x02\x32\xf0\x01\n\x0bSinkService\x12\x33\n\x15onAudioFrameAvailable\x12\r.AudioMessage\x1a\t.Response\"\x00\x12\x33\n\x15onVideoFrameAvailable\x12\r.VideoMessage\x1a\t.Response\"\x00\x12@\n\x1bonAccelerationValuesChanged\x12\x14.AccelerationMessage\x1a\t.Response\"\x00\x12\x35\n\x17setAccelerationMaxRange\x12\r.RangeMessage\x1a\t.Response\"\x00\x42\x17\n\x13mliot.sensors.protoP\x01\x62\x06proto3'
)




_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='received', full_name='Response.received', index=0,
      number=1, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=14,
  serialized_end=42,
)


_AUDIOMESSAGE = _descriptor.Descriptor(
  name='AudioMessage',
  full_name='AudioMessage',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='audio_frame', full_name='AudioMessage.audio_frame', index=0,
      number=1, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=b"",
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=44,
  serialized_end=79,
)


_VIDEOMESSAGE = _descriptor.Descriptor(
  name='VideoMessage',
  full_name='VideoMessage',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='video_frame', full_name='VideoMessage.video_frame', index=0,
      number=1, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=b"",
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=81,
  serialized_end=116,
)


_RANGEMESSAGE = _descriptor.Descriptor(
  name='RangeMessage',
  full_name='RangeMessage',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='max_range', full_name='RangeMessage.max_range', index=0,
      number=1, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=118,
  serialized_end=151,
)


_ACCELERATIONMESSAGE = _descriptor.Descriptor(
  name='AccelerationMessage',
  full_name='AccelerationMessage',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='x', full_name='AccelerationMessage.x', index=0,
      number=1, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='y', full_name='AccelerationMessage.y', index=1,
      number=2, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='z', full_name='AccelerationMessage.z', index=2,
      number=3, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=153,
  serialized_end=207,
)

DESCRIPTOR.message_types_by_name['Response'] = _RESPONSE
DESCRIPTOR.message_types_by_name['AudioMessage'] = _AUDIOMESSAGE
DESCRIPTOR.message_types_by_name['VideoMessage'] = _VIDEOMESSAGE
DESCRIPTOR.message_types_by_name['RangeMessage'] = _RANGEMESSAGE
DESCRIPTOR.message_types_by_name['AccelerationMessage'] = _ACCELERATIONMESSAGE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), {
  'DESCRIPTOR' : _RESPONSE,
  '__module__' : 'sink_pb2'
  # @@protoc_insertion_point(class_scope:Response)
  })
_sym_db.RegisterMessage(Response)

AudioMessage = _reflection.GeneratedProtocolMessageType('AudioMessage', (_message.Message,), {
  'DESCRIPTOR' : _AUDIOMESSAGE,
  '__module__' : 'sink_pb2'
  # @@protoc_insertion_point(class_scope:AudioMessage)
  })
_sym_db.RegisterMessage(AudioMessage)

VideoMessage = _reflection.GeneratedProtocolMessageType('VideoMessage', (_message.Message,), {
  'DESCRIPTOR' : _VIDEOMESSAGE,
  '__module__' : 'sink_pb2'
  # @@protoc_insertion_point(class_scope:VideoMessage)
  })
_sym_db.RegisterMessage(VideoMessage)

RangeMessage = _reflection.GeneratedProtocolMessageType('RangeMessage', (_message.Message,), {
  'DESCRIPTOR' : _RANGEMESSAGE,
  '__module__' : 'sink_pb2'
  # @@protoc_insertion_point(class_scope:RangeMessage)
  })
_sym_db.RegisterMessage(RangeMessage)

AccelerationMessage = _reflection.GeneratedProtocolMessageType('AccelerationMessage', (_message.Message,), {
  'DESCRIPTOR' : _ACCELERATIONMESSAGE,
  '__module__' : 'sink_pb2'
  # @@protoc_insertion_point(class_scope:AccelerationMessage)
  })
_sym_db.RegisterMessage(AccelerationMessage)


DESCRIPTOR._options = None

_SINKSERVICE = _descriptor.ServiceDescriptor(
  name='SinkService',
  full_name='SinkService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=210,
  serialized_end=450,
  methods=[
  _descriptor.MethodDescriptor(
    name='onAudioFrameAvailable',
    full_name='SinkService.onAudioFrameAvailable',
    index=0,
    containing_service=None,
    input_type=_AUDIOMESSAGE,
    output_type=_RESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='onVideoFrameAvailable',
    full_name='SinkService.onVideoFrameAvailable',
    index=1,
    containing_service=None,
    input_type=_VIDEOMESSAGE,
    output_type=_RESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='onAccelerationValuesChanged',
    full_name='SinkService.onAccelerationValuesChanged',
    index=2,
    containing_service=None,
    input_type=_ACCELERATIONMESSAGE,
    output_type=_RESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='setAccelerationMaxRange',
    full_name='SinkService.setAccelerationMaxRange',
    index=3,
    containing_service=None,
    input_type=_RANGEMESSAGE,
    output_type=_RESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_SINKSERVICE)

DESCRIPTOR.services_by_name['SinkService'] = _SINKSERVICE

# @@protoc_insertion_point(module_scope)
