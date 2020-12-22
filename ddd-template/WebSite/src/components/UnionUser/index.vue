<!--
 @Descripttion:
 @Author: gong qun
 @Date: 2020-06-16 14:11:45
 @LastEditors: gong qun
 @LastEditTime: 2020-06-18 10:25:12
-->
<template>
  <div v-if="isShow">
    <layout-card :show-title="true" type="primary">
      <div slot="title">{{ tableTitle }}&nbsp;下用户</div>
      <el-row slot="filter" :gutter="5">
        <el-col :xs="24" :sm="12" :lg="8" :xl="6">
          <el-input
            v-model="searchUserModel.code"
            placeholder="请输入工号"
            :clearable="true"
          ></el-input>
        </el-col>
        <el-col :xs="24" :sm="12" :lg="8" :xl="6">
          <el-input
            v-model="searchUserModel.name"
            placeholder="请输入姓名"
            :clearable="true"
          ></el-input>
        </el-col>
        <el-col :xs="24" :sm="12" :lg="8" :xl="6">
          <el-select
            v-model="searchUserModel.userType"
            placeholder="请选择用户类型"
            :clearable="true"
            style="width:100%"
          >
            <el-option
              v-for="item in userTypeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-col>
        <el-col :xs="24" :sm="12" :lg="8" :xl="6">
          <OrganizationSelectTree
            ref="organizationTree"
            @change="onOrganizationTreeChange"
          >
          </OrganizationSelectTree>
        </el-col>
        <el-col :xs="24" :sm="12" :lg="8" :xl="6">
          <el-button
            type="default"
            plain
            icon="el-icon-search"
            @click="onSearchUnion"
          >
            查询
          </el-button>
        </el-col>
      </el-row>
      <div slot="button" style="text-align: right;">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          @click="onSelectUser"
        >
          添加
        </el-button>
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          @click="onDeleteUnion"
        >
          删除
        </el-button>
      </div>
      <div slot="content">
        <el-table
          stripe
          :data="userPageInfo.data"
          style="width: 100%"
          class="mtop"
          ref="userTable"
          fit
          @selection-change="onSelectionChange"
        >
          <el-table-column type="selection" width="55"> </el-table-column>
          <el-table-column label="工号" prop="code"></el-table-column>
          <el-table-column label="姓名" prop="name"></el-table-column>
          <el-table-column label="类型" prop="userType">
            <template slot-scope="scope">
              <span>{{ userTypeFilters(scope.row.userType) }}</span>
            </template>
          </el-table-column>
        </el-table>
        <Pagination
          v-show="userPageInfo.total > 0"
          :total="userPageInfo.total"
          :page.sync="searchUserModel.pageIndex"
          :limit.sync="searchUserModel.pageSize"
          @pagination="getUserPageInfo"
        />
      </div>
    </layout-card>

    <SelectUser
      ref="selectUser"
      :dialogSelectUser="dialogSelectUser"
      @onCloseSelectUser="onCloseSelectUser"
      @onSelectUserChange="onSelectUserChange"
    ></SelectUser>
  </div>
</template>
<script>
import SelectUser from "@/components/SelectUser";
import OrganizationSelectTree from "@/components/OrganizationSelectTree";
import Pagination from "@/components/Pagination";
export default {
  components: {
    SelectUser,
    OrganizationSelectTree,
    Pagination
  },
  props: {
    tableTitle: {
      type: String,
      default: "关联关系"
    }
  },
  data() {
    return {
      activeNames: ["1"],
      searchUserModel: {
        pageIndex: 1,
        pageSize: 10
      },
      userTypeOptions: [
        { value: "ADMIN", label: "管理员" },
        { value: "TEACHER", label: "教工" },
        { value: "STUDENT", label: "学生" },
        { value: "EXTERNAL", label: "外聘" },
        { value: "OTHER", label: "其他" }
      ],
      userPageInfo: {
        total: 0
      },
      multipleSelectionUser: [],
      dialogSelectUser: false,
      isShow: false
    };
  },
  methods: {
    searchUser(val) {
      if (this.$refs.organizationTree) {
        this.$refs.organizationTree.clearSelect();
      }
      this.searchUserModel = {
        pageIndex: 1,
        pageSize: 10,
        enabled: "YES"
      };
      if (val) {
        if (val.roleId) {
          this.searchUserModel.roleIds = [val.roleId];
        } else {
          this.searchUserModel.roleIds = [];
        }
        if (val.accountId) {
          this.searchUserModel.accountIds = [val.accountId];
        } else {
          this.searchUserModel.accountIds = [];
        }
      }
      this.getUserPageInfo();
    },
    getUserPageInfo() {
      if (!this.getIsSelect()) {
        this.userPageInfo = {};
        this.$message.warning("请选择" + this.tableTitle);
        return;
      }
      this.$service.User.getPageByRelation(this.searchUserModel).then(res => {
        this.userPageInfo = res;
      });
    },
    onUserSizeChange(val) {
      this.searchUserModel.pageIndex = 1;
      this.searchUserModel.pageSize = val;
      this.getUserPageInfo();
    },
    onUserCurrentChange(val) {
      this.searchUserModel.pageIndex = val;
      this.getUserPageInfo();
    },
    onSelectionChange(val) {
      this.multipleSelectionUser = val;
    },
    onDeleteUnion() {
      if (this.multipleSelectionUser.length === 0) {
        this.$message.warning("请勾选用户！");
        return;
      }
      this.$emit("onRemoveUnion", this.multipleSelectionUser);
    },
    clearSelection() {
      this.$refs.userTable.clearSelection();
      this.onSearchUnion();
    },
    userTypeFilters(value) {
      if (!value) return "";
      let userType = this.userTypeOptions.filter(t => t.value === value);
      if (userType.length === 0) {
        return "";
      }
      return userType[0].label;
    },
    onSearchUnion() {
      this.searchUserModel.pageIndex = 1;
      this.getUserPageInfo();
    },
    onSelectUser() {
      if (!this.getIsSelect()) {
        this.$message.warning("请选择" + this.tableTitle);
        return;
      }
      this.$refs.selectUser.onShowSelectUser();
    },
    onCloseSelectUser() {
      this.onSearchUnion();
      this.$refs.selectUser.onCloseSelectUser();
    },
    onSelectUserChange(val) {
      this.$emit("onAddUnion", val);
    },
    getIsSelect() {
      let isNotRole =
        this.searchUserModel.roleIds == null ||
        this.searchUserModel.roleIds.length === 0;
      let isNotAccount =
        this.searchUserModel.accountIds == null ||
        this.searchUserModel.accountIds.length === 0;
      this.isShow = !(isNotRole && isNotAccount);
      return this.isShow;
    },
    onOrganizationTreeChange(val) {
      this.searchUserModel.organizationIds = !val ? null : [val];
    }
  }
};
</script>

<style lang="scss" scoped>
.account {
  width: 100%;
  // min-height: calc(100vh - 90px);
  display: flex;
  .mtop {
    margin-top: 20px;
  }
  .fl {
    width: 50%;
    margin-right: 20px;
  }
  .fr {
    width: 50%;
  }
  .header {
    padding-bottom: 10px;
    border-bottom: 1px solid #f2f2f2;
  }
  .el-collapse {
    border-top: none;
  }
}
.el-button + .el-button {
  margin-left: 0px;
}
.el-col {
  margin-bottom: 5px;
  // &:last-child {
  //   margin-bottom: 0;
  // }
}
</style>
