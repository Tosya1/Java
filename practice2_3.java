// 3.* Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// (используйте методы split и replace)

package practice2;

public class practice2_3 {
    public static void main(String[] args) {
        String s = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(transfFromJSON(s));
    }
    static StringBuilder transfFromJSON (String s) {
        s = s.replace("{", " ");
        s = s.replace("}", " ");
        s = s.trim();
        String[] sl = s.split(", ");
        StringBuilder sb = new StringBuilder("where ");
        for (int i = 0; i < sl.length; i++) {
            if (!sl[i].contains("null")) {
                int ind = sl[i].indexOf(":");
                StringBuilder part1 = new StringBuilder(sl[i].substring(1, 2).toUpperCase()
                        + sl[i].substring(2, ind - 1));
                StringBuilder part2 = new StringBuilder(sl[i].substring(ind + 2, sl[i].length() - 1));
                if (i != sl.length - 2) {
                    sb.append(part1).append(" = ").append("'").append(part2)
                            .append("'").append(" AND ");
                } else {
                    sb.append(part1).append(" = ").append("'").append(part2)
                            .append("'");
                }
            }
        }
        return sb;
    }
}
