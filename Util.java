
/**
 * Name         : Limas Nursalim, Hevin Jantasmin
 * Assignment   : Lab 2
 * Date         : April 22, 2021
 */

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.HashMap;

public class Util {
    /**
     * Method to get the decimal representation of a op code.
     *
     * @param opText is the op code in string format, ex. and, add, etc.
     * @return return the decimal representation of the given op code.
     */
    public static int getOp(String opText) {
        int opcode;

        switch (opText) {
            case "and":
                opcode = 0; // "000000";
                break;
            case "or":
                opcode = 0; // "000000";
                break;
            case "add":
                opcode = 0; // "000000";
                break;
            case "addi":
                opcode = 8; // "001000";
                break;
            case "sll":
                opcode = 0; // "000000";
                break;
            case "sub":
                opcode = 0; // "000000";
                break;
            case "slt":
                opcode = 0; // "000000";
                break;
            case "beq":
                opcode = 4; // "000100";
                break;
            case "bne":
                opcode = 5; // "000101";
                break;
            case "lw":
                opcode = 35; // "100011";
                break;
            case "sw":
                opcode = 43; // "101011";
                break;
            case "j":
                opcode = 2; // "000010";
                break;
            case "jr":
                opcode = 0; // "000000";
                break;
            case "jal":
                opcode = 3; // "000011";
                break;
            default:
                opcode = -1; // "none";
                // System.out.println("OP code not found.");
        }

        return opcode;
    }

    /**
     * Method to get the decimal representation of a funct code.
     *
     * @param opText is the op code in string format, ex. and, add, etc.
     * @return return the decimal representation of the given funct code.
     */
    public static int getFunct(String opText) {
        int funct;

        switch (opText) {
            case "and":
                funct = 36; // "100100";
                break;
            case "or":
                funct = 37; // "100101";
                break;
            case "add":
                funct = 32; // "100000";
                break;
            case "addi":
                funct = -1; // "none";
                break;
            case "sll":
                funct = 0; // "000000";
                break;
            case "sub":
                funct = 34; // "100010";
                break;
            case "slt":
                funct = 42; // "101010";
                break;
            case "beq":
                funct = -1; // "none";
                break;
            case "bne":
                funct = -1; // "none";
                break;
            case "lw":
                funct = -1; // "none";
                break;
            case "sw":
                funct = -1; // "none";
                break;
            case "j":
                funct = -1; // "none";
                break;
            case "jr":
                funct = 8; // "001000";
                break;
            case "jal":
                funct = -1; // "none";
                break;
            default:
                funct = -1; // "none";
                // System.out.println("FUNCT code not found.");
        }

        return funct;
    }

    /**
     * Method to get the decimal representation of a register.
     *
     * @param reg is the register name in string, ex. t0, s0, etc.
     * @return return the decimal representation of the given register.
     */
    public static int getRegister(String reg) {
        int r;
        switch (reg) {
            case "zero":
                r = 0;
                break;
            case "0":
                r = 0;
                break;
            case "v0":
                r = 2;
                break;
            case "v1":
                r = 3;
                break;
            case "a0":
                r = 4;
                break;
            case "a1":
                r = 5;
                break;
            case "a2":
                r = 6;
                break;
            case "a3":
                r = 7;
                break;
            case "t0":
                r = 8;
                break;
            case "t1":
                r = 9;
                break;
            case "t2":
                r = 10;
                break;
            case "t3":
                r = 11;
                break;
            case "t4":
                r = 12;
                break;
            case "t5":
                r = 13;
                break;
            case "t6":
                r = 14;
                break;
            case "t7":
                r = 15;
                break;
            case "t8":
                r = 24;
                break;
            case "t9":
                r = 25;
                break;
            case "s0":
                r = 16;
                break;
            case "s1":
                r = 17;
                break;
            case "s2":
                r = 18;
                break;
            case "s3":
                r = 19;
                break;
            case "s4":
                r = 20;
                break;
            case "s5":
                r = 21;
                break;
            case "s6":
                r = 22;
                break;
            case "s7":
                r = 23;
                break;
            case "sp":
                r = 29;
                break;
            case "ra":
                r = 31;
                break;
            default:
                r = -1;
        }

        return r;
    }

