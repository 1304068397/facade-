/*
 * @Descripttion:
 * @Author: dong
 * @Date: 2020-04-21 18:54:20
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-08-20 08:39:38
 */
import Vue from "vue";
import Cookies from "js-cookie";
import "normalize.css/normalize.css"; // a modern alternative to CSS resets
import Element from "element-ui";
import "./styles/element-variables.scss";
import "@/styles/index.scss"; // global css
import App from "./App";
import store from "./store";
import router from "./router";
import "./icons"; // icon
import "./permission"; // permission control
import "./utils/error-log"; // error log
import * as filters from "./filters"; // global filters
import VueJsonp from "vue-jsonp"; // jsonp
import service from "./service";
import LayoutCard from "./components/LayoutCard";
import JumpDialog from "./components/JumpDialog";
import JumpDialogItem from "./components/JumpDialog/components/JumpDialogItem";

// 打包后提供mock数据，如使用真实api，请注释
if (process.env.NODE_ENV === "test") {
  const { mockXHR } = require("../mock");
  mockXHR();
}

//全局注册组件
Vue.component("LayoutCard", LayoutCard);
Vue.component("JumpDialog", JumpDialog);
Vue.component("JumpDialogItem", JumpDialogItem);

Vue.use(service);
Vue.use(Element, {
  //size: Cookies.get("size") || "medium" // set element-ui default size
  size: "mini"
});
// use jsonp
Vue.use(VueJsonp);

// register global utility filters
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key]);
});

Vue.config.productionTip = false;

new Vue({
  el: "#app",
  router,
  store,
  render: h => h(App)
});
