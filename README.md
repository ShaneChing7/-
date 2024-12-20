游戏是在Eclipse环境里开发的
直接打开Eclipse选择左上角File-->Import Projects from File System or Archive-->Directory
选择项目文件夹导入即可
Start.java是游戏的主入口
Ball，Wall，Paddle是三个实体类
游戏用的是awt里的Canvas进行绘制
游戏可能会出现闪烁现象，可以把Canvas换成JPanel
JPanel也可以像Canvas一样进行绘图，可以有效防止闪烁现象

<img width="587" alt="屏幕截图 2024-12-20 214941" src="https://github.com/user-attachments/assets/5f8e80ea-99de-4c04-9e47-b46802c3d5dc" />
