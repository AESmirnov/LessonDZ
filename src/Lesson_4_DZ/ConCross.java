package Lesson_4_DZ;

import java.util.Random;
import java.util.Scanner;

public class ConCross {

        static int SIZE_X = 5;
        static int SIZE_Y = 5;

        static char[][] field = new char[SIZE_Y][SIZE_X];

        static char PLAYER_DOT = 'X';
        static char AI_DOT = 'O';
        static char EMPTY_DOT = '.';

        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();

    // заполнить поле
        private static void initField() {
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    field[i][j] = EMPTY_DOT;
                }
            }
        }
        private static void fillLineH( int leftShift, String symbol, int lineLength ) {
            System.out.println(new String(new char[leftShift]).replace("\0", " ")
                               +new String(new char[lineLength*2]).replace("\0", symbol));
        }
        // метод для вывода на консоль поля
        private static void printField() {
            System.out.print(" ");
            for (int j = 0; j < SIZE_Y; j++ ) {
                System.out.print(" "+(j+1));
            }
            System.out.println("");
            fillLineH(2,"-",SIZE_X);
            for (int i = 0; i < SIZE_X; i++) {
                System.out.print(1+i + "|");
                for (int j = 0; j < SIZE_Y; j++) {
                    System.out.print(field[i][j] + "|");
                }
                System.out.println();
            }
            fillLineH(2,"-",SIZE_X);
        }

        // метод для установки символа
        private static void setSym(int y, int x, char sym) {
            field[y][x] = sym;
        }

        // проверка валидности ячейки
        private static boolean isCellValid(int y, int x) {
            if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
                return false;
            }
            return field[y][x] == EMPTY_DOT;
        }

        // ход человека
        private static void playerStep() {
            int x;
            int y;
            do {
                System.out.println("Введите координаты: X Y (1 - "+SIZE_X+")");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(y,x));
            setSym(y, x, PLAYER_DOT);
        }

        // ход ПК
        private static void aiStep() {
            int x=-1;
            int y=-1;
            boolean userwin = false;
            boolean aiwin = false;
            // находим выигрышный ход у ПК
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    if (field[j][i]==EMPTY_DOT) {
                        setSym(j, i, AI_DOT);
                        if (checkWin(AI_DOT)) {
                            x = i;
                            y = j;
                            aiwin = true;
                        }
                        setSym(j, i, EMPTY_DOT);
                    }
                }
            }
            // находим выигрышный ход у человека
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    if (field[j][i]==EMPTY_DOT) {
                        setSym(j, i, PLAYER_DOT);
                        if (checkWin(PLAYER_DOT)) {
                            x = i;
                            y = j;
                            userwin = true;
                        }
                        setSym(j, i, EMPTY_DOT);
                    }
                }
            }
            if (!userwin && !aiwin) {
                do {
                    x = random.nextInt(SIZE_X);
                    y = random.nextInt(SIZE_Y);
                } while (!isCellValid(y, x));
            }
            if (!isCellValid(y, x))
                setSym(y, x, AI_DOT);
        }

        /*
         * если не встретили пустую ячейку
         * это значит что все поле заполнено
         * */
        private static boolean isDraw() {
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    if(field[i][j] == EMPTY_DOT) {
                        return false;
                    }
                }
            }
            return true;
        }

        private static boolean checkDiagonal(char sym) {
            boolean toRight, toLeft;
            toRight = true;
            toLeft = true;
            for (int i=0; i<SIZE_X; i++) {
                // по 2-м диагоналям
                toRight &= (field[i][i] == sym);
                toLeft &= (field[SIZE_X-i-1][i] == sym);
            }
            if (toRight || toLeft) return true;
            return false;
        }
        private static boolean checkLines(char sym) {
        boolean cols, rows;
        for (int col=0; col<SIZE_Y; col++) {
            cols = true;
            rows = true;
            for (int row=0; row<SIZE_X; row++) {
                cols &= (field[col][row] == sym);
                rows &= (field[row][col] == sym);
            }
            if (cols || rows) return true;
        }

        return false;
    }

        private static boolean checkWin(char sym) {
            for (int col=0; col<SIZE_Y; col++) {
                for (int row=0; row<SIZE_X; row++) {
                    if (checkDiagonal(sym) || checkLines(sym))
                        return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            initField();
            printField();

            while (true) {
                playerStep();
                printField();
                if(checkWin(PLAYER_DOT)) {
                    System.out.println("Player WIN!");
                    break;
                }
                if(isDraw()) {
                    System.out.println("DRAW");
                    break;
                }

                aiStep();
                printField();
                if(checkWin(AI_DOT)) {
                    System.out.println("SKYNET WIN!");
                    break;
                }
                if(isDraw()) {
                    System.out.println("DRAW");
                    break;
                }
            }
        }


}
