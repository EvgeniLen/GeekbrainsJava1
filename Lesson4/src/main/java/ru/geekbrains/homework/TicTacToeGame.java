package ru.geekbrains.homework;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static Scanner sc;
    public static Random random;
    private static char[][] map;
    private static final int SIZE = 3;
    public static final int DOT_TO_WIN = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        random = new Random();
        init();
        printMap();

        while (true) {
            playerTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Поздравляем! Вы выиграли!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Выиграл AI!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Конец игры");
    }

    public static void init() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Ход игрока. Ввведите кординаты X и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!checkValue(x, y));
        map[x][y] = DOT_X;
    }

    public static void aiTurn() {
        int[] arr = getAICoordinates();
        System.out.println("Ход противника, введены координаты [" + (arr[0] + 1) + ", " + (arr[1] + 1) + "]");
        map[arr[0]][arr[1]] = DOT_O;
    }

    public static int[] getAICoordinates() {
        int[] arrAI = new int[2];

        int hor = 0;
        int vert = 0;
        int diag = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int almostWon = DOT_TO_WIN - 1;

                if (map[i][j] == DOT_X) {
                    vert++;
                    if (vert == almostWon) {
                        arrAI[0] = i;
                        if (j >= vert) {
                            for (int k = j; k >= (j - almostWon); k--) {
                                if (map[i][k] == DOT_EMPTY) {
                                    arrAI[1] = k;
                                    return arrAI;
                                }
                            }
                        } else if (j + 1 < SIZE && map[i][j + 1] == DOT_EMPTY) {
                            arrAI[1] = j + 1;
                            return arrAI;
                        } else if (j - almostWon >= 0 && map[i][j - almostWon] == DOT_EMPTY) {
                            arrAI[1] = j - almostWon;
                            return arrAI;
                        }
                    }
                }
                if (map[j][i] == DOT_X) {
                    hor++;
                    if (hor == almostWon) {
                        arrAI[1] = i;
                        if (j >= hor) {
                            for (int k = j; k >= (j - almostWon); k--) {
                                if (map[k][i] == DOT_EMPTY) {
                                    arrAI[0] = k;
                                    return arrAI;
                                }
                            }
                        } else if (j + 1 < SIZE && map[j + 1][i] == DOT_EMPTY) {
                            arrAI[0] = j + 1;
                            return arrAI;
                        } else if (j - almostWon >= 0 && map[j - almostWon][i] == DOT_EMPTY) {
                            arrAI[0] = j - almostWon;
                            return arrAI;
                        }
                    }
                }
                if (j == i && map[i][j] == DOT_X) {
                    diag++;
                    if (diag == almostWon) {
                        if (j + 1 < SIZE && map[j + 1][j + 1] == DOT_EMPTY) {
                            arrAI[0] = j + 1;
                            arrAI[1] = j + 1;
                            return arrAI;
                        } else if (j - almostWon >= 0 && map[j - almostWon][j - almostWon] == DOT_EMPTY) {
                            arrAI[0] = j - almostWon;
                            arrAI[1] = j - almostWon;
                            return arrAI;
                        }
                    }
                }
            }
            hor = 0;
            vert = 0;
        }

        do {

            arrAI[0] = random.nextInt(SIZE);
            arrAI[1] = random.nextInt(SIZE);
        } while (!checkValue(arrAI[0], arrAI[1]));

        return arrAI;
    }

    public static boolean checkValue(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWin(char c) {
        int hor = 0;
        int vert = 0;

        if (isDiagFill(c)) {
            return true;
        }

        if (isRightDiagFill(c)) {
            return true;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    hor++;
                } else {
                    hor--;
                }
                if (map[j][i] == c) {
                    vert++;
                } else {
                    vert--;
                }
            }
            if (hor == DOT_TO_WIN || vert == DOT_TO_WIN) {
                return true;
            }
            hor = 0;
            vert = 0;

        }
        return false;
    }

    public static boolean isDiagFill(char c) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == c) {
                count++;
                if (count == DOT_TO_WIN) return true;
            } else if (map[i][i] != c) {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (map[j][i] == c){
                    count++;
                    if (count == DOT_TO_WIN) return true;
                    break;
                } else if (map[j][i] != c){
                    count--;
                    break;
                }
            }
        }

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (map[i][j] == c){
                    count++;
                    if (count == DOT_TO_WIN) return true;
                    break;
                } else if (map[i][j] != c){
                    count--;
                    break;
                }
            }
        }

        return false;
    }

    public static boolean isRightDiagFill(char c){
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 1; j >= 0; j--) {
                if (j + i == SIZE - 1 && map[j][i] == c) {
                    count++;
                    if (count == DOT_TO_WIN) return true;
                } else if (j + i == SIZE - 1 && map[j][i] != c) {
                    count--;
                }
            }
        }

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 2; j >= 0; j--) {
                if (j + i == SIZE - 2 && map[j][i] == c) {
                    count++;
                    if (count == DOT_TO_WIN) return true;
                    break;
                } else if (j + i == SIZE - 2 && map[j][i] != c) {
                    count--;
                }
            }
        }

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 1; j >= 0; j--) {
                if (j + i == SIZE && map[j][i] == c) {
                    count++;
                    if (count == DOT_TO_WIN) return true;
                    break;
                } else if (j + i == SIZE && map[j][i] != c) {
                    count--;
                }
            }
        }
        return false;
    }

}