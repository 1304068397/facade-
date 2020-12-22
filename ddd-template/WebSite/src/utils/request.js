import axios from "axios";
import { MessageBox, Message } from "element-ui";
import store from "@/store";
import { getToken } from "@/utils/auth";
import { getConfig } from "@/utils/config";
import { startLoading, endLoading } from "@/utils/loading";
import router from "@/router";

// try to get baseURL from config
let baseURL;
if (process.env.NODE_ENV === "test" || process.env.NODE_ENV === "production") {
  getConfig().then(config => {
    if (config.baseURL) {
      baseURL = config.baseURL;
    }
  });
}

// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 60000 // request timeout
});

// request interceptor
service.interceptors.request.use(
  config => {
    startLoading();
    // do something before request is sent
    // use baseURL
    if (baseURL) {
      config.baseURL = baseURL;
    }

    return config;
  },
  error => {
    // do something with request error
    console.log(error); // for debug
    return Promise.reject(error);
  }
);

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
   */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    setTimeout(() => {
      endLoading();
    }, 500);
    // blob类型需在调用api参数位置传入参数 responseType: 'blob'
    if (response.config.responseType === "blob") {
      const fileName = decodeURI(
        response.headers["content-disposition"].split("filename=")[1]
      );
      // 返回文件流内容，以及获取文件名
      return Promise.resolve({ data: response.data, fileName: fileName });
    }

    const res = response.data;

    // if the custom code is not 20000, it is judged as an error.
    if (res.code !== 20000 && res.code !== "00000") {
      Message({
        message: res.message || res.description || "Error",
        type: "error",
        duration: 5 * 1000
      });

      // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
      if (res.code === "10000") {
        // to re-login
        store.dispatch("user/logout").then(() => {
          router.push("/login");
        });
      }
      return Promise.reject(
        new Error(res.message || res.description || "Error")
      );
    } else {
      return res;
    }
  },
  error => {
    endLoading();
    let errMsg = "";
    if (
      error.code == "ECONNABORTED" &&
      error.message.indexOf("timeout") != -1
    ) {
      errMsg = "no response from server";
    } else {
      switch (error.response.status) {
        case 401:
          errMsg = "no login or login is invalid";
          break;
        case 403:
          errMsg = "server reject";
          break;
        default:
          errMsg = error.response.statusText;
          break;
      }
    }

    const msg = `${error.response.status}: ${errMsg}`;

    console.log(error); // for debug

    Message({
      message: msg,
      type: "error",
      duration: 5 * 1000
    });

    return Promise.reject(error);
  }
);

export default service;
