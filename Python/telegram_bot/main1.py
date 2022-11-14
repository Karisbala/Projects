import telebot
from bs4 import BeautifulSoup
import requests
import random
def dodo(somelist): 
    stxt=random.choice(somelist)
    text= 'DodoPizza\n' +stxt + '\nhttps://dodopizza.kz/almaty/bonusactions'
    somelist.remove(stxt)
    token = "1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio"
    url = "https://api.telegram.org/bot%s/sendMessage" % token
    data = { 
    'chat_id': '-1001195106533',
    'text': text
    }
    r = requests.post(url, data=data)
    print(r.text)	
def choco(somelist):
    stxt=random.choice(somelist)
    text= 'Chocofood\n' +stxt + '\nhttps://almaty.chocofood.kz/promotions/new/'
    somelist.remove(stxt)
    token = "1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio"
    url = "https://api.telegram.org/bot%s/sendMessage" % token
    data = { 
    'chat_id': '-1001195106533',
    'text': text
    }
    r = requests.post(url, data=data)
    print(r.text)
def bestfood(somelist):
    stxt=random.choice(somelist)
    text= 'BestFood\n' +stxt + '\nhttps://bestfood.kz/stocks'
    somelist.remove(stxt)
    token = "1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio"
    url = "https://api.telegram.org/bot%s/sendMessage" % token
    data = { 
    'chat_id': '-1001195106533',
    'text': text
    }
    r = requests.post(url, data=data)
    print(r.text)
def bazilik(somelist):
    stxt=random.choice(somelist)
    text= 'Basilic\n' +stxt + '\nhttps://ala.basilic.kz/aktsii_i_novosti/'
    somelist.remove(stxt)
    token = "1176216634:AAHwqvj4aoFsjl0og03ZjY0Hsm0SdeDkTio"
    url = "https://api.telegram.org/bot%s/sendMessage" % token
    data = { 
    'chat_id': '-1001195106533',
    'text': text
    }
    r = requests.post(url, data=data)
    print(r.text)		
comps1 = []
URL1='https://dodopizza.kz/almaty/bonusactions'
HEADERS = {
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36'
}
response1 = requests.get(URL1, headers = HEADERS)
soup1 = BeautifulSoup(response1.content,'html.parser')
items1 = soup1.findAll('article', class_ = 'eh81ri-1 gmeiQE')
for item1 in items1:
    comps1.append({
    'title': item1.find('h1', class_='title').get_text(strip=True),
    'description': item1.find('div', class_='description').get_text(strip=True)
    })
sset1=set()
for comp1 in comps1:
    tex1 = f'{comp1["title"]} -> Description : {comp1["description"]}'
    sset1.add(tex1)
llist1=list(sset1)

comps2 = []
URL2='https://chocofood.kz/almaty/promotions/new/'
HEADERS = {
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36'
}
response2 = requests.get(URL2, headers = HEADERS)
soup2 = BeautifulSoup(response2.content,'html.parser')
items2 = soup2.findAll('div', class_ = 'promotion-item__content')
for item2 in items2:
    comps2.append({
        'title': item2.find('div', class_='promotion-item__content__restaurant').get_text(strip=True),
        'description': item2.find('div', class_='promotion-item__content__description').get_text(strip=True)
        })
sset2=set()
for comp2 in comps2:
    tex2 = f'{comp2["title"]} -> Description : {comp2["description"]}'
    sset2.add(tex2)
llist2=list(sset2)

comps3 = []
URL3='https://bestfood.kz/stocks'
HEADERS = {
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36'
}
response3 = requests.get(URL3, headers = HEADERS)
soup3 = BeautifulSoup(response3.content,'html.parser')
items3 = soup3.findAll('div', class_ = 'news-block col-md-4 col-sm-6 col-xs-12')
for item3 in items3:
    comps3.append({
        'title': item3.find('div', class_ = 'lower-content').get_text(strip=False)
    })
sset3=set()
for comp3 in comps3:
    tex3 = f'{comp3["title"]}'+'\nhttps://bestfood.kz/stocks'
    sset3.add(tex3)
llist3=list(sset3)

comps4 = []
URL4='https://ala.basilic.kz/aktsii_i_novosti/'
HEADERS = {
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36'
}
response4 = requests.get(URL4, headers = HEADERS)
soup4 = BeautifulSoup(response4.content,'html.parser')
items4 = soup4.findAll('div', class_ = 'vc_col-sm-12 vc_gitem-col vc_gitem-col-align-')
for item4 in items4:
    comps4.append({
        'title': item4.find('div', class_='vc_custom_heading vc_gitem-post-data vc_gitem-post-data-source-post_title').get_text(strip=True),
        'description': item4.find('div', class_='vc_custom_heading vc_gitem-post-data vc_gitem-post-data-source-post_excerpt').get_text(strip=True)
        })
sset4=set()
for comp4 in comps4:
    tex4 = f'{comp4["title"]} -> Description : {comp4["description"]}'
    sset4.add(tex4)
llist4=list(sset4)


