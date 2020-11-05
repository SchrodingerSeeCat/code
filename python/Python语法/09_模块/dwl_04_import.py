import dwl_01_模块1 as Hello
import dwl_02_模块2
# 从一个模块中导入部分工具
from dwl_03_模块3 import num

# 在Python中每一个以py结尾的文件都是一个模块
# 可以通过 模块名. 的方式来调用模块中的 全局变量 函数 类
# 使用import导入模块
# 如果模块的名字太长，可以使用as指定模块的名称，以方便在代码中使用
# 别名推荐使用大驼峰命名法
# 两个模块中存在相同的函数，后导入的函数会覆盖先导入的函数,或者给其中一个函数起别名
# from 模块 import 函数名 as 别名
# from 模块 import * 导入模块中所有工具

print(Hello.title)
print(dwl_02_模块2.title)
Hello.say_hello()
# 导入之后可以直接使用
print(num)
