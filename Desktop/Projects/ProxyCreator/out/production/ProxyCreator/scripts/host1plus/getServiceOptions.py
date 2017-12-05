import requests
import re
import json
from Options import ServerOptions  # imports the ServerOptions class from the Options.py module

s = requests.Session()

url = "https://manage.host1plus.com/api/v2/cloudservers/products"
apikey = 'e95f07aee35590bb400d7c4305bb1fbb6e061495'
payload = '{}'
getHeaders = {'x-auth-token': apikey}

r = s.get(url, data=payload, headers=getHeaders)

result = json.loads(r.text)
windowsRegex = re.compile(r'Windows')
productList = {}

for serviceDict in result['data']:
    name = serviceDict['name']
    productId = serviceDict['id']
    answer = windowsRegex.search(name)
    if answer == None:
        productList[productId] = name

host1plusOptions = ServerOptions(productList)
print(host1plusOptions.productList)
