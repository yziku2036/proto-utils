package hmjn023.protoutils

import hmjn023.protoutils.core.BlockInit
import hmjn023.protoutils.core.ItemInit
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

@Mod(ProtoUtils.MOD_ID)
object ProtoUtils {
    const val MOD_ID = "proto_utils"
    private val LOGGER: Logger = LogManager.getLogger(MOD_ID)
    init {
        LOGGER.info("proto utils initialization")
        LOGGER.info(
            runForDist(
                clientTarget = {
                    MOD_BUS.addListener(ProtoUtils::onClientSetup)
                },
            serverTarget = {
                FORGE_BUS.addListener(ProtoUtils::onServerAboutToStart)
            }
        ))
        val PROTO_UTILS_TAB :CreativeModeTab = object hoge : CreativeModeTab(MOD_ID) {
            override fun makeIcon(): ItemStack {
                //TODO("Not yet implemented"
                return ItemInit.
            }
        }

        val bus = thedarkcolour.kotlinforforge.forge.MOD_CONTEXT.getKEventBus()
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("client setup")
    }

    private fun onServerAboutToStart(event: FMLDedicatedServerSetupEvent) {
        LOGGER.info("server about to start")
    }

}
