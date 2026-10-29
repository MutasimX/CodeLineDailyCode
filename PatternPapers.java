package week2;

import java.util.Scanner;

public class PatternPapers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        title("Paper 1: Hollow Square");
        hollowSquare(n);

        title("Paper 2: Repeated Number Triangle");
        repeatedNumberTriangle(n);

        title("Paper 3: Reverse Number Triangle");
        reverseNumberTriangle(n);

        title("Paper 4: Full Diamond");
        fullDiamond(n);

        title("Paper 5: Hollow Diamond");
        hollowDiamond(n);

        title("Paper 6: X Pattern");
        xPattern(n);

        title("Paper 7: Hourglass");
        hourglass(n);

        title("Paper 8: Descending Alphabet Triangle");
        descendingAlphabetTriangle(n);

        title("Paper 9: Odd Number Triangle");
        oddNumberTriangle(n);

        title("Paper 10: Plus Sign");
        plusSign(n);

        sc.close();
    }

    static void title(String text) {
        System.out.println();
        System.out.println(text);
    }

    static void spaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    static void stars(int count) {
        for (int i = 0; i < count; i++) System.out.print("*");
    }

    // Paper 1: Hollow Square
    static void hollowSquare(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // Paper 2: Repeated Number Triangle
    static void repeatedNumberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Paper 3: Reverse Number Triangle
    static void reverseNumberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Paper 4: Full Diamond
    static void fullDiamond(int n) {
        for (int i = 1; i <= n; i++) {
            spaces(n - i);
            stars(2 * i - 1);
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            spaces(n - i);
            stars(2 * i - 1);
            System.out.println();
        }
    }

    // Paper 5: Hollow Diamond
    static void hollowDiamond(int n) {
        for (int i = 1; i <= n; i++) {
            hollowDiamondRow(n, i);
        }
        for (int i = n - 1; i >= 1; i--) {
            hollowDiamondRow(n, i);
        }
    }

    static void hollowDiamondRow(int n, int i) {
        spaces(n - i);
        System.out.print("*");
        if (i > 1) {
            spaces(2 * i - 3);
            System.out.print("*");
        }
        System.out.println();
    }

    // Paper 6: X Pattern
    static void xPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i + j == n + 1) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // Paper 7: Hourglass
    static void hourglass(int n) {
        for (int i = n; i >= 1; i--) {
            spaces(n - i);
            stars(2 * i - 1);
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            spaces(n - i);
            stars(2 * i - 1);
            System.out.println();
        }
    }

    // Paper 8: Descending Alphabet Triangle
    static void descendingAlphabetTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print((char) ('A' + n - 1 - k));
            }
            System.out.println();
        }
    }

    // Paper 9: Odd Number Triangle
    static void oddNumberTriangle(int n) {
        int odd = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(odd + " ");
                odd += 2;
            }
            System.out.println();
        }
    }

    // Paper 10: Plus Sign
    static void plusSign(int n) {
        int mid = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == mid || j == mid) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
