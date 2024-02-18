package features.task5.additional;

public class SymbolPrinterOne implements Runnable {

    private final char symbol;

    public SymbolPrinterOne(char symbol) {

        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(symbol);


        }
    }
}