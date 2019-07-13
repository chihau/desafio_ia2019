import time
import requests
import random

while True:
  try:
    valor = random.randint(-5,40)
    r = requests.post('http://things.ubidots.com/api/v1.6/devices/raspberry/?token=TOKEN_AQUI', data={'temperature': valor})
    print('Posting temperatures: ', valor)
  except Exception as e:
    print('error: ', e)          
  time.sleep(10)
