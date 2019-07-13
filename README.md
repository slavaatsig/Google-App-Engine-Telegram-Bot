# Google-App-Engine-Telegram-Bot
An attempt to run https://github.com/seik/kotlin-telegram-bot in Google 
Cloud App Engine (not yet successfully)

## Startup

1. Create a
   [Telegram bot](https://core.telegram.org/bots#3-how-do-i-create-a-bot)
   and use your new bot token instead of `YOUR_TELEGRAM_BOT_TOKEN` in
   the `Bot.kt`
2. Create a Google cloud
   [project](https://cloud.google.com/resource-manager/docs/creating-managing-projects)
   and set your project ID instead `YOUR_GOOGLE_CLOUD_PROJECT` in the
   `build.gradle.kts`
3. Try gradle tasks `appengineCloudSdkLogin` and `appengineDeploy` to
   deploy Example Telegram Bot to a Google App Engine or alternatively
   `run` to debug Telegram bot locally

