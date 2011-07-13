/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2011, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.swing;

import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.map.MapContent;
import org.geotools.renderer.GTRenderer;
import org.geotools.swing.event.MapMouseListener;
import org.geotools.swing.event.MapPaneListener;
import org.opengis.geometry.Envelope;

/**
 * Defines the core map pane methods.
 *
 * @author Michael Bedward
 * @since 8.0
 * @source $URL: $
 * @version $Id: $
 */
public interface MapPane {

    /**
     * Sets the {@code MapContent} instance containing the layers
     * to display.
     *
     * @param content the map content
     */
    void setMapContent(MapContent content);

    /**
     * Gets the {@code MapConent} instance containing the layers
     * being displayed by this map pane.
     *
     * @return the map content
     */
    MapContent getMapContent();

    /**
     * Sets the renderer to be used by this map pane.
     *
     * @param renderer the renderer to use
     */
    void setRenderer(GTRenderer renderer);
    
    /**
     * Gets the renderer used by this map pane.
     *
     * @return the renderer
     */
    GTRenderer getRenderer();

    /**
     * Gets the current display area in world coordinates. This is a
     * short-cut for {@code mapPane.getMapContent().getViewport().getBounds()}.
     * If a MapContent object has not yet been associated with the map pane, an
     * empty {@code ReferencedEnvelope} is returned.
     *
     * @return the display area in world coordinates
     */
    ReferencedEnvelope getDisplayArea();

    /**
     * Sets the area to display in world units.
     * 
     * @param the new display area
     * @throws IllegalArgumentException if {@code envelope} is {@code null]
     */
    void setDisplayArea(Envelope envelope);

    /**
     * Reset the map area to include the full extent of all
     * layers and redraw the display
     */
    void reset();

    /**
     * Adds a listener to receive {@link org.geotools.swing.event.MapPaneEvent}s.
     *
     * @param listener the listener to add
     * 
     * @throws IllegalArgumentException if {@code listener} is {@code null}
     */
    void addMapPaneListener(MapPaneListener listener);
    
    /**
     * Removes the specified listener.
     *
     * @param listener the listener to remove
     */
    void removeMapPaneListener(MapPaneListener listener);

    /**
     * Registers an object that wishes to receive {@code MapMouseEvent}s
     * such as a {@linkplain StatusBar}.
     *
     * @param listener the listener to add
     * @throws IllegalArgumentException if listener is null
     * @see MapMouseListener
     */
    void addMouseListener(MapMouseListener listener);

    /**
     * Removes the specified listener.
     *
     * @param listener the listener to remove
     */
    void removeMouseListener(MapMouseListener listener);

}