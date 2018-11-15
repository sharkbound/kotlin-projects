import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.IntegerArgumentType.getInteger
import com.mojang.brigadier.arguments.IntegerArgumentType.integer
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder.argument
import com.mojang.brigadier.builder.LiteralArgumentBuilder.literal



fun main(args: Array<String>) {
    val d = CommandDispatcher<CommandSourceStack>()
    d.register(
        literal<Any>("foo")
            .then(
                argument("bar", integer())
                    .executes({ c ->
                        System.out.println("Bar is " + getInteger(c, "bar"))
                        1
                    })
            )
            .executes({ c ->
                println("Called foo with no arguments")
                1
            })
    )
}

class CommandSourceStack {

}
