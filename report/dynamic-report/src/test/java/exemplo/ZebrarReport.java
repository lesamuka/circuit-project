package exemplo;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import java.util.Date;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import org.templat.Templates;

public class ZebrarReport {

    public ZebrarReport() {
        build();
    }

    private void build() {

        StyleBuilder textStyle = stl.style(Templates.columnStyle).setBorder(stl.pen1Point());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());
        TextColumnBuilder<Date> orderDateColumn = col.column("Order date", "orderdate", type.dateType());
        TextColumnBuilder<Date> orderDateFColumn = col.column("Order date", "orderdate", type.dateYearToFractionType());
        TextColumnBuilder<Date> orderYearColumn = col.column("Order year", "orderdate", type.dateYearType());
        TextColumnBuilder<Date> orderMonthColumn = col.column("Order month", "orderdate", type.dateMonthType());
        TextColumnBuilder<Date> orderDayColumn = col.column("Order day", "orderdate", type.dateDayType());

        try {
            JasperReportBuilder report = report();
                    
            report.setTemplate(Templates.reportTemplate);
            report.setColumnStyle(textStyle);
                    
            report.columns(itemColumn, 
                           quantityColumn, 
                           unitPriceColumn, 
                           orderDateColumn,
                           orderDateFColumn, 
                           orderYearColumn,
                           orderMonthColumn, 
                           orderDayColumn);
                    
            report.title(Templates.createTitleComponent("ColumnGrid"));
            report.pageFooter(Templates.footerComponent);
            report.setDataSource(createDataSource());
            report.highlightDetailEvenRows();
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Notebook", new Date(), 1, new BigDecimal(500));
        dataSource.add("Book", new Date(), 7, new BigDecimal(300));
        dataSource.add("PDA", new Date(), 2, new BigDecimal(250));
        return dataSource;
    }

    public static void main(String[] args) {
        new ZebrarReport();
    }
}
