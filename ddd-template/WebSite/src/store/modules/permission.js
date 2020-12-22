/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-06-08 09:28:05
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-07-10 13:48:29
 */
import { deepClone } from "@/utils/index.js";
import router, {
  constantRoutes,
  asyncRoutes,
  layoutRoutes,
  notFoundRoutes
} from "@/router";

const state = {
  routes: []
};

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.routes = routes;
  }
};

const component = () => import("@/views/outer");

function eachMenu(menuList, cb) {
  menuList.forEach(m => {
    cb(m);
    m.children && m.children.length > 0 && eachMenu(m.children, cb);
  });
}

function getDynamicRoutes(menuList) {
  const dynamicRoutes = [];
  const layoutRoute = deepClone(layoutRoutes[0]);

  eachMenu(menuList, m => {
    if (m.routingUrl && !m.redirectUrl) {
      const asyncRoute = asyncRoutes.find(r => r.path === m.routingUrl);
      if (asyncRoute) {
        const route = deepClone(asyncRoute);
        // 设置meta
        route.meta = {
          icon: m.icon,
          title: m.name
        };
        // 系统内部路由
        layoutRoute.children.push(route);
        // 供外部调用的路由
        const routeForOuter = deepClone(route);
        routeForOuter.path = `/${routeForOuter.path}`;
        routeForOuter.name = `${routeForOuter.name}ForOuter`;
        dynamicRoutes.push(routeForOuter);
      }
    }
    if (m.routingUrl && m.redirectUrl) {
      const routeToOuter = {
        path: m.routingUrl,
        component,
        name: `${m.id}ToOuter`,
        meta: {
          icon: m.icon,
          title: m.name
        }
      };
      layoutRoute.children.push(routeToOuter);
    }
  });
  dynamicRoutes.push(layoutRoute);
  return dynamicRoutes;
}

const actions = {
  /**
   * 根据当前用户权限动态添加路由
   */
  generateRoutes({ commit }, menuList) {
    //
    const dynamicRoutes = getDynamicRoutes(menuList);
    router.addRoutes(dynamicRoutes);
    router.addRoutes(notFoundRoutes);
    commit("SET_ROUTES", [
      ...constantRoutes,
      ...dynamicRoutes,
      ...notFoundRoutes
    ]);
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
