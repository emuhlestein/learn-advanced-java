public class RunnableLambdaExample {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.printf("Inside runnable 1");
            }
        };

        new Thread(runnable).start();

        Runnable runnableLambda = () -> {
            System.out.printf("Inside runnable 2");
        };

        new Thread(runnableLambda).start();
    }
}
