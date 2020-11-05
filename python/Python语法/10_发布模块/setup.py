"""
制作发布压缩包的步骤
1.创建setup.py
2.构建模块
    $ python3 setup.py build
3.生成发布压缩包
    $ python3 setup.py sdist
    执行此条命令后 目录下会生成一个dist文件夹，dist文件夹中有一个压缩包
4.解压缩
    $ tar -zxvf 压缩包名
5.安装模块
    进入刚解压的文件夹
    $ python3 setup.py install
    执行命令过后，这个模块就会被安装到python的安装目录\Lib\site-packages\dwl_message
    还会生成一个dwl_message-1.0-py3.8.egg-info文件
    之后就可以在项目中使用 import 关键字来导入安装的模块
6.卸载模块
    如果之前安装的模块不想使用了可以找到之前安装的目录直接删除dwl_message和dwl_message-1.0-py3.8.egg-info
"""
from distutils.core import setup
setup(name="dwl_message",  # 包名
      version="1.0",        # 版本
      description="发送和接受消息模块",  # 描述信息
      long_description="完整的发送和接受消息模块的描述信息",  # 完整的描述信息
      author="dwl",  # 作者
      author_email="471068961@qq.com",  # 作者邮箱
      url="www.dingwanli.pro",  # 主页
      py_modules=["dwl_message.send_message",
                  "dwl_message.receive_message"])
