package pages.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    private static final SimpleDateFormat DAY_FORMATTER = new SimpleDateFormat("dd", Locale.ENGLISH);
    private static final SimpleDateFormat MONTH_FORMATTER = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    private static final SimpleDateFormat YEAR_FORMATTER = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    private static final List<String> SUBJECTS = Arrays.asList(
            "Hindi",
            "English",
            "Maths",
            "Physics",
            "Chemistry",
            "Biology",
            "Computer Science",
            "Commerce",
            "Accounting",
            "Economics",
            "Arts",
            "Social Studies",
            "History",
            "Civics"
    );
    private static final List<String> STATES = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    private static final Map<String, List<String>> STATES_WITH_CITIES = new HashMap<>(STATES.size()) {
        {
            put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
            put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
            put("Haryana", Arrays.asList("Karnal", "Panipat"));
            put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        }
    };
    static Faker faker = new Faker(Locale.ENGLISH);


    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }


    public static Date getBirthDay() {
        return faker.date().birthday();
    }

    public static String dayOfBirthday(Date date) {
        return DAY_FORMATTER.format(date);
    }

    public static String monthOfBirthday(Date date) {
        return MONTH_FORMATTER.format(date);
    }

    public static String yearOfBirthday(Date date) {
        return YEAR_FORMATTER.format(date);
    }

    public static String getSubjects(String... used) {
        List<String> subjectsCopy = new ArrayList<>(SUBJECTS);
        subjectsCopy.removeAll(Arrays.asList(used));
        return faker.options().nextElement(subjectsCopy);
    }

    public static String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getPicture() {
        return faker.options().option("test.jpg", "test1.jpeg", "test2.jpg");
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        return faker.options().nextElement(STATES);
    }

    public static String getCity(String state) {
        List<String> cities = STATES_WITH_CITIES.get(state);
        return faker.options().nextElement(cities);
    }

}
