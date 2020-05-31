package com.nodir.entityQuery;

public class SolutionQuery4 {
    private int countMonth;
    private int countCanceled;

    public SolutionQuery4(int countMonth, int countCanceled) {
        this.countMonth = countMonth;
        this.countCanceled = countCanceled;
    }

    public int getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    public int getCountCanceled() {
        return countCanceled;
    }

    public void setCountCanceled(int countCanceled) {
        this.countCanceled = countCanceled;
    }
}
