/*
 * @Descripttion: global service module ver .1
 * @Author: dong
 * @Date: 2020-05-11 19:56:12
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-06-17 14:39:39
 */

const modulesFiles = require.context("./modules", true, /\.js$/);

const modules = modulesFiles.keys().reduce((modules, modulePath) => {
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, "$1");
  const value = modulesFiles(modulePath);

  const key = moduleName.charAt(0).toUpperCase() + moduleName.slice(1);
  modules[key] = value.default;

  return modules;
}, {});

// import Organization from "@/service/modules/organization";
// const modules = { Organization };

Object.defineProperty(modules, "invoke", {
  value: function(method, ...params) {
    let im;
    eachMethod(this, (name, m) => {
      name === method && (im = m);
    });
    if (im) {
      return im(...params);
    }
  },
  writable: false,
  enumerable: false,
  configurable: false
});

function eachMethod(modules, cb) {
  Object.keys(modules).forEach(cKey => {
    const c = modules[cKey];
    typeof c === "function" &&
      Object.getOwnPropertyNames(c).forEach(mKey => {
        const m = c[mKey];
        typeof m === "function" && cb(`${c.name}/${m.name}`, m);
      });
  });
}

const service = {
  install(Vue) {
    Vue.prototype.$service = modules;
  }
};

export default service;
