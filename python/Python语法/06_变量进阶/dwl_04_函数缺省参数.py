def print_info(name, gender=True, hoppy="NO"):
    """
    默认参数：如果在调用函数是不传入此参数，则会自动使用默认的参数
    缺省参数一定要放在参数列表的后面，不能放在没有默认参数的前面
    缺省参数可以有多个
    """
    gender_text = "男生"
    if not gender:
        gender_text = "女生"
    print("%s 是 %s, hoppy = %s" % (name, gender_text, hoppy))


print_info("小明")
print_info("小红", False)
print_info("小刚", hoppy="打篮球")
