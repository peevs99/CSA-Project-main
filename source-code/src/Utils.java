import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public SystemCore systemCore;

    public Utils(SystemCore systemCore) {
        this.systemCore = systemCore;
    }

    public void loadExternalProgram(String s) {
        File file = new File(s);
        String line;
        int addr;
        int content;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            line = br.readLine();
            while (line != null) {
                if (line.equals("")) {
                    line = br.readLine();
                    continue;
                }
                if (line.charAt(0) == '#') {
                    line = br.readLine();
                    continue;
                }
                addr = Integer.parseInt(line.substring(0, 4), 16);
                content = Integer.parseInt(line.substring(5, 9), 16);
                systemCore.memory.ProcessorMemory[addr] = content;
                line = br.readLine();
            }
            systemCore.frame.debugPrint(String.format("Program %s loaded", s));
        } catch (IOException e) {
            systemCore.frame.debugPrint(String.format("Program %s doesn't exist", s));
        }
    }

    public void exec(InstructionComponents instruction) {
        instruction.EA = computeEA(instruction);
        instruction.IXEA = computeIXREA(instruction);


        if (((instruction.opcode >= 4 && instruction.opcode <= 7) || (instruction.opcode >= 16 && instruction.opcode <= 18) || (instruction.opcode >= 25 && instruction.opcode <= 26))) {
            systemCore.registers.CC = 0;
        }

        switch (instruction.opcode) {
            case 0:
                systemCore.alu.halt();
                break;
            case 1:
                systemCore.alu.LDR(instruction);
                break;
            case 2:
                systemCore.alu.STR(instruction);
                break;
            case 3:
                systemCore.alu.LDA(instruction);
                break;
            case 33:
                systemCore.alu.LDX(instruction);
                break;
            case 34:
                systemCore.alu.STX(instruction);
                break;
            case 8:
                systemCore.alu.JZ(instruction);
                break;
            case 9:
                systemCore.alu.JNE(instruction);
                break;
            case 10:
                systemCore.alu.JCC(instruction);
                break;
            case 11:
                systemCore.alu.JMA(instruction);
                break;
            case 12:
                systemCore.alu.JSR(instruction);
                break;
            case 13:
                systemCore.alu.RFS(instruction);
                break;
            case 14:
                systemCore.alu.SOB(instruction);
                break;
            case 15:
                systemCore.alu.JGE(instruction);
                break;
            case 4:
                systemCore.alu.AMR(instruction);
                break;
            case 5:
                systemCore.alu.SMR(instruction);
                break;
            case 6:
                systemCore.alu.AIR(instruction);
                break;
            case 7:
                systemCore.alu.SIR(instruction);
                break;
            case 16:
                systemCore.alu.MLT(instruction);
                break;
            case 17:
                systemCore.alu.DVD(instruction);
                break;
            case 18:
                systemCore.alu.TRR(instruction);
                break;
            case 19:
                systemCore.alu.AND(instruction);
                break;
            case 20:
                systemCore.alu.ORR(instruction);
                break;
            case 21:
                systemCore.alu.NOT(instruction);
            case 25:
                systemCore.alu.SRC(instruction);
                break;
            case 26:
                systemCore.alu.RRC(instruction);
                break;
            case 49:
                systemCore.alu.IN(instruction);
                break;
            case 50:
                systemCore.alu.OUT(instruction);
                break;
            case 51:
                systemCore.alu.CHK(instruction);
                break;
            case 35:
                systemCore.alu.JGT(instruction);
                break;
            case 30:
                if (instruction.TrapCode > 15 || instruction.TrapCode < 0) {
                    systemCore.registers.MFR |= 1;
                    break;
                }
                systemCore.alu.trap(instruction);
                break;
            default:
                systemCore.registers.MFR |= 4;
                systemCore.registers.PC = systemCore.memory.ReadFromMemory(1);
                systemCore.frame.debugPrint("Illegal Operation Code");
                break;
        }

        /*
        if (!((instruction.opcode >= 4 && instruction.opcode <= 7) || (instruction.opcode >= 16 && instruction.opcode <= 18) || (instruction.opcode >= 25 && instruction.opcode <= 26))) {
            registers.CC = 0;
        }
        */

        systemCore.systemFunctions.Delay();
    }


    public int computeEA(InstructionComponents instruction) {
        if (instruction.I_bit == 0) {
            if (instruction.IXR_Index >= 0) {
                return instruction.Address + systemCore.registers.IXRS[instruction.IXR_Index];
            } else {
                return instruction.Address;
            }
        } else {
            if (instruction.IXR_Index >= 0) {
                return systemCore.memory.ReadFromMemory(instruction.Address) + systemCore.memory.ReadFromMemory(systemCore.registers.IXRS[instruction.IXR_Index]);
            } else {
                return systemCore.memory.ReadFromMemory(instruction.Address);
            }
        }
    }

    //Connecting and updating the memory.ProcessorMemory
    public int computeIXREA(InstructionComponents instruction) {
        if (instruction.I_bit == 0) {
            return instruction.Address;
        } else {
            return systemCore.memory.ReadFromMemory(instruction.Address);
        }
    }


}
