import socket


class NetworkHelper:

    @staticmethod
    def listening_address():
        socket_instance = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        socket_instance.settimeout(0)
        try:
            socket_instance.connect(("google.com", 443))
            ip_address = socket_instance.getsockname()[0]
        except socket.error as exception:
            print("Caught exception socket.error : %s" % exception)
            ip_address = None
        finally:
            socket_instance.close()
        return ip_address

    @staticmethod
    def listening_port():
        return 7117
