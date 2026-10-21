package c2_w1_m1;

public class Diamond {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Squre Shape");
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a<=n; a++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Increasing Triangle");
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a<=i; a++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Decreasing Triangle");
        for (int i = 1; i <= n; i++) {
            for (int a = i; a<=n; a++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Right Sided Triangle");
        for (int i = 1; i <= n; i++) {
            for (int a = i; a<=n; a++) {
                System.out.print(" ");
            }
            for (int a = 1; a<=i; a++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Left Sided Triangle");
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a<=i; a++) {
                System.out.print(" ");
            }
            for (int a = i; a<=n; a++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println("Diamon");
        for (int i = 1; i <= n; i++) {
            for (int a = 0; a < n - i; a++) {
                System.out.print(" ");
            }
            for (int b = 0; b < 2 * i - 1; b++) {  // stars
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int a = 0; a < n - i; a++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {  // stars
                System.out.print("*");
            }
            System.out.println();
        }
    }
}