# alogrithm_study
用java语言实现一些算法

#### 1、数据交换的方式

     * 1、使用中间变量交换数据
     * 2、使用加法和减法交换数据
     * 3、使用位运算的异或的特性 a^b^b=a

#### 2、单词逆序

     * 1、方法一：将字符串变为char数组，倒序输出
     * 2、方法二：利用栈的先进后出的特性
     * 3、方法三：利用数学置换的思想：
           第一个和最后一个置换，      
           第二个和倒数第二个置换，     
            ...      
           以此类推

#### 3、栈的简单实现
    
    特点：先进后出
    实现方法：入栈，出栈
#### 4、队列的简单实现

    特点：先进先出
    实现方法：进入队列，获取数据
#### 5、链表的简单实现

    5.1单向链表的简单实现
     添加，查询，删除
    
#### 6、一些简单的排序算法
    
    6.1 冒泡排序
    6.2 选择排序
    6.3 插入排序
    6.4 二分插入排序
    6.5 希尔排序
    
#### 7、 三角数字问题：


    * 即数列的第一项为1.第n项的值为第n-1项加n得到
    
#### 8、Fibonacci数列问题：

    * 即数列中第1,2项为1，第n项由n-1项加n-2项得到

#### 9、二叉树的实现

    1、插入节点：
        1.1 如果不存在节点，则直接插入。
        1.2 从根节点开始查找一个相应的节点,即一个新节点作为父节点，并确定新的节点与左节点还是右节点连接。
        如果插入结点的值比父节点要小则与其左子树链接，否则与右子树链接
    2、查找结点：
        从根节点开始查找，如果查找结点的值比父节点要小则查找其左子树，否则查找右子树。
    3、修改节点
    
    4、遍历二叉树
    先序遍历：父节点，左节点，右节点
    中序遍历：左节点，父节点，右节点
    后序遍历：左节点，右节点，父节点
    
    5、删除节点
    
    6、展示树状结构
#### 10、2-3-4树（平衡树）
    
    特点：
        1、每个节点中最多可以存3个数据项
        2、有一个数据项的节点如果有子节点总是有两个子节点
        3、有两个数据项的节点如果有子节点总是有三个子节点
        4、有三个数据项的节点如果有子节点总是有四个子节点
        5、不存在空节点
        6、只有叶子节点可以有数据项而没有子节点
        7、插入数据时数据总是插入在叶子节点
        
        假设：
        L：如果表示子节点的个数
        D：表示数据项个数
        针对非叶子节点而言：L=D+1