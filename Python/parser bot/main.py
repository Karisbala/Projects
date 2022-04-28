import main1
import telebot
bot = telebot.TeleBot('1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio')
keyboard1 = telebot.types.ReplyKeyboardMarkup()
keyboard1.row('DodoPizza', 'Chocofood','BestFood','Basilic')
@bot.message_handler(commands=['start'])
def start_message(message):
    bot.send_message(message.chat.id, 'Привет, выберите сайт', reply_markup=keyboard1)

@bot.message_handler(content_types=['text'])
def send_text(message):
    if message.text.lower() == 'dodopizza':
        if len(main1.llist1)==0:
            bot.send_message(message.chat.id, 'Привет, выберите другой сайт')
        else:    
            main1.dodo(main1.llist1)
    elif message.text.lower() == 'chocofood':
        if len(main1.llist2)==0:
            bot.send_message(message.chat.id, 'Привет, выберите другой сайт')
        else:    
            main1.choco(main1.llist2)
    elif message.text.lower() == 'bestfood':
        if len(main1.llist3)==0:
            bot.send_message(message.chat.id, 'Привет, выберите другой сайт')
        else:    
            main1.bestfood(main1.llist3)
    elif message.text.lower() == 'basilic':
        if len(main1.llist4)==0:
            bot.send_message(message.chat.id, 'Привет, выберите другой сайт')
        else:    
            main1.bazilik(main1.llist4)
bot.polling()
