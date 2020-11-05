import httplib2
import json
uri = "https://oapi.dingtalk.com/robot/send?access_token=dd0c084b4eda2c752a20e39a3e940bf706b4bc8862aee7130005408c7e5dd367"
message = {
    "msgtype": "text",
    "text": {
        "content": "方总我就是我, 是不一样的烟火@156xxxx8827"
    },
    "at": {
        "atMobiles": [
            "156xxxx8827",
            "189xxxx8325"
        ],
        "isAtAll": False
    }
}
http = httplib2.Http()
http.request(uri=uri, body=json.dumps(message), headers={'Content-Type': 'application/json'})
