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
package net.sf.dynamicreports.examples.subreport;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DetailDynamicSubreport {

    public void build() throws DRException {
        
        
        
        JRDataSource createDataSource = createDataSource();

        SubreportBuilder subreport = cmp.subreport(new SubreportExpression()).setDataSource(new SubreportDataSourceExpression());

        JasperReportBuilder report = report();
        report.title(Templates.createTitleComponent("DetailDynamicSubreport"));
        report.detail(subreport);
        report.pageFooter(Templates.footerComponent);
        report.setDataSource(createDataSource).show();

    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("column");
        dataSource.add("AAAAAAa");
        dataSource.add("AAAAAAa");
        dataSource.add("AAAAAAa");
        return dataSource;
    }

    private class SubreportExpression extends AbstractSimpleExpression<JasperReportBuilder> {

        private static final long serialVersionUID = 1L;

        @Override
        public JasperReportBuilder evaluate(ReportParameters reportParameters) {
            int masterRowNumber = reportParameters.getReportRowNumber();

            JasperReportBuilder report = report();

            report.setTemplate(Templates.reportTemplate).title(cmp.text("Subreport" + masterRowNumber).setStyle(Templates.bold12CenteredStyle));

            for (int i = 1; i <= masterRowNumber; i++) {
                report.addColumn(col.column("Column" + i, "column" + i, type.stringType()));
            }

            return report;
        }
    }

    private class SubreportDataSourceExpression extends AbstractSimpleExpression<JRDataSource> {

        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            int masterRowNumber = reportParameters.getReportRowNumber();

            String[] columns = new String[masterRowNumber];
            for (int i = 1; i <= masterRowNumber; i++) {
                columns[i - 1] = "column" + i;
            }
            DRDataSource dataSource = new DRDataSource(columns);

            for (int i = 1; i <= masterRowNumber; i++) {
                Object[] values = new Object[masterRowNumber];
                for (int j = 1; j <= masterRowNumber; j++) {
                    values[j - 1] = "row" + i + "_column" + j;
                }
                dataSource.add(values);
            }

            return dataSource;
        }
    }

    public static void main(String[] args) throws DRException {
        new DetailDynamicSubreport().build();
    }
}
