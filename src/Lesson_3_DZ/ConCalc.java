package Lesson_3_DZ;
import java.util.Scanner;
    public class ConCalc {

        public static void main(String[] args) {
            ConCalc calc = new ConCalc();
            calc.consoleCalc();
        }

        private boolean isValidInteger(String sStr){
            if(sStr == null)
                return false;

            try
            {
                Integer.parseInt(sStr);
            }
            catch (NumberFormatException e)
            {
                return false;
            }

            return true;
        }

        private boolean isValidOperation(String sStr){
            if(sStr == null)
                return false;

            switch(sStr){
                case "+":
                case "-":
                case "*":
                case "/":
                    return true;
            }

            return false;
        }

        private boolean isValidExpression(String[] sTokens){
            if(sTokens.length == 0)
                return true;

            if(!isValidInteger(sTokens[0]))
                return false;

            for(int i = 1; i < sTokens.length; i += 2){
                if(!isValidOperation(sTokens[i]) || i + 1 == sTokens.length || !isValidInteger(sTokens[i+1]))
                    return false;
            }

            return true;
        }

        public void consoleCalc() {
            Scanner in = new Scanner(System.in);
            String[] line = in.nextLine().split(" ");

            if(!isValidExpression(line)){
                System.out.println("Выражение некорректно и содержит ошибки");
                return;
            }

            int nRes = 0;

            if(line.length == 0){
                System.out.println("Результат: " + nRes);
                return;
            }

            nRes = Integer.parseInt(line[0]);

            for(int i = 1; i < line.length; i += 2) {
                int nRight = Integer.parseInt(line[i+1]);

                switch (line[i]) {
                    case "+":
                        nRes += nRight;
                        break;
                    case "-":
                        nRes -= nRight;
                        break;
                    case "*":
                        nRes *= nRight;
                        break;
                    case "/":
                        nRes /= nRight;
                }
            }

            System.out.println("Результат: " + nRes);
            in.close();
        }
    }

