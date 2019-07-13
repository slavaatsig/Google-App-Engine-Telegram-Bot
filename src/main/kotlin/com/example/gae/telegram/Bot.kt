package com.example.gae.telegram

import me.ivmg.telegram.bot
import me.ivmg.telegram.dispatch
import me.ivmg.telegram.dispatcher.command
import me.ivmg.telegram.dispatcher.telegramError
import me.ivmg.telegram.dispatcher.text
import me.ivmg.telegram.network.fold
import okhttp3.logging.HttpLoggingInterceptor


fun main() {
    println("Starting Example Telegram bot...")

    bot {

        token = "YOUR_TELEGRAM_BOT_TOKEN"
        timeout = 30
        logLevel = HttpLoggingInterceptor.Level.BODY

        dispatch {
            command("start") { bot, update ->
                bot.sendMessage(chatId = update.message!!.chat.id, text = "Bot started").fold({
                    // do something here with the response
                }, {
                    // do something with the error
                })
            }

            text("ping") { bot, update ->
                bot.sendMessage(chatId = update.message!!.chat.id, text = "Pong")
            }

            telegramError { _, telegramError ->
                println(telegramError.getErrorMessage())
            }
        }
    }.also { println("Example Telegram bot is ready. Stat polling.") }.startPolling()
}
