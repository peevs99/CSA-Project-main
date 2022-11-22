import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.io.File;

public class Frame {
    public final Frame frame = this;
    private SystemCore systemCore;

    private JButton gpr0LDButton;
    private JTextField gpr0HexTextField;
    private JTextField gpr0BinTextField;
    private JButton gpr1LDButton;
    private JTextField gpr1BinTextField;
    private JTextField gpr1HexTextField;
    private JButton gpr2LDButton;
    private JTextField gpr2BinTextField;
    private JTextField gpr2HexTextField;
    private JButton gpr3LDButton;
    private JTextField gpr3BinTextField;
    private JTextField gpr3HexTextField;
    private JButton ixr1LDButton;
    private JTextField ixr1HexTextField;
    private JTextField ixr1BinTextField;
    private JButton ixr2LDButton;
    private JTextField ixr2BinTextField;
    private JTextField ixr2HexTextField;
    private JButton ixr3LDButton;
    private JTextField ixr3BinTextField;
    private JTextField ixr3HexTextField;
    private JButton mbrLDButton;
    private JTextField mbrBinTextField;
    private JTextField mbrHexTextField;
    private JButton marLDButton;
    private JTextField marBinTextField;
    private JTextField marHexTextField;
    private JButton pcLDButton;
    private JTextField pcBinTextField;
    private JTextField pcHexTextField;
    private JTextField irBinTextField;
    private JTextField irHexTextField;
    private JTextField ccHexTextField;
    private JRadioButton CC4RadioButton;
    private JRadioButton CC3RadioButton;
    private JRadioButton CC2RadioButton;
    private JRadioButton CC1RadioButton;
    private JTextField mfrHexTextField;
    private JRadioButton MFR4RadioButton;
    private JRadioButton MFR3RadioButton;
    private JRadioButton MFR2RadioButton;
    private JRadioButton MFR1RadioButton;
    private JPanel Memory;
    private JScrollPane MemoryListScroll;
    private JPanel MemoryFullList;
    private JLabel MemoryAddressLabel;
    private JList MemoryValueList;
    private JList MemoryHexValueList;
    private JList MemoryAssembleCodeList;
    private JLabel MemoryValueLabel;
    private JLabel MemoryHexValue;
    private JLabel MemoryAssembleCode;
    private JList MemoryAddressList;
    private JTextField Cache0;
    private JTextField kbInputField;
    private JButton kbInputButton;
    private JButton crInputButton;
    private JTextArea kbBuffer;
    private JTextArea crBuffer;
    private JTextArea printerBuffer;
    private JScrollPane consoleScrollPanel;
    private JTextArea debugConsoleOutput;
    private JTextField cpuHzTextField;
    private JButton setButton;
    private JButton runButton;
    private JButton stopButton;
    private JTextField inputBinTextField;
    private JTextField inputHexTextField;
    private JButton IPLButton;
    private JButton prog1Button;
    private JButton prog2Button;
    private JButton singleStepButton;
    private JPanel mainPanel;
    private JCheckBox runningCheckBox;
    private JCheckBox haltedCheckBox;
    private JTextField Cache1;
    private JTextField Cache2;
    private JTextField Cache3;
    private JTextField Cache4;
    private JTextField Cache5;
    private JTextField Cache6;
    private JTextField Cache7;
    private JTextField Cache8;
    private JTextField Cache9;
    private JTextField Cache10;
    private JTextField Cache11;
    private JTextField Cache12;
    private JTextField Cache13;
    private JTextField Cache14;
    private JTextField Cache15;
    private JPanel CardReaderFileText;
    private JLabel CRFileName;
    private JCheckBox DebugCheck;
    private JFileChooser CardReadeFile;

    private Color defaultcolor;






    private Vector AddressList = new Vector();
    private Vector memoryValue = new Vector();
    private Vector memoryHexValue = new Vector();
    private Vector memoryAssembleCode = new Vector();



