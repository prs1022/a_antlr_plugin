# antlr语法高亮插件
第一行输入sql，第二行输入DSL，输入完DSL后回车即可。
举个栗子
查找以下SQL中子查询中包含表B_t的字段b,c

> select  a,b,c from A_t join ( 	select b,c,d 	from B_t ) t_t on A_t.b = t_t.b  


![img](GIF.gif) 