    /**
     * Method to check if op code is in R-format.
     *
     * @param op is the op code in the decimal representation.
     * @return return 1 if it is R-format, -1 otherwise.
     */
    public static int isR(int op) {
        if (op == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Method to check if op code is in I-format.
     *
     * @param op is the op code in the decimal representation.
     * @return 2 if it is I-format, -1 otherwise.
     */
    public static int isI(int op) {
        ArrayList<Integer> IList = new ArrayList();
        IList.add(4);
        IList.add(5);
        IList.add(8);
        IList.add(35);
        IList.add(43);

        if (IList.contains(op)) {
            return 2;
        }
        return -1;
    }

    /**
     * Method to check if op code is in J-format.
     *
     * @param op is the op code in the decimal representation.
     * @return 3 if it is J-format, -1 otherwise.
     */
    public static int isJ(int op) {
        ArrayList<Integer> JList = new ArrayList();
        JList.add(2);
        JList.add(3);

        if (JList.contains(op)) {
            return 3;
        }
        return -1;
    }

    /**
     * Method to parse input line into chunks of valid instructions words. Input :
     * ex: done: add $t1, $t2,$t3 #command Output : parsed information in Output :
     * splitted array. ex: ["add","t1","t2","t3"]
     *
     * @param line     original string
     * @param splitted splitted string in array
     */
    public static ArrayList<String> parseLine(String line) {
        ArrayList<String> output = new ArrayList<>();
        String[] splitted;
        String op, temp;

        // Handle comments
        String[] c = line.split("#");
        if (c.length > 0) {
            line = line.split("#")[0];
        } else {
            output.add("-1");
            return output;
        }

        // delete all whitespaces
        line = line.replaceAll("\\s", "");

        // check if there's a label
        if (line.contains(":")) {
            String[] ln = line.split(":");
            if (ln.length > 1) {
                line = ln[1];
            } else {
                output.add("-1");
                return output;
            }
        }

        // get the opcode
        int flag = 0;
        temp = line;
        if (temp.contains("jal")) {
            flag = 1;
            temp = temp.replaceAll("jal", "");
        }
        if (temp.contains("jr")) {
            flag = 2;
            temp = temp.replaceAll("jr", "");
        }
        if (temp.contains("j")) {
            flag = 3;
            temp = temp.replaceAll("j", "");
        }
        if (flag == 1)
            op = "jal";
        else if (flag == 2)
            op = "jr";
        else if (flag == 3)
            op = "j";
        else
            op = temp.split("\\$")[0];

        // parse information
        line = line.replaceAll(op, "");
        line = line.replaceAll("\\(", ",");
        line = line.replaceAll("\\)", "");
        line = line.replaceAll("\\$", "");
        splitted = line.split(",");

        // push output to array list
        output.add(op);
        for (int i = 0; i < splitted.length; i++) {
            output.add(splitted[i]);
        }
        return output;
    }

    /**
     * Method to parse label.
     *
     * @param line is the input line.
     * @return label to be stored in the symbol table.
     */
    public static String buildSymbolTable(String line) {
        String label = "!";
        if (line.contains(":")) {
            label = line.split(":")[0];
        }

        return label;
    }

    /**
     * Method to convert decimal to binary with specified length.
     *
     * @param n       is the decimal representation value.
     * @param padding is the specified the length of the binary.
     * @return binary value in string.
     */
    public static String toBinary(int n, int padding) {
        String binary = "";

        binary = Integer.toBinaryString(n);
        if (n >= 0)
            binary = prependZeros(binary, padding);
        else // if n<0
             // remove the leading ones since Java's integer is 32-bit by default and will
             // prepend with ones
            binary = binary.substring(binary.length() - padding, binary.length());
        return binary;
    }

    /**
     * Method to prepend zeros for sign extension of positive binary.
     *
     * @param input  is the binary value in string.
     * @param length is the specified final length of binary value.
     * @return binary value with prepended zeros (if needed).
     */
    public static String prependZeros(String input, int length) {
        if (input.length() >= length) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - input.length()) {
            sb.append('0');
        }
        sb.append(input);

        return sb.toString();
    }

    /**
     * Method to calculate the offset of label.
     *
     * @param symbols is the symbol table.
     * @param label   is the label inside the instruction.
     * @param line    is the current line.
     * @return the offset in integer.
     */
    public static int getOffset(LinkedList<SymbolTable> symbols, String label, int line) {
        int offset = 0;
        boolean flag = false;

        for (int i = 0; i < symbols.size(); i++) {
            flag = symbols.get(i).getSymbol().equals(label);
            if (flag == true) {
                offset = symbols.get(i).getLine() - (line + 1);
                break;
            }
        }
        return offset;
    }

    /**
     * Method to get the address of a label
     *
     * @param symbols is a list of labels and their corresponding lines.
     * @param label   is the label in the instruction.
     * @return return the address of the label as an integer.
     */
    public static int getAddress(LinkedList<SymbolTable> symbols, String label) {
        int address = 0;
        boolean flag = false;

        for (int i = 0; i < symbols.size(); i++) {
            flag = symbols.get(i).getSymbol().equals(label);
            if (flag == true) {
                address = symbols.get(i).getLine() - 1;
                break;
            }
        }
        return address;
    }

    /**
     * Method to execute each instruction line
     *
     * @param cmd       is the object type Command of each instruction line of the
     *                  asm file.
     * @param memory    is an array of memory.
     * @param registers is an array of registers.
     * @param pc        is the current program counter.
     * @return
     */
    public static int compute(Command cmd, int[] memory, int[] registers, int pc, Boolean[] hazards) {
        switch (cmd.getInstruction()) {
            case "and":
                // rd = rs & rt
                int and = registers[cmd.getRs()] & registers[cmd.getRt()];
                registers[cmd.getRd()] = and;
                break;
            case "or":
                // rd = rs | rt
                int or = registers[cmd.getRs()] | registers[cmd.getRt()];
                registers[cmd.getRd()] = or;
                break;
            case "add":
                // rd = rs + rt
                int add = registers[cmd.getRs()] + registers[cmd.getRt()];
                registers[cmd.getRd()] = add;
                break;
            case "addi":
                // rt = rs + immediate
                int addi = registers[cmd.getRs()] + cmd.getImmediate();
                registers[cmd.getRt()] = addi;
                break;
            case "sll":
                // rd = rt << shamt
                int sll = registers[cmd.getRt()] << registers[cmd.getShamt()];
                registers[cmd.getRd()] = sll;
                break;
            case "sub":
                // rd = rs - rt
                int sub = registers[cmd.getRs()] - registers[cmd.getRt()];
                registers[cmd.getRd()] = sub;
                break;
            case "slt":
                // if (rs < rt) do: rd = 1, else: rd = 0
                int slt = 0;
                if (registers[cmd.getRs()] < registers[cmd.getRt()])
                    slt = 1;
                registers[cmd.getRd()] = slt;
                break;
            case "beq":
                // if (rs == rt) do:
                if (registers[cmd.getRs()] == registers[cmd.getRt()]) {
                    pc += cmd.getImmediate();
                    hazards[1] = true;
                }
                break;
            case "bne":
                // if(rs != rt)
                if (registers[cmd.getRs()] != registers[cmd.getRt()]) {
                    pc += cmd.getImmediate();
                    hazards[1] = true;
                }
                break;
            case "lw":
                // rt = rs + imm
                registers[cmd.getRt()] = memory[(registers[cmd.getRs()] + cmd.getImmediate())];
                break;
            case "sw":
                // rs + imm = rt // sw $t1, 1($t0)
                memory[(registers[cmd.getRs()] + cmd.getImmediate())] = registers[cmd.getRt()];
                break;
            case "j":
                // pc = jump addr
                pc = cmd.getAddress();
                hazards[2] = true;
                return pc;
            case "jr":
                // pc = rs
                pc = registers[cmd.getRs()];
                hazards[2] = true;
                return pc;
            case "jal":
                // PC = r[31] = pc + 4 / PC = jump addr
                registers[31] = pc + 1;
                pc = cmd.getAddress();
                hazards[2] = true;
                return pc;
            default:
                // default
                break;
        }
        pc += 1;
        return pc;
    }

    /**
     * Method to emulate interactive mode or script mode
     *
     * @param cmds                  is a Linked List of instructions that contains
     *                              the Command object class.
     * @param inst_line             is an array fills with the given String
     *                              instructions from the user.
     * @param script_or_interactive is a flag to run either in script mode or
     *                              interactive mode.
     */
    public static void emulator(LinkedList<Command> cmds, ArrayList<String> inst_line, String script_or_interactive) {
        int pc = 0;
        int displayPC = 0;
        int[] memory = new int[8192];
        int[] registers = new int[32];
        int[] delayMemory = new int[8192];
        int[] delayRegisters = new int[32];
        Arrays.fill(memory, 0);
        Arrays.fill(registers, 0);
        Scanner sc = new Scanner(System.in);
        String input;
        String in[];
        int i = 0;

        int totalCycles = 0;
        int totalInstr = 0;
        boolean branchTaken = false;
        LinkedList<String> pipe = new LinkedList();
        for (int p = 0; p < 4; p++) {
            pipe.add("empty");
        }
        LinkedList<Integer> pipePc = new LinkedList();
        for (int p = 0; p < 4; p++) {
            pipePc.add(-1);
        }

        HashMap<Integer, Integer> jumpBranchTaken = new HashMap<Integer, Integer>(); // key: pc, value: calculated
        // branch pc

        Boolean[] hazards = new Boolean[] { false, false, false }; // ual, branch, isJump

        while (true) {
            if (script_or_interactive.equals("interactive")) {
                System.out.printf("mips> ");
                input = sc.nextLine();
                in = input.split("[ ]+");
            } else {
                System.out.printf("mips> %s", inst_line.get(i));
                input = inst_line.get(i);
                in = input.split("[ ]+");
                i++;
            }

            switch (in[0]) {
                case "h":
                    System.out.println("\nh = show help");
                    System.out.println("d = dump register state");
                    System.out.println("p = show pipeline registers");
                    System.out.println("s = step through a single clock cycle step (i.e. simulate 1 cycle and stop)");
                    System.out.println("s num = step through num clock cycles");
                    System.out.println("r = run until the program ends and display timing summary");
                    System.out.println("m num1 num2 = display data memory from location num1 to num2");
                    System.out.println("c = clear all registers, memory, and the program counter to 0");
                    System.out.println("q = exit the program\n");
                    break;
                case "d":
                    System.out.printf("\npc = %d\n", pc);
                    System.out.printf("$0 = %d     $v0 = %d     $v1 = %d     $a0 = %d\n", registers[0], registers[2],
                            registers[3], registers[4]);
                    System.out.printf("$a1 = %d     $a2 = %d     $a3 = %d     $t0 = %d\n", registers[5], registers[6],
                            registers[7], registers[8]);
                    System.out.printf("$t1 = %d     $t2 = %d     $t3 = %d     $t4 = %d\n", registers[9], registers[10],
                            registers[11], registers[12]);
                    System.out.printf("$t5 = %d     $t6 = %d     $t7 = %d     $s0 = %d\n", registers[13], registers[14],
                            registers[15], registers[16]);
                    System.out.printf("$s1 = %d     $s2 = %d     $s3 = %d     $s4 = %d\n", registers[17], registers[18],
                            registers[19], registers[20]);
                    System.out.printf("$s5 = %d     $s6 = %d     $s7 = %d     $t8 = %d\n", registers[21], registers[22],
                            registers[23], registers[24]);
                    System.out.printf("$t9 = %d     $sp = %d     $ra = %d\n\n", registers[25], registers[29],
                            registers[31]);
                    break;
                case "p":
                    System.out.printf("\npc      if/id   id/exe  exe/mem mem/wb\n");
                    System.out.printf("%d      %s      %s      %s      %s\n\n", pc, pipe.get(0), pipe.get(1),
                            pipe.get(2), pipe.get(3));
                    break;
                case "s":
                    if (pc < cmds.get(cmds.size() - 1).getLine()) {
                        // case for "s num"
                        if (in.length > 1) {
                            int temp = pc;
                            for (int l = temp; l < temp + Integer.parseInt(in[1]); l++) {
                                int calculated_pc = 0;
                                if (branchTaken) {
                                    calculated_pc = Util.compute(cmds.get(pc), delayMemory, delayRegisters, pc,
                                            hazards);
                                } else {
                                    calculated_pc = Util.compute(cmds.get(pc), memory, registers, pc, hazards);
                                }

                                // if the instruction is jump or a taken branch, store the calculated pc and its
                                // corresponding instruction's pc in the hashmap.
                                if (hazards[1] || hazards[2]) {
                                    jumpBranchTaken.put(pc, calculated_pc);
                                    delayMemory = memory.clone();
                                    delayRegisters = registers.clone();
                                    branchTaken = true;
                                    hazards[1] = false;
                                    hazards[2] = false;
                                }

                                // branch hazard check (if beq/bne is about to enter mem/wb, check if the branch
                                // is taken)
                                if ((pipe.get(2).equals("beq") || pipe.get(2).equals("bne"))
                                        && jumpBranchTaken.get(pipePc.get(2)) != null) {
                                    // update the pc to the calculated pc and remove this branch from the hashmap.
                                    pc = jumpBranchTaken.get(pipePc.get(2));
                                    displayPC = pc;
                                    jumpBranchTaken.remove(pipePc.get(2));
                                    // move branch to mem/wb, and squash 3 instructions.
                                    pipe.addFirst("squash");
                                    pipe.removeLast();
                                    pipePc.addFirst(-1);
                                    pipePc.removeLast();
                                    pipe.set(1, "squash");
                                    pipe.set(2, "squash");
                                    totalCycles += 1;
                                    totalInstr -= 2;
                                    branchTaken = false;

                                }
                                // jump hazard check (if jump is about to enter id/exe, update the pc)
                                else if ((pipe.get(0).equals("j") || pipe.get(0).equals("jal")
                                        || pipe.get(0).equals("jr"))) {
                                    if (jumpBranchTaken.get(pipePc.get(0)) != null) {
                                        // update the pc to the calculated pc and remove this jump from the hashmap.
                                        pc = jumpBranchTaken.get(pipePc.get(0));
                                        displayPC = pc;
                                        jumpBranchTaken.remove(pipePc.get(0));
                                        // squash 1 previous instruction.
                                        pipe.addFirst("squash");
                                        pipe.removeLast();
                                        pipePc.addFirst(-1);
                                        pipePc.removeLast();
                                        totalCycles += 1;
                                        branchTaken = false;
                                    }
                                } else {
                                    // use-after-load hazard check (if a load instruction is in id/exe, check the
                                    // next instruction's rt and rs regs.
                                    if (pipe.get(1).equals("lw")) {
                                        if (pipe.get(0).equals("addi")) {
                                            if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                                hazards[0] = true;
                                            } else {
                                                hazards[0] = false;
                                            }
                                        } else if (pipe.get(0).equals("lw")) {
                                            if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                                hazards[0] = true;
                                            } else {
                                                hazards[0] = false;
                                            }
                                        } else {
                                            if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())
                                                    || (cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0))
                                                            .getRt())) {
                                                hazards[0] = true;
                                            } else {
                                                hazards[0] = false;
                                            }
                                        }
                                    }

                                    int prev_pc = displayPC;
                                    // if there's no load hazard.
                                    if (hazards[0] == false) {
                                        // update the pc by 1 because there's no jump or branch.
                                        pc = calculated_pc;
                                        displayPC += 1;
                                        // update pipeline registers.
                                        pipe.addFirst(cmds.get(prev_pc).getInstruction());
                                        pipe.removeLast();
                                        pipePc.addFirst(prev_pc);
                                        pipePc.removeLast();
                                        totalCycles += 1;
                                        totalInstr += 1;
                                    }
                                    // if there's load hazard.
                                    else {
                                        // stall for use-after-load and add 1 extra clock cycle.
                                        pipe.add(1, "stall");
                                        pipe.removeLast();
                                        pipePc.add(1, -1);
                                        pipePc.removeLast();
                                        hazards[0] = false;
                                        totalCycles += 1;
                                    }
                                }
                            }

