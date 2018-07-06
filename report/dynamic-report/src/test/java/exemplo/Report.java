package exemplo;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class Report {

    private StyleBuilder boldCenteredStyle;

    private StyleBuilder borderedStyle;

    public Report() {
        build();
    }

    private void build() {
        boldCenteredStyle = stl.style().bold().setHorizontalAlignment(HorizontalAlignment.CENTER);
        borderedStyle = stl.style(stl.pen1Point());
        try {
            JasperReportBuilder report = report();
            report.summary(createVerticalList());
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private TextFieldBuilder<String> createTextField(String label) {
        return cmp.text(label).setStyle(boldCenteredStyle);
    }

    private ComponentBuilder<?, ?> createHorizontalList() {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        for (int i = 0; i < 10; i++) {
            horizontalList.add(cmp.text("").setStyle(borderedStyle));
        }
        return horizontalList;
    }

    private ComponentBuilder<?, ?> createMultiRowHorizontalList() {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        for (int i = 0; i < 3; i++) {
            horizontalList.add(cmp.text("").setStyle(borderedStyle));
        }
        horizontalList.newRow();
        for (int i = 0; i < 7; i++) {
            horizontalList.add(cmp.text("").setStyle(borderedStyle));
        }
        return horizontalList;
    }

    private ComponentBuilder<?, ?> createHorizontalFlowList() {
        HorizontalListBuilder horizontalList = cmp.horizontalFlowList();
        for (int i = 0; i < 9; i++) {
            horizontalList.add(cmp.text("").setStyle(borderedStyle));
        }
        return horizontalList;
    }

    private ComponentBuilder<?, ?> createVerticalList() {
        VerticalListBuilder verticalList = cmp.verticalList();
        for (int i = 0; i < 4; i++) {
            verticalList.add(cmp.text("A").setStyle(borderedStyle));
        }
        verticalList.setStyle(borderedStyle);
        return verticalList;
    }

    private ComponentBuilder<?, ?> createNestedList() {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        for (int i = 0; i < 2; i++) {
            horizontalList.add(createVerticalList());
        }
        return horizontalList;
    }

    public static void main(String[] args) {
        new Report();
    }
}
