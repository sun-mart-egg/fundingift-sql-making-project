package _common.sql;

import java.util.ArrayList;
import java.util.List;

public class InsertSQL {

    private static String insert = "INSERT INTO";
    private static String value = "VALUES";

    private String table;
    private String columns;
    private List<String> values;

    public InsertSQL(String table, String columns) {
        this.table = table;
        this.columns = columns;
        this.values = new ArrayList<>();
    }

    public void addValue(String value) {
        values.add(value);
    }

    public String make() {
        if(values.isEmpty())
            throw new RuntimeException("values값이 하나도 없습니다.");

        StringBuilder sb = new StringBuilder();

        sb.append(insert).append(" ")
                .append(table).append("\n").append("\t")
                .append(columns).append("\n")
                .append(value).append("\n").append("\t");

        for(String s : values)
            sb.append(s).append(", ");

        sb.setCharAt(sb.length() - 2, ';');

        return sb.toString();
    }
}
