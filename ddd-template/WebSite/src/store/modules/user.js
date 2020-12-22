/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-03-13 10:03:58
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-08-10 13:17:16
 */
import { getToken, setToken, removeToken } from "@/utils/auth";
import router, { resetRouter } from "@/router";
import Account from "@/service/modules/account";
import User from "@/service/modules/user";
import { Message } from "element-ui";
import { getConfig } from "@/utils/config";

const state = {
  token: getToken(),
  name: "",
  avatar: "",
  introduction: "",
  roles: [],
  menuTree: [],
  user: null,
  accountId: "",
  userId: ""
};

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token;
  },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction;
  },
  SET_NAME: (state, name) => {
    state.name = name;
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar;
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles;
  },
  SET_MENUTREE: (state, menuTree) => {
    state.menuTree = menuTree;
  },
  SET_USER: (state, user) => {
    state.user = user;
  },
  SET_ACCOUNTID: (state, accountId) => {
    state.accountId = accountId;
  },
  SET_USERID: (state, userId) => {
    state.userId = userId;
  }
};

const actions = {
  async login({ commit }, loginInfo) {
    loginInfo.rememberMe = true;
    const { recognizeId } = await getConfig();
    if (!recognizeId) {
      Message.error("请先配置应用识别id");
      return Promise.reject();
    }
    const resLogin = await Account.login({ recognizeId, ...loginInfo });
    const account = resLogin.data[0];
    const { id, users } = resLogin.data[0];
    if (!users || users.length === 0) {
      Message.error("当前登录账号无可选用户");
      return Promise.reject();
    }
    commit("SET_ACCOUNTID", id);
    localStorage.setItem("accountId", id);
    return account;
  },

  async setUser({ commit }, id) {
    await User.setCurrent({ id });
    commit("SET_USERID", id);
    commit("SET_TOKEN", id);
    setToken(id);
  },

  async getInfo({ commit, dispatch }) {
    const accountId = localStorage.getItem("accountId");
    commit("SET_ACCOUNTID", accountId);

    const res = await User.getCurrent();
    const { id, name } = res.data[0];
    const menuTree = res.data[0].menuList;
    const roles = ["admin"];
    const avatar =
      "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";
    const introduction = "";

    const data = { roles, menuTree, id, name, avatar, introduction };

    commit("SET_ROLES", roles);
    commit("SET_MENUTREE", menuTree);
    commit("SET_NAME", name);
    commit("SET_AVATAR", avatar);
    commit("SET_INTRODUCTION", introduction);
    commit("SET_USER", res.data[0]);
    commit("SET_USERID", id);

    dispatch("permission/generateRoutes", menuTree, { root: true });

    return data;
  },

  // user logout
  async logout({ dispatch }) {
    await dispatch("resetCache");
    resetRouter();

    // reset visited views and cached views
    // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
    dispatch("tagsView/delAllViews", null, { root: true });
  },

  // resst all cache
  async resetCache({ commit }) {
    commit("SET_ACCOUNTID", null);
    commit("SET_TOKEN", null);
    commit("SET_ROLES", null);
    commit("SET_MENUTREE", null);
    commit("SET_NAME", null);
    commit("SET_AVATAR", null);
    commit("SET_INTRODUCTION", null);
    commit("SET_USER", null);
    commit("SET_USERID", null);
    localStorage.clear();
    removeToken();
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
