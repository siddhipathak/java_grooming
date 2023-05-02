package com.example.q2.utility;

import java.util.concurrent.RecursiveTask;

public class CountInstance extends RecursiveTask<Integer> {

    int target;
    int start, end;
    int threshold = 100;

    public CountInstance(int target, int start, int end) {
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int arrLength = end - start + 1;

        if (arrLength <= threshold)
            return countFreq();
        else {
            int mid = (start + threshold) - 1;

            CountInstance subtask_1 = new CountInstance(target, start, mid);
            CountInstance subtask_2 = new CountInstance(target, mid + 1, end);

            subtask_1.fork();
            subtask_2.fork();

            return subtask_1.join() + subtask_2.join();
        }
    }

    private Integer countFreq() {
        int count = 0;
        String st = "" + target;
        char ch = st.charAt(0);

        for (int i = start; i <= end; i++) {

            st = "";
            st = st + i;

            if (i == target || st.indexOf(ch) >= 0)
                count++;
        }
        return count;
    }

}
