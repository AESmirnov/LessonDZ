package Lesson_3_DZ;

import java.util.Random;
import java.util.Scanner;

    public class Dz3 {
        public static void main(String[] args) {
          guessNumber();
          guessWord();
        }
        /*
         1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
            При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
            После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
         */
        public static void guessNumber() {
                Scanner scanAnswer = new Scanner(System.in);
                boolean isFlag = false;
                char answer;

                guessNumberRun();

            do {
                System.out.println("Повторить игру еще раз? 1–да/0–нет:");
                while (!scanAnswer.hasNext("[10]")) {
                    System.out.println("Не 1/0. Введите 1–да/0–нет:");
                    scanAnswer.next();
                }
                answer = scanAnswer.next().charAt(0);
                if ('0' == answer) {
                    isFlag = true;
                } else if ('1' == answer) {
                    guessNumberRun();
                }
            } while (!isFlag);
        }

        public static void guessNumberRun() {
            Scanner scanner = new Scanner(System.in);
            Random randomNumber = new Random();
            int unknownNumber = randomNumber.nextInt(10);
            boolean isWin = false;
            int currentNumber;
            for (int i = 0; i < 3; i++) {
                System.out.printf("Введите число от 0 до 9: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Не число. Введите число от 0 до 9:");
                    scanner.next();
                }
                currentNumber = scanner.nextInt();
                if (currentNumber == unknownNumber) {
                    isWin = true;
                    break;
                } else if (currentNumber > unknownNumber) {
                    System.out.printf("%d > загаданное\n\n", currentNumber);
                } else {
                    System.out.printf("%d < загаданное\n\n", currentNumber);
                }
            }
            if (isWin) System.out.println("Победа");
            else System.out.printf("Game Over. Ответ: %d\n", unknownNumber);
        }

        /*
        2 . Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
           "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
           "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
           "pepper", "pineapple", "pumpkin", "potato"};
           При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
           сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
           Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
           apple – загаданное
           apricot - ответ игрока
           ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
           Для сравнения двух слов посимвольно, можно пользоваться:
           String str = "apple";
           str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
           Играем до тех пор, пока игрок не отгадает слово
           Используем только маленькие буквы
         */
        public static void guessWord() {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                              "avocado", "broccoli", "carrot", "cherry", "garlic",
                              "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                              "nut", "olive", "pea", "peanut", "pear", "pepper",
                              "pineapple", "pumpkin", "potato"
            };
            int wordLength = words.length;
            Scanner scanWord = new Scanner(System.in);
            Random randomWord = new Random();
            int randomNumWord = randomWord.nextInt(wordLength);
            String unknowWord = words[randomNumWord];
            int hiddenWordLength = unknowWord.length();
            String inputWord;
            int inputLength;
            int countChar;
            boolean flag = true;
            String hiddenChar = "#";
            String knowWord;
            do {
                System.out.println("Введите слово:");
                countChar = 0;
                while (!scanWord.hasNext()) {
                    System.out.println("Введите слово:");
                    scanWord.next();
                }
                inputWord = scanWord.nextLine().toLowerCase();
                inputLength = inputWord.length();
                knowWord = "";
                for (int i = 0; i < inputLength && i < hiddenWordLength; i++) {
                    if (inputWord.charAt(i) == unknowWord.charAt(i)) {
                        knowWord += inputWord.charAt(i);
                        countChar++;
                    } else {
                        knowWord += hiddenChar;
                    }
                }
                for (int i = 0; i < 15 - knowWord.length(); i++) {
                    knowWord += hiddenChar;
                }
                if (inputLength == hiddenWordLength && countChar == hiddenWordLength) {
                    flag = false;
                    System.out.println("Вы победили!");
                } else if (countChar> 0) {
                    System.out.println(knowWord);
                } else {
                    System.out.println("нет совпадений\n");
                }

            } while (flag);
        }

}
