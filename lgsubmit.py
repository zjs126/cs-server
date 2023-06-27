import sys
import requests

url = sys.argv[1]
User_Agent = sys.argv[2]
cookie = sys.argv[3]
referer = sys.argv[4]
x_csrf_token = sys.argv[5]
code = sys.argv[6]
lang = sys.argv[7]
headers = {'User-Agent': User_Agent,
           'cookie': cookie,
           'referer': referer,
           'x-csrf-token': x_csrf_token,
           }

# lang: 0-自动识别语言，1-Pascal, 2-C, 27-C++20, 7-Python3, 8-java 8, 14-Go
data = {'code': code,
        'enableO2': 0,
        'lang': 0}

requests.packages.urllib3.disable_warnings()
session = requests.Session()
response = session.post(url=url, headers=headers, json=data, verify=False)
print(response.text)
