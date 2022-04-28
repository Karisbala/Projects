import telebot
from telebot.types import InlineKeyboardMarkup, InlineKeyboardButton
from db import SQLite, DBRequest
import sqlite3

class SQLite():
  def __init__(self, db):
    self.db = db

  def __enter__(self):
    self.conn = sqlite3.connect(self.db)
    self.conn.row_factory = sqlite3.Row
    
    return self.conn.cursor()

  def __exit__(self, type, value, traceback):
    self.conn.commit()
    self.conn.close()

class DBRequest():
  def __init__(self, sqlite):
    self.sqlite = sqlite
 
  def create(self):
    with self.sqlite as db:
      db.execute("""
        CREATE TABLE IF NOT EXISTS post (
          id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          channel_id INTEGER NOT NULL,
          post_id INTEGER NOT NULL,
          like_yes INTEGER NOT NULL,
          like_not INTEGER NOT NULL
        )
      """)

  def new_post(self, data):
    with self.sqlite as db:
      db.execute("INSERT INTO post VALUES (?, ?, ?, ?, ?)", data)

  def select_post(self, data):
    with self.sqlite as db:
      db.execute("SELECT * FROM post WHERE channel_id = ? AND post_id = ? LIMIT 1", data)

      return db.fetchall()

  def new_like_yes(self, data):
    with self.sqlite as db:
      db.execute("UPDATE post SET like_yes = ? WHERE channel_id = ? AND post_id = ?", data)

  def new_like_not(self, data):
    with self.sqlite as db:
      db.execute("UPDATE post SET like_not = ? WHERE channel_id = ? AND post_id = ?", data)
TOKEN = '1129713823:AAFFIqL5HufOfRBepBGACbmRzrCDz6uGUew'# Telegram токен
PATH_DB = 'alld.db' # Путь к базе данных

bot = telebot.TeleBot(TOKEN)
db = DBRequest(SQLite(PATH_DB))

def post_markup(like_yes='', like_not=''):
  markup = InlineKeyboardMarkup()
  item1 = InlineKeyboardButton('👍 {0}'.format(like_yes), callback_data=f'yes')
  item2 = InlineKeyboardButton('👎 {0}'.format(like_not), callback_data=f'not')
  markup.add(item1, item2)

  return markup

@bot.channel_post_handler()
def channel_post(message):
  db.new_post([None, message.chat.id, message.message_id, 0, 0])
  bot.edit_message_reply_markup(message.chat.id, message.message_id, reply_markup=post_markup())

@bot.callback_query_handler(func=lambda call: True)
def callback_query(call):
  data = db.select_post([call.message.chat.id, call.message.message_id])

  if call.data == 'yes':
    num = data[0][3] + 1
    db.new_like_yes([num, call.message.chat.id, call.message.message_id])
    bot.edit_message_reply_markup(call.message.chat.id, call.message.message_id, reply_markup=post_markup(num, data[0][4]))
    bot.answer_callback_query(call.id, 'Нравится')
  elif call.data == 'not':
    num = data[0][4] + 1
    db.new_like_not([num, call.message.chat.id, call.message.message_id])
    bot.edit_message_reply_markup(call.message.chat.id, call.message.message_id, reply_markup=post_markup(data[0][3], num))
    bot.answer_callback_query(call.id, 'Не нравится')

if __name__ == '__main__':
  db.create()
  bot.polling()