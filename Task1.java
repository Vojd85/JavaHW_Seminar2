/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос. 
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
то есть должно получиться что-то вроде:
... where name = Ivanov and country = Russia and city = Moscow 
*/

package HomeWorks.Seminar2;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Task1 {
    public static void main(String[] args) {
        String sql = "select * from students where ";
        JSONParser parser = new JSONParser();
        String path = "C:/Users/Вождь/Desktop/SecondQuarter/Java/HomeWorks/Seminar2/file.json";
        try (FileReader reader = new FileReader(path))
        {
            JSONObject jsobj = (JSONObject)parser.parse(reader);
            StringBuilder res = new StringBuilder();
            res.append(sql);
            for (Object key: jsobj.keySet()) {
                String keyStr = (String)key;
                Object keyvalue = jsobj.get(keyStr);
                System.out.println();
                if (keyvalue.equals("null") == false) {
                    if (jsobj.keySet().toArray()[0] == key) {
                        res.append(String.format("\"%s\" = \"%s\"", keyStr, keyvalue));
                    }
                    else {res.append(String.format(" and \"%s\" = \"%s\"", keyStr, keyvalue));
                    }
                }
            }
            System.out.println(res);
        } catch (IOException | ParseException ex) {
            ex.getStackTrace();
            System.out.println(ex);
        }
    }
}
