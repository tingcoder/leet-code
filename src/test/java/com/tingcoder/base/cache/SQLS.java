package com.tingcoder.base.cache;

/***
 * @author yfeng
 * @date 2019-03-01 14:30
 */
public class SQLS {
    public static void main(String[] args) {
        for (int i=0;i<128;i++){
            String sql = "alter table t_mem_member_point_log_" + i +
                    " DROP COLUMN `reduceStatus`;";
            System.out.println(sql);
        }
    }
}
