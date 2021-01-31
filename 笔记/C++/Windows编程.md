# Windows编程

[TOC]

## 1. 窗口程序

`Windows`编程的基本要素之`windows.h`

在进行`windows`编程的时候需要包含一个新的万能头文件。`Windows.h`它是一个综合性头文件，他里面包含了许多其他的文件

### 1.1 Windwos常见数据类型

- `UINT`无符号32位整数

- `DWORD`32位整数

- `PDWORD`32位整数类型指针

- `BOOL`布尔类型

- `SHORT`带符号16位整数

- `LRRSULT`32位函数返回值

- `WPARAM`32位的消息参数

- `LPARAM`32位的消息参数

- `HANDLE`是`windows`编程中一个特别重要的概念，在计算机中翻译为句柄。用于标识操作系统中的某个对象

  `HANDLE`通用句柄、`HWND`窗口句柄、`HINSTANCE`实例句柄

程序的入口函数为`WinMain`

```c++
int WINAPI WinMain(
        HINSTANCE hInstance, //程序实例句柄
        HINSTANCE hPreHinstance, // 上一个程序的实例句柄
        LPSTR lpCmdLine, // char* args[] 命令行参数
        int nCmdShow    // 显示方式
) {
    return 0;
}
```

### 1.2 快速入门

```c++
#include<Windows.h>

int WINAPI WinMain(
        HINSTANCE hInstance, //程序实例句柄
        HINSTANCE hPreHinstance, // 上一个程序的实例句柄
        LPSTR lpCmdLine, // char* args[] 命令行参数
        int nCmdShow    // 显示方式
) {
    int result = MessageBox(0, "Hello World", "测试", MB_OK);
    return 0;
}
```

`MessageBox`：弹出一个对话框

```c++
int MessageBox(
	HWND hwnd,
	LPCTSTR lpText,
	LPCTSTR lpCaption,
	UINT uType
);
```

`hwnd`：要创建的消息框的所有者窗口的句柄。如果此参数为`NULL`，则消息框没有所有者窗口

`lpText`：要显示的消息。

`lpCaption`：对话框标题。如果为`NULL`，则默认标题为`Error`

`uType`：对话框的内容和行为。此参数可以是来自以下标志组的标志的组合

返回值是一个`int`类型，不同的数值表示不同按钮被选中

```c++
int result = MessageBox(0, "Hello World", "测试", MB_OK);
```

## 2. 字符处理

`C++`支持两种字符串，常规的`ANSI`编码(使用`""`包裹)和`Unicode`编码(使用`L""`包裹)

1. 普通字符串类型`CHAR`-->`char`
2. 宽字符串类型`WCHAR`-->`wchar_t`输出使用`%ls`
3. 通用字符串类型`TCHAR`-->类型未知，由环境决定。需要引用`tchar.h`头文件

微软将`CHAR`和`WCHAR`这两套字符集及其操作进行了统一，通过条件编译(通过`_UNICODE`和`UNICODE`宏)控制实际使用的字符集，这样就有了`_T("")`这样的字符串

字符串长度计算：`strlen`、`wcslen`、`_tcslen`