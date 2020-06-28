package com.hqz.hzuoj.common.constants;

/**
 * 系统常量类配置
 * @author Cruiying
 * @date 2020/6/28 9:47
 */
public class Constants {

    /**
     * 验证码过期时间 此处为五分钟
     */
   Integer CODE_EXPIRE_TIME = 5;

    /**
     * jwtToken过期时间
     */
    Long TOKEN_EXPIRE_TIME = 30 * 24 * 60 * 60 * 1000L;

    /**
     * token请求头名称
     */
    String TOKEN_HEADER_NAME = "X-Token";

    /**
     * 表单重复提交间隔时间 单位 S
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    int FORM_REPEAT_TIME = 10;


    public static class  Problem {
        /** 公开类型 **/
        public interface Public {
            /** 管理员 **/
            final int ADMIN = -1;
            /** 公开 **/
            final int PUBLIC = 0;
            /** 比赛 **/
            final int CONTEST = 1;
        }
        public interface Level {
            /** 等级字段 **/
            final String LEVEL_CODE = "PROBLEM_LEVEL_CODE";
        }
    }

    public static class Contest {
        /** 赛制类型 **/
        public interface Type {
            final String OI = "OI";
            final String ACM = "ACM";
            final String IOI = "IOI";
            final String LEDUO = "LEDUO";
            final String CF = "CF";
        }
        public interface Status {
            final int NOT_START = -1;
            final int START = 0;
            final int END = 1;
        }
        public interface Public {
            final int PRIVATE = 0;
            final int PUBLIC = 1;
        }
        public interface Register {
            final int NOT_START_REGISTER = -1;
            final int START_REGISTER = 0;
            final int END_REGISTER = 1;
        }
        public interface Rating {
            final int NOT_START = -1;
            final int START = 0;
            final int END = 1;
        }

        public interface Rank {

        }

        public interface IsRating {
            int YES = 1;
            int NO = 0;
        }

        public interface IsRank {
            int YES = 1;
            int NO = 0;
        }
    }

}
