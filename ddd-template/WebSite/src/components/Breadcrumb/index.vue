<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-08 12:38:19
 * @LastEditors: dongjunhua
 * @LastEditTime: 2020-08-15 11:27:38
-->
<template>
  <el-breadcrumb class="app-breadcrumb" separator="/">
    <transition-group name="breadcrumb">
      <el-breadcrumb-item v-for="(item, index) in levelList" :key="item.id">
        <span
          v-if="item.redirect === 'noRedirect' || index == levelList.length - 1"
          class="no-redirect"
          >{{ item.meta.title }}</span
        >
        <a v-else @click.prevent="handleLink(item)">{{ item.meta.title }}</a>
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script>
import { deepClone } from "@/utils/index.js";
import pathToRegexp from "path-to-regexp";
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      levelList: null
    };
  },
  computed: {
    ...mapGetters(["menuTree"])
  },
  watch: {
    $route(route) {
      // if you go to the redirect page, do not update the breadcrumbs
      if (route.path.startsWith("/redirect/")) {
        return;
      }
      // this.getBreadcrumb();
      this.getBreadcrumbFromMenu();
    }
  },
  created() {
    // this.getBreadcrumb();
    this.getBreadcrumbFromMenu();
  },
  methods: {
    getBreadcrumbFromMenu() {
      this.levelList = [];
      const matched = this.$route.matched.filter(
        item => item.meta && item.meta.title
      );
      if (matched && matched.length === 1 && matched[0].name === "Home") {
        this.levelList.unshift({
          id: "0",
          redirect: "noRedirect",
          path: `/i/`,
          meta: { title: "首页" }
        });
      } else {
        const menu = deepClone(this.menuTree);
        menu.forEach(m => this.filterMenuNode(m, this.$route.path));
      }
    },
    filterMenuNode(node, path) {
      if (node.children && node.children.length > 0) {
        node.children.forEach(c => this.filterMenuNode(c, path));
        node.children = node.children.filter(
          c =>
            `/i/${c.routingUrl}` === path ||
            (c.children && c.children.length > 0)
        );
      }
      if (
        `/i/${node.routingUrl}` === path ||
        (node.children && node.children.length > 0)
      ) {
        this.levelList.unshift({
          id: node.id,
          redirect: "noRedirect",
          path: `/i/${node.routingUrl}`,
          meta: { title: node.name }
        });
      }
    },
    // getBreadcrumb() {
    //   // only show routes with meta.title
    //   let matched = this.$route.matched.filter(
    //     item => item.meta && item.meta.title
    //   );
    //   const first = matched[0];
    //   if (!this.isDashboard(first)) {
    //     matched = [{ path: "/", meta: { title: "首页" } }].concat(matched);
    //   }

    //   this.levelList = matched.filter(
    //     item => item.meta && item.meta.title && item.meta.breadcrumb !== false
    //   );
    // },
    // isDashboard(route) {
    //   const name = route && route.name;
    //   if (!name) {
    //     return false;
    //   }
    //   return (
    //     name.trim().toLocaleLowerCase() === "Dashboard".toLocaleLowerCase()
    //   );
    // },
    pathCompile(path) {
      // To solve this problem https://github.com/PanJiaChen/vue-element-admin/issues/561
      const { params } = this.$route;
      var toPath = pathToRegexp.compile(path);
      return toPath(params);
    },
    handleLink(item) {
      const { redirect, path } = item;
      if (redirect) {
        this.$router.push(redirect);
        return;
      }
      this.$router.push(this.pathCompile(path));
    }
  }
};
</script>

<style lang="scss" scoped>
.app-breadcrumb.el-breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  .no-redirect {
    color: #97a8be;
    cursor: text;
  }
}
</style>
