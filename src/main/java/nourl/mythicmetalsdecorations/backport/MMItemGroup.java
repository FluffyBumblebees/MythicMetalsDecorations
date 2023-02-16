package nourl.mythicmetalsdecorations.backport;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import io.wispforest.owo.itemgroup.gui.ItemGroupTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class MMItemGroup extends OwoItemGroup {
    private final Supplier<ItemStack> icon;

    protected MMItemGroup(Identifier id, Supplier<ItemStack> icon) {
        super(id);
        this.icon = icon;
    }
    
    public static MMItemGroup of(Identifier id, Supplier<ItemStack> icon) {
        return new MMItemGroup(id, icon);
    }

    public MMItemGroup initializer(ModifiableInstance o) {
        o.provideInstance(this);
        return this;
    }

    @Override
    public void addButton(ItemGroupButton button) {
        super.addButton(button);
    }
    
    public void addTab(Icon icon, String name, TagKey<Item> contentTag, Identifier texture) {
        this.tabs.add(new ItemGroupTab(icon, name, contentTag, texture));
    }
    
    @Override
    protected void setup() {
    }

    @Override
    public ItemStack createIcon() {
        return icon.get();
    }

    public interface ModifiableInstance {
        void provideInstance(MMItemGroup group);
    }
}
