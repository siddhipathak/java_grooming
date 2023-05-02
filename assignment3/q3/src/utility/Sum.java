package utility;

import java.util.concurrent.CompletableFuture;

public class Sum {

    public static Integer findSum(int start) {
        int sum = 0;
        for (int i = start; i <= start + 9; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> findSum(1))
                    .thenApply(sum -> findSum(11)).thenApply(sum -> findSum(21));
            System.out.println(completableFuture.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
