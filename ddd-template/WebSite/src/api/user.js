/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-03-13 10:03:56
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-04-21 10:21:42
 */
import request from "@/utils/request";

export function login(data) {
  return request({
    url: "/vue-element-admin/user/login",
    method: "post",
    data
  });
}

export function getInfo(token) {
  return request({
    url: "/vue-element-admin/user/info",
    method: "get",
    params: { token }
  });
}

export function logout() {
  return request({
    url: "/vue-element-admin/user/logout",
    method: "post"
  });
}
