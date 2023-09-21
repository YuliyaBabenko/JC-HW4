package ru.geekbrains.hw4;

import static ru.geekbrains.hw4.ArrayConverter.convertAndSum;

public class ArrayTools {
    /**
     * Метод принимает двухмерный массив строк и его описание,
     * проверяет, что размер массива равен 4x4, иначе выбрасывает исключение.
     * Затем выполняет действия над массивом.
     *
     * @param array       двухмерный массив строк для проверки
     * @param description описание массива, используется в сообщении об ошибке
     * @throws MyArraySizeException если размер массива не равен 4x4
     */
    public static void processArray(String[][] array, String description) throws MyArraySizeException {
        if (array == null) throw new MyArraySizeException("Что-то пошло не так. \n" +
                "Получено значение null вместо массива (4х4)!");
        System.out.println("Массив");
        printArray(array);
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException(String.format("Массив %s должен быть размером 4х4!", description));
        } else {
            try {
                // Вызываем метод convertAndSum, который преобразует строки в числа и суммирует их
                int sum = convertAndSum(array);
                // Выводим результат

                System.out.println("Сумма: " + sum);
            } catch (MyArrayDataException e) {
                // Если возникло исключение, выводим сообщение об ошибке
                System.out.println("Неверные данные в массиве");
            }
        }
    }

    /**
     * Метод для вывода двухмерного массива с подстраиванием ширины колонок
     *
     * @param arr двухмерный массив строк
     */
    public static void printArray(String[][] arr) {
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.printf("%-5s", string);
            }
            System.out.println();
        }
    }
}
