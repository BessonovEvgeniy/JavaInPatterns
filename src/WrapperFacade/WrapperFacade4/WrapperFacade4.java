package WrapperFacade.WrapperFacade4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

public class WrapperFacade4 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = new PrintStream(System.out);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String line = outputStream.toString();
        String[] chars = line.split(" ");

        Integer num1 = Integer.parseInt(chars[0]);
        Integer num2 = Integer.parseInt(chars[2]);
        Integer res = 0;

        if (chars[1].equals("+")){
            res = num1 + num2;
        }
        else if (chars[1].equals("*")){
            res = num1 * num2;
        }
        else if (chars[1].equals("-")){
            res = num1 - num2;
        }
        System.out.println(line.trim() + " " + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
