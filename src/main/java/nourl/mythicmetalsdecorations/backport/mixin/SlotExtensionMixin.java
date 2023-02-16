package nourl.mythicmetalsdecorations.backport.mixin;

import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Slot.class)
public class SlotExtensionMixin implements SlotExtension{
    @Unique
    private boolean owo$disabledOverride;

    @Override
    public void owo$setDisabledOverride(boolean disabled) {
        this.owo$disabledOverride = disabled;
    }

    @Override
    public boolean owo$getDisabledOverride() {
        return this.owo$disabledOverride;
    }
}