    public Frame() {

        JFileChooser MEMFileChooser = new JFileChooser();

        defaultcolor = Cache0.getBackground();

        runButton.addActionListener(e -> systemCore.systemFunctions.startMachine());

        stopButton.addActionListener(e -> systemCore.systemFunctions.stopMachine());

        inputBinTextField.addActionListener(e -> {
            try {
                int inputValue = Integer.parseUnsignedInt(inputBinTextField.getText(), 2);
                inputHexTextField.setText(Integer.toHexString(inputValue));
            } catch (NumberFormatException ex) {
                inputBinTextField.setText("");
                inputHexTextField.setText("");
                debugPrint("Invalid binary input");
            }
        });

        inputHexTextField.addActionListener(e -> {
            try {
                int inputValue = Integer.parseUnsignedInt(inputHexTextField.getText(), 16);
                inputBinTextField.setText(Integer.toBinaryString(inputValue));
            } catch (NumberFormatException ex) {
                inputBinTextField.setText("");
                inputHexTextField.setText("");
                debugPrint("Invalid binary input");
            }
        });

        gpr0LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for GPR0");
                return;
            }
            systemCore.registers.GPRS[0] = inputValue;
            frame.update();
        });

        gpr1LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for GPR1");
                return;
            }
            systemCore.registers.GPRS[1] = inputValue;
            frame.update();
        });

        gpr2LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for GPR2");
                return;
            }
            systemCore.registers.GPRS[2] = inputValue;
            frame.update();
        });

        gpr3LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for GPR3");
                return;
            }
            systemCore.registers.GPRS[3] = inputValue;
            frame.update();
        });

        ixr1LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for IXR1");
                return;
            }
            systemCore.registers.IXRS[0] = inputValue;
            frame.update();
        });

        ixr2LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for IXR2");
                return;
            }
            systemCore.registers.IXRS[1] = inputValue;
            frame.update();
        });

        ixr3LDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for IXR3");
                return;
            }
            systemCore.registers.IXRS[2] = inputValue;
            frame.update();
        });

        pcLDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 12) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for PC");
                return;
            }
            systemCore.registers.PC = inputValue;
            frame.update();
        });

        marLDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 12) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for MAR");
                return;
            }
            systemCore.registers.MAR = inputValue;
            frame.update();
        });

        mbrLDButton.addActionListener(e -> {
            int inputValue;
            if (inputBinTextField.getText().equals("")) {
                inputValue = Integer.parseInt(inputHexTextField.getText(), 16);
            } else {
                inputValue = Integer.parseInt(inputBinTextField.getText(), 2);
            }
            if (inputValue > (Math.pow(2, 16) - 1) || inputValue < 0) {
                debugPrint("Input is invalid for MBR");
                return;
            }
            systemCore.registers.MBR = inputValue;
            frame.update();
        });

        IPLButton.addActionListener(e -> systemCore.utils.loadExternalProgram("IPL.txt"));

        prog1Button.addActionListener(e -> {
            systemCore.systemFunctions.reset();
            // Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            // debugPrint(path.toString());
            systemCore.utils.loadExternalProgram("program1.txt");
            systemCore.registers.PC = 0x100;
            systemCore.cache.flush();
            update();
            update_memory();
            debugPrint("PC Set to 0x100");
        });

        prog2Button.addActionListener(e ->
        {
            systemCore.systemFunctions.reset();
            systemCore.utils.loadExternalProgram("program2.txt");
            systemCore.registers.PC = 0x200;
            systemCore.cache.flush();
            update();
            update_memory();
            debugPrint("PC Set to 0x200");
        });

        singleStepButton.addActionListener(e -> {
            systemCore.systemFunctions.runSingleStep();
            debugPrint("Running single step");
        });

        DebugCheck.addActionListener(e -> {
            systemCore.systemSettings.Debug = DebugCheck.isSelected();
            if (systemCore.systemSettings.Debug)
            {
                debugPrint("Debug Enabled");
            }
            else {
                debugPrint("Debug Disabled");
            }
        });

        kbInputButton.addActionListener(e -> {
            kbBuffer.append(kbInputField.getText());
            kbBuffer.append("\0");

            kbBuffer.setCaretPosition(kbBuffer.getDocument().getLength());
        });

        kbInputField.addActionListener(e -> {
            kbBuffer.append(kbInputField.getText());
            kbBuffer.append("\0");

            kbBuffer.setCaretPosition(kbBuffer.getDocument().getLength());
        });

        crInputButton.addActionListener(e -> {

            int select = MEMFileChooser.showOpenDialog(null);
            if (select == MEMFileChooser.APPROVE_OPTION) {

                String Final_string = "";
                crBuffer.setText(Final_string);

                File MEMFile = MEMFileChooser.getSelectedFile();

                String file_name = MEMFile.getName();


                systemCore.frame.debugPrint("Selected File" + MEMFile.getName());

                if (file_name.endsWith(".txt"))
                {
                    try (BufferedReader br = new BufferedReader(new FileReader(MEMFile.getPath())))
                    {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());
                            line = br.readLine();
                        }
                        Final_string = sb.toString();

                        crBuffer.append(Final_string);
                        crBuffer.append("\0");
                        crBuffer.setCaretPosition(crBuffer.getDocument().getLength());

                        CRFileName.setText(file_name);
                    }
                    catch (Exception error)
                    {
                        systemCore.frame.debugPrint("Unable to Read File \nReason :" + error);
                    }
                }
                else {
                    systemCore.frame.debugPrint("Please select a .txt file");
                }
            }

        });


    }



    public char popKBBuffer() {
        String s = kbBuffer.getText();
        char c = '\0';
        if (!s.equals("")) {
            c = s.charAt(0);
            s = s.substring(1);
        }
        kbBuffer.setText(s);

        return c;
    }

    public boolean isKBBufferEmpty() {
        return kbBuffer.getText().equals("");
    }

    public boolean isCRBufferEmpty() {
        return crBuffer.getText().equals("");
    }

    public char popCRBuffer() {
        String s = crBuffer.getText();
        char c = '\0';
        if (!s.equals("")) {
            c = s.charAt(0);
            s = s.substring(1);
        }
        crBuffer.setText(s);

        return c;
    }

    public void pushPrinterBuffer(char c) {
        String s = printerBuffer.getText();

        s = s + c;
        printerBuffer.setText(s);

        printerBuffer.setCaretPosition(printerBuffer.getDocument().getLength());
    }

    public void insertPrinterBuffer(char c) {
        String s = printerBuffer.getText();

        String[] split = s.split("\n");

        split[split.length - 1] = c + split[split.length - 1];

        StringBuilder ns = new StringBuilder();

        for (String value : split) {
            ns.append(value);
            ns.append("\n");
        }
        printerBuffer.setText(ns.toString());

        printerBuffer.setCaretPosition(printerBuffer.getDocument().getLength());
    }












    public void debugPrint(String s) {
        if (!systemCore.systemSettings.Debug) {
            return;
        }
        debugConsoleOutput.append(s);
        debugConsoleOutput.append("\n");
        debugConsoleOutput.setCaretPosition(debugConsoleOutput.getDocument().getLength());
    }














    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void bindSystemControl(SystemCore systemCore) {
        this.systemCore = systemCore;
    }






    public void update_cache_hit_miss(int cache_loc)
    {
        switch (cache_loc)
        {
            case 0:
                if (Cache0.getBackground() != Color.GREEN)
                {
                    Cache0.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 1:
                if (Cache1.getBackground() != Color.GREEN)
                {
                    Cache1.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 2:
                if (Cache2.getBackground() != Color.GREEN)
                {
                    Cache2.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 3:
                if (Cache3.getBackground() != Color.GREEN)
                {
                    Cache3.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 4:
                if (Cache4.getBackground() != Color.GREEN)
                {
                    Cache4.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 5:
                if (Cache5.getBackground() != Color.GREEN)
                {
                    Cache5.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 6:
                if (Cache6.getBackground() != Color.GREEN)
                {
                    Cache6.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 7:
                if (Cache7.getBackground() != Color.GREEN)
                {
                    Cache7.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 8:
                if (Cache8.getBackground() != Color.GREEN)
                {
                    Cache8.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 9:
                if (Cache9.getBackground() != Color.GREEN)
                {
                    Cache9.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 10:
                if (Cache10.getBackground() != Color.GREEN)
                {
                    Cache10.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 11:
                if (Cache11.getBackground() != Color.GREEN)
                {
                    Cache11.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 12:
                if (Cache12.getBackground() != Color.GREEN)
                {
                    Cache12.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 13:
                if (Cache13.getBackground() != Color.GREEN)
                {
                    Cache13.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 14:
                if (Cache14.getBackground() != Color.GREEN)
                {
                    Cache14.setBackground(Color.GREEN);
                    set_cache_bg(cache_loc);
                }

            case 15:
                if (Cache15.getBackground() != Color.GREEN)
                {
                    Cache15.setBackground(Color.GREEN);
                }
                set_cache_bg(cache_loc);
        };
    }

    public void set_cache_bg(int cache_loc)
    {
        if (cache_loc != 0)
        {
            Cache0.setBackground(defaultcolor);
        }
        if (cache_loc != 1)
        {
            Cache1.setBackground(defaultcolor);
        }
        if (cache_loc != 2)
        {
            Cache2.setBackground(defaultcolor);
        }
        if (cache_loc != 3)
        {
            Cache3.setBackground(defaultcolor);
        }
        if (cache_loc != 4)
        {
            Cache4.setBackground(defaultcolor);
        }
        if (cache_loc != 5)
        {
            Cache5.setBackground(defaultcolor);
        }
        if (cache_loc != 6)
        {
            Cache6.setBackground(defaultcolor);
        }
        if (cache_loc != 7)
        {
            Cache7.setBackground(defaultcolor);
        }
        if (cache_loc != 8)
        {
            Cache8.setBackground(defaultcolor);
        }
        if (cache_loc != 9)
        {
            Cache9.setBackground(defaultcolor);
        }
        if (cache_loc != 10)
        {
            Cache10.setBackground(defaultcolor);
        }
        if (cache_loc != 11)
        {
            Cache11.setBackground(defaultcolor);
        }
        if (cache_loc != 12)
        {
            Cache12.setBackground(defaultcolor);
        }
        if (cache_loc != 13)
        {
            Cache13.setBackground(defaultcolor);
        }
        if (cache_loc != 14)
        {
            Cache14.setBackground(defaultcolor);
        }
        if (cache_loc != 15)
        {
            Cache15.setBackground(defaultcolor);
        }
    }


    public void update_memory()
    {
        for (int i = 0; i < systemCore.memory.ProcessorMemory.length; i++)
        {
            AddressList.add(String.format("%4S", Integer.toHexString(i)).replace(' ', '0'));
            memoryValue.add(String.format("%16S", Integer.toBinaryString(systemCore.memory.ProcessorMemory[i])).replace(' ', '0'));
            memoryHexValue.add(String.format("%4S", Integer.toHexString(systemCore.memory.ProcessorMemory[i])).replace(' ', '0'));
            memoryAssembleCode.add("NONE");
        }


        MemoryAddressList.setListData(AddressList);
        MemoryValueList.setListData(memoryValue);
        MemoryHexValueList.setListData(memoryHexValue);
        MemoryAssembleCodeList.setListData(memoryAssembleCode);


    }


    public void update_memory_single(int Value, int Address)
    {
        memoryValue.setElementAt(String.format("%16S", Integer.toBinaryString(Value)).replace(' ', '0'), Address);
        memoryHexValue.setElementAt(String.format("%4S", Integer.toHexString(Value)).replace(' ', '0'), Address);

        MemoryAddressList.setListData(AddressList);
        MemoryValueList.setListData(memoryValue);
        MemoryHexValueList.setListData(memoryHexValue);
        MemoryAssembleCodeList.setListData(memoryAssembleCode);
    }


    public void update_registers()
    {
        String CC_BIN = String.format("%4S", Integer.toBinaryString(systemCore.registers.CC)).replace(' ', '0');
        String MFR_BIN = String.format("%4S", Integer.toBinaryString(systemCore.registers.MFR)).replace(' ', '0');

        if (CC_BIN.charAt(3) == '1') {CC1RadioButton.setSelected(true);} else {CC1RadioButton.setSelected(false);}
        if (CC_BIN.charAt(2) == '1') {CC2RadioButton.setSelected(true);} else {CC2RadioButton.setSelected(false);}
        if (CC_BIN.charAt(1) == '1') {CC3RadioButton.setSelected(true);} else {CC3RadioButton.setSelected(false);}
        if (CC_BIN.charAt(0) == '1') {CC4RadioButton.setSelected(true);} else {CC4RadioButton.setSelected(false);}

        if (MFR_BIN.charAt(3) == '1') {MFR1RadioButton.setSelected(true);} else {MFR1RadioButton.setSelected(false);}
        if (MFR_BIN.charAt(2) == '1') {MFR2RadioButton.setSelected(true);} else {MFR2RadioButton.setSelected(false);}
        if (MFR_BIN.charAt(1) == '1') {MFR3RadioButton.setSelected(true);} else {MFR3RadioButton.setSelected(false);}
        if (MFR_BIN.charAt(0) == '1') {MFR4RadioButton.setSelected(true);} else {MFR4RadioButton.setSelected(false);}

        gpr0BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.GPRS[0])).replace(' ', '0'));
        gpr1BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.GPRS[1])).replace(' ', '0'));
        gpr2BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.GPRS[2])).replace(' ', '0'));
        gpr3BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.GPRS[3])).replace(' ', '0'));
        irBinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.IR)).replace(' ', '0'));
        ixr1BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.IXRS[0])).replace(' ', '0'));
        ixr2BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.IXRS[1])).replace(' ', '0'));
        ixr3BinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.IXRS[2])).replace(' ', '0'));
        marBinTextField.setText(String.format("%12S", Integer.toBinaryString(systemCore.registers.MAR)).replace(' ', '0'));
        mbrBinTextField.setText(String.format("%16S", Integer.toBinaryString(systemCore.registers.MBR)).replace(' ', '0'));
        pcBinTextField.setText(String.format("%12S", Integer.toBinaryString(systemCore.registers.PC)).replace(' ', '0'));

        gpr0HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.GPRS[0])).replace(' ', '0'));
        gpr1HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.GPRS[1])).replace(' ', '0'));
        gpr2HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.GPRS[2])).replace(' ', '0'));
        gpr3HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.GPRS[3])).replace(' ', '0'));
        irHexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.IR)).replace(' ', '0'));
        ixr1HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.IXRS[0])).replace(' ', '0'));
        ixr2HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.IXRS[1])).replace(' ', '0'));
        ixr3HexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.IXRS[2])).replace(' ', '0'));
        marHexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.MAR)).replace(' ', '0'));
        mbrHexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.MBR)).replace(' ', '0'));
        pcHexTextField.setText(String.format("%4S", Integer.toHexString(systemCore.registers.PC)).replace(' ', '0'));
        ccHexTextField.setText(String.format("%1S", Integer.toHexString(systemCore.registers.CC)).replace(' ', '0'));
        mfrHexTextField.setText(String.format("%1S", Integer.toHexString(systemCore.registers.MFR)).replace(' ', '0'));


        runningCheckBox.setSelected(systemCore.systemSettings.Running);
        haltedCheckBox.setSelected(systemCore.systemSettings.Idle);
    }

    public void update_cache()
    {
        try {
            Cache0.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(0))).replace(' ', '0'));
            Cache1.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(1))).replace(' ', '0'));
            Cache2.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(2))).replace(' ', '0'));
            Cache3.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(3))).replace(' ', '0'));
            Cache4.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(4))).replace(' ', '0'));
            Cache5.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(5))).replace(' ', '0'));
            Cache6.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(6))).replace(' ', '0'));
            Cache7.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(7))).replace(' ', '0'));
            Cache8.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(8))).replace(' ', '0'));
            Cache9.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(9))).replace(' ', '0'));
            Cache10.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(10))).replace(' ', '0'));
            Cache11.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(11))).replace(' ', '0'));
            Cache12.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(12))).replace(' ', '0'));
            Cache13.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(13))).replace(' ', '0'));
            Cache14.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(14))).replace(' ', '0'));
            Cache15.setText(String.format("%16S", Integer.toBinaryString(systemCore.cache.CacheContent.get(15))).replace(' ', '0'));
        } catch (Exception e)
        {
            assert true;
        }

    }


    public void update()
    {
        update_registers();
        update_cache();
    }

}




