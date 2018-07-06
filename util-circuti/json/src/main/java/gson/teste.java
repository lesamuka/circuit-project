package gson;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class teste {

    public static void main(String[] args) {

        List<List<Integer>> integerList = new ArrayList<>();
        {
            List<Integer> list = new ArrayList<>();
            list.add(17);
            list.add(15);
            list.add(67);
            list.add(77);
            list.add(27);
            integerList.add(list);
        }

        {
            List<Integer> list = new ArrayList<>();
            list.add(17);
            list.add(15);
            list.add(67);
            list.add(77);
            list.add(27);
            integerList.add(list);
        }

        {
            List<Integer> list = new ArrayList<>();
            list.add(17);
            list.add(15);
            list.add(67);
            list.add(77);
            list.add(27);
            integerList.add(list);
        }
        String toJson = new Gson().toJson(integerList);
    }

    public static void main1() {

        DataTable dataTable = new DataTable();
        dataTable.setType(new Type("Month"));
        dataTable.addHeader(new Header("DISPENSAÇÃO"));
        dataTable.addHeader(new Header("CONSUMO INTERNO"));
        dataTable.addHeader(new Header("TRANSFÊNCIA-ENTRADA"));
        dataTable.addHeader(new Header("TRANSFÊNCIA-SAÍDA"));
        dataTable.addHeader(new Header("DOAÇÃO"));
        dataTable.addHeader(new Header("ESTORNO"));

        {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(17);
            integerList.add(15);
            integerList.add(67);
            integerList.add(77);
            integerList.add(27);
            integerList.add(47);
            integerList.add(49);
            Row row = new Row("2004/05", integerList);
            dataTable.addRow(row);
        }

        {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(17);
            integerList.add(15);
            integerList.add(67);
            integerList.add(77);
            integerList.add(27);
            integerList.add(47);
            integerList.add(49);
            Row row = new Row("2005/05", integerList);
            dataTable.addRow(row);
        }

        dataTable.toJson();

        String toJson = new Gson().toJson(dataTable);
        System.out.println(toJson);
    }

    private static class DataTable {

        private Type type;
        private List<Header> headerList = new ArrayList<>();
        private List<Row> rowList = new ArrayList<>();

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public void addHeader(Header header) {
            headerList.add(header);
        }

        public void addRow(Row header) {
            rowList.add(header);
        }

        private String columnHeader() {
            List<String> list = new ArrayList<>();
            list.add("'" + type.getTitle() + "'");
            list.addAll(headerList.stream().map(x -> "'" + x.getTitle() + "'").collect(Collectors.toList()));
            return list.toString();
        }

        private String rowList() {
            List<String> list = rowList.stream().map(x -> x.toArray()).collect(Collectors.toList());
            return StringUtils.join(list, ",");
        }

        public String toJson() {
            List<String> list = new ArrayList<>();
            list.add(columnHeader());
            list.add(rowList());
            return null;
        }
    }

    private static class Type {

        private String title;

        public Type(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

    private static class Header {

        private String title;

        public Header() {
        }

        public Header(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    private static class Row {

        private String key;
        private List<Integer> valueList;

        public Row(String key, List<Integer> valueList) {
            this.key = key;
            this.valueList = valueList;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<Integer> getValueList() {
            return valueList;
        }

        public void setValueList(List<Integer> valueList) {
            this.valueList = valueList;
        }

        public String toArray() {
            List<String> list = new ArrayList<>();
            list.add("'".concat(key).concat("'"));
            list.addAll(valueList.stream().map(x -> x.toString()).collect(Collectors.toList()));

            return list.toString();
        }
    }

}
