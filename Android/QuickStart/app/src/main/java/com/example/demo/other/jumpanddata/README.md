### Activity之间的跳转
1. 显示跳转
    ```java
    // 显示跳转
    Intent intent = new Intent(AActivity.this, BActivity.class);
    startActivity(intent);
    ```