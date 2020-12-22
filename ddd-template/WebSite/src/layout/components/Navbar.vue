<template>
  <div class="navbar">
    <hamburger
      id="hamburger-container"
      :is-active="sidebar.opened"
      class="hamburger-container"
      @toggleClick="toggleSideBar"
    />

    <breadcrumb id="breadcrumb-container" class="breadcrumb-container" />

    <div class="right-menu">
      <template v-if="false">
        <!-- device !== 'mobile' -->
        <search id="header-search" class="right-menu-item" />

        <error-log class="errLog-container right-menu-item hover-effect" />

        <screenfull id="screenfull" class="right-menu-item hover-effect" />

        <el-tooltip content="Global Size" effect="dark" placement="bottom">
          <size-select id="size-select" class="right-menu-item hover-effect" />
        </el-tooltip>
      </template>

      <el-dropdown
        class="avatar-container right-menu-item hover-effect"
        trigger="click"
      >
        <div class="avatar-wrapper">
          <!-- <img :src="avatar + '?imageView2/1/w/80/h/80'" class="user-avatar" /> -->
          <span class="text-avatar"><i class="el-icon-user-solid"></i></span>
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown">
          <!-- <router-link to="/profile/index">
            <el-dropdown-item>Profile</el-dropdown-item>
          </router-link>
          <router-link to="/">
            <el-dropdown-item>Dashboard</el-dropdown-item>
          </router-link>
          <a
            target="_blank"
            href="https://github.com/PanJiaChen/vue-element-admin/"
          >
            <el-dropdown-item>Github</el-dropdown-item>
          </a>
          <a
            target="_blank"
            href="https://panjiachen.github.io/vue-element-admin-site/#/"
          >
            <el-dropdown-item>Docs</el-dropdown-item>
          </a>
          <el-dropdown-item divided @click.native="logout">
            <span style="display:block;">Log Out</span>
          </el-dropdown-item> -->
          <!-- <el-dropdown-item @click.native="handleSelectUser"
            >{{ name
            }}<span style="color:#409EFF"> 切换</span></el-dropdown-item
          > -->
          <el-dropdown-item
            ><span style="display:block; font-size:12px"
              ><i class="el-icon-user-solid" /> {{ name }}</span
            ></el-dropdown-item
          >
          <el-dropdown-item divided @click.native="handleModifyPassword">
            <span style="display:block; font-size:12px">
              <i class="el-icon-s-cooperation" />
              修改密码</span
            >
          </el-dropdown-item>
          <el-dropdown-item @click.native="logout">
            <span style="display:block; font-size:12px"
              ><i class="el-icon-switch-button" /> 注销</span
            >
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <select-user
      :visible.sync="dialogSelectUser.visible"
      :userList="dialogSelectUser.userList"
      @handle-confirm="setUser"
    />
    <modify-password :visible.sync="dialogModifyPassword.visible" />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Breadcrumb from "@/components/Breadcrumb";
import Hamburger from "@/components/Hamburger";
import ErrorLog from "@/components/ErrorLog";
import Screenfull from "@/components/Screenfull";
import SizeSelect from "@/components/SizeSelect";
import Search from "@/components/HeaderSearch";
import ModifyPassword from "@/components/ModifyPassword";
import SelectUser from "@/components/SelectUser";

export default {
  data() {
    return {
      dialogSelectUser: {
        visible: false,
        userList: []
      },
      dialogModifyPassword: {
        visible: false
      }
    };
  },
  components: {
    Breadcrumb,
    Hamburger,
    ErrorLog,
    Screenfull,
    SizeSelect,
    Search,
    ModifyPassword,
    SelectUser
  },
  computed: {
    ...mapGetters(["sidebar", "avatar", "device", "name"])
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch("app/toggleSideBar");
    },
    async logout() {
      await this.$store.dispatch("user/logout");
      this.$router.push("/login");
    },
    async handleSelectUser() {
      const { users } = await this.$store.dispatch("user/login", {});
      this.dialogSelectUser.userList = users;
      if (this.dialogSelectUser.userList.length > 1) {
        this.dialogSelectUser.visible = true;
      }
    },
    async setUser(id) {
      await this.$store.dispatch("user/setUser", id);
      await this.$store.dispatch("user/getInfo");
      this.$router.push({
        path: "/",
        query: {
          t: new Date().valueOf()
        }
      });
    },
    handleModifyPassword() {
      this.dialogModifyPassword.visible = true;
    }
  }
};
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background 0.3s;
    -webkit-tap-highlight-color: transparent;

    &:hover {
      background: rgba(0, 0, 0, 0.025);
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background 0.3s;

        &:hover {
          background: rgba(0, 0, 0, 0.025);
        }
      }
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }

        .text-avatar {
          display: flex;
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 20px;
          justify-content: center;
          align-items: center;
          background-color: #eeeeee;
        }
      }
    }
  }
}
</style>
