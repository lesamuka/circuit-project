/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2012 Ricardo Mariaca
 * http://dynamicreports.sourceforge.net
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package receita;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class ColumnSubreportDataReport {

    public void ColumnSubreportDataReport() throws DRException, JRScriptletException {
        build();
    }

    private void build() {
        SubreportBuilder subreport = cmp.subreport(new SubreportDesign()).setDataSource(new SubreportData());
        try {
            JasperReportBuilder report = report();
            report.setTemplate(Templates.reportTemplate);
            report.fields(field("receitaEspecial", ReceitaEspecial.class));
            report.columns(col.componentColumn(subreport));
            report.title(Templates.createTitleComponent("ColumnSubreportDatassss"));
            report.pageFooter(Templates.footerComponent);
            report.setDataSource(createDataSource());
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private class SubreportDesign extends AbstractSimpleExpression<JasperReportBuilder> {

        private static final long serialVersionUID = 1L;

        @Override
        public JasperReportBuilder evaluate(ReportParameters reportParameters) {
            ReceitaEspecial value = (ReceitaEspecial) reportParameters.getValue("receitaEspecial");

            return gerarRelatorio(value);
        }

        public JasperReportBuilder gerarRelatorio(ReceitaEspecial value) {
            
            
            TextColumnBuilder<String> column = col.column("comment", "comment", type.stringType());
            
            
            HorizontalListBuilder itemComponent = cmp.horizontalList(cmp.text("999999999999999999999"));

            VerticalListBuilder verticalList = cmp.verticalList();
            verticalList.add(cmp.text("AAAAAAAAAAAA"));
            verticalList.add(cmp.text("BBBBBBBBBBBBB"));
            verticalList.add(cmp.text(value.getNome()));

            JasperReportBuilder report = report();

            report.addTitle(verticalList);
            report.columns(col.componentColumn("comment", itemComponent));

            return report;
        }

    }

    private class SubreportData extends AbstractSimpleExpression<JRDataSource> {

        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            ReceitaEspecial value = (ReceitaEspecial) reportParameters.getValue("receitaEspecial");

            DRDataSource dataSource = new DRDataSource("comment");
            dataSource.add("XXXXXXXXXXXXXXXx");
            dataSource.add("XXXXXXXXXXXXXXXx");
            dataSource.add("XXXXXXXXXXXXXXXx");
            return dataSource;
        }
    }

    private JRDataSource createDataSource() {
        List<ReportData> datasource = new ArrayList<ReportData>();

        {
            ReportData data = new ReportData();
            data.setItem("Book");
            data.setQuantity(10);
            data.setReceitaEspecial(new ReceitaEspecial("AAAAAAAAAAAAA", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"));
            data.getList().add("comment1");
            datasource.add(data);
        }

        {
            ReportData data = new ReportData();
            data.setItem("Bookkkkk");
            data.setQuantity(10);
            data.setReceitaEspecial(new ReceitaEspecial("CCCCCCCCCC", "************************************"));
            data.getList().add("comment4");
            datasource.add(data);
        }

        return new JRBeanCollectionDataSource(datasource);
    }

    public class ReportData {

        private String item;
        private Integer quantity;
        private ReceitaEspecial receitaEspecial;
        private List<String> list = new ArrayList<>();

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public ReceitaEspecial getReceitaEspecial() {
            return receitaEspecial;
        }

        public void setReceitaEspecial(ReceitaEspecial receitaEspecial) {
            this.receitaEspecial = receitaEspecial;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    public class ReceitaEspecial {

        private String item;
        private String nome;

        public ReceitaEspecial(String item, String nome) {
            this.item = item;
            this.nome = nome;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    public static void main(String[] args) throws DRException, JRScriptletException {
        new ColumnSubreportDataReport().ColumnSubreportDataReport();
    }
}
