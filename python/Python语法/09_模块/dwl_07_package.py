"""
package
包是一个包含多个模块的特殊目录
目录下有一个特殊的文件__init__.py
包名的命名方式和变量名保持一致
使用  import 包名  可以一次性导入包中所有的模块
"""
import dwl_message
dwl_message.send_message.send("我是来自导入包的模块")
print(dwl_message.receive_message.receive())
