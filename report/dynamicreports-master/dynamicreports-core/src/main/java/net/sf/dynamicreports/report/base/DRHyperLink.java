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

package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HyperLinkTarget;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.report.definition.DRIHyperLink;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRHyperLink implements DRIHyperLink {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<String> anchorExpression;
	private DRIExpression<Integer> pageExpression;
	private DRIExpression<String> referenceExpression;
	private DRIExpression<String> tooltipExpression;
	private HyperLinkType hyperLinkType;
	private HyperLinkTarget hyperLinkTarget;

	@Override
	public DRIExpression<String> getAnchorExpression() {
		return anchorExpression;
	}

	public void setAnchorExpression(DRIExpression<String> anchorExpression) {
		this.anchorExpression = anchorExpression;
	}

	@Override
	public DRIExpression<Integer> getPageExpression() {
		return pageExpression;
	}

	public void setPageExpression(DRIExpression<Integer> pageExpression) {
		this.pageExpression = pageExpression;
	}

	@Override
	public DRIExpression<String> getReferenceExpression() {
		return referenceExpression;
	}

	public void setReferenceExpression(DRIExpression<String> referenceExpression) {
		this.referenceExpression = referenceExpression;
	}

	@Override
	public DRIExpression<String> getTooltipExpression() {
		return tooltipExpression;
	}

	public void setTooltipExpression(DRIExpression<String> tooltipExpression) {
		this.tooltipExpression = tooltipExpression;
	}

	@Override
	public HyperLinkType getType() {
		return hyperLinkType;
	}

	public void setType(HyperLinkType hyperLinkType) {
		this.hyperLinkType = hyperLinkType;
	}

	@Override
	public HyperLinkTarget getTarget() {
		return hyperLinkTarget;
	}

	public void setTarget(HyperLinkTarget hyperLinkTarget) {
		this.hyperLinkTarget = hyperLinkTarget;
	}
}
