import telebot
import requests
txt1=list()

bot = telebot.TeleBot('1129713823:AAFFIqL5HufOfRBepBGACbmRzrCDz6uGUew')
@bot.message_handler(commands=['start'])
def start_message(message):
    bot.send_message(message.chat.id, 'Привет, здесь вы можете загрузить любую скидку на канал AllDiscount\n\nНапишите тайтл скидки или акции')

@bot.message_handler(content_types=['text'])
def send_text(message):
    global txt1
    txt=message.text
    txt1.append(txt)
    if len(txt1)==1:
        bot.send_message(message.chat.id, 'Теперь напишите описание')
    if len(txt1)==2:
        bot.send_message(message.chat.id, 'Теперь скиньте ссылку на сайт')
    if len(txt1)==3:
        bot.send_message(message.chat.id, 'Спасибо за ваше предложение!')
        text=txt1[0]+'\n'+txt1[1]+'\n'+txt1[2]
        token = "1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio"
        url = "https://api.telegram.org/bot%s/sendMessage" % token
        data = { 
        'chat_id': '-1001195106533',
        'text': text
        }
        r = requests.post(url, data=data)
        print(r.text)
        txt1.clear()
bot.polling()
