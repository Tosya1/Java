// 1. Напишите метод, который вернет содержимое текущей папки в виде массива строк.
// Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции. В случае возникновения 
// исключения, оно должно записаться в лог-файл. (используйте метод list класса File)
// 
// 2. Напишите метод, который определит тип (расширение) файлов из текущей папки 
// и выведет в консоль результат вида:
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg


package practice2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;

public class practice2 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(practice2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        fh.setLevel(Level.WARNING);

        String path = System.getProperty("user.dir");
        ArrayList li = getDirCont(path, logger);
        System.out.println(li);
        writeToFile(li, logger);
        getFilesExt(li);
    }

    static ArrayList<String> getDirCont(String path, Logger logger) {
        ArrayList<String> li = new ArrayList<>();
        File dir = new File(path);
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                li.add(item.getName());
            }
        }
        return li;
    }

    static void writeToFile(ArrayList li, Logger logger) {
        File dirCont = new File("dirContent.txt");
        try {
            boolean created = dirCont.createNewFile();
            if (created) {
                System.out.printf("Файл %s создан", dirCont);
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        try (FileWriter fr = new FileWriter("dirContent.txt", false)) {
            for (int i = 0; i < li.size(); i++) {
                fr.write(li.get(i) + "\n");
            }
            fr.flush();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            logger.warning(e.getMessage());
        }
    }

    // 2.
    static void getFilesExt(ArrayList<String> li) {
        int count = 1;
        for (int i = 0; i < li.size(); i++) {
            if ((li.get(i).indexOf('.')) >= 0) {
                String ext = li.get(i).substring(li.get(i).indexOf('.') + 1);
                System.out.printf("%d Расширение файла %s: %s \n", count, li.get(i), ext);
            } else {
                System.out.printf("%d Расширение файла %s: \n", count, li.get(i));
            }
            count++;
        }
    }
}
