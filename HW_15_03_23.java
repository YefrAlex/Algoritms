package Algoritms;

public class HW_15_03_23 {
    public static void main(String[] args) {
        int n = 3;
        hanoiTower(n);
        hanoiTowerRecurs(n, 'A', 'B', 'X');
    }


    public static void hanoiTower(int n) {
        int moves = (int) Math.pow(2, n) - 1; // количество ходов
        int from = 1, to = 3, using = 2; // начальные стержни
        if (n % 2 == 0) {
            int temp = to;
            to = using;
            using = temp;
        }
        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                moveDisk(from, to);
            } else if (i % 3 == 2) {
                moveDisk(from, using);
            } else {
                moveDisk(using, to);
            }
        }
    }

    private static void moveDisk(int from, int to) {
        System.out.println("Перекладываем диск со стержня № " + from + " на стержень № " + to);
    }
    public static void hanoiTowerRecurs(int n, char from, char to, char temp) {
        if (n == 1) {
            System.out.println("Перенести диск 1 с " + from + " на " + to);
        } else {
            hanoiTowerRecurs(n - 1, from, temp, to);
            System.out.println("Перенести диск " + n + " с " + from + " на " + to);
            hanoiTowerRecurs(n - 1, temp, to, from);
        }
    }

}
