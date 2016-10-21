package Adapter.Adapter2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String line = scanner.nextLine();
            String[] params = line.split(" ",4);
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = new Date();
            try {
                birthDate = formatter.parse(params[3]);
            }
            catch (ParseException e){}
            return new Person(params[1], params[2], params[0], birthDate);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
    public static void main(String[] args) throws Exception {
        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner("Иванов Иван Иванович 31 12 1950"));
        Person person = psa.read();
    }
}
