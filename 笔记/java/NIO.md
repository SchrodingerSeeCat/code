# NIO

[TOC]

## 1. 简介

`java NIO`(`New IO / Non Blocking IO`),是`java1.4`版本开始引入的一个新的`IO API`，可以替代标准的`java IO API`。`NIO`与原来的`IO`有同样的作用和目的，但是使用的方式完全不同，`NIO`支持面向缓冲区的、基于通道的`IO`操作。`NIO`将以更加高效的方式进行文件的读写操作

### 1.1 NIO与IO的主要区别

| IO                      | NIO                         |
| ----------------------- | --------------------------- |
| 面向流(Stream Oriented) | 面向缓冲区(Buffer Oriented) |
| 阻塞IO(Blocking IO)     | 非阻塞IO(Non Blocking IO)   |
| 无                      | 选择器(Selectors)           |

