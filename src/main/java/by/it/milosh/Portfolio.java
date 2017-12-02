package by.it.milosh;

import java.util.List;

public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    public Portfolio() {
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue() {
        double marketValue = 0.0;

        for (Stock stock : stocks) {
            marketValue = marketValue + stockService.getPrice(stock)*stock.getQuantity();
        }

        return marketValue;
    }

}
