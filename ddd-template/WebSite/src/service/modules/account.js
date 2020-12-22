/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-06-11 11:13:25
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-15 17:21:52
 */
import request from "@/utils/request";
import { Base } from "../base/base";

class Account extends Base {
  static login(data) {
    return request.post("/account/pc/v1/login", data);
  }

  static modifyPassword(data) {
    return Promise.resolve("success");
  }
}

export default Account;
