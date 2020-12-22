/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-03-13 10:03:56
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-08-14 16:31:37
 */
module.exports = {
  title: "Vue Element Admin",

  /**
   * @type {boolean} true | false
   * @description Whether show the settings right-panel
   */
  showSettings: false,

  /**
   * @type {boolean} true | false
   * @description Whether need tagsView
   */
  tagsView: true,

  /**
   * @type {boolean} true | false
   * @description Whether fix the header
   */
  fixedHeader: false,

  /**
   * @type {boolean} true | false
   * @description Whether show the logo in sidebar
   */
  sidebarLogo: false,

  /**
   * @type {boolean} true | false
   * @description Whether show when there is only one root menu
   */
  sidebarRootMenu: true,

  /**
   * @type {string | array} 'production' | ['production', 'development']
   * @description Need show err logs component.
   * The default is only used in the production env
   * If you want to also use it in dev, you can pass ['production', 'development']
   */
  errorLog: "production"
};
