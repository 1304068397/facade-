<!--
 * @Description: 
 * @Autor: dong jun hua
 * @Date: 2020-06-15 11:18:22
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-08-14 16:01:05
-->
<template>
  <div>
    <!-- 可展开 -->
    <el-submenu
      v-if="item.children && item.children.length > 0"
      ref="subMenu"
      :index="item.id"
      popper-append-to-body
    >
      <template slot="title">
        <item :icon="item.icon" :title="item.name" />
      </template>
      <sidebar-item
        v-for="child in item.children"
        :key="child.id"
        :item="child"
        class="nest-menu"
      />
    </el-submenu>

    <template v-else>
      <app-link :to="`${path}${params}`">
        <el-menu-item :index="path">
          <item :icon="item.icon" :title="item.name" />
        </el-menu-item>
      </app-link>
    </template>
  </div>
</template>

<script>
// import path from "path";
import { isExternal } from "@/utils/validate";
import Item from "./Item";
import AppLink from "./Link";
import FixiOSBug from "./FixiOSBug";

export default {
  name: "SidebarItem",
  components: { Item, AppLink },
  mixins: [FixiOSBug],
  props: {
    // route object
    item: {
      type: Object,
      required: true
    }
  },
  computed: {
    path() {
      return `/i/${this.item.routingUrl}`;
    },
    params() {
      return this.item.redirectUrl ? `?url=${this.item.redirectUrl}` : "";
    }
  },
  data() {
    return {};
  },
  methods: {}
};
</script>
