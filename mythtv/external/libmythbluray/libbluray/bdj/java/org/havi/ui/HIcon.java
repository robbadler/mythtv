/*
 * This file is part of libbluray
 * Copyright (C) 2010  William Hahne
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.havi.ui;

import java.awt.Image;

import org.havi.ui.event.HFocusEvent;
import org.havi.ui.event.HFocusListener;

public class HIcon extends HStaticIcon implements HNavigable {
    public HIcon()
    {
        org.videolan.Logger.unimplemented(HIcon.class.getName(), "");
    }

    public HIcon(Image image)
    {
        org.videolan.Logger.unimplemented(HIcon.class.getName(), "");
    }

    public HIcon(Image image, int x, int y, int width, int height)
    {
        org.videolan.Logger.unimplemented(HIcon.class.getName(), "");
    }

    public HIcon(Image imageNormal, Image imageFocus, int x, int y, int width,
            int height)
    {
        org.videolan.Logger.unimplemented(HIcon.class.getName(), "");
    }

    public static void setDefaultLook(HGraphicLook hlook)
    {
        DefaultLook = hlook;
    }

    public static HGraphicLook getDefaultLook()
    {
        if (DefaultLook == null)
            org.videolan.Logger.unimplemented("", "getDefaultLook");
        return DefaultLook;
    }

    public void setMove(int keyCode, HNavigable target)
    {
        throw new Error("Not implemented");
    }

    public HNavigable getMove(int keyCode)
    {
        throw new Error("Not implemented");
    }

    public void setFocusTraversal(HNavigable up, HNavigable down,
            HNavigable left, HNavigable right)
    {
        throw new Error("Not implemented");
    }

    public boolean isSelected()
    {
        throw new Error("Not implemented");
    }

    public void setGainFocusSound(HSound sound)
    {
        throw new Error("Not implemented");
    }

    public void setLoseFocusSound(HSound sound)
    {
        throw new Error("Not implemented");
    }

    public HSound getGainFocusSound()
    {
        throw new Error("Not implemented");
    }

    public HSound getLoseFocusSound()
    {
        throw new Error("Not implemented");
    }

    public void addHFocusListener(HFocusListener l)
    {
        throw new Error("Not implemented");
    }

    public void removeHFocusListener(HFocusListener l)
    {
        throw new Error("Not implemented");
    }

    public int[] getNavigationKeys()
    {
        throw new Error("Not implemented");
    }

    public void processHFocusEvent(HFocusEvent evt)
    {
        throw new Error("Not implemented");
    }

    private static HGraphicLook DefaultLook = null;

    private static final long serialVersionUID = 2006124827619610922L;
}
