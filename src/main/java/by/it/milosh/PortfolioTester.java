package by.it.milosh;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PortfolioTester {

    Portfolio portfolio;
    StockService stockService;

    public static void main(String[] args) {
        PortfolioTester tester = new PortfolioTester();
        tester.setUp();
        boolean check = tester.testMarketValue();
        System.out.println(check);
    }

    public void setUp() {
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    public boolean testMarketValue() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue == 100500.0;
    }

}
