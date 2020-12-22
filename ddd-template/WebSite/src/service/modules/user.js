/*
 * @Descripttion:
 * @Author: dong
 * @Date: 2020-05-11 19:57:33
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-15 17:14:35
 */
import request from "@/utils/request";
import { Base } from "../base/base";

class User extends Base {
  static setCurrent(data) {
    return request.post("/user/pc/v1/setCurrent", data);
  }

  static getCurrent() {
    return request.post("/user/pc/v1/getCurrent");
  }
}

export default User;
