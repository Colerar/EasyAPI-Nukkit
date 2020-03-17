package top.wetabq.easyapi.api

import cn.nukkit.Server

class CompatibilityCheck(private val providers: List<String>) {

    private var finalKey = ""

    fun check() {
        // TODO: Check server started
        providers.forEach { plugin ->
            if (Server.getInstance().pluginManager.getPlugin(plugin) != null) {
                finalKey = plugin
            }
        }
    }


    fun <T> doCompatibilityAction(compatibleAction: Map<String, () -> T>): T? {
        var finalValue: T? = null
        if (finalKey != "") {
            compatibleAction.forEach { (key, action) ->
                if (key == finalKey)  {
                    finalValue = action()
                }
            }
        } else throw CompatibilityException("don't find any compatible provider to do action")
        return finalValue
    }

}