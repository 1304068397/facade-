/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-07-11 18:39:03
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-11 19:32:46
 */

import Mock from "mockjs";
import { param2Obj } from "../src/utils";

import user from "./user";
import role from "./role";
import article from "./article";
import search from "./remote-search";
import application from "./application";
import account from "./account";

const mocks = [
  ...user,
  ...role,
  ...article,
  ...search,
  ...application,
  ...account
];

// for front mock
// please use it cautiously, it will redefine XMLHttpRequest,
// which will cause many of your third-party libraries to be invalidated(like progress event).
export function mockXHR() {
  // mock patch
  // https://github.com/nuysoft/Mock/issues/300
  Mock.XHR.prototype.proxy_send = Mock.XHR.prototype.send;
  Mock.XHR.prototype.send = function() {
    if (this.custom.xhr) {
      this.custom.xhr.withCredentials = this.withCredentials || false;

      if (this.responseType) {
        this.custom.xhr.responseType = this.responseType;
      }
    }
    this.proxy_send(...arguments);
  };

  function XHR2ExpressReqWrap(respond) {
    return function(options) {
      let result = null;
      if (respond instanceof Function) {
        const { body, type, url } = options;
        // https://expressjs.com/en/4x/api.html#req
        result = respond({
          method: type,
          body: JSON.parse(body),
          query: param2Obj(url)
        });
      } else {
        result = respond;
      }
      return Mock.mock(result);
    };
  }

  for (const i of mocks) {
    Mock.mock(
      new RegExp(i.url),
      i.type || "get",
      XHR2ExpressReqWrap(i.response)
    );
  }
}

export default mocks;
