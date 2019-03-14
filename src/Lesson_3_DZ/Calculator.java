package Lesson_3_DZ;

import java.util.Scanner;

/* Дополнительное задание, простейший калькулятор
   1 Складывать больше двух чисел сразу
   2 Добавить опреации
   3 Проверка что введено число
    --необязательно
   4 Приоритет операций
   5 Реализовать несколько операторов в строке**
*/
public class Calculator {

    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(sc.hasNextInt()){
            num = sc.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            sc.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(sc.hasNext()){
            operation = sc.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            sc.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
