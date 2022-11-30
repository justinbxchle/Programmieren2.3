public class MagicSquare {
    public MagicSquare(int[][] square) {
    }

    //Gernerating the Magic Number for a k-Square
    static int magicNumber(int k) {
        int magicNumber;
        double tmp;
        tmp = Math.pow(k, 3);
        magicNumber = (int) ((tmp + k) / 2.0);
        return magicNumber;
    }

    //Output of Magic Numbers from 0 to k
    static String showMagicNumbers(int k) {
        String magicNumber = "";
        for (int i = 1; i <= k; i++) {
            magicNumber = magicNumber + magicNumber(i);
            if (i < k) {
                magicNumber = magicNumber + ",";
            }
        }
        return magicNumber;
    }

    //Method to sum the Square
    static int[] sum(int[][] square) {
        int tmpVertical = 0;
        int tmpHorizontal = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;
        int l = square[0].length;
        int[] sum = new int [(2 * l) + 2];
        for (int i = 0; i < l; i++){
            for (int j = 0; j < l; j++) {
                //sum vertical lines
                tmpVertical = tmpVertical + square[i][j];
                //sum horizontal lines
                tmpHorizontal = tmpHorizontal + square[j][i];
            }
            sum[i] = tmpVertical;
            sum[l + i] = tmpHorizontal;
            tmpVertical = 0;
            tmpHorizontal = 0;
            //sum diagonals
            diagonal1 = diagonal1 + square[i][i];
            diagonal2 = diagonal2 + square[i][l - i - 1];

        }
        sum[2 * l] = diagonal1;
        sum[(2 * l) + 1] = diagonal2;
        return sum;
    }

    //
    static boolean isMagicSquare(String numbers) {
        int[][] square = toSquare(numbers);
        int n = square[0].length;
        boolean magicSquare = true;
        int[] sum = sum(square);
        int l = sum.length;
        for (int i = 0; i < l - 1; i++) {
            if (sum[i] != sum[i + 1] || sum[0] != magicNumber(n)) {
                magicSquare = false;
            }
        }
        return magicSquare;
    }

    static boolean isSemimagicSquare(String numbers) {
        int[][] square = toSquare(numbers);
        int n = square[0].length;
        int[] sum = sum(square);
        boolean semiSquare = true;
        int l = sum.length;
        for (int i = 0; i < (l - 3); i++) {
            if (sum[i] != sum[i + 1] || (sum[l - 2] == sum[l - 1] && sum[l - 2] == magicNumber(n))) {
                semiSquare = false;
            }
        }
        return semiSquare;
    }




    static int[][] complement(String square) {
        //Extract the numbers
        int[][] numbersA = toSquare(square);
        int n = numbersA[0].length;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp = numbersA[i][j];
                numbersA[i][j] = (tmp * (-1)) + (int) (Math.pow(n, 2) + 1);
            }
        }

        return numbersA;
    }

    static int[][] toSquare(String square) {
        String numbersOnly = square.replaceAll("[^0-9]", "");
        char[] chars = numbersOnly.toCharArray();
        int l = chars.length;
        int n = (int) Math.sqrt(l);
        int count = 0;
        int[][] numbers = new int [l][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numbers[i][j] = Character.getNumericValue(chars[count]);
                count++;
            }
        }
        return numbers;
    }

    static String toString(int[][] square) {
        int l = square[0].length;
        String squareString = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                squareString = squareString + square[i][j];
                if (j < l-1) {
                    squareString = squareString + " ";
                }
            }
            if (i < l-1) {
                squareString = squareString + "\n";
            }
        }
        return squareString;
    }


}