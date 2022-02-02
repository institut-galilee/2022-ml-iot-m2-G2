
class SinkSetupCallback(object):

    def __init__(self):
        pass

    def on_student_recognized(self, student):
        raise Exception("NotImplementedException")

    def on_monitor_connection_interface_set(self, address, port):
        raise Exception("NotImplementedException")

    def on_sink_connection_interface_set(self):
        raise Exception("NotImplementedException")

    def on_hand_device_set(self):
        raise Exception("NotImplementedException")

    def on_head_device_set(self):
        raise Exception("NotImplementedException")
