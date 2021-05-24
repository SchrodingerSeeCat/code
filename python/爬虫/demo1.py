import requests

if __name__ == "__main__":
    res = requests.get("https://www.baidu.com")
    print(res.text)