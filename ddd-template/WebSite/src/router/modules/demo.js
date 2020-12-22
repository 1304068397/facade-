/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-07-15 16:40:16
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-09-18 13:56:32
 */

export const demoRoutes = [
  {
    path: "icon",
    component: () => import("@/views/icons"),
    name: "Icon"
  },
  {
    path: "dashboard",
    component: () => import("@/views/dashboard"),
    name: "Dashboard"
  },
  {
    path: "example/index",
    component: () => import("@/views/example/index"),
    name: "Example"
  },
  {
    path: "example/button",
    component: () => import("@/views/example/button"),
    name: "Button"
  },
  {
    path: "example/table",
    component: () => import("@/views/example/table"),
    name: "Table"
  },
  {
    path: "example/dialog",
    component: () => import("@/views/example/dialog"),
    name: "Dialog"
  },
  {
    path: "example/icon",
    component: () => import("@/views/example/icon"),
    name: "Icon"
  },
  {
    path: "example/layout",
    component: () => import("@/views/example/layout"),
    name: "Layout"
  },
  {
    path: "example/form",
    component: () => import("@/views/example/form"),
    name: "Form"
  }
];
