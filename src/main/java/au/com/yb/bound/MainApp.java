package au.com.yb.bound;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainApp {

    private static ScheduledExecutorService executorService;
    private Runnable runnableFuture;
    private static final String CAL_NAME = "integer-calculator-1";
    private CalculatorService<Integer> calculatorService = new IntCalculator(CAL_NAME);
    private int toBeManipulated;
    private int result = 0;

    public int getResult() {
        return result;
    }

    public interface CalculatorService<T extends Number> {
        T calculate(T val);
    }


    abstract static class AbstractCalculator<T extends Number> implements CalculatorService<T> {
        private String name;

        public AbstractCalculator(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public abstract T calculate(T val);
    }

    static class IntCalculator extends AbstractCalculator<Integer> {

        public IntCalculator(String name) {
            super(name);
        }

        @Override
        public Integer calculate(Integer val) {
            return val + 2;
        }
    }

    public MainApp() {
        this.executorService = new ScheduledThreadPoolExecutor(1);
        init();
    }

    public void start() {
        System.out.println("started calculator service....");
    }

    public void updateTargetVal(int targetVal) {
        toBeManipulated = targetVal;
        executorService.submit(runnableFuture);
    }
    private void init() {
        runnableFuture = () -> {
            result = calculatorService.calculate(toBeManipulated);
            System.out.printf("calculated target value: [%s] => result: [%s]", toBeManipulated, result);
        };
    }

}
