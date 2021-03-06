package mliot.monitor.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mliot.monitor.MainApplication;
import mliot.monitor.model.Student;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static final int MONITOR_PORT_NUMBER = 1771;
    public static final String STUDENT_FILE_NAME = "students.json";
    public static final String STUDENT_FIRST_NAME = "first_name";
    public static final String STUDENT_LAST_NAME = "last_name";
    public static final String STUDENT_CARD_NUMBER = "card_number";
    public static final String STUDENT_IMAGES_DIRECTORY_NAME = "images";
    private static final Logger logger = Logger.getLogger(Util.class.getCanonicalName());

    public static String getIpAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("google.com"), 443);
            return socket.getLocalAddress().getHostAddress();
        } catch (UnknownHostException | SocketException e) {
            logger.log(Level.SEVERE, "Error while reading server's IP address", e);
            return null;
        }
    }

    public static JsonArray loadArrayOfStudents() {
        try {
            String fileName = String.format(Locale.getDefault(), "asset%s%s", File.separator, STUDENT_FILE_NAME);
            URL studentUrl = MainApplication.class.getResource(fileName);
            if (studentUrl != null) {
                File file = new File(studentUrl.getFile());
                String students = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                return new Gson().fromJson(students, JsonArray.class);
            }
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while reading the list of students from a file", e);
            return null;
        }
    }

    public static List<Student> loadListOfStudents() {
        JsonArray studentArray = loadArrayOfStudents();
        if (studentArray != null) {
            List<Student> studentList = new ArrayList<>();
            for (JsonElement jsonElement : studentArray) {
                JsonObject studentObject = jsonElement.getAsJsonObject();
                Student student = new Student();
                student.setFirstName(studentObject.get(Util.STUDENT_FIRST_NAME).getAsString());
                student.setLastName(studentObject.get(Util.STUDENT_LAST_NAME).getAsString());
                student.setCardNumber(studentObject.get(Util.STUDENT_CARD_NUMBER).getAsString());
                studentList.add(student);
            }
            return studentList;
        }
        return null;
    }

    public static byte[] readImage(String imageName) {
        try {
            String fileName = String.format(Locale.getDefault(), "asset%s%s%s%s.jpg", File.separator, STUDENT_IMAGES_DIRECTORY_NAME, File.separator, imageName);
            URL imageUrl = MainApplication.class.getResource(fileName);
            if (imageUrl != null) {
                File image = new File(imageUrl.getFile());
                BufferedImage buffer = ImageIO.read(image);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                ImageIO.write(buffer, "jpg", stream);
                return stream.toByteArray();
            }
            return null;
        } catch (IOException e) {
            logger.log(Level.SEVERE, String.format(Locale.getDefault(), "Error while reading image of a student identified by %s", imageName), e);
            return null;
        }
    }

    public static void saveExamUrl(String examUrl) {
        String fileName = String.format(Locale.getDefault(), "config%sexam.txt", File.separator);
        URL url = MainApplication.class.getResource(fileName);
        if (url != null) {
            File file = new File(url.getPath());
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(examUrl);
                writer.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE,"Error while writing in exam file", e);
            }
        }
    }

    public static void saveApiUrl(String apiUrl) {
        String fileName = String.format(Locale.getDefault(), "config%sapi.txt", File.separator);
        URL url = MainApplication.class.getResource(fileName);
        if (url != null) {
            File file = new File(url.getPath());
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(apiUrl);
                writer.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE,"Error while writing in api file", e);
            }
        }
    }

    public static String findApiUrl() {
        try {
            String fileName = String.format(Locale.getDefault(), "config%sapi.txt", File.separator);
            URL apiUrl = MainApplication.class.getResource(fileName);
            if (apiUrl != null) {
                File file = new File(apiUrl.getFile());
                return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            }
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error while reading in api file", e);
            return null;
        }
    }

    public static String findExamUrl() {
        try {
            String fileName = String.format(Locale.getDefault(), "config%sexam.txt", File.separator);
            URL examUrl = MainApplication.class.getResource(fileName);
            if (examUrl != null) {
                File file = new File(examUrl.getFile());
                return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            }
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error while reading in exam file", e);
            return null;
        }
    }
}
