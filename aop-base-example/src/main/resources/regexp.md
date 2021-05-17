### 正则表达式常用符号
1. 点(.)：匹配除换行以外的所有单个字符，如.n匹配nay，an apple is on the three中的an和on，但不匹配nay。
1. 星号(*)：匹配*前面的字符0次或n次，如bo*匹配A ghost booooed中的boooo或A bird warbled中的b，但不匹配Agoat g runted中的任何字符。
1. 加号(+)：匹配+前面的字符1次或n次，等价以{1,}，如a+匹配candy中的a和caaaady中的所有a。
1. ^：表示匹配的字符必须在最前面，如^A不匹配an A，但匹配An A中最前面的A。
1. 美元符($)：与^类似，匹配最末端的字符，如t$不匹配eater中的t，但匹配eat中的t。
1. x|y：匹配x或y，如green|red匹配green apple中的green或red apple中的red。
1. [xyz]：一张字符表，匹配列表中的任一字符。可以通过连字符"-"指出一个字符范围。如[abc]跟[a-c]是等效的，它们匹配brisket中的b及ache中的a和c。
1. {n}：这里的n是一个正整数，匹配前面的n个字符。如a{2}不匹配candy中的a，但匹配caandy中的两个a。
1. {n,}：这里的n是一个正整数，匹配至少n个前面的字符。如a{2,}不匹配candy中的a，但匹配caandy中的所有a和caaaaaaady中的所有a。
1. {n,m}：这里的n和m都是正整数，匹配至少n个，最多m个前面的字符。
1. \：将下一个字符标记为一个特殊字符，如n匹配字符n，\n匹配一个换行符。
### 转义符
1. \d：匹配一个数字，等价于[0-9]
1. \D：匹配一个非数字，等价于[^0-9]
1. \f：匹配一个换页符，等价于\x0c和\cL
1. \n：匹配一个换行符
1. \r：匹配一个回车符
1. \s：匹配任何空白字符，包括空格、制表符、换页符等。
1. \S：匹配任何非空白字符
1. \t：匹配一个制表符
1. \v：匹配一个垂直制表符
1. \w：匹配包括下划线的任何单词字符，等价于[A-Za-z0-9_]
1. \W：匹配任何非单词字符