import java.util.Scanner;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String[] input = sc.nextLine().split(" ");

            String path = "";

            int[] result = findBest(findIndex(input[0]), findIndex(input[1]), input[2]);

            if (result[0] == -1) {

                path = input[0] + " -> " + input[1];

            } else {

                path = input[0] + " -> " + findTown(result[0]) + " -> " + input[1];

            }

            System.out.format("(%d min, %d km) %s\n", result[1], result[2], path);

        }

    }

    static int findIndex(String town) {

        String[] townArr = {"liberec", "ceska-lipa", "chrastava", "new-york", "turnov", "jablonec-nad-nisou"};

        for (int i = 0; i < townArr.length; i++) {

            if (townArr[i].equals(town)) {

                return i;

            }

        }

        return -1;

    }

    static String findTown(int i) {

        String[] townArr = {"liberec", "ceska-lipa", "chrastava", "new-york", "turnov", "jablonec-nad-nisou"};

        return townArr[i];

    }

    static int[] findBest(int indexR, int indexC, String path) {

        int[] values = new int[3];

        ArrayList<Integer> indexes = new ArrayList<Integer>();

        indexes.add(indexR);

        indexes.add(indexC);

        int[][] time = {

            {999, 999, 12, 24, 22, 20},

            {999, 999, 40, 10, 52, 999},

            {12, 40, 999, 20, 999, 999},

            {24, 10, 20, 999, 15, 30},

            {22, 52, 999, 15, 999, 22},

            {20, 999, 999, 30, 22, 999}

        };

        int[][] dist = {

            {999, 999, 10, 35, 26, 20},

            {999, 999, 47, 30, 67, 999},

            {10, 47, 999, 14, 999, 999},

            {35, 30, 14, 999, 40, 30},

            {26, 67, 999, 40, 999, 24},

            {20, 999, 999, 30, 24, 999}

        };

        switch (path) {

            case "nejkratsi":

                values = getMainVal(indexes, dist, 2);

                indexes.add(values[0]);

                values[1] = getSecVal(indexes, time);

                break;

            case "nejlepsi":

                values = getMainVal(indexes, time, 1);

                indexes.add(values[0]);

                values[2] = getSecVal(indexes, dist);

                break;

            default:

                break;

        }

        return values;

    }

    static int[] getMainVal(ArrayList<Integer> indexes, int[][] arrType, int type) {

        ArrayList<Integer> connect = new ArrayList<>();

        int[] best = new int[3];

        int sum;

        best[0] = -1;

        best[type] = arrType[indexes.get(0)][indexes.get(1)];

        for (int k = 0; k < arrType.length; k++) {

            if (arrType[indexes.get(0)][k] != 999) {

                connect.add(k);

            }

        }

        for (int m : connect) {

            sum = arrType[indexes.get(0)][m] + arrType[m][indexes.get(1)];

            if (sum < best[type]) {

                best[0] = m;

                best[type] = sum;

            }

        }

        return best;

    }

    static int getSecVal(ArrayList<Integer> indexes, int[][] arrType) {

        int val;

        if (indexes.get(2) == -1) {

            val = arrType[indexes.get(0)][indexes.get(1)];

        } else {

            val = arrType[indexes.get(0)][indexes.get(2)] + arrType[indexes.get(2)][indexes.get(1)];

        }

        return val;

    }

}

