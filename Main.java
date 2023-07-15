import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        //Test: creating a spreadsheet
        SpreadSheet sp = new SpreadSheet();
        sp.addRow();
        sp.addRow();
        sp.addColumn();
        sp.addColumn();
        sp.addColumn();
        int value = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                sp.setValueAt(i, j, value++);
        }
        System.out.println("sp:");
        sp.viewValues();
        System.out.println();
        SpreadSheet sp1 = new SpreadSheet(3,4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++)
                sp1.setValueAt(i, j, value++);
        }
        System.out.println("sp1:");
        sp1.viewValues();
        System.out.println(sp1.getValueAt(0,2));
        sp1.getValueAt(5,2);
        sp1.addRow(1);
        for (int j = 0; j < 4; j++) {
            sp1.setValueAt(1, j, LocalDate.now());
        }
        //Test: methods that calculate sum and average
        System.out.println(sp.getAreaSum());
        System.out.println(sp.getRowSum(1));
        sp1.addColumn(2);
        for (int i = 0; i < 4; i++) {
            sp1.setValueAt(i, 2, value++);
        }
        System.out.println();
        System.out.println("sp1:");
        sp1.viewValues();
        System.out.println(sp1.getColumnSum(2));
        System.out.println(sp1.getColumnSum(0));
        sp.addRow(0);
        for (int i = 0; i < 3; i++) {
            sp.setValueAt(0, i, value++);
        }
        System.out.println();
        System.out.println("sp:");
        sp.viewValues();
        System.out.println(sp.getAreaAverage(0,2,0,3));
        System.out.println(sp.getAreaAverage());
        System.out.println(sp1.getRowAverage(1));
        System.out.println(sp1.getColumnAverage(2));
        System.out.println(sp.getAreaSum(0,2,0,3));
        //Test: assigning colors to cells
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                sp.setColorAt(i, j, Color.RED);
        sp.setColorAt(1,1,Color.GREEN);
        sp.setColorAt(8,0, Color.PINK);
        sp.setColorAt(0,2, Color.PURPLE);
        System.out.println("sp:");
        sp.viewColors();
        sp1.addColumn();
        for (int i = 0; i < 4; i++) {
            sp1.setValueAt(i,5, "value" + i);
        }
        System.out.println("sp1");
        sp1.viewTypes();
        sp1.resetCellAt(0,2);
        System.out.println();
        sp1.viewTypes();
        System.out.println();
        sp1.viewValues();
        sp.reset();
        System.out.println("sp:");
        sp.viewTypes();
        System.out.println();
        sp.viewColors();
        System.out.println();
        sp.viewValues();

    }
}