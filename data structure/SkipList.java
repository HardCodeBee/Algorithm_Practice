/*
Core idea SkipList:

Use multiple layers of “SPARSE index” SORTED linked lists to speed up search：

the bottom layer is the full sorted list, 
and the upper layers randomly keep fewer nodes as express lanes.

When searching, We start from the top, 
jump right as far as we can, 
and when we can’t go further, drop down a level
repeat until you land on the target.

Because each node’s height is chosen randomly, 
the structure stays balanced on average, 
so SEARCH/INSERT/DELETE are typically O(log n).


USE MORE SPACE TO SAVE MORE RUNNING TIME
*/

import java.util.Random;

public class SkipList {

    private static final int MAX_LEVEL = 16;   // 最大层数（够用了）
    private static final double P = 0.5;       // “抛硬币”概率
    private final Random rand = new Random();

    private static class Node {
        int key;
        int value;
        Node[] next; // **next[i] 指向第 i 层的下一个节点**

        Node(int key, int value, int level) {
            this.key = key;
            this.value = value;
            this.next = new Node[level];
        }
    
    }

/*
Here is an example about skiplist struture
indexLevel   0-----------------------8-----10
indexLevel   0-----------4-----------8-----10
indexLevel   0-----2-----4-----6-----8-----10
indexLevel   0--1--2--3--4--5--6--7--8--9--10

：

0：next[0]=1, next[1]=2, next[2]=4, next[3]=8
which means:
For node 0, 
the next element of 0 in 0-th line is 1;
the next element of 0 in 1-th line is 2;
the next element of 0 in 2-th line is 4;
the next element of 0 in 3-th line is 8;

1：next[0]=2

2：next[0]=3, next[1]=4

3：next[0]=4

4：next[0]=5, next[1]=6, next[2]=8

5：next[0]=6

6：next[0]=7, next[1]=8

7：next[0]=8

8：next[0]=9, next[1]=10, next[2]=10, next[3]=10

9：next[0]=10

10：next[0]=null, next[1]=null, next[2]=null, next[3]=null
*/
}
