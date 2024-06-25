package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] ars) {
        List<String> stockSymbol = Arrays.asList("ABC", "XYZ", "UYT", "PSH", "ETC");
        List<Future<Double>> futures = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (String stock : stockSymbol) {
            StockPricesFetcher stockPricesFetcher = new StockPricesFetcher(stock);
            Future<Double> future = service.submit(stockPricesFetcher);
            System.out.println(future);
            futures.add(future);
        }

        service.shutdown();

        for (int i = 0; i < futures.size(); i++) {
            try {
                while(!futures.get(i).isDone()){
                    System.out.println("Waiting .....");
                    Thread.sleep(2000);
                }
                System.out.println("Stock " + stockSymbol.get(i) + " price is = " + futures.get(i).get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class StockPricesFetcher implements Callable<Double> {

    private final String stockSymbol;

    StockPricesFetcher(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(10000);
        return Math.random() * 10000;
    }
}
