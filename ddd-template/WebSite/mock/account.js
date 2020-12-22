/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-07-11 19:09:10
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 13:57:07
 */
import { deepClone } from "../src/utils/index";

const userList = [
  {
    id: "1",
    available: "YES",
    versionDate: "2020-07-01 01:34:33.767",
    updator: "1",
    creator: "1",
    remark: "test",
    name: "角色1",
    code: "0001",
    userType: "ADMIN",
    mobilePhone: "15911111111",
    email: "test@seasky.com",
    enabled: "YES"
  },
  {
    id: "2",
    available: "YES",
    versionDate: "2020-07-01 01:34:33.767",
    updator: "1",
    creator: "1",
    remark: "test",
    name: "角色2",
    code: "0002",
    userType: "ADMIN",
    mobilePhone: "15911111111",
    email: "test@seasky.com",
    enabled: "YES"
  }
];

const menuList = [
  {
    id: "1",
    available: "YES",
    versionDate: "2020-07-10 02:31:46.962",
    creator: "1",
    applicationId: "1",
    menuNo: "0000",
    name: "演示",
    icon: "list",
    parentId: "0",
    routingUrl: "",
    isNewWindow: "NO",
    isSystem: "YES",
    withUserId: "NO",
    enabled: "YES",
    authUser: ["1", "2"],
    children: [
      {
        id: "2",
        available: "YES",
        versionDate: "2020-07-10 05:53:01.597",
        updator: "1",
        creator: "1",
        applicationId: "1",
        menuNo: "SBD_001",
        name: "驾驶舱",
        icon: "dashboard",
        parentId: "1",
        routingUrl: "dashboard",
        redirectUrl: "",
        urlParameter: "",
        isNewWindow: "NO",
        isSystem: "NO",
        withUserId: "NO",
        enabled: "YES",
        authUser: ["1"],
        children: []
      },
      {
        id: "3",
        available: "YES",
        versionDate: "2020-07-10 05:53:08.334",
        updator: "1",
        creator: "1",
        applicationId: "1",
        menuNo: "SBD_003",
        name: "UI规范",
        icon: "example",
        parentId: "1",
        routingUrl: "",
        redirectUrl: "",
        urlParameter: "",
        isNewWindow: "NO",
        isSystem: "NO",
        withUserId: "NO",
        enabled: "YES",
        authUser: ["1"],
        children: [
          {
            id: "301",
            menuNo: "301",
            name: "概述",
            icon: "",
            routingUrl: "example/index",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "302",
            menuNo: "302",
            name: "布局",
            icon: "",
            routingUrl: "example/layout",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "303",
            menuNo: "303",
            name: "图标",
            icon: "",
            routingUrl: "example/icon",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "304",
            menuNo: "304",
            name: "按钮",
            icon: "",
            routingUrl: "example/button",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "305",
            menuNo: "305",
            name: "表格",
            icon: "",
            routingUrl: "example/table",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "306",
            menuNo: "306",
            name: "表单",
            icon: "",
            routingUrl: "example/form",
            redirectUrl: "",
            authUser: ["1"]
          },
          {
            id: "307",
            menuNo: "307",
            name: "对话框",
            icon: "",
            routingUrl: "example/dialog",
            redirectUrl: "",
            authUser: ["1"]
          }
        ]
      }
    ]
  }
];

let currentUser = {};

function filterMenuNode(node, id) {
  if (node.children && node.children.length > 0) {
    node.children.forEach(c => filterMenuNode(c, id));
    node.children = node.children.filter(
      c =>
        (c.authUser && c.authUser.includes(id)) ||
        (c.children && c.children.length > 0)
    );
  }
}

function getMenuListByUser() {
  const { id } = currentUser;
  const menus = deepClone(menuList);
  filterMenuNode(menus[0], id);
  return menus;
}

export default [
  // login
  {
    url: "/account/pc/v1/login",
    type: "post",
    response: _ => {
      return {
        data: [
          {
            id: "1",
            available: "YES",
            versionDate: "2020-07-08 02:30:50.390",
            updator: "1",
            username: "admin",
            enabled: "YES",
            isInitial: "NO",
            users: userList,
            token: "d79ba79c-0561-43ed-afa4-d94a9ef2b5ff"
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: "1594465972765",
        rid: "pyAn4K2g"
      };
    }
  },
  // setCurrent
  {
    url: "/user/pc/v1/setCurrent",
    type: "post",
    response: config => {
      const { id } = config.body;
      currentUser = userList.find(u => u.id === id);
      return {
        code: "00000",
        currentTime: "1594466609898",
        description: "成功",
        rid: "79HgNrDI"
      };
    }
  },
  // getCurrent
  {
    url: "/user/pc/v1/getCurrent",
    type: "post",
    response: _ => {
      return {
        data: [
          {
            ...currentUser,
            menuList: getMenuListByUser(),
            functionList: []
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: "1594466793502",
        rid: "YBi5A0sJ"
      };
    }
  },
  // modifyPassword
  {
    url: "/account/pc/v1/modifyPassword",
    type: "post",
    response: _ => {
      return {
        code: "00000",
        description: "成功",
        currentTime: "1594466793502",
        rid: "YBi5A0sJ"
      };
    }
  }
];
