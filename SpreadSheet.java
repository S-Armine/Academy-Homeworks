import java.util.ArrayList;
public class SpreadSheet {
    private ArrayList<ArrayList<Cell>> cells;
    private int column;
    private int row;

    SpreadSheet() {
        cells = new ArrayList<ArrayList<Cell>>();
    }

    SpreadSheet(int row, int column) {
        this.row = row;
        this.column = column;
        cells = new ArrayList<ArrayList<Cell>>();
        for (int i = 0; i < row; i++) {
            cells.add(new ArrayList<Cell>());
            for (int j = 0; j < column; j++) {
                cells.get(i).add(new Cell());
            }
        }
    }

    public void addColumn() {
        for (int i = 0; i < row; i++)
            cells.get(i).add(new Cell());
        column++;
    }

    public void addColumn(int newCol) {
        try {
            for (int i = 0; i < row; i++)
                cells.get(i).add(newCol, new Cell());
            column++;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't add column. ");
            System.out.println(e.getMessage());
        }
    }

    public void addRow() {
        cells.add(new ArrayList<Cell>());
        for (int i = 0; i < column; i++) {
            cells.get(row).add(new Cell());
        }
        row++;
    }

    public void addRow(int newRow) {
        try {
            cells.add(newRow, new ArrayList<Cell>());
            for (int i = 0; i < column; i++) {
                cells.get(newRow).add(new Cell());
            }
            row++;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't add row. ");
            System.out.println(e.getMessage());
        }
    }

    public void setValueAt(int r, int c, Object setVal) {
        try {
            cells.get(r).get(c).setValue(setVal);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't set value. ");
            System.out.println(e.getMessage());
        }
    }

    public Object getValueAt(int r, int c) {
        try {
            return cells.get(r).get(c).getValue();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't get value. ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void setColorAt(int r, int c, Color color) {
        try {
        cells.get(r).get(c).setColor(color);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't set color. ");
            System.out.println(e.getMessage());
        }
    }

    public Color getColorAt(int r, int c) {
        try {
            return cells.get(r).get(c).getColor();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't get color. ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void reset() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                cells.get(i).get(j).reset();
        }
    }

    public void resetCellAt(int r, int c) {
        try {
            cells.get(r).get(c).reset();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't reset cell. ");
            System.out.println(e.getMessage());
        }
    }

    public double getColumnSum(int col) {
        try {
            double sum = 0;
            for (ArrayList<Cell> cellRow : cells) {
                if (cellRow.get(col).getType() == Type.NUMBER) {
                    sum += ((Number) cellRow.get(col).getValue()).doubleValue();
                } else {
                    System.out.print("This column contains non-numeric value. ");
                    return 0;
                }
            }
            return sum;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate sum. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public double getRowSum(int row) {
        try {
            double sum = 0;
            for (Cell cell : cells.get(row)) {
                if (cell.getType() == Type.NUMBER) {
                    sum += ((Number) cell.getValue()).doubleValue();
                } else {
                    System.out.print("This row contains non-numeric value. ");
                    return 0;
                }
            }
            return sum;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate sum. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public double getAreaSum() {
        double sum = 0;
        for (ArrayList<Cell> cellRow: cells) {
            for(Cell cell: cellRow) {
                if (cell.getType() == Type.NUMBER) {
                    sum += ((Number) cell.getValue()).doubleValue();
                } else {
                    System.out.print("This SpreadSheet contains non-numeric value. ");
                    return 0;
                }
            }
        }
        return sum;
    }

    public double getAreaSum(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        try {
            double sum = 0;
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = columnStart; j < columnEnd; j++) {
                    if (cells.get(i).get(j).getType() == Type.NUMBER) {
                        sum += ((Number) cells.get(i).get(j).getValue()).doubleValue();
                    } else {
                        System.out.print("This area contains non-numeric value. ");
                        return 0;
                    }
                }
            }
            return sum;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate sum. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public double getColumnAverage(int col) {
        try {
            double sum = 0;
            for (ArrayList<Cell> cellRow : cells) {
                if (cellRow.get(col).getType() == Type.NUMBER) {
                    sum += ((Number) cellRow.get(col).getValue()).doubleValue();
                } else {
                    System.out.print("This column contains non-numeric value. ");
                    return 0;
                }
            }
            return sum / row;
        } catch(IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate average. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public double getRowAverage(int row) {
        try {
            double sum = 0;
            for (Cell cell : cells.get(row)) {
                if (cell.getType() == Type.NUMBER) {
                    sum += ((Number) cell.getValue()).doubleValue();
                } else {
                    System.out.print("This row contains non-numeric value. ");
                    return 0;
                }
            }
            return sum / column;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate average. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public double getAreaAverage() {
        double sum = 0;
        for (ArrayList<Cell> cellRow: cells) {
            for(Cell cell: cellRow) {
                if (cell.getType() == Type.NUMBER) {
                    sum += ((Number) cell.getValue()).doubleValue();
                } else {
                    System.out.print("This SpreadSheet contains non-numeric value. ");
                    return 0;
                }
            }
        }
        return sum / (row * column);
    }

    public double getAreaAverage(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        try {
            double sum = 0;
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = columnStart; j < columnEnd; j++) {
                    if (cells.get(i).get(j).getType() == Type.NUMBER) {
                        sum += ((Number) cells.get(i).get(j).getValue()).doubleValue();
                    } else {
                        System.out.print("This area contains non-numeric value. ");
                        return 0;
                    }
                }
            }
            return sum / ((rowEnd - rowStart) * (columnEnd - columnStart));
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Couldn't calculate average. ");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public void viewValues() {
        for (ArrayList<Cell> cellRow: cells) {
            for (Cell cell: cellRow) {
                System.out.print(cell.getValue() + " ");
            }
            System.out.println();
        }
    }

    public void viewColors() {
        for (ArrayList<Cell> cellRow: cells) {
            for (Cell cell: cellRow) {
                System.out.print(cell.getColor() + " ");
            }
            System.out.println();
        }
    }

    public void viewTypes() {
        for (ArrayList<Cell> cellRow: cells) {
            for (Cell cell: cellRow) {
                System.out.print(cell.getType() + " ");
            }
            System.out.println();
        }
    }
}
