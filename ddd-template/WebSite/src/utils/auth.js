/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-03-13 10:03:58
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-04-21 09:25:25
 */
import Cookies from "js-cookie";

const TokenKey = "Admin-Token";

export function getToken() {
  return Cookies.get(TokenKey);
}

export function setToken(token) {
  return Cookies.set(TokenKey, token);
}

export function removeToken() {
  return Cookies.remove(TokenKey);
}

export function getStorage(key) {
  return JSON.parse(localStorage.getItem(key));
}

export function setStorage(key, value) {
  return localStorage.setItem(key, JSON.stringify(value));
}

export function removeStorage(key) {
  return localStorage.removeItem(key);
}
