package WrapperFacade.WrapperFacade3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

public class WrapperFacade3 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = new PrintStream(System.out);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String line = outputStream.toString();

        System.setOut(consoleStream);


        for (char item : line.toCharArray()) {
            if (item >= '0' && item <= '9') {
                System.out.print(String.valueOf(item));
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
