package org.github.caishijun.gc.test002;

public class FinalizeDemo002 {
    private int id;

    public FinalizeDemo002(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        if (id % 2 == 0) {
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new FinalizeDemo002(i);
        }
        System.gc();
    }
}
