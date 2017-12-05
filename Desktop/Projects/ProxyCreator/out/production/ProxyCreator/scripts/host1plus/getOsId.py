import requests
import json
import re

# user chooses id of server....
# inser that code here
ServerId = 357
# let id to be placeholder, we choose the Host1plus cloud server-chicago of id 357 to be placeholder

url = "https://manage.host1plus.com/api/v2/cloudservers/templates?productId=" + str(ServerId)
apikey = 'e95f07aee35590bb400d7c4305bb1fbb6e061495'

s = requests.Session()
payload = '{}'
getHeaders = {'x-auth-token': apikey}

r = s.get(url, data=payload, headers=getHeaders)
result = json.loads(r.text)
Debian8Regex = re.compile(r'Debian 8')
for osInfo in result['data']:

    answer = Debian8Regex.search(osInfo['name'])
    if answer != None:
        OsId = osInfo['id']
print(OsId)
