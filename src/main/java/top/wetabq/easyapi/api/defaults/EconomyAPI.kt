package top.wetabq.easyapi.api.defaults

import cn.nukkit.Player
import me.onebone.economyapi.EconomyAPI
import top.wetabq.easyapi.api.CompatibilityCheck
import top.wetabq.easyapi.api.SimpleIntegrateAPI

object EconomyAPI : SimpleIntegrateAPI {

    const val ECONOMY_API = "EconomyAPI"
    // const val ECOKKIT = "ECOKKIT"

    val compatibilityCheck = CompatibilityCheck(listOf(ECONOMY_API))

    init {
        SimplePluginTaskAPI.delay(20) { _, _ ->
            compatibilityCheck.check()
        }
    }

    fun getMoney(player: Player): Double? {
        return compatibilityCheck.doCompatibilityAction(mapOf(
            ECONOMY_API to {
                EconomyAPI.getInstance().myMoney(player)
            }
        ))
    }

    fun addMoney(player: Player, amount: Double) {
        compatibilityCheck.doCompatibilityAction(mapOf(
            ECONOMY_API to {
                EconomyAPI.getInstance().addMoney(player, amount)
            }
        ))
    }

    fun reduceMoney(player: Player, amount: Double) {
        compatibilityCheck.doCompatibilityAction(mapOf(
            ECONOMY_API to {
                EconomyAPI.getInstance().reduceMoney(player, amount)
            }
        ))
    }

    fun setMoney(player: Player, amount: Double) {
        compatibilityCheck.doCompatibilityAction(mapOf(
            ECONOMY_API to {
                EconomyAPI.getInstance().setMoney(player, amount)
            }
        ))
    }

}