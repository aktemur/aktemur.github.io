import urllib2
import json

url = urllib2.urlopen("http://api.piyasa.com/json/?kaynak=doviz_guncel_serb")
text = json.loads(url.read())

for item in text:
    print item['foex'], ": ", item['sell']

