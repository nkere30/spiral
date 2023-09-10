package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        fillSpiralArray(columns, rows, array);
        return array;
    }

    /*
    Fills the array with numbers starting from 1, in spiral direction.
    If it already reached spiral size and filled all the array cells, ends loop.
     */
    private static void fillSpiralArray(int columns, int rows, int[][] array) {
        int counter = 1, minCol = 0, maxCol = columns, minRow = 0, maxRow = rows, spiralSize = rows * columns;
        while(true) {
          counter = fillLeftToRight(minCol, maxCol, minRow, counter, array);
          if (counter > spiralSize) break;
          counter = fillTopToBottom(minRow + 1, maxRow, maxCol - 1, counter, array);
          counter = fillRightToLeft(maxCol - 2, minCol - 1, maxRow - 1, counter, array);
          counter = fillBottomToTop(maxRow - 2, minRow + 1, minCol, counter, array);
          minCol++; minRow++; maxCol--; maxRow--;
        }
    }

    /*
    Fills the unfilled cells of the array row, moving from left to right, increasing the number for every next cell.
     */
    private static int fillLeftToRight(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i < end; i++) {
            array[fixed][i] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    /*
    Fills the unfilled cells of the array column, moving from top to bottom, increasing the number for every next cell.
     */
    private static int fillTopToBottom(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i < end; i++) {
            array[i][fixed] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    /*
    Fills the unfilled cells of the array row, moving from right to left, increasing the number for every next cell.
     */
    private static int fillRightToLeft(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i > end; i--) {
            array[fixed][i] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }

    /*
    Fills the unfilled cells of the array column, moving from bottom to top, increasing the number for every next cell.
     */
    private static int fillBottomToTop(int start, int end, int fixed, int counter, int[][] array) {
        int tempCounter = counter;
        for (int i = start; i >= end; i--) {
            array[i][fixed] = tempCounter;
            tempCounter++;
        }
        return tempCounter;
    }
}
