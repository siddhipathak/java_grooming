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
            CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> findSum(1));
            CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> findSum(11));
            CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(() -> findSum(21));

            CompletableFuture future= completableFuture1.thenCombine(completableFuture2,(s1,s2)->s1+s2).thenCombine(completableFuture3,(s1,s2)->s1+s2);           
            System.out.println(future.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
