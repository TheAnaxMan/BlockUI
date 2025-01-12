package com.ldtteam.blockui.mod;

import com.ldtteam.blockui.Pane;
import com.ldtteam.blockui.controls.Text;
import com.ldtteam.blockui.util.records.SizeI;
import com.ldtteam.blockui.views.BOWindow;
import com.ldtteam.blockui.views.ScrollingList;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

/**
 * Sets up gui for dynamic scrolling lists.
 */
public class DynamicScrollingListGui
{
    public static void setup(final BOWindow window)
    {
        final ScrollingList list1 = window.findPaneOfTypeByID("list1", ScrollingList.class);
        list1.setDataProvider(new ScrollingList.DataProvider()
        {
            @Override
            public int getElementCount()
            {
                return 10;
            }

            @Override
            public void updateElement(final int index, final Pane rowPane)
            {
                rowPane.findPaneByType(Text.class).setText(Component.literal("Hi " + index));
            }
        });

        final ScrollingList list2 = window.findPaneOfTypeByID("list2", ScrollingList.class);
        list2.setDataProvider(new ScrollingList.DataProvider()
        {
            @Override
            public int getElementCount()
            {
                return 10;
            }

            @Override
            public @Nullable SizeI getElementSize(final int index, final Pane rowPane)
            {
                return index % 2 == 0 ? new SizeI(100, 40) : null;
            }

            @Override
            public void updateElement(final int index, final Pane rowPane)
            {
                rowPane.findPaneByType(Text.class).setText(Component.literal("Hi " + index));
            }
        });
    }
}
