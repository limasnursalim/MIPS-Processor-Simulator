/**
 * Name         : Limas Nursalim, Hevin Jantasmin
 * Assignment   : Lab 2
 * Date         : April 22, 2021
 */

public class SymbolTable {
    private int line;
    private String symbol;

    public SymbolTable(int line, String symbol) {
        this.line = line;
        this.symbol = symbol;
    }
    
    // SETTER
    public void setLine(int line) {
        this.line = line;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    // GETTER
    public int getLine() {
        return this.line;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
}
