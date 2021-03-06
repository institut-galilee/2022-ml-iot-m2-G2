import socket
import logging as logger

SINK_LISTENING_PORT = 7117
MONITOR_FILE_PATH = "resources/monitor.txt"


class NetworkHelper:

    @staticmethod
    def get_sink_listening_address():
        socket_instance = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        socket_instance.settimeout(0)
        try:
            socket_instance.connect(("google.com", 443))
            ip_address = socket_instance.getsockname()[0]
        except socket.error as exception:
            logger.log(level=logger.FATAL, msg=f"Caught exception socket.error : {exception}")
            ip_address = None
        finally:
            socket_instance.close()
        return ip_address

    @staticmethod
    def set_monitor_listening_connection_interface(address, port):
        with open(MONITOR_FILE_PATH, 'w') as file:
            file.write(f"{address}:{port}")

    @staticmethod
    def get_monitor_listening_address():
        with open(MONITOR_FILE_PATH) as file:
            content = file.readline()
            return content.split(":")[0]

    @staticmethod
    def get_monitor_listening_port_number():
        with open(MONITOR_FILE_PATH) as file:
            content = file.readline()
            return content.split(":")[1]
