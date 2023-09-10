package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        fillArray(columns, rows, array);
        return array;
    }

    private static void fillArray(int columns, int rows, int[][] array) {
        int counter = 1;
        int minCol = 0;
        int maxCol = columns;
        int minRow = 0;
        int maxRow = rows;
        int spiralSize = rows * columns;
        while(true) {
//            for (int i = minCol; i < maxCol; i++) {
//                array[minRow][i] = counter;
//                counter++;
//            }
          counter = increaseRight(minCol, maxCol, minRow, counter, array);

            if (counter > spiralSize) break;
            counter = increaseDown(minRow + 1, maxRow, maxCol - 1, counter, array);
//            for (int i = minRow + 1; i < maxRow; i++) {
//                array[i][maxCol - 1] = counter;
//                counter++;
//            }
            counter = decreaseLeft(maxCol - 2, minCol - 1, maxRow - 1, counter, array);
//            for (int i = maxCol - 2; i > minCol - 1; i--) {
//                array[maxRow - 1][i] = counter;
//                counter++;
//            }
            counter = decreaseUp(maxRow - 2, minRow + 1, minCol, counter, array);
//            for (int i = maxRow - 2; i >= minRow + 1; i--) {
//                array[i][minCol] = counter;
//                counter++;
//            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
    }


    private static int increaseRight(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i < end; i++) {
            array[fixed][i] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    private static int increaseDown(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i < end; i++) {
            array[i][fixed] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    private static int decreaseLeft(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i > end; i--) {
            array[fixed][i] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    private static int decreaseUp(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i >= end; i--) {
            array[i][fixed] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }
}
