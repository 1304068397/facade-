/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-03-13 10:03:57
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-08-14 16:30:05
 */
import { sidebarRootMenu } from "@/settings";

const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  introduction: state => state.user.introduction,
  roles: state => state.user.roles,
  user: state => state.user.user,
  accountId: state => state.user.accountId,
  permissionRoutes: state => state.permission.routes,
  menuTree: state => {
    if (!sidebarRootMenu) {
      if (state.user.menuTree.length === 1 && state.user.menuTree[0].children) {
        return state.user.menuTree[0].children;
      }
    }
    return state.user.menuTree;
  },
  errorLogs: state => state.errorLog.logs
};
export default getters;