                            System.out.printf("\n\npc      if/id   id/exe  exe/mem mem/wb\n");
                            System.out.printf("%d      %s      %s      %s      %s\n\n", displayPC, pipe.get(0),
                                    pipe.get(1), pipe.get(2), pipe.get(3));
                        } else {
                            int calculated_pc = 0;
                            if (branchTaken) {
                                calculated_pc = Util.compute(cmds.get(pc), delayMemory, delayRegisters, pc, hazards);
                            } else {
                                calculated_pc = Util.compute(cmds.get(pc), memory, registers, pc, hazards);
                            }

                            // if the instruction is jump or a taken branch, store the calculated pc and its
                            // corresponding instruction's pc in the hashmap.
                            if (hazards[1] || hazards[2]) {
                                jumpBranchTaken.put(pc, calculated_pc);
                                delayMemory = memory.clone();
                                delayRegisters = registers.clone();
                                branchTaken = true;
                                hazards[1] = false;
                                hazards[2] = false;
                            }

                            // branch hazard check (if beq/bne is about to enter mem/wb, check if the branch
                            // is taken)
                            if ((pipe.get(2).equals("beq") || pipe.get(2).equals("bne"))
                                    && jumpBranchTaken.get(pipePc.get(2)) != null) {
                                // update the pc to the calculated pc and remove this branch from the hashmap.
                                pc = jumpBranchTaken.get(pipePc.get(2));
                                displayPC = pc;
                                jumpBranchTaken.remove(pipePc.get(2));
                                // move branch to mem/wb, and squash 3 instructions.
                                pipe.addFirst("squash");
                                pipe.removeLast();
                                pipePc.addFirst(-1);
                                pipePc.removeLast();
                                pipe.set(1, "squash");
                                pipe.set(2, "squash");
                                totalCycles += 1;
                                totalInstr -= 2;
                                branchTaken = false;

                            }
                            // jump hazard check (if jump is about to enter id/exe, update the pc)
                            else if ((pipe.get(0).equals("j") || pipe.get(0).equals("jal")
                                    || pipe.get(0).equals("jr"))) {
                                if (jumpBranchTaken.get(pipePc.get(0)) != null) {
                                    // update the pc to the calculated pc and remove this jump from the hashmap.
                                    pc = jumpBranchTaken.get(pipePc.get(0));
                                    displayPC = pc;
                                    jumpBranchTaken.remove(pipePc.get(0));
                                    // squash 1 previous instruction.
                                    pipe.addFirst("squash");
                                    pipe.removeLast();
                                    pipePc.addFirst(-1);
                                    pipePc.removeLast();
                                    totalCycles += 1;
                                    branchTaken = false;
                                }
                            } else {
                                // use-after-load hazard check (if a load instruction is in id/exe, check the
                                // next instruction's rt and rs regs.
                                if (pipe.get(1).equals("lw")) {
                                    if (pipe.get(0).equals("addi")) {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    } else if (pipe.get(0).equals("lw")) {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    } else {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())
                                                || (cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0))
                                                        .getRt())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    }
                                }

                                int prev_pc = displayPC;
                                // if there's no load hazard.
                                if (hazards[0] == false) {
                                    // update the pc by 1 because there's no jump or branch.
                                    pc = calculated_pc;
                                    displayPC += 1;
                                    // update pipeline registers.
                                    pipe.addFirst(cmds.get(prev_pc).getInstruction());
                                    pipe.removeLast();
                                    pipePc.addFirst(prev_pc);
                                    pipePc.removeLast();
                                    totalCycles += 1;
                                    totalInstr += 1;
                                }
                                // if there's load hazard.
                                else {
                                    // stall for use-after-load and add 1 extra clock cycle.
                                    pipe.add(1, "stall");
                                    pipe.removeLast();
                                    pipePc.add(1, -1);
                                    pipePc.removeLast();
                                    hazards[0] = false;
                                    totalCycles += 1;
                                }
                            }

                            System.out.printf("\n\npc      if/id   id/exe  exe/mem mem/wb\n");
                            System.out.printf("%d      %s      %s      %s      %s\n\n", displayPC, pipe.get(0),
                                    pipe.get(1), pipe.get(2), pipe.get(3));
                        }
                    } else {
                        System.out.printf("Program's finished!\n");
                    }
                    break;
                case "r":
                    if (pc < cmds.get(cmds.size() - 1).getLine()) {
                        while (pc < cmds.get(cmds.size() - 1).getLine()) {
                            int calculated_pc = 0;
                            if (branchTaken) {
                                calculated_pc = Util.compute(cmds.get(pc), delayMemory, delayRegisters, pc, hazards);
                            } else {
                                calculated_pc = Util.compute(cmds.get(pc), memory, registers, pc, hazards);
                            }

                            if (hazards[1] || hazards[2]) {
                                jumpBranchTaken.put(pc, calculated_pc);
                                branchTaken = true;
                                delayMemory = memory.clone();
                                delayRegisters = registers.clone();
                                hazards[1] = false;
                                hazards[2] = false;
                            }

                            // branch hazard check
                            if ((pipe.get(2).equals("beq") || pipe.get(2).equals("bne"))
                                    && jumpBranchTaken.get(pipePc.get(2)) != null) {
                                pc = jumpBranchTaken.get(pipePc.get(2));
                                displayPC = pc;
                                jumpBranchTaken.remove(pipePc.get(2));

                                pipe.addFirst("squash"); // a a beq a
                                pipe.removeLast();
                                pipePc.addFirst(-1);
                                pipePc.removeLast();
                                pipe.set(1, "squash");
                                pipe.set(2, "squash");
                                totalCycles += 1;
                                totalInstr -= 2;
                                branchTaken = false;
                            }
                            // jump hazard check
                            else if ((pipe.get(0).equals("j") || pipe.get(0).equals("jal")
                                    || pipe.get(0).equals("jr"))) {
                                if (jumpBranchTaken.get(pipePc.get(0)) != null) {
                                    pc = jumpBranchTaken.get(pipePc.get(0));
                                    displayPC = pc;
                                    jumpBranchTaken.remove(pipePc.get(0));
                                    pipe.addFirst("squash");
                                    pipe.removeLast();
                                    pipePc.addFirst(-1);
                                    pipePc.removeLast();
                                    totalCycles += 1;
                                    branchTaken = false;
                                }
                            } else {
                                // use-after-load hazard check (if a load instruction is in id/exe, check the
                                // next instruction's rt and rs regs.
                                if (pipe.get(1).equals("lw")) {
                                    if (pipe.get(0).equals("addi")) {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    } else if (pipe.get(0).equals("lw")) {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    } else {
                                        if ((cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0)).getRs())
                                                || (cmds.get(pipePc.get(1)).getRt() == cmds.get(pipePc.get(0))
                                                        .getRt())) {
                                            hazards[0] = true;
                                        } else {
                                            hazards[0] = false;
                                        }
                                    }
                                }

                                int prev_pc = displayPC;
                                // if no hazard
                                if (hazards[0] == false) {
                                    pc = calculated_pc;
                                    displayPC += 1;
                                    // update pipeline registers
                                    pipe.addFirst(cmds.get(prev_pc).getInstruction());
                                    pipe.removeLast();
                                    pipePc.addFirst(prev_pc);
                                    pipePc.removeLast();
                                    totalCycles += 1;
                                    totalInstr += 1;
                                } else {
                                    // stall for use-after-load
                                    pipe.add(1, "stall");
                                    pipe.removeLast();
                                    pipePc.add(1, -1);
                                    pipePc.removeLast();
                                    hazards[0] = false;
                                    totalCycles += 1;
                                }
                            }
                        }
                        for (int p = 0; p < 4; p++) {
                            pipe.addFirst("empty");
                        }
                        totalCycles += 4;
                        double CPI = Double.valueOf(totalCycles) / Double.valueOf(totalInstr);
                        System.out.printf("\n\nProgram complete\n");
                        System.out.printf("CPI = %.3f Cycles = %d Instructions = %d\n\n", CPI, totalCycles, totalInstr);
                        // System.exit(0); // Program finished
                    } else {
                        System.out.printf("Program's finished!\n");
                    }
                    break;
                case "m":
                    if (in.length == 3) {
                        int low = Integer.parseInt(in[1]);
                        int high = Integer.parseInt(in[2]);
                        System.out.println();
                        for (int m = low; m <= high; m++) {
                            System.out.printf("[%d] = %d\n", m, memory[m]);
                        }
                        System.out.println();
                    } else {
                        System.out.println("\ninvalid input!\n");
                    }
                    break;
                case "c":
                    Arrays.fill(memory, 0);
                    Arrays.fill(registers, 0);
                    pc = 0;
                    System.out.printf("Simulator reset\n\n");
                    break;
                case "q":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\ninvalid input!\n\n");
            }
        }
    }
}