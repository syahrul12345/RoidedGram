import requests
import json

# user chooses id of server....
# inser that code here
productId = 357
# let id to be placeholder, we choose the Host1plus cloud server-chicago of id 357 to be placeholder

url = "https://manage.host1plus.com/api/v2/cloudservers/options?productId=" + str(productId)
apikey = 'e95f07aee35590bb400d7c4305bb1fbb6e061495'

s = requests.Session()
payload = '{}'
getHeaders = {'x-auth-token': apikey}

r = s.get(url, data=payload, headers=getHeaders)
result = json.loads(r.text)
result = result['data']

# this will be used to populate the UI
for specname, specinfo in result.items():
    name = specname
    minimum = specinfo['min']
    maximum = specinfo['max']
    step = specinfo['step']
    print('the name of the spec is {}, and it has a maximum of {}, a minimum of {}, with a step of {}'.format(name, maximum, minimum, step))

# the ui then abosords the product options
