package top.wetabq.easyapi.command

import cn.nukkit.command.CommandSender

abstract class EasySubCommand(val subCommandName: String) {

    abstract fun getArguments(): Array<CommandArgument>?

    abstract fun getAliases(): Array<String>

    abstract fun getDescription() : String

    abstract fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean

}