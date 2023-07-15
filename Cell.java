import java.time.LocalDate;
public class Cell {
    private Object value;
    private Color color;
    private Type type;

    public void setValue(Object val) {
        if (val instanceof Number) type = Type.NUMBER;
        else if (val instanceof String) type = Type.STRING;
        else if (val instanceof LocalDate) type = Type.DATE;
        else {
            System.out.println("Invalid value was given, so this value can not be assigned.");
            return;
        }
        value = val;
    }

    public Object getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public void setColor(Color col) {
        color = col;
    }

    public Color getColor() {
        return color;
    }

    public void reset() {
        color = null;
        type = null;
        value = null;
    }
}
