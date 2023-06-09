// Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа

// Исходная json строка это просто String !!! Для работы используйте методы String, 
// такие как replace, split, substring и т.д. по необходимости

// Создать метод, который запишет результат работы в файл. 
// Обработайте исключения и запишите ошибки в лог файл.

import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class task1 {
    public static void main(String[] args) throws IOException {
        String jsonString = "[{ \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        // Парсинг json-строки и формирование строки с оценками
        JSONArray jsonArray = new JSONArray(jsonString);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            stringBuilder.append("Студент ").append(jsonObject.getString("фамилия"))
                    .append(" получил ").append(jsonObject.getString("оценка"))
                    .append(" по предмету ").append(jsonObject.getString("предмет"))
                    .append(".\n");
        }

        // Запись результата в файл и обработка исключений
        File outputFile = new File("output.txt");
        File logFile = new File("log.txt");
        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            FileWriter logWriter = new FileWriter(logFile, true);
            logWriter.write("Ошибка: файл не найден.n");
            logWriter.close();
        } catch (IOException e) {
            FileWriter logWriter = new FileWriter(logFile, true);
            logWriter.write("Ошибка: " + e.getMessage() + "n");
            logWriter.close();
        }

    }
}