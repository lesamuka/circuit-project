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

package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.jasperreports.engine.component.Component;
import net.sf.jasperreports.engine.component.ComponentFillFactory;
import net.sf.jasperreports.engine.component.FillComponent;
import net.sf.jasperreports.engine.fill.JRFillCloneFactory;
import net.sf.jasperreports.engine.fill.JRFillObjectFactory;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class GeoMapFillFactory implements ComponentFillFactory {

	@Override
	public FillComponent toFillComponent(Component component, JRFillObjectFactory factory) {
		GeoMapComponent geoMap = (GeoMapComponent) component;
		return new GeoMapFillComponent(geoMap, factory);
	}

	@Override
	public FillComponent cloneFillComponent(FillComponent component, JRFillCloneFactory factory) {
		throw new UnsupportedOperationException();
	}

}
