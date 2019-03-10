package Lesson_2_DZ;

import java.util.Arrays;

    public class Main {

        public static void main(String[] args) {

            nullToOne();
            System.out.println("------------");
            addTree();
            System.out.println("------------");
            SixToTwo();
            System.out.println("------------");
            diagOne();
            System.out.println("------------");
            minMax();
            System.out.println("------------");

        }
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        public static void nullToOne() {
            int[] NtO = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            for (int i = 0; i < NtO.length; ++i) {
                if (NtO[i] == 0)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.print("\n");
        }
        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        public static void addTree() {
            int[] addTree = new int[8];
            for (int i = 1; i < addTree.length; ++i){
                addTree[i] = addTree[i-1]+3;
            }
            System.out.println(Arrays.toString(addTree));
        }
        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        public static void SixToTwo() {
            int[] SixToTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < SixToTwo.length; ++i) {
                if(SixToTwo[i] < 6) SixToTwo[i] *= 2;
            }
            System.out.println(Arrays.toString(SixToTwo));
        }
        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        public static void diagOne(){
            int [] [] DiagOne = new int [4] [4];
            int c = 1;
            for(int i = 0; i < DiagOne.length; ++i){
                for(int j = 0; j < DiagOne[i].length; ++j){
                    int r;
                    System.out.print((r = (j == i || j == DiagOne[i].length - c ) ? 1 : 0) + " ");
                }
                ++c;
                System.out.print("\n");
            }
        }
        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        public static void minMax() {
            int[] MinMax = {10,34,56,5,73,88,43,4,17};
            int MaxNum = 0;
            int MinNum = 0;
            for (int i = 1; i < MinMax.length; ++i) {
                if (MaxNum < MinMax[i]) MaxNum = MinMax[i];
                else if (MinNum > MinMax[i]) MinNum = MinMax[i];
            }
            System.out.println("Mинимальное  : "+ MinNum);
            System.out.println("Максимальное : "+ MaxNum);
        }
        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

}
