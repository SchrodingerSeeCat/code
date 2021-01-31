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