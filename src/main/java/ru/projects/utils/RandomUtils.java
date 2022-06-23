package ru.projects.utils;

import org.apache.commons.lang3.RandomStringUtils;
import ru.projects.ConfigQA;
import ru.projects.dictionary.ShareholderDocInfoType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils extends org.apache.commons.lang3.RandomUtils {
    private static List<String> lastNames = Arrays.asList("Косоруков", "Эскин", "Немцов", "Крыжов", "Кондаков",
            "Мячин", "Бессонов", "Щедров", "Буслаев", "Ярошенко", "Кутузов", "Хлопонин", "Паринов", "Кабалкин",
            "Гуськов", "Алябьев", "Москвин", "Филиппов", "Карпюк", "Болокан", "Кардапольцев", "Ягутян", "Есаулов",
            "Мятлев", "Кандаков", "Шевцов", "Каде", "Веселков", "Воронов", "Кубланов", "Старицкий", "Митрушичев",
            "Барышев", "Цехановецкий", "Явленский", "Кутепов", "Манторов", "Прибылов", "Алленов", "Саянов", "Лобачёв",
            "Хуртин", "Топорков", "Храмов", "Кручинин", "Комолов", "Богданов", "Болтунов", "Норин", "Тимирязев",
            "Водопьянов", "Степанишин", "Изотов", "Шмаков", "Сомов", "Федоров", "Добролюбов", "Мандрыко", "Люба",
            "Шатохин", "Ящук", "Квартиров", "Мадулин", "Лясин", "Саитов", "Поздов", "Хабенский", "Ян", "Иканов",
            "Ярополов", "Титов", "Розанов", "Ясенев", "Ямпольский", "Ешевский", "Мощенский", "Круминьш", "Ожогин",
            "Митрохов", "Прохоров", "Бальсунов", "Яимов", "Перфильев", "Цирюльников", "Опринчук", "Кадцын", "Мусорин",
            "Ревягин", "Шелагин", "Печкин", "Владимиров", "Никишов", "Шкуратов", "Богачёв", "Голодяев", "Саянкин",
            "Петрунин", "Нужнов", "Ягренев");
    private static List<String> firstNames = Arrays.asList("Михей", "Артур", "Прокл", "Федот", "Мефодий", "Эрнест",
            "Онуфрий", "Изяслав", "Роман", "Измаил", "Клавдий", "Георгий", "Богдан", "Константин", "Дмитрий", "Владилен",
            "Матвей", "Феофан", "Михаил", "Григорий", "Борислав", "Порфирий", "Артём", "Адам", "Андрон", "Виталий",
            "Марк", "Агап", "Макар", "Демьян", "Ростислав", "Евстигней", "Потап", "Евгений", "Ярослав", "Артем",
            "Никанор", "Мартын", "Тимур", "Чеслав", "Иннокентий", "Данила", "Лев", "Борис", "Станислав", "Аскольд",
            "Анатолий", "Назар", "Серафим", "Феликс", "Капитон", "Александр", "Викентий", "Фока", "Поликарп", "Пимен",
            "Вацлав", "Игнатий", "Иосиф", "Федор", "Петр", "Егор", "Денис", "Якуб", "Осип", "Прокофий", "Трофим",
            "Зиновий", "Фома", "Ефрем", "Кир", "Никон", "Варфоломей", "Лукьян", "Адриан", "Авдей", "Мирон", "Эдуард", "Елизар");
    private static List<String> middleNames = Arrays.asList("Евлампиевич", "Михеевич", "Мартьянович",
            "Севастьянович", "Саввевич", "Яковович", "Георгиевич", "Владиславович", "Климентович", "Иннокентиевич",
            "Кириллович", "Егорович", "Игнатиевич", "Эрнестович", "Леонович", "Кондратович", "Андреевич", "Капитонович",
            "Трофимович", "Святославович", "Миронович", "Макарович", "Адрианович", "Филимонович", "Эдуардович",
            "Филиппович", "Ипполитович", "Изяславович", "Моисеевич", "Тарасович", "Несторович", "Александрович",
            "Аполлинариевич", "Иванович", "Геннадиевич", "Андриянович", "Дмитриевич", "Никанорович", "Эмилевич",
            "Никонович", "Ипатиевич", "Натанович", "Прохорович", "Алексеевич", "Елисеевич", "Валерьянович", "Гордеевич",
            "Брониславович", "Мирославович", "Сигизмундович", "Прокофиевич", "Остапович", "Евгениевич", "Вячеславович",
            "Сергеевич", "Модестович", "Якубович", "Захарович", "Потапович", "Ростиславович", "Фролович", "Даниилович",
            "Иосифович", "Платонович", "Ульянович", "Ираклиевич", "Игоревич", "Левович", "Леонтиевич", "Давыдович",
            "Сидорович", "Измаилович");

    public static String nextPhone() {
        return "+7999" + nextLong(1000000, 2999999);
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static String getRandomLastName() {
        return lastNames.get(randInt(0, lastNames.size() - 1));
    }

    public static String getRandomFirstName() {
        return firstNames.get(randInt(0, firstNames.size() - 1));
    }

    public static String getRandomMiddleName() {
        return middleNames.get(randInt(0, middleNames.size() - 1));
    }

    public static String nextEmail() {
        return String.format("at%s@dasredatest.ru", getTimeStemp());
    }

    public static String nextString(int bound) {
        return RandomStringUtils.randomAlphabetic(bound);
    }

    public static String getTimeStemp() {
        return new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Timestamp(System.currentTimeMillis()));
    }

    public static String getEmailWithTimeStamp(String email) {
        return email.replaceFirst("@", String.format("+%s@", getTimeStemp()));
    }

    public static String getRandomGoogleEmail() {
        String defGoogleEmail = ConfigQA.getInstance().getParams().getGmailUserName();
        return getEmailWithTimeStamp(defGoogleEmail);
    }

    public static String getRandomINN() {
        int region = randInt(10, 92);
        int inspection = randInt(52, 99);
        int number = randInt(100000, 999999);

        String inn = String.valueOf(region) + String.valueOf(inspection) + String.valueOf(number);
        long[] innNumbers = Arrays.stream(inn.split("")).mapToLong(Long::parseLong).toArray();
        long controlNumber1 = (7 * innNumbers[0] + 2 * innNumbers[1] + 4 * innNumbers[2] + 10 * innNumbers[3] + 3 * innNumbers[4]
                + 5 * innNumbers[5] + 9 * innNumbers[6] + 4 * innNumbers[7] + 6 * innNumbers[8] + 8 * innNumbers[9]) % 11 % 10;

        if (controlNumber1 == 10)
            controlNumber1 = 0;

        inn = String.valueOf(Long.parseLong(inn)) + String.valueOf(controlNumber1);
        innNumbers = Arrays.stream(inn.split("")).mapToLong(Long::parseLong).toArray();
        long controlNumber2 = (3 * innNumbers[0] + 7 * innNumbers[1] + 2 * innNumbers[2] + 4 * innNumbers[3] + 10 * innNumbers[4]
                + 3 * innNumbers[5] + 5 * innNumbers[6] + 9 * innNumbers[7] + 4 * innNumbers[8] + 6 * innNumbers[9] + 8 * innNumbers[10]) % 11 % 10;

        if (controlNumber2 == 10)
            controlNumber2 = 0;

        inn = String.valueOf(Long.parseLong(inn)) + String.valueOf(controlNumber2);

        return inn;
    }

    public static String getRandomCaTransactionId() {
        return "f06e9b1f-9fa4-44ca-a07e-"
                + new SimpleDateFormat("yyMMddHHmmss").format(new Timestamp(System.currentTimeMillis()));
    }

    public static String randomNumber(int sizeOfNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeOfNumber; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
}
