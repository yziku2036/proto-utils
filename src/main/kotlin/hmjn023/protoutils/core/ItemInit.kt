package hmjn023.protoutils.core

import hmjn023.protoutils.ProtoUtils
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries



class ItemInit {
    init {
        val ITEMS :DeferredRegister<Item> = DeferredRegister.create(
            ForgeRegistries.ITEMS,
            ProtoUtils.MOD_ID
        )

        val EXAMPLE_ITEM = ITEMS.register(
            "example_item",
        ){
            Item(
                Item.Properties()
            )
        }
    }

}