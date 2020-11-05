from flask import Flask, request
# 上传文件
app = Flask(__name__)

@app.route("/upload", methods=["POST"])
def upload():
    """接收前端传送过来的文件"""
    file_obj = request.files.get("pic")
    if file_obj is None:
        return 
    
    # # 将文件保存到本地
    # # 1.创建一个文件
    # f = open("./demo.jpg", "wb")
    # # 2.向文件写内容
    # data = file_obj.read()
    # f.write(data)
    # # 3.关闭文件
    # f.close()
    file_obj.save("./demo.png")
    return "上传成功"




if __name__ == "__main__":
    app.run(debug=True)