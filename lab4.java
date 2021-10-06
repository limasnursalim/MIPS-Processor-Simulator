
/**
 * Name         : Limas Nursalim, Hevin Jantasmin
 * Assignment   : Lab 3
 * Date         : May 1, 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class lab4 {
    public static void main(String[] args) throws FileNotFoundException {
        String fname = args[0];
        File f = new File(fname);

        /* FIRST PASS */
        LinkedList<SymbolTable> symbols = new LinkedList<>();
        try {
            Scanner sc = new Scanner(f);

            int line = 1;
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String label = Util.buildSymbolTable(input);

                if (!label.equals("!")) {
                    SymbolTable st = new SymbolTable(line, label);
                    symbols.add(st);
                }

                ArrayList<String> splitted = Util.parseLine(input);

                int Rformat = -1, Iformat = -1, Jformat = -1;
                Rformat = Util.isR(Util.getOp(splitted.get(0)));
                Iformat = Util.isI(Util.getOp(splitted.get(0)));
                Jformat = Util.isJ(Util.getOp(splitted.get(0)));

                if (Rformat != -1 || Iformat != -1 || Jformat != -1)
                    line++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        /* SECOND PASS */
        LinkedList<Command> cmds = new LinkedList<>();
        try {
            Scanner sc = new Scanner(f);

            int line = 1, format = -1;
            while (sc.hasNextLine()) {
                format = -1;
                String input = sc.nextLine();
                ArrayList<String> splitted = Util.parseLine(input);

                int op = -1, funct = -1, rd = -1, rt = -1, rs = -1, immediate = -1, address = -1, shamt = 0;

                String instruction = splitted.get(0);

                // check the format of the instruction
                int Rformat = -1, Iformat = -1, Jformat = -1;
                Rformat = Util.isR(Util.getOp(splitted.get(0)));
                Iformat = Util.isI(Util.getOp(splitted.get(0)));
                Jformat = Util.isJ(Util.getOp(splitted.get(0)));

                // R-FORMAT
                // ex: add $t1(rd) $t3(rs) $t2(rt)
                if (Rformat != -1) {
                    format = Rformat;
                    // get op
                    op = Util.getOp(splitted.get(0));

                    // get funct
                    funct = Util.getFunct(splitted.get(0));

                    // get rd
                    rd = Util.getRegister(splitted.get(1));

                    // cover the unique case for 'sll' to print immediate on rt instead of register
                    if (funct == 0) {
                        // get rt as immediate for 'sll' case
                        rt = Util.getRegister(splitted.get(2));

                        // get rs as 0 for 'sll' case
                        rs = 0;

                        // set shamt
                        shamt = Integer.parseInt(splitted.get(3));
                    }
                    // cover the case for 'jr'
                    else if (funct == 8) {
                        rs = Util.getRegister(splitted.get(1));

                        rt = 0;

                        rd = 0;
                    } else {
                        // get rs
                        rs = Util.getRegister(splitted.get(2));

                        // get rt as register
                        rt = Util.getRegister(splitted.get(3));
                    }
                }

                // I-FORMAT
                // ex: addi $t0(rt), $t0(rs), 100(immediate)
                // ex: lw $a0(rt), 8(immediate)($a1)(rs)
                if (Iformat != -1) {
                    format = Iformat;
                    // get op
                    op = Util.getOp(splitted.get(0));

                    // get rt
                    rt = Util.getRegister(splitted.get(1));

                    // cover the case for 'lw' and 'sw' by switching immediate and rs printing
                    // position
                    if (op == 35 || op == 43) {
                        immediate = Integer.parseInt(splitted.get(2));
                        rs = Util.getRegister(splitted.get(3));
                    } else {
                        // get rs
                        rs = Util.getRegister(splitted.get(2));

                        // cover the case for 'bne' and 'beq'
                        if (op == 4 || op == 5) {
                            rs = Util.getRegister(splitted.get(1));
                            rt = Util.getRegister(splitted.get(2));
                        }

                        // get immediate
                        try {
                            immediate = Integer.parseInt(splitted.get(3)); // String to integer
                        } catch (NumberFormatException e) {
                            // print offset instead of immediate
                            immediate = Util.getOffset(symbols, splitted.get(3), line);
                        }
                    }
                }

                // J-FORMAT
                if (Jformat != -1) {
                    format = Jformat;
                    // get op
                    op = Util.getOp(splitted.get(0));

                    // get address
                    address = Util.getAddress(symbols, splitted.get(1));
                }

                // check for label
                String label = "!";
                boolean isLabel = false;
                if (input.contains(":"))
                    label = input.split(":")[0];
                if (instruction.equals("-1") == true && label.equals("!") == false)
                    for (int i = 0; i < symbols.size(); i++)
                        if (symbols.get(i).getSymbol().equals(label))
                            isLabel = true;

                // add valid and invalid command to the linked list to be printed later
                if (!isLabel && splitted.size() > 1) {
                    if (format != -1 || instruction.isEmpty() == false) {
                        Command cmd = new Command(instruction, format, line, op, funct, rd, rt, rs, immediate, address, shamt);
                        cmds.add(cmd);
                        line++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        /* ===== LAB 3 WORKS ===== */

        /* INTERACTIVE MODE */
        ArrayList<String> instruction_lines = new ArrayList<>();
        if (args.length == 1) {
            Util.emulator(cmds, instruction_lines, "interactive");
        }
        /* SCRIPT MODE */
        else {
            String fname_script = args[1];
            File f_script = new File(fname_script);
            Scanner s = new Scanner(f_script);
            while (s.hasNextLine()) {
                instruction_lines.add(s.nextLine());
            }
            Util.emulator(cmds, instruction_lines, "script");
            s.close();
        }
    }
}
