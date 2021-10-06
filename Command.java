/**
 * Name         : Limas Nursalim, Hevin Jantasmin
 * Assignment   : Lab 2
 * Date         : April 22, 2021
 */

public class Command {
    private String instruction;
    private int format;
    private int line;
    private int op;
    private int funct;
    private int rd;
    private int rt;
    private int rs;
    private int immediate;
    private int address;
    private int shamt;

    public Command(String instruction, int format, int line, int op, int funct, int rd, int rt, int rs, int immediate, int address, int shamt) {
        this.instruction = instruction;
        this.format = format;
        this.line = line;
        this.op = op;
        this.funct = funct;
        this.rd = rd;
        this.rt = rt;
        this.rs = rs;
        this.immediate = immediate;
        this.address = address;
        this.shamt = shamt;
    }
   
    // SETTER
    public void setInstruction(String inst) {
        this.instruction = inst;
    }

    public void setLine(int line) {
        this.line = line;
    }
   
    public void setOp(int op) {
        this.op = op;
    }

    public void setFunct(int funct) {
        this.funct = funct;
    }
   
    public void setRd(int rd) {
        this.rd = rd;
    }
   
    public void setRt(int rt) {
        this.rt = rt;
    }
   
    public void setRs(int rs) {
        this.rs = rs;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setShamt(int shamt) {
        this.shamt = shamt;
    }
   
    // GETTER
    public String getInstruction() {
        return this.instruction;
    }

    public int getFormat() {
        return this.format;
    }

    public int getLine() {
        return this.line;
    }
   
    public int getOp() {
        return this.op;
    }

    public int getFunct() {
        return this.funct;
    }
   
    public int getRd() {
        return this.rd;
    }
   
    public int getRt() {
        return this.rt;
    }
   
    public int getRs() {
        return this.rs;
    }

    public int getImmediate() {
        return this.immediate;
    }

    public int getAddress() {
        return this.address;
    }

    public int getShamt() {
        return this.shamt;
    }

}
